package kopoAwtProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class selloutMgmtView {

	String selloutTable = "KOPO_PRODUCT_VOLUME_SY3";
	String regionTable = "REGION_MASTER_SY3";
	
	private JFrame frame;
	private JTable tableSellout;
	
	private JTextField textRegion;

	// DataBase Connection information
	String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
	String DB_URL = "jdbc:oracle:thin:@192.168.110.14:1522/xe";
	String USERNAME = "SY2019";
	String PASSWORD = "sy2019";
			
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	DefaultTableModel model;
	
	private JTextField textRegionU;
	private JTextField textProductU;
	private JTextField textYearweekU;
	private JTextField textQtyU;
	
	/**
	 * Launch the application.
	 */
	public static void selloutView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selloutMgmtView window = new selloutMgmtView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public selloutMgmtView() {
		// Initialize Unit
		initialize();
		// Connect Database
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
		frame.setBounds(100, 100, 749, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSelectSellout = new JButton("\uC870\uD68C");
		btnSelectSellout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				try {
					dataSelect();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSelectSellout.setBounds(555, 80, 105, 27);
		frame.getContentPane().add(btnSelectSellout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				 int selectedRowIndex = tableSellout.getSelectedRow();
			       

			       textRegionU.setText(model.getValueAt(selectedRowIndex, 0).toString());
//			       String selectedProduct = model.getValueAt(selectedRowIndex, 1).toString();
//			       String selectedYearweek = model.getValueAt(selectedRowIndex, 2).toString();
//			       String selectedQty= model.getValueAt(selectedRowIndex, 3).toString();
			
			}
			
			
		});
		scrollPane.setBounds(24, 151, 358, 192);
		frame.getContentPane().add(scrollPane);
		
		tableSellout = new JTable();
		scrollPane.setViewportView(tableSellout);
		
		JButton btnInsertSellout = new JButton("\uCD94\uAC00");
		btnInsertSellout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		         try {
					dataInsert();
					dataSelect();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInsertSellout.setBounds(387, 316, 105, 27);
		frame.getContentPane().add(btnInsertSellout);
		
		JButton btnUpdateSellout = new JButton("\uC218\uC815");
		btnUpdateSellout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog (null, "판매량 정보만 변경 가능합니다.","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			    if (response == JOptionPane.YES_OPTION) {	
				try {
					dataUpdate();
					dataSelect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnUpdateSellout.setBounds(504, 316, 105, 27);
		frame.getContentPane().add(btnUpdateSellout);
		
		JButton btnDeleteSellout = new JButton("\uC0AD\uC81C");
		btnDeleteSellout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int response = JOptionPane.showConfirmDialog (null, "선택한 지역/상품/연주차 실적정보만 삭제됩니다.","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			    if (response == JOptionPane.YES_OPTION) { //The ISSUE is here	
				
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
		btnDeleteSellout.setBounds(623, 316, 105, 27);
		frame.getContentPane().add(btnDeleteSellout);
		
		JLabel label = new JLabel("\uC9C0\uC5ED\uBA85");
		label.setBounds(24, 84, 62, 18);
		frame.getContentPane().add(label);
		
		textRegion = new JTextField();
		textRegion.setBounds(100, 81, 116, 24);
		frame.getContentPane().add(textRegion);
		textRegion.setColumns(10);
		
		//table �ʱ� ����
		String[] columnNames = { "REGION_ID","REGION_NAME","PRODUCT","YEARWEEK","QTY" }; 
		
		scrollPane.setViewportView(tableSellout);
		tableSellout.setModel(new DefaultTableModel(
			new Object[][] {
			},
			columnNames
		));
		
		model = (DefaultTableModel)tableSellout.getModel();
		
		tableSellout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			       
				int selectedRowIndex = tableSellout.getSelectedRow();
				
			      textRegionU.setText(model.getValueAt(selectedRowIndex, 0).toString());
			      textProductU.setText(model.getValueAt(selectedRowIndex, 2).toString());
			      textYearweekU.setText(model.getValueAt(selectedRowIndex, 3).toString());
			      textQtyU.setText(model.getValueAt(selectedRowIndex, 4).toString());
			}
		});
		
		textRegionU = new JTextField();
		textRegionU.setColumns(10);
		textRegionU.setBounds(493, 156, 116, 24);
		frame.getContentPane().add(textRegionU);
		
		JLabel label_1 = new JLabel("\uC9C0\uC5ED");
		label_1.setBounds(410, 159, 62, 18);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uC0C1\uD488\uC815\uBCF4");
		label_2.setBounds(410, 205, 62, 18);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uC5F0\uC8FC\uCC28");
		label_3.setBounds(410, 246, 62, 18);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uD310\uB9E4\uB7C9");
		label_4.setBounds(410, 276, 62, 18);
		frame.getContentPane().add(label_4);
		
		textProductU = new JTextField();
		textProductU.setColumns(10);
		textProductU.setBounds(493, 202, 116, 24);
		frame.getContentPane().add(textProductU);
		
		textYearweekU = new JTextField();
		textYearweekU.setColumns(10);
		textYearweekU.setBounds(493, 243, 116, 24);
		frame.getContentPane().add(textYearweekU);
		
		textQtyU = new JTextField();
		textQtyU.setColumns(10);
		textQtyU.setBounds(493, 280, 116, 24);
		frame.getContentPane().add(textQtyU);
		
		
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

		String selectSql = "SELECT A.REGIONID, A.REGIONNAME, "
				+ "B.PRODUCTGROUP, B.YEARWEEK, B.VOLUME "
				+ "FROM "+regionTable+" A "
				+ "LEFT JOIN "+selloutTable+" B ON A.REGIONID = B.REGIONID "
				+ "ORDER BY A.REGIONNAME, PRODUCTGROUP, YEARWEEK";
		
		// set executed Query
		stmt = conn.prepareStatement(selectSql);
		// execute and return to rs variables
		rs = stmt.executeQuery();

			
		while(rs.next()) {
			Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getDouble(5)
					};
			
			model.addRow(data);
		}

	}
	
	public void dataInsert() throws SQLException{
		
		//String 
		String region = textRegionU.getText();
		String product = textProductU.getText();
		String yearweek = textYearweekU.getText();
		String qty = textQtyU.getText();

		try {
		String sql  = "INSERT INTO " + selloutTable+ " (REGIONID, PRODUCTGROUP, YEARWEEK, VOLUME) "
				+ "VALUES(?, ?, ?, ?)";

	     stmt =  conn.prepareStatement(sql);
	     stmt.setString(1, region);
	     stmt.setString(2, product );
	     stmt.setString(3, yearweek);
	     stmt.setString(4, qty);
	     
         System.out.println("Insert operation completed");

         stmt.executeUpdate();

	      } catch (SQLException ex) {
			ex.printStackTrace();
			String SqlError = ex.getMessage();
			JOptionPane.showMessageDialog(null, SqlError);
	      }	
	}
	
	public void dataUpdate() throws SQLException{
		

       int selectedRowIndex = tableSellout.getSelectedRow();
	       

       String selectedRegion = model.getValueAt(selectedRowIndex, 0).toString();
       String selectedProduct = model.getValueAt(selectedRowIndex, 2).toString();
       String selectedYearweek = model.getValueAt(selectedRowIndex, 3).toString();
       String selectedQty= model.getValueAt(selectedRowIndex, 4).toString();
	    
       String updateQty = textQtyU.getText();

       String updateSql  = "UPDATE " + selloutTable + " SET VOLUME = ?"
	     		+ " WHERE REGIONID = ? AND PRODUCTGROUP = ? AND YEARWEEK = ?";
        
		try {
	        	
	         stmt =  conn.prepareStatement(updateSql);
	         stmt.setString(1, updateQty);
	         stmt.setString(2, selectedRegion );
	         stmt.setString(3, selectedProduct);
	         stmt.setString(4, selectedYearweek);
	         
	         System.out.println("update operation completed");

	         stmt.executeUpdate();

	      } catch (SQLException ex) {
			ex.printStackTrace();
			String SqlError = ex.getMessage();
			JOptionPane.showMessageDialog(null, SqlError);
	
	      }		
	}
	
	public void dataDelete() throws SQLException{
		
		int selectedRowIndex = tableSellout.getSelectedRow();
	       

	       String selectedRegion = model.getValueAt(selectedRowIndex, 0).toString();
	       String selectedProduct = model.getValueAt(selectedRowIndex, 2).toString();
	       String selectedYearweek = model.getValueAt(selectedRowIndex, 3).toString();
	       String selectedQty= model.getValueAt(selectedRowIndex, 4).toString();
		    
	       //String qty = textQtyU.getText();

	       String updateSql  = "DELETE FROM  " + selloutTable + " WHERE REGIONID = ? AND PRODUCTGROUP = ? AND YEARWEEK = ?";
	        
			try {
		        	
		         stmt =  conn.prepareStatement(updateSql);
		         stmt.setString(1, selectedRegion );
		         stmt.setString(2, selectedProduct);
		         stmt.setString(3, selectedYearweek);
		         
		         System.out.println("delete operation completed");

		         stmt.executeUpdate();

		      } catch (SQLException ex) {
				ex.printStackTrace();
				String SqlError = ex.getMessage();
				JOptionPane.showMessageDialog(null, SqlError);
		
		      }			
	}
}
