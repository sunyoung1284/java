package kopoAwtProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class regionMgmtView {

	String selloutTable = "KOPO_PRODUCT_VOLUME_SY3";
	String regionTable = "REGION_MASTER_SY3";
	
	private JFrame frame;
	private JTextField textRegionName;
	private JTextField textRegionIdU;
	private JTextField textRegionNameU;

	// DataBase Connection information
	String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
	String DB_URL = "jdbc:oracle:thin:@192.168.110.14:1522/xe";
	String USERNAME = "SY2019";
	String PASSWORD = "sy2019";


			
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
		
	DefaultTableModel model;
	private JTable tableRegion;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JTextField selectedRegion;
	/**
	 * Launch the application.
	 */
	public static void rgView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regionMgmtView window = new regionMgmtView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public regionMgmtView() {
		
		initialize();
		
		try {
			dbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 718, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		textRegionName = new JTextField();
		textRegionName.setBounds(167, 95, 116, 24);
		frame.getContentPane().add(textRegionName);
		textRegionName.setColumns(10);
		
		JButton btnRegionSelect = new JButton("\uC870\uD68C");
		btnRegionSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						// 데이터 조회 함수
						dataSelect();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnRegionSelect.setBounds(488, 82, 105, 27);
		frame.getContentPane().add(btnRegionSelect);
		
		textRegionIdU = new JTextField();
		textRegionIdU.setColumns(10);
		textRegionIdU.setBounds(424, 226, 116, 24);
		frame.getContentPane().add(textRegionIdU);
		
		textRegionNameU = new JTextField();
		textRegionNameU.setColumns(10);
		textRegionNameU.setBounds(424, 282, 116, 24);
		frame.getContentPane().add(textRegionNameU);
		
		JButton btnRegionAdd = new JButton("\uCD94\uAC00");
		btnRegionAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dataInsert();
					dataSelect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegionAdd.setBounds(342, 377, 105, 27);
		frame.getContentPane().add(btnRegionAdd);
		
		JButton btnRegionUpdate = new JButton("\uC218\uC815");
		btnRegionUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dataUpdate();
					dataSelect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegionUpdate.setBounds(462, 377, 105, 27);
		frame.getContentPane().add(btnRegionUpdate);
		
		JButton btnRegionDelete = new JButton("\uC0AD\uC81C");
		btnRegionDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int response = JOptionPane.showConfirmDialog (null, "연관된 선택 지역의 실적정보가 함꼐 삭제됩니다. 그래도 진행하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			    if (response == JOptionPane.YES_OPTION) {
				
					try {
						dataDelete();
						dataSelect();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
			}
		});
		btnRegionDelete.setBounds(581, 377, 105, 27);
		frame.getContentPane().add(btnRegionDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 202, 225, 189);
		frame.getContentPane().add(scrollPane);
		
		tableRegion = new JTable();
		scrollPane.setViewportView(tableRegion);
		
		//table �ʱ� ����
		String[] columnNames = { "REGION_ID","REGION_NAME"}; 
		
		tableRegion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			columnNames
		));
		
		lblNewLabel = new JLabel("\uC9C0\uC5EDID");
		lblNewLabel.setBounds(330, 229, 62, 18);
		frame.getContentPane().add(lblNewLabel);
		
		label = new JLabel("\uC9C0\uC5ED\uBA85");
		label.setBounds(330, 285, 62, 18);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("\uC9C0\uC5ED\uBA85");
		label_1.setBounds(58, 98, 62, 18);
		frame.getContentPane().add(label_1);
		
		selectedRegion = new JTextField();
		selectedRegion.setEditable(false);
		selectedRegion.setColumns(10);
		selectedRegion.setBounds(424, 175, 116, 24);
		frame.getContentPane().add(selectedRegion);
		
		JLabel lblId = new JLabel("선택지역 ID");
		lblId.setBounds(330, 178, 80, 18);
		frame.getContentPane().add(lblId);
		
		model = (DefaultTableModel)tableRegion.getModel();
		
		tableRegion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			       
				int selectedRowIndex = tableRegion.getSelectedRow();
				
				  selectedRegion.setText(model.getValueAt(selectedRowIndex, 0).toString());
			      textRegionIdU.setText(model.getValueAt(selectedRowIndex, 0).toString());
			      textRegionNameU.setText(model.getValueAt(selectedRowIndex, 1).toString());
			}
		});
	}

	public void dbConnection() throws SQLException {
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			//conn.setAutoCommit(true);
			System.out.println("Opened database successfully");

		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void dataSelect() throws SQLException{
		
		
		model.setNumRows(0);

		String selectCondition = textRegionName.getText();
		
		String selectSql = "SELECT * FROM "+regionTable+" WHERE REGIONNAME LIKE '%"+selectCondition+"%' order by REGIONNAME";
		
		// set executed Query
		stmt = conn.prepareStatement(selectSql);
		// execute and return to rs variables
		rs = stmt.executeQuery();

			
		while(rs.next()) {
			Object data[] = { rs.getString(1), rs.getString(2)
					};
			
			model.addRow(data);
		}

	}
	
	public void dataInsert() throws SQLException{
		
		//String 
		String regionId = textRegionIdU.getText();
		String regionName = textRegionNameU.getText();

		try {
		String sql  = "INSERT INTO " + regionTable+ " (REGIONID, REGIONNAME) "
				+ "VALUES(?, ?)";

	     stmt =  conn.prepareStatement(sql);
	     stmt.setString(1, regionId);
	     stmt.setString(2, regionName );
	     
         stmt.executeUpdate();
         
         System.out.println("Insert operation completed");

	      } catch (SQLException ex) {
			ex.printStackTrace();
			String SqlError = ex.getMessage();
			JOptionPane.showMessageDialog(null, SqlError);
	      }	
	}
	
	public void dataUpdate() throws SQLException{
		

       int selectedRowIndex = tableRegion.getSelectedRow();
	       
       String selectedRegionId = model.getValueAt(selectedRowIndex, 0).toString();
       String updateRegionId = textRegionIdU.getText();
       String updateRegionName = textRegionNameU.getText();
       

       String updateSql  = "UPDATE " + regionTable + " SET REGIONID = ?, REGIONNAME = ?"
	     		+ " WHERE REGIONID = ? ";
        
		try {
	        	
	         stmt =  conn.prepareStatement(updateSql);
	         stmt.setString(1, updateRegionId);
	         stmt.setString(2, updateRegionName);
	         stmt.setString(3, selectedRegionId);
	         System.out.println("update operation completed");

	         stmt.executeUpdate();

	      } catch (SQLException ex) {
			ex.printStackTrace();
			String SqlError = ex.getMessage();
			JOptionPane.showMessageDialog(null, SqlError);
	
	      }		
	}
	
	public void dataDelete() throws SQLException{
		
		int selectedRowIndex = tableRegion.getSelectedRow();
	       
	       String selectedRegionId = selectedRegion.getText();

	       String updateSql  = "DELETE FROM  " + regionTable + " WHERE REGIONID = ?" ;
	        
			try {
		        	
		         stmt =  conn.prepareStatement(updateSql);
		         stmt.setString(1, selectedRegionId );
		         
		         System.out.println("delete operation completed");

		         stmt.executeUpdate();

		      } catch (SQLException ex) {
				ex.printStackTrace();
				String SqlError = ex.getMessage();
				JOptionPane.showMessageDialog(null, SqlError);
		
		      }			
	}
}
