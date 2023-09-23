package com.cinema.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cinema.dao.UserDao;
import com.cinema.model.User;
import com.cinema.util.DbUtil;
import com.cinema.util.StringUtil;

public class UserAddInterFrm extends JInternalFrame {
	private JTextField userNameTxt;
	private JTextField passwordTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField registrationTimeTxt;
	private JTextField costTotalTxt;
	private JTextField costNumTxt;
	private JTextField telNumberTxt;
	private JTextField mailNumberTxt;
	private JRadioButton goldenJrb;
	private JRadioButton sliveryJrb;
	private JRadioButton BrassJrb;
	private JTextField idTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddInterFrm frame = new UserAddInterFrm();
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
	public UserAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("用户添加");
		setBounds(100, 100, 440, 515);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("用户级别：");
		
		goldenJrb = new JRadioButton("金牌用户");
		buttonGroup.add(goldenJrb);
		
		sliveryJrb = new JRadioButton("银牌用户");
		buttonGroup.add(sliveryJrb);
		
		BrassJrb = new JRadioButton("铜牌用户");
		buttonGroup.add(BrassJrb);
		BrassJrb.setSelected(true);
		
		JLabel lblNewLabel_3 = new JLabel("用户注册时间：");
		
		registrationTimeTxt = new JTextField();
		registrationTimeTxt.setText("");
		registrationTimeTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		JLabel lblNewLabel_5 = new JLabel("用户累计消费总额：");
		
		costTotalTxt = new JTextField();
		costTotalTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("用户累计消费次数：");
		
		costNumTxt = new JTextField();
		costNumTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("用户手机号：");
		
		JLabel lblNewLabel_8 = new JLabel("用户邮箱：");
		
		telNumberTxt = new JTextField();
		telNumberTxt.setColumns(10);
		
		mailNumberTxt = new JTextField();
		mailNumberTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JLabel idlb = new JLabel("用户ID:");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(idlb, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(userNameTxt)
										.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(mailNumberTxt, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(30))
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(goldenJrb, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sliveryJrb, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(BrassJrb, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(costNumTxt))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(telNumberTxt, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
										.addComponent(registrationTimeTxt, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
										.addComponent(costTotalTxt))))))
					.addGap(59))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(108))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(idlb)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(goldenJrb)
						.addComponent(sliveryJrb)
						.addComponent(BrassJrb))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(registrationTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(costTotalTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(costNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(telNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(mailNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetValue();
	}

	/**
	 * 用户添加事件
	 * @param e
	 */
	private void userAddActionPerformed(ActionEvent evt) {
		String id = this.idTxt.getText();
		String userName = this.userNameTxt.getText();
		String password = this.passwordTxt.getText();
		String registrationTime = this.registrationTimeTxt.getText();
		String costTotal = this.costTotalTxt.getText();
		String costNum = this.costNumTxt.getText();
		String telNumber = this.telNumberTxt.getText();
		String mailNumber = this.mailNumberTxt.getText();
		
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "用户ID不能为空！");
			return;
		}
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(registrationTime)) {
			JOptionPane.showMessageDialog(null, "注册时间不能为空！");
			return;
		}
		
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
		
		User user = new User(Integer.parseInt(id), userName, password, userLevel, registrationTime, Integer.parseInt(costTotal), Integer.parseInt(costNum),
				telNumber, mailNumber);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = userDao.add(con, user);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "用户添加成功！");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "用户添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "用户添加失败！");
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
	 * 重置事件
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.idTxt.setText("");
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		this.BrassJrb.setSelected(true);
		this.registrationTimeTxt.setText("");
		this.costTotalTxt.setText("");
		this.costNumTxt.setText("");
		this.telNumberTxt.setText("");
		this.mailNumberTxt.setText("");
	}
}
