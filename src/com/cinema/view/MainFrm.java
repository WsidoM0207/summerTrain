package com.cinema.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("影院管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本数据维护");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/_38OB($P)SY7%[D]53)6]O7.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("用户管理");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("用户信息添加");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAddInterFrm userAddInterFrm = new UserAddInterFrm();
				userAddInterFrm.setVisible(true);
				table.add(userAddInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("用户信息维护");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManageInterFrm userManageInterFrm = new UserManageInterFrm();
				userManageInterFrm.setVisible(true);
				table.add(userManageInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("安全退出");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/N$@)W{([{_T7~G]W}B~RBBF.png")));
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		/**
		 * 设置最大化
		 */
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
