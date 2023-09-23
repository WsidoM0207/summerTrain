package com.cinema.view;

import java.awt.EventQueue;
import java.awt.Font;
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

import com.cinema.dao.PlayDao;
import com.cinema.model.Play;
import com.cinema.util.DbUtil;
import com.cinema.util.StringUtil;

public class PlayAddInterFrm extends JInternalFrame {
	private JTextField movieNameTxt;
	private JTextField priceTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton AJrb;
	private JRadioButton BJrb;
	private JRadioButton CJrb;
	private JRadioButton Jrb9;
	private JRadioButton Jrb14;
	private JRadioButton Jrb19;
	
	private DbUtil dbUtil = new DbUtil();
	private PlayDao playDao = new PlayDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayAddInterFrm frame = new PlayAddInterFrm();
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
	public PlayAddInterFrm() {
		setTitle("场次添加");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 400, 592);
		
		JLabel lblNewLabel = new JLabel("片名：");
		
		JLabel lblNewLabel_1 = new JLabel("价格：");
		
		JLabel lblNewLabel_2 = new JLabel("放映室：");
		
		JLabel lblNewLabel_3 = new JLabel("放映时间：");
		
		movieNameTxt = new JTextField();
		movieNameTxt.setColumns(10);
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		AJrb = new JRadioButton("A放映厅");
		buttonGroup.add(AJrb);
		AJrb.setSelected(true);
		AJrb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		BJrb = new JRadioButton("B放映厅");
		buttonGroup.add(BJrb);
		BJrb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		CJrb = new JRadioButton("C放映厅");
		buttonGroup.add(CJrb);
		CJrb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		Jrb9 = new JRadioButton("9：00-11：00");
		buttonGroup_1.add(Jrb9);
		Jrb9.setSelected(true);
		Jrb9.setFont(new Font("宋体", Font.PLAIN, 14));
		
		Jrb14 = new JRadioButton("14：00-16：00");
		buttonGroup_1.add(Jrb14);
		Jrb14.setFont(new Font("宋体", Font.PLAIN, 14));
		
		Jrb19 = new JRadioButton("19：00-21：00");
		buttonGroup_1.add(Jrb19);
		Jrb19.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAddActionPerformed(e);
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
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Jrb19, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(Jrb14, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(Jrb9, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(AJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(BJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(CJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(priceTxt, Alignment.LEADING)
							.addComponent(movieNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
					.addContainerGap(118, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(58))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(movieNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(AJrb))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(BJrb)
							.addGap(18)
							.addComponent(CJrb)
							.addGap(44)
							.addComponent(Jrb9))
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addComponent(Jrb14)
					.addGap(18)
					.addComponent(Jrb19)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.TRAILING)
						.addComponent(btnNewButton_1, Alignment.TRAILING))
					.addGap(30))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 场次添加
	 * @param evt
	 */
	private void playAddActionPerformed(ActionEvent evt) {
		String movieName = this.movieNameTxt.getText();
		String price = this.priceTxt.getText();
		String room = "";
		if(AJrb.isSelected()) {
			room = "A放映厅";
		}
		else if(BJrb.isSelected()){
			room = "B放映厅";
		}
		else if(CJrb.isSelected()){
			room = "C放映厅";
		}
		
		String time = "";
		if(Jrb9.isSelected()) {
			time = "9:00-11:00";
		}
		else if(Jrb14.isSelected()){
			time = "14:00-16:00";
		}
		else if(Jrb19.isSelected()){
			time = "19:00-21:00";
		}
		
		if(StringUtil.isEmpty(movieName)) {
			JOptionPane.showMessageDialog(null, "片名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空！");
			return;
		}
		
		Play play = new Play(movieName, Float.parseFloat(price), room, time);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = playDao.add(con, play);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "场次添加成功！");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "场次添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "场次添加失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetValue();
	}

	private void resetValue() {
		this.movieNameTxt.setText("");
		this.priceTxt.setText("");
		this.AJrb.setSelected(true);
		this.Jrb9.setSelected(true);
	}
}
