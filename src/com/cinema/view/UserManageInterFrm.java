package com.cinema.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cinema.dao.UserDao;
import com.cinema.model.User;
import com.cinema.util.DbUtil;
import com.cinema.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserManageInterFrm extends JInternalFrame {
	private JTable userTable;
	private JTextField s_idTxt;
	JRadioButton sliveryJrb;
	JRadioButton BrassJrb;
	JRadioButton goldenJrb;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	private JTextField costTotalTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField costNumTxt;
	private JTextField telNumberTxt;
	private JTextField mailNumberTxt;
	private JTextField idTxt;
	private JTextField s_userNameTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManageInterFrm frame = new UserManageInterFrm();
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
	public UserManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("用户管理");
		setBounds(100, 100, 912, 509);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel_7 = new JLabel("用户名:");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 777, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(742))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(53))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_7)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2 = new JLabel("用户级别：");
		
		costTotalTxt = new JTextField();
		costTotalTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("累计消费总额：");
		
		goldenJrb = new JRadioButton("金牌用户");
		buttonGroup.add(goldenJrb);
		
		BrassJrb = new JRadioButton("铜牌用户");
		buttonGroup.add(BrassJrb);
		
		sliveryJrb = new JRadioButton("银牌用户");
		buttonGroup.add(sliveryJrb);
		
		JLabel lblNewLabel_4 = new JLabel("累计消费次数：");
		
		costNumTxt = new JTextField();
		costNumTxt.setText("");
		costNumTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("用户电话：");
		
		telNumberTxt = new JTextField();
		telNumberTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("用户邮箱：");
		
		mailNumberTxt = new JTextField();
		mailNumberTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userUpdateActionPerformed(evt);
			}
		});
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userDeleteActionPerformed(evt);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(goldenJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(BrassJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(sliveryJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(telNumberTxt, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mailNumberTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(60, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(costTotalTxt, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(costNumTxt, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(69))))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(175)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(140)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(271, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(goldenJrb))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sliveryJrb)
							.addGap(4)
							.addComponent(BrassJrb))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(8)
									.addComponent(telNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_5)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(24)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(26)
									.addComponent(costTotalTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(7)
									.addComponent(mailNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(11)
									.addComponent(lblNewLabel_6)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(30)
									.addComponent(lblNewLabel_4))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(24)
									.addComponent(costNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(33))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("用户ID：");
		
		s_idTxt = new JTextField();
		s_idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userSearchActionPerformed(e);
			}
		});
		
		s_userNameTxt = new JTextField();
		s_userNameTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_idTxt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_userNameTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(s_idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(s_userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton))))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		userTable = new JTable();
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				userTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(userTable);
		userTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237ID", "\u7528\u6237\u540D", "\u7528\u6237\u7EA7\u522B", "\u6CE8\u518C\u65F6\u95F4", "\u7D2F\u8BA1\u6D88\u8D39\u603B\u91D1\u989D", "\u7D2F\u8BA1\u6D88\u8D39\u6B21\u6570", "\u7528\u6237\u624B\u673A\u53F7", "\u7528\u6237\u90AE\u7BB1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		userTable.getColumnModel().getColumn(4).setPreferredWidth(109);
		userTable.getColumnModel().getColumn(5).setPreferredWidth(101);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new User());
	}
	
	/**
	 * 用户删除事件处理
	 * @param evt
	 */
	private void userDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请确认要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con = dbUtil.getCon();
				int deleteNum = userDao.delete(con, id);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new User());
				}
				else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
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

	/**
	 * 用户修改事件处理
	 * @param evt
	 */
	private void userUpdateActionPerformed(ActionEvent evt) {
		String id = this.idTxt.getText();
		String costTotal = this.costTotalTxt.getText();
		String costNum = this.costNumTxt.getText();
		String telNumber = this.telNumberTxt.getText();
		String mailNumber = this.mailNumberTxt.getText();
		
		if(StringUtil.isEmpty(costTotal)) {
			JOptionPane.showMessageDialog(null, "累计消费额不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(costNum)) {
			JOptionPane.showMessageDialog(null, "累计消费次数不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(telNumber)) {
			JOptionPane.showMessageDialog(null, "用户电话不能为空！");
			return;
		}
		
		String userLevel = "";
		if(goldenJrb.isSelected()) {
			userLevel = "金牌用户";
		}
		else if(sliveryJrb.isSelected()){
			userLevel = "银牌用户";
		}
		else if(BrassJrb.isSelected()){
			userLevel = "铜牌用户";
		}
		
		User user = new User(id, userLevel, Integer.parseInt(costTotal), Integer.parseInt(costNum), telNumber, mailNumber);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = userDao.update(con, user);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "用户修改成功！");
				resetValue();
				this.fillTable(new User());
			}
			else {
				JOptionPane.showMessageDialog(null, "用户修改失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "用户修改失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param me
	 */
	private void userTableMousePressed(MouseEvent me) {
		int row = this.userTable.getSelectedRow();
		this.idTxt.setText((String)userTable.getValueAt(row, 1));
		String level = (String)userTable.getValueAt(row,2);
		if("金牌用户".equals(level)) {
			this.goldenJrb.setSelected(true);
		}
		else if("银牌用户".equals(level)) {
			this.sliveryJrb.setSelected(true);
		}
		else if("铜牌用户".equals(level)) {
			this.BrassJrb.setSelected(true);
		}
		this.costTotalTxt.setText((Integer)userTable.getValueAt(row, 4)+"");
		this.costNumTxt.setText((Integer)userTable.getValueAt(row, 5)+"");
		this.telNumberTxt.setText((String)userTable.getValueAt(row, 6));
		this.mailNumberTxt.setText((String)userTable.getValueAt(row, 7)+"");
		
	}

	/**
	 * 用户查询事件处理
	 * @param e
	 */
	private void userSearchActionPerformed(ActionEvent evt) {
		String id = this.s_idTxt.getText();
		String userName = this.s_userNameTxt.getText();
		
		User user = new User(Integer.parseInt(id), userName);
		this.fillTable(user);
	}

	/**
	 * 初始化表格
	 * @param user
	 */
	private void fillTable(User user) {
		DefaultTableModel dtm = (DefaultTableModel) userTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con =dbUtil.getCon();
			ResultSet rs= userDao.list(con, user);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("ID"));
				v.add(rs.getString("userName"));
				v.add(rs.getString("userLevel"));
				v.add(rs.getString("registrationTime"));
				v.add(rs.getInt("costTotal"));
				v.add(rs.getInt("costNum"));
				v.add(rs.getString("telNumber"));
				v.add(rs.getString("mailNumber"));
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
	
	private void resetValue() {
		this.idTxt.setText("");
		this.BrassJrb.setSelected(true);
		this.costTotalTxt.setText("");
		this.costNumTxt.setText("");
		this.telNumberTxt.setText("");
		this.mailNumberTxt.setText("");
	}
}
