package com.cinema.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.cinema.dao.AdminDao;
import com.cinema.model.Admin;
import com.cinema.util.DbUtil;
import com.cinema.util.StringUtil;

public class logOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField adminNameTxt;
	private JPasswordField passwordTxt;

	private DbUtil dbUtil = new DbUtil();
	private AdminDao adminDao = new AdminDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logOnFrm frame = new logOnFrm();
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
	public logOnFrm() {
		setTitle("影院管理员系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("影院管理系统");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 19));
		lblNewLabel.setIcon(new ImageIcon(logOnFrm.class.getResource("/images/movie.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("用户名：");
		lblNewLabel_1.setIcon(new ImageIcon(logOnFrm.class.getResource("/images/1692951117300.jpg")));
		
		JLabel lblNewLabel_2 = new JLabel(" 密   码：");
		lblNewLabel_2.setIcon(new ImageIcon(logOnFrm.class.getResource("/images/1692950969562.jpg")));
		
		adminNameTxt = new JTextField();
		adminNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetVauleActionPerformeed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(50, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(22)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(adminNameTxt, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
								.addComponent(passwordTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
					.addGap(118))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(lblNewLabel_2)))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		
		/**
		 * 设置居中
		 */
		this.setLocationRelativeTo(null);
	}

	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String adminName = this.adminNameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(adminName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		Admin admin = new Admin(adminName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			Admin currentAdmin = adminDao.login(con, admin);
			if(currentAdmin != null) {
//				JOptionPane.showMessageDialog(null, "登录成功！");
				dispose();
				new MainFrm().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件
	 * @param e
	 */
	private void resetVauleActionPerformeed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.adminNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
