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

import com.cinema.dao.MovieDao;
import com.cinema.model.Movie;
import com.cinema.util.DbUtil;
import com.cinema.util.StringUtil;

public class MovieAddInterFrm extends JInternalFrame {
	private JTextField movieNameTxt;
	private JTextField directorTxt;
	private JTextField actorTxt;
	private JTextField durationTxt;
	private JTextArea briefTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private MovieDao movieDao = new MovieDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieAddInterFrm frame = new MovieAddInterFrm();
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
	public MovieAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("影片添加");
		setBounds(100, 100, 450, 518);
		
		JLabel lblNewLabel = new JLabel("片名：");
		
		JLabel lblNewLabel_1 = new JLabel("导演：");
		
		JLabel lblNewLabel_2 = new JLabel("主演：");
		
		JLabel lblNewLabel_3 = new JLabel("时长：");
		
		JLabel lblNewLabel_4 = new JLabel("剧情简介：");
		
		movieNameTxt = new JTextField();
		movieNameTxt.setColumns(10);
		
		directorTxt = new JTextField();
		directorTxt.setColumns(10);
		
		actorTxt = new JTextField();
		actorTxt.setColumns(10);
		
		durationTxt = new JTextField();
		durationTxt.setColumns(10);
		
		briefTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movieAddActionPerformed(e);
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
					.addGap(94)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(durationTxt, 156, 156, 156))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(actorTxt, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(directorTxt, 156, 156, 156))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(movieNameTxt, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(briefTxt, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addGap(112))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(movieNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(directorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(actorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(durationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(briefTxt, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(23))
		);
		getContentPane().setLayout(groupLayout);

		/**
		 * 设置文本域边框
		 */
		briefTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
	}

	/**
	 * 影片添加
	 * @param evt
	 */
	private void movieAddActionPerformed(ActionEvent evt) {
		String movieName = this.movieNameTxt.getText();
		String director = this.directorTxt.getText();
		String actor = this.actorTxt.getText();
		String duration = this.durationTxt.getText();
		String brief = this.briefTxt.getText();
		
		if(StringUtil.isEmpty(movieName)) {
			JOptionPane.showMessageDialog(null, "片名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(director)) {
			JOptionPane.showMessageDialog(null, "导演不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(actor)) {
			JOptionPane.showMessageDialog(null, "主演不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(duration)) {
			JOptionPane.showMessageDialog(null, "时长不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(brief)) {
			JOptionPane.showMessageDialog(null, "剧情简介不能为空！");
			return;
		}
		
		Movie movie = new Movie(movieName, director, actor, Integer.parseInt(duration), brief);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = movieDao.add(con, movie);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "影片添加成功！");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "影片添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "影片添加失败！");
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
		resetValue();
	}

	private void resetValue() {
		this.movieNameTxt.setText("");
		this.directorTxt.setText("");
		this.actorTxt.setText("");
		this.durationTxt.setText("");
		this.briefTxt.setText("");
	}
}
