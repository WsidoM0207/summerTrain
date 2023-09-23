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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mMainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mMainFrm frame = new mMainFrm();
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
	public mMainFrm() {
		setTitle("影院经理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本数据维护");
		mnNewMenu.setIcon(new ImageIcon(mMainFrm.class.getResource("/images/_38OB($P)SY7%[D]53)6]O7.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("影片信息管理");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("影片添加");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieAddInterFrm movieAddInterFrm = new MovieAddInterFrm();
				movieAddInterFrm.setVisible(true);
				table.add(movieAddInterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("影片维护");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieManageInterFrm movieManageInterFrm = new MovieManageInterFrm();
				movieManageInterFrm.setVisible(true);
				table.add(movieManageInterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("排片管理");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("场次增加");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayAddInterFrm playAddInterFrm = new PlayAddInterFrm();
				playAddInterFrm.setVisible(true);
				table.add(playAddInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("场次信息维护");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayManageInterFrm playManageInterFrm = new PlayManageInterFrm();
				playManageInterFrm.setVisible(true);
				table.add(playManageInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("安全退出");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(mMainFrm.class.getResource("/images/N$@)W{([{_T7~G]W}B~RBBF.png")));
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置JFram最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
