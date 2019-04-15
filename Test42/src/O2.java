
public class O2 { //모든 클래스는 오브젝트 상속을 받음extends Object
	int name= 1;
	
	@Override
	public String toString() {
		return ""+ this.name;
		
	}
	@Override
	public boolean equals(Object obj) {
		O2 obj2= (O2)obj;
		if(this.name==obj2.name) {
			return true;
		}
		return false;
		//return this.name==obj2.name

}}
