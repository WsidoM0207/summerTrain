package com.cinema.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.cinema.dao.UserTypeDao;
import com.cinema.model.UserType;
import com.cinema.util.DbUtil;
import com.cinema.util.StringUtil;

public class UserTypeAddInterFrm extends JInternalFrame {
	private JTextArea userTypeDescTxt; 
	private JTextField userTypeNameTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserTypeDao userTypeDao = new UserTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTypeAddInterFrm frame = new UserTypeAddInterFrm();
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
	public UserTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("用户类别添加");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("用户类别名称：");
		
		JLabel lblNewLabel_1 = new JLabel("用户类别描述：");
		
		userTypeNameTxt = new JTextField();
		userTypeNameTxt.setColumns(10);
		
		userTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserTypeAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(69)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(userTypeNameTxt)
								.addComponent(userTypeDescTxt, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(114)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(64)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userTypeDescTxt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(30))
		);
		getContentPane().setLayout(groupLayout);

		/**
		 * 设置文本域边框
		 */
		userTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
	}
	
	/**
	 * 用户类别添加事件处理
	 * @param e
	 */
	private void UserTypeAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userTypeName = this.userTypeNameTxt.getText();
		String userTypeDesc = this.userTypeDescTxt.getText();
		
		if(StringUtil.isEmpty(userTypeName)) {
			JOptionPane.showMessageDialog(null, "用户类别不能为空！");
			return;
		}
		UserType userType = new UserType(userTypeName, userTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = userTypeDao.add(con, userType);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "用户类别添加成功！");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "用户类别添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "用户类别添加失败！");
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
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.userTypeNameTxt.setText("");
		this.userTypeDescTxt.setText("");
	}
}
