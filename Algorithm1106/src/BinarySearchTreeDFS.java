import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeDFS {

	private Node root;
	public ArrayList nodes = new ArrayList();
	public int[][] adjMatrix;// Edges will be represented as adjacency Matrix
	int size;

	public void setRootNode(Node n) {
		this.root = n;
	}

	public Node getRootNode() {
		return this.root;
	}


	static class Node {
		int key;

		Node leftChild;
		Node rightChild;

		public boolean visited;

		public String label;

		Node(int key) {
			this.key = key;
		}

		public String toString() {
//			return "key:" + this.key;
			return  Integer.toString(this.key);
		}
	}

	public Node getRoot() {
		return this.root;
	}

	public void addNode(int key) {
		if (findNode(key) != null)
			return;

		Node newNode = new Node(key);

		if (root == null) {
			root = newNode;
			nodes.add(newNode);
			setRootNode(newNode);// 트리가 비어있으면 root 에 삽입

		} else {
			Node focusNode = root; // 탐색용 노드
			Node parent;
			// 탐색용 노드의 부모 노드

			while (true) {
				parent = focusNode; // 이동

				if (key < parent.key) { // 삽입하려는 키가 현재 노드보다 작으면
					focusNode = parent.leftChild; // 왼쪽으로 이동

					if (focusNode == null) { // 왼쪽 노드가 비어있으면
						parent.leftChild = newNode;
//						System.out.println("나는부모" + parent+ "나는 꼬붕" + newNode);
						nodes.add(newNode);
						connectNode(parent, newNode);
						// 왼쪽 노드에 삽입
						return;
					}
				} else { // 삽입하려는 키가 현재 노드보다 크다면
					focusNode = parent.rightChild; // 오른쪽으로 이동

					if (focusNode == null) { // 오른쪽 노드가 비어있으면
						parent.rightChild = newNode;// 오른쪽 노드에 삽입
//						System.out.println("나는부모" + parent.key + "나는 꼬붕" + newNode.key);
						nodes.add(newNode);
						connectNode(parent, newNode);
						return;
					}

				}

			}
		}
	}
	
	
	
	public void connectNode(Node parent, Node newNode) {
		if (adjMatrix == null) {
			size = 11;
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(parent);
		System.out.println(startIndex);

		int endIndex = nodes.indexOf(newNode);
		System.out.println(endIndex);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
	}
	

	
	public boolean deleteNode(int key) {
		// focusNode 와 parent 가 같을 수 있는 경우는 찾으려는 key 가 root 인 경우
		Node focusNode = root;
		Node parent = root;

		boolean isLeftChild = true;

		// while 문이 끝나고 나면 focusNode 는 삭제될 노드를 가리키고, parent 는 삭제될 노드의 부모노드를 가리키게 되고, 삭제될
		// 노드가 부모노드의 left 인지 right 인지에 대한 정보를 가지게 된다
		while (focusNode.key != key) {
			parent = focusNode;

			if (key < focusNode.key) {
				isLeftChild = true; // 지우려는 노드가 왼쪽에 있는 노드냐 기록용
				focusNode = parent.leftChild;
			} else {
				isLeftChild = false; // 지우려는 노드가 오른쪽에 있는 노드냐 기록용
				focusNode = parent.rightChild;		
			}

			// 찾으려는 노드가 없는 경우
			if (focusNode == null) {
				return false;
			}
		}

		Node replacementNode;
		// 지우려는 노드의 자식 노드가 없는 경우
		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			if (focusNode == root) {
				root = null;	
				
			}
			else if (isLeftChild) {
				parent.leftChild = null;
			}
				
			else {
				parent.rightChild = null;
				
			}
			replacementNode= null;
			System.out.println("허허"+replacementNode);
			delectConnectNode(parent, focusNode, null,null,null,null);
		
		}
		// 지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
		else if (focusNode.rightChild == null) {
			replacementNode = focusNode.leftChild;
			

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
			System.out.println("허허"+replacementNode);
			if(replacementNode.leftChild==null) {
				delectConnectNode(parent, focusNode, replacementNode,focusNode.leftChild,null,null);	
			}else {
				delectConnectNode(parent, focusNode, replacementNode,focusNode.leftChild,null,replacementNode.leftChild);
				
			}
			
		}
		// 지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있는 경우)
		else if (focusNode.leftChild == null) {
			replacementNode = focusNode.rightChild;
			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;
			System.out.println("허허"+replacementNode);
			
			if(replacementNode.leftChild==null) {
				delectConnectNode(parent, focusNode, replacementNode,null,focusNode.rightChild,null);				
			}else {
				delectConnectNode(parent, focusNode, replacementNode,null,focusNode.rightChild,replacementNode.leftChild);
			}
		}
		
		// 지우려는 노드의 양쪽 자식노드가 모두 있는 경우
		// 오른쪽 자식 노드의 sub tree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
		else {
			Node rightSubTree = focusNode.rightChild; // 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
			replacementNode = getRightMinNode(focusNode.rightChild); // 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree 에서 가장 작은 값을
																		// 가진 노드). 이 노드는 왼쪽 child 가 없어야 한다 (가장 작은 값이기
																		// 때문에)

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.leftChild = replacementNode;
			else
				parent.rightChild = replacementNode;

			replacementNode.rightChild = rightSubTree;
			if (replacementNode == rightSubTree) // 지우려는 노드의 오른쪽 sub tree 에 노드가 하나밖에 없는 경우
				replacementNode.rightChild = null;

			replacementNode.leftChild = focusNode.leftChild; // 지우려는 노드의 왼쪽 sub tree 를 연결시킨다
			delectConnectNode(parent, focusNode, replacementNode,focusNode.leftChild,focusNode.rightChild,replacementNode.leftChild);
		}
//		System.out.println("노드스"+nodes);
//		System.out.println("지울게뭐지focusNode"+focusNode);
//		int nodeSize=nodes.size();
//		System.out.println("부모parent"+parent);
//		System.out.println("이게 중요replacementNode"+replacementNode);
//		System.out.println("바꾸는 애의 자식" + replacementNode.leftChild);
//		
		
//		System.out.println("지우는애 왼손"+ focusNode.leftChild);
//		System.out.println("지우는애 오른손"+ focusNode.rightChild);

		return true;		
	}
	
	public void delectConnectNode(Node parent, Node focusNode , Node replacementNode, Node focusNodeLeftChild, Node focusNodeRightChild ,Node replacementNodeLeftChild) {
		if (adjMatrix == null) {
			return;
		}
		
		System.out.println("부모"+parent+"지울거"+focusNode+"새로들어올것"+replacementNode+"지울꺼의 왼쪽놈"+focusNodeLeftChild+"지울거의 오른쪽놈"+focusNodeRightChild+"새로운거의 왼쪽"+replacementNodeLeftChild);
		

		int startIndex = nodes.indexOf(parent);

		int endIndex = nodes.indexOf(focusNode);
		int endLeftIndex = nodes.indexOf(focusNodeLeftChild);
		int endRightIndex = nodes.indexOf(focusNodeRightChild);
		int newEndIndex = nodes.indexOf(replacementNode);
		int newEndLeftIndex = nodes.indexOf(replacementNodeLeftChild);
		
		adjMatrix[startIndex][endIndex] = 0;
		adjMatrix[endIndex][startIndex] = 0;
		if(replacementNode == null) {//지우려는거에 자식노드 없을때	
			
		}else if(focusNodeRightChild==null){//지우려는 거 오른쪽 자식노드 없을때
			
			adjMatrix[endIndex][endLeftIndex] = 0;
			adjMatrix[endLeftIndex][endIndex] = 0;
			adjMatrix[startIndex][newEndIndex] = 1;
			adjMatrix[newEndIndex][startIndex] = 1;	

		}else if(focusNodeLeftChild==null){//지우려는 거 왼쪽 자식노드 없을때
			
			adjMatrix[endIndex][endRightIndex] = 0;
			adjMatrix[endRightIndex][endIndex] = 0;
			adjMatrix[startIndex][newEndIndex] = 1;
			adjMatrix[newEndIndex][startIndex] = 1;
		}else {
			adjMatrix[endIndex][endLeftIndex] = 0;
			adjMatrix[endLeftIndex][endIndex] = 0;
			adjMatrix[endIndex][endRightIndex] = 0;
			adjMatrix[endRightIndex][endIndex] = 0;		
			adjMatrix[startIndex][newEndIndex] = 1;
			adjMatrix[newEndIndex][startIndex] = 1;
			adjMatrix[newEndIndex][newEndLeftIndex] = 1;
			adjMatrix[newEndLeftIndex][newEndIndex] = 1;
			adjMatrix[newEndIndex][endRightIndex] = 1;
			adjMatrix[endRightIndex][newEndIndex] = 1;
			
		}
		
		
	}
    //오른쪽 노드들 중 가장 작은고 구하는거
	private Node getRightMinNode(Node rightChildRoot) {
		Node parent = rightChildRoot;
		Node focusNode = rightChildRoot;

		while (focusNode.leftChild != null) {
			parent = focusNode;
			focusNode = focusNode.leftChild;
		}

		parent.leftChild = null;
		return focusNode;
	}

	public void inOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverse(focusNode.leftChild);
			System.out.print(focusNode.key + " ");
			inOrderTraverse(focusNode.rightChild);
		}
	}

	public void preOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			System.out.print(focusNode.key + " ");
			preOrderTraverse(focusNode.leftChild);
			preOrderTraverse(focusNode.rightChild);
		}
	}

	public void postOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			postOrderTraverse(focusNode.leftChild);
			postOrderTraverse(focusNode.rightChild);
			System.out.print(focusNode.key + " ");
		}
	}

	public Node findNode(int key) {
		// 트리가 비었을 때
		if (root == null)
			return null;

		Node focusNode = root;

		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}

			// 찾으려는 노드가 없을 때
			if (focusNode == null)
				return null;
		}

		return focusNode;
	}

	public void BFS() {
		Queue<Node> q = new LinkedList<>();  //큐는 처음들어온게 먼저 나가지
		q.offer(root); 
		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.print(n.key + " ");
			if (n.leftChild != null)
				q.offer(n.leftChild);
			if (n.rightChild != null)
				q.offer(n.rightChild);
		}
	}

	// 방문하지 않은 자식 노드
	private Node getUnvisitedChildNode(Node n) {

		int index = nodes.indexOf(n);
		int j = 0;
		while (j < size) {
			if (adjMatrix[index][j] == 1 && ((Node) nodes.get(j)).visited == false) { //자식 노드 이면서 안들린곳
				return (Node) nodes.get(j);
			}
			j++;
		}
		return null;
	}

	public void DFS() {
		// DFS uses Stack data structure
		Stack s = new Stack();  //스택은 마지막 들어온거부터 나간당
		s.push(this.root);
		root.visited = true;
		printNode(root);
		while (!s.isEmpty()) {
			Node n = (Node) s.peek();// 마지막들어온새끼 누구야~
			Node child = getUnvisitedChildNode(n);
			if (child != null) {
				child.visited = true;
				printNode(child);
				s.push(child);
			} else {
				s.pop();
			}
		}
		// Clear visited property of nodes
		clearNodes(); //이거는 방문한 거 노드 지우는고야
	}

	// Utility methods for clearing visited property of node
	private void clearNodes() {
		int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.visited = false;
			i++;
		}
	}

	// Utility methods for printing the node's label
	private void printNode(Node n) {
		System.out.print(n.key + " ");
	}

	public static void main(String[] args) {

		BinarySearchTreeDFS bTree = new BinarySearchTreeDFS();
		BinarySearchTreeDFS bTree2 = new BinarySearchTreeDFS();

	
		// Adding nodes to the BinarySearchTree
//        bTree.addNode(50);
//        bTree.addNode(25);
//        bTree.addNode(75);
//        bTree.addNode(15);
//        bTree.addNode(30);
//        bTree.addNode(70);
//        bTree.addNode(85);
//        bTree.addNode(2);
//        bTree.addNode(18);
//        bTree.addNode(26);
//        bTree.addNode(32);
//        bTree.addNode(32);
//        bTree.addNode(32);
//        bTree.addNode(32);


		bTree2.addNode(50);
		bTree2.addNode(25);
		bTree2.addNode(15);
		bTree2.addNode(2);
		bTree2.addNode(18);
		bTree2.addNode(30);	
		bTree2.addNode(26);
		bTree2.addNode(32);
		bTree2.addNode(75);
		bTree2.addNode(70);		
		bTree2.addNode(85);
		

	


//        bTree.BFS();
//
//		// Tree traversal
//		System.out.println("\n---------- In Order Traversal ----------");
//		bTree.inOrderTraverse(bTree.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Pre Order Traversal ----------");
//		bTree.preOrderTraverse(bTree.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Post Order Traversal ----------");
//		bTree.postOrderTraverse(bTree.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Find Node ----------");
//		Node found = bTree.findNode(25);
//		System.out.println(found == null ? "not exists" : found);
//		System.out.println("\n");
//
//		// Deleting node
//		System.out.println("---------- Delete Node Test ----------");
//		bTree.deleteNode(15);
//		bTree.BFS();
//		System.out.println();

		////////////// DFS///////////////
		System.out.println("---------- 여기는 DFS ----------");
		
		
		
		bTree2.DFS();

		// Tree traversal
//		System.out.println("\n---------- In Order Traversal ----------");
//		bTree2.inOrderTraverse(bTree2.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Pre Order Traversal ----------");
//		bTree2.preOrderTraverse(bTree2.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Post Order Traversal ----------");
//		bTree2.postOrderTraverse(bTree2.getRoot());
//		System.out.println("\n");
//
//		System.out.println("---------- Find Node ----------");
//		Node found2 = bTree2.findNode(25);
//		System.out.println(found2 == null ? "not exists" : found2);
//		System.out.println("\n");
//
//		// Deleting node
//		System.out.println("---------- Delete Node Test ----------");
		System.out.println("지우기");
		bTree2.deleteNode(25);
		
		bTree2.DFS();
		System.out.println();
	}
}
