package com.cinema.view;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cinema.dao.PlayDao;
import com.cinema.model.Movie;
import com.cinema.model.Play;
import com.cinema.util.DbUtil;
import com.cinema.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayManageInterFrm extends JInternalFrame {
	private JTable playTable;
	private JTextField s_movieNameTxt;
	private JTextField s_roomTxt;
	private JTextField s_timeTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private PlayDao playDao = new PlayDao();
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayManageInterFrm frame = new PlayManageInterFrm();
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
	public PlayManageInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("场次管理");
		setBounds(100, 100, 767, 559);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(108)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_3 = new JLabel("片名：");
		
		movieNameTxt = new JTextField();
		movieNameTxt.setEditable(false);
		movieNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("价格：");
		
		priceTxt =  new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("放映室：");
		
		AJrb = new JRadioButton("A放映厅");
		buttonGroup.add(AJrb);
		AJrb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		BJrb = new JRadioButton("B放映厅");
		buttonGroup.add(BJrb);
		BJrb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		CJrb = new JRadioButton("C放映厅");
		buttonGroup.add(CJrb);
		CJrb.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("放映时间：");
		
		Jrb9 = new JRadioButton("9:00-11:00");
		buttonGroup_1.add(Jrb9);
		Jrb9.setFont(new Font("宋体", Font.PLAIN, 14));
		
		Jrb14 = new JRadioButton("14:00-16:00");
		buttonGroup_1.add(Jrb14);
		Jrb14.setFont(new Font("宋体", Font.PLAIN, 14));
		
		Jrb19 = new JRadioButton("19:00-21:00");
		buttonGroup_1.add(Jrb19);
		Jrb19.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				playUpdateActionPerformed(evt);
			}
		});
		
		JButton btnNewButton_2 = new JButton("删除");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(movieNameTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(BJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(AJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(CJrb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(24)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(Jrb9, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(100)
							.addComponent(Jrb14, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(101)
							.addComponent(Jrb19, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(47))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(movieNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_4)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(btnNewButton_1)
							.addGap(4)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(AJrb)
								.addComponent(lblNewLabel_6))
							.addGap(18)
							.addComponent(BJrb)
							.addGap(18)
							.addComponent(CJrb))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(25)
							.addComponent(Jrb9)
							.addGap(19)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(Jrb14)
								.addComponent(btnNewButton_2))
							.addGap(21)
							.addComponent(Jrb19)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("片名：");
		
		JLabel lblNewLabel_1 = new JLabel("放映室：");
		
		JLabel lblNewLabel_2 = new JLabel("放映时间：");
		
		s_movieNameTxt = new JTextField();
		s_movieNameTxt.setColumns(10);
		
		s_roomTxt = new JTextField();
		s_roomTxt.setColumns(10);
		
		s_timeTxt = new JTextField();
		s_timeTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_movieNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_roomTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(s_timeTxt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(s_movieNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(s_roomTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(s_timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addComponent(btnNewButton)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		playTable = new JTable();
		playTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				playTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(playTable);
		playTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7247\u540D", "\u4EF7\u683C", "\u653E\u6620\u5BA4", "\u653E\u6620\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		playTable.getColumnModel().getColumn(3).setPreferredWidth(111);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Play());
	}
	
	/**
	 * 表格填充
	 * @param movie
	 */
	private void fillTable(Play play) {
		DefaultTableModel dtm = (DefaultTableModel) playTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con =dbUtil.getCon();
			ResultSet rs= playDao.list(con, play);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("movieName"));
				v.add(rs.getString("price"));
				v.add(rs.getString("room"));
				v.add(rs.getString("time"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 场次查询
	 * @param e
	 */
	private void playSearchActionPerformed(ActionEvent e) {
		String movieName = this.s_movieNameTxt.getText();
		String director = this.s_roomTxt.getText();
		String actor = this.s_timeTxt.getText();
		
		Play play = new Play(movieName, director, actor);
		this.fillTable(play);
	}
	
	/**
	 * 表格行点击事件处理
	 * @param me
	 */
	private void playTableMousePressed(MouseEvent met) {
		int row = this.playTable.getSelectedRow();
		this.movieNameTxt.setText((String)playTable.getValueAt(row, 0));
		this.priceTxt.setText((String)playTable.getValueAt(row, 1));
		String room = (String)playTable.getValueAt(row,2);
		if("A放映厅".equals(room)) {
			this.AJrb.setSelected(true);
		}
		else if("B放映厅".equals(room)) {
			this.BJrb.setSelected(true);
		}
		else if("C放映厅".equals(room)) {
			this.CJrb.setSelected(true);
		}
		String time = (String)playTable.getValueAt(row,3);
		if("9:00-11:00".equals(time)) {
			this.Jrb9.setSelected(true);
		}
		else if("14:00-16:00".equals(time)) {
			this.Jrb14.setSelected(true);
		}
		else if("19:00-21:00".equals(time)) {
			this.Jrb19.setSelected(true);
		}
	}
	
	/**
	 * 修改事件
	 * @param evt
	 */
	private void playUpdateActionPerformed(ActionEvent evt) {
		String movieName = this.movieNameTxt.getText();
		String price = this.priceTxt.getText();
		String room = "";
		if(AJrb.isSelected()) {
			room = "A放映厅";
		}
		else if(BJrb.isSelected()) {
			room = "B放映厅";
		}
		else if(CJrb.isSelected()) {
			room = "C放映厅";
		}
		String time = "";
		if(Jrb9.isSelected()) {
			time = "9:00-11:00";
		}
		else if(Jrb14.isSelected()) {
			time = "14:00-16:00";
		}
		else if(Jrb19.isSelected()) {
			time = "19:00-21:00";
		}
		Play play = new Play(movieName, Float.parseFloat(price), room, time);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = playDao.update(con, play);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "场次修改成功！");
				resetValue();
				this.fillTable(new Play());
			}
			else {
				JOptionPane.showMessageDialog(null, "场次修改失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "场次修改失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void resetValue() {
		this.movieNameTxt.setText("");
		this.priceTxt.setText("");
		this.AJrb.setSelected(true);
		this.Jrb9.setSelected(true);
	}
}
