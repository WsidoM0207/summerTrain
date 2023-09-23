package com.cinema.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cinema.dao.UserTypeDao;
import com.cinema.model.UserType;
import com.cinema.util.DbUtil;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserTypeManageInterFrm extends JInternalFrame {
	private JTable userTypeTable;
	
	private DbUtil dbUtil = new DbUtil();
	private UserTypeDao userTypeDao = new UserTypeDao();
	private JTextField s_userTypeNameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTypeManageInterFrm frame = new UserTypeManageInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserTypeManageInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("用户类别管理");
		setBounds(100, 100, 495, 493);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("用户类别名称：");
		
		s_userTypeNameTxt = new JTextField();
		s_userTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTypeSearchActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_userTypeNameTxt, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(48))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
							.addGap(66))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_userTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		
		userTypeTable = new JTable();
		userTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7528\u6237\u7C7B\u522B", "\u7528\u6237\u7C7B\u522B\u63CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		userTypeTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		userTypeTable.getColumnModel().getColumn(2).setPreferredWidth(106);
		scrollPane.setViewportView(userTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new UserType());
	}
	
	/**
	 * 用户类别搜索事件处理
	 * @param evt
	 */
	private void userTypeSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_userTypeName = this.s_userTypeNameTxt.getText();
		UserType userType = new UserType();
		this.fillTable(userType);
	}

	/**
	 * 初始化表格
	 * @param userType
	 */
	private void fillTable(UserType userType) {
		DefaultTableModel dtm = (DefaultTableModel) userTypeTable.getModel();
		dtm.setRowCount(0);  //设置成零行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = userTypeDao.list(con, userType);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("userTypeName"));
				v.add(rs.getString("userTypeDesc"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
