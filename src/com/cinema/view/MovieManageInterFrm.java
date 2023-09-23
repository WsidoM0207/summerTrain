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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.cinema.dao.MovieDao;
import com.cinema.model.Movie;
import com.cinema.model.User;
import com.cinema.util.DbUtil;
import com.cinema.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MovieManageInterFrm extends JInternalFrame {
	private JTable movieTable;
	private JTextField s_movieNameTxt;
	private JTextField s_directorTxt;
	private JTextField s_actorTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private MovieDao movieDao = new MovieDao();
	private JTextField movieNameTxt;
	private JTextField directorTxt;
	private JTextField actorTxt;
	private JTextField durationTxt;
	private JTextArea briefTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieManageInterFrm frame = new MovieManageInterFrm();
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
	public MovieManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("影片管理");
		setBounds(100, 100, 724, 621);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_3 = new JLabel("片名：");
		
		movieNameTxt = new JTextField();
		movieNameTxt.setEditable(false);
		movieNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("主演：");
		
		JLabel lblNewLabel_5 = new JLabel("导演：");
		
		JLabel lblNewLabel_6 = new JLabel("时长：");
		
		directorTxt = new JTextField();
		directorTxt.setColumns(10);
		
		actorTxt = new JTextField();
		actorTxt.setColumns(10);
		
		durationTxt = new JTextField();
		durationTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("剧情简介：");
		
		briefTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				movieUpdateActionPerformed(evt);
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
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(movieNameTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(directorTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
							.addGap(31)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addComponent(durationTxt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(actorTxt, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(briefTxt, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(168, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(435, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(55))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(movieNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(actorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(btnNewButton_1)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(directorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(durationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(briefTxt, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(59, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(39)
							.addComponent(btnNewButton_2)
							.addContainerGap())))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("片名：");
		
		s_movieNameTxt = new JTextField();
		s_movieNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("导演：");
		
		s_directorTxt = new JTextField();
		s_directorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("主演：");
		
		s_actorTxt = new JTextField();
		s_actorTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movieSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(s_movieNameTxt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(s_directorTxt, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(s_actorTxt, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(s_movieNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(s_directorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(s_actorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(btnNewButton)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		movieTable = new JTable();
		movieTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				movieTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(movieTable);
		movieTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7247\u540D", "\u5BFC\u6F14", "\u4E3B\u6F14", "\u65F6\u957F\uFF08\u5206\u949F\uFF09", "\u5267\u60C5\u7B80\u4ECB"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		movieTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		getContentPane().setLayout(groupLayout);

		
		/**
		 * 设置文本域边框
		 */
		briefTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
	
		this.fillTable(new Movie());
	}
	
	/**
	 * 修改事件
	 * @param evt
	 */
	private void movieUpdateActionPerformed(ActionEvent evt) {
		String movieName = this.movieNameTxt.getText();
		String director = this.directorTxt.getText();
		String actor = this.actorTxt.getText();
		String duration = this.durationTxt.getText();
		String brief = this.briefTxt.getText();
		
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
			int addNum = movieDao.update(con, movie);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "影片修改成功！");
				resetValue();
				this.fillTable(new Movie());
			}
			else {
				JOptionPane.showMessageDialog(null, "影片修改失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "影片修改失败！");
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
		this.movieNameTxt.setText("");
		this.directorTxt.setText("");
		this.actorTxt.setText("");
		this.durationTxt.setText("");
		this.briefTxt.setText("");
	}

	/**
	 * 影片查询
	 * @param e
	 */
	private void movieSearchActionPerformed(ActionEvent e) {
		String movieName = this.s_movieNameTxt.getText();
		String director = this.s_directorTxt.getText();
		String actor = this.s_actorTxt.getText();
		
		Movie movie = new Movie(movieName, director, actor);
		this.fillTable(movie);
	}

	/**
	 * 表格填充
	 * @param movie
	 */
	private void fillTable(Movie movie) {
		DefaultTableModel dtm = (DefaultTableModel) movieTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con =dbUtil.getCon();
			ResultSet rs= movieDao.list(con, movie);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("movie"));
				v.add(rs.getString("director"));
				v.add(rs.getString("actor"));
				v.add(rs.getInt("duration"));
				v.add(rs.getString("brief"));
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
	 * 表格行点击事件处理
	 * @param me
	 */
	private void movieTableMousePressed(MouseEvent met) {
		int row = this.movieTable.getSelectedRow();
		this.movieNameTxt.setText((String)movieTable.getValueAt(row, 0));
		this.directorTxt.setText((String)movieTable.getValueAt(row, 1));
		this.actorTxt.setText((String)movieTable.getValueAt(row, 2));
		this.durationTxt.setText((Integer)movieTable.getValueAt(row, 3) + "");
		this.briefTxt.setText((String)movieTable.getValueAt(row, 4));
	}
	
	/**
	 *影片删除事件处理
	 * @param evt
	 */
	private void userDeleteActionPerformed(ActionEvent evt) {
		String movieName = movieNameTxt.getText();
		if(StringUtil.isEmpty(movieName)) {
			JOptionPane.showMessageDialog(null, "请确认要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con = dbUtil.getCon();
				int deleteNum = movieDao.delete(con, movieName);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Movie());
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
}
