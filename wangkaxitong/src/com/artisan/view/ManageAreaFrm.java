package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import com.artisan.dao.AreaDao;
import com.artisan.model.Area;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageAreaFrm extends JInternalFrame {
	private JTextField searchAreaNameTextField;
	private JTable areaListTable;
	private JTextField editAreaNameTextField;
	private JTextArea editAreaInfoTextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAreaFrm frame = new ManageAreaFrm();
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
	public ManageAreaFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u673A\u533A\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 773, 562);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u673A\u533A\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(ManageAreaFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchAreaNameTextField = new JTextField();
		searchAreaNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Area sc = new Area();
				sc.setName(searchAreaNameTextField.getText().toString());
				setTable(sc);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageAreaFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u673A\u533A\u540D\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(ManageAreaFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editAreaNameTextField = new JTextField();
		editAreaNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u673A\u533A\u4FE1\u606F\uFF1A");
		label_2.setIcon(new ImageIcon(ManageAreaFrm.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editAreaInfoTextArea = new JTextArea();
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageAreaFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteAreaAct(ae);
			}
		});
		submitDeleteButton.setIcon(new ImageIcon(ManageAreaFrm.class.getResource("/images/\u5220\u9664.png")));
		submitDeleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(160)
							.addComponent(label)
							.addGap(18)
							.addComponent(searchAreaNameTextField, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2)
									.addGap(18)
									.addComponent(editAreaInfoTextArea))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(editAreaNameTextField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
							.addGap(102)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(submitDeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(submitEditButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchAreaNameTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(editAreaNameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(editAreaInfoTextArea, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addGap(32))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(submitEditButton)
							.addGap(34)
							.addComponent(submitDeleteButton)
							.addContainerGap())))
		);
		
		areaListTable = new JTable();
		areaListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		areaListTable.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		areaListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u673A\u533A\u7F16\u53F7", "\u673A\u533A\u540D\u79F0", "\u673A\u5668\u4F7F\u7528\u4FE1\u606F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		areaListTable.getColumnModel().getColumn(2).setPreferredWidth(316);
		scrollPane.setViewportView(areaListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Area());
	}
	protected void deleteAreaAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		int index = areaListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) areaListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(areaListTable.getSelectedRow(), 0).toString());
		AreaDao classDao = new AreaDao();
		if(classDao.delete(id)){
			JOptionPane.showMessageDialog(this, "删除成功!");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败!");
		}
		classDao.closeDao();
		setTable(new Area());
	}

	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		AreaDao areaDao = new AreaDao();
		int index = areaListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) areaListTable.getModel();
		String areaName = dft.getValueAt(areaListTable.getSelectedRow(), 1).toString();
		String areaInfo = dft.getValueAt(areaListTable.getSelectedRow(), 2).toString();
		String editAreaName = editAreaNameTextField.getText().toString();
		String editAreaInfo = editAreaInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editAreaName)){
			JOptionPane.showMessageDialog(this, "请填写要修改的名称!");
			return;
		}
		if(areaName.equals(editAreaName) && areaInfo.equals(editAreaInfo)){
			JOptionPane.showMessageDialog(this, "您还没有做任何修改!");
			return;
		}
		int id = Integer.parseInt(dft.getValueAt(areaListTable.getSelectedRow(), 0).toString());
		Area sc = new Area();
		sc.setId(id);
		sc.setName(editAreaName);
		sc.setInfo(editAreaInfo);
		if(areaDao.update(sc)){
			JOptionPane.showMessageDialog(this, "更新成功!");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败!");
		}
		areaDao.closeDao();
		setTable(new Area());
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) areaListTable.getModel();
		editAreaNameTextField.setText(dft.getValueAt(areaListTable.getSelectedRow(), 1).toString());
		editAreaInfoTextArea.setText(dft.getValueAt(areaListTable.getSelectedRow(), 2).toString());
	}

	private void setTable(Area customerArea){
		DefaultTableModel dft = (DefaultTableModel) areaListTable.getModel();
		dft.setRowCount(0);
		AreaDao areaDao = new AreaDao();
		List<Area> areaList = areaDao.getAreaList(customerArea);
		for (Area sc : areaList) {
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);
		}
		areaDao.closeDao();
	}
}
