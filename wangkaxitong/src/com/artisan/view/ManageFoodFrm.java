package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.FoodDao;
import com.artisan.model.Food;
import com.artisan.util.StringUtil;
import java.awt.Color;

public class ManageFoodFrm extends JInternalFrame {
	private JTable foodListTable;
	private JTextField searchFoodNameTextField;
	private JTextField editFoodNameTextField;
	private JTextField editFoodTypeTextField;
	private JTextField editFoodpriceTextField;
	private JTextField editFoodProductField;
	private JButton deleteFoodButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageFoodFrm frame = new ManageFoodFrm();
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
	public ManageFoodFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u98DF\u54C1\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 805, 691);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u98DF\u54C1\u540D\u79F0\uFF1A");
		label.setIcon(null);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchFoodNameTextField = new JTextField();
		searchFoodNameTextField.setColumns(10);
		
		JButton searchFoodButton = new JButton("\u67E5\u8BE2");
		searchFoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFood(e);
			}
		});
		searchFoodButton.setIcon(new ImageIcon(ManageFoodFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchFoodButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u98DF\u54C1\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(178)
							.addComponent(label)
							.addGap(33)
							.addComponent(searchFoodNameTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(searchFoodButton))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(92)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchFoodNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(searchFoodButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u98DF\u54C1\u540D\u79F0\uFF1A");
		label_1.setIcon(null);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editFoodNameTextField = new JTextField();
		editFoodNameTextField.setColumns(10);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JLabel label_3 = new JLabel("\u98DF\u54C1\u7C7B\u578B\uFF1A");
		label_3.setIcon(null);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editFoodTypeTextField = new JTextField();
		editFoodTypeTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u98DF\u54C1\u4EF7\u683C\uFF1A");
		label_4.setIcon(null);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editFoodpriceTextField = new JTextField();
		editFoodpriceTextField.setColumns(10);
		
		JLabel lblid = new JLabel("\u98DF\u54C1ID\uFF1A");
		lblid.setIcon(null);
		lblid.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editFoodProductField = new JTextField();
		
		JButton editGameSubmitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editGameSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editFoodAct(ae);
			}
		});
		editGameSubmitButton.setIcon(new ImageIcon(ManageFoodFrm.class.getResource("/images/\u786E\u8BA4.png")));
		editGameSubmitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		deleteFoodButton = new JButton("\u5220\u9664\u4FE1\u606F");
		deleteFoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteFood(ae);
			}
		});
		deleteFoodButton.setIcon(new ImageIcon(ManageFoodFrm.class.getResource("/images/\u5220\u9664.png")));
		deleteFoodButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editFoodNameTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(editGameSubmitButton)
								.addComponent(editFoodTypeTextField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblid)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(editFoodProductField)
								.addComponent(editFoodpriceTextField, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addComponent(deleteFoodButton, Alignment.TRAILING))))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editFoodNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(editFoodpriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(editFoodTypeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblid)
						.addComponent(editFoodProductField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(editGameSubmitButton)
						.addComponent(deleteFoodButton))
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		
		foodListTable = new JTable();
		foodListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		foodListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u98DF\u54C1\u540D\u79F0", "\u98DF\u54C1\u7C7B\u578B", "\u98DF\u54C1\u4EF7\u683C", "\u98DF\u54C1ID"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(foodListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Food());
		setAuthority();
	}
	protected void editFoodAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = foodListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		String foodName = editFoodNameTextField.getText().toString();
		String foodType = editFoodTypeTextField.getText().toString();
		int foodPrice = 0;
		try {
			foodPrice = Integer.parseInt(editFoodpriceTextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "价格只允许输入数字！");
			return;
		}
		String foodProduct = editFoodProductField.getText().toString();
		if(StringUtil.isEmpty(foodName)){
			JOptionPane.showMessageDialog(this, "食品名称必须填写！");
			return;
		}
		if(StringUtil.isEmpty(foodType)){
			JOptionPane.showMessageDialog(this, "食品类型必须填写！");
			return;
		}
		if(foodPrice == 0 || foodPrice < 0){
			JOptionPane.showMessageDialog(this, "价格必须大于0！");
			return;
		}
		if(StringUtil.isEmpty(foodProduct)){
			JOptionPane.showMessageDialog(this, "生产日期必须填写！");
			return;
		}
		Food food = new Food();
		food.setId(Integer.parseInt(foodListTable.getValueAt(row, 0).toString()));
		food.setName(foodName);
		food.setType(foodType);
		food.setPrice(foodPrice);
		food.setProduct(foodProduct);
		FoodDao foodDao = new FoodDao();
		if(foodDao.update(food)){
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else{
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		foodDao.closeDao();
		setTable(new Food());
	}

	protected void searchFood(ActionEvent e) {
		// TODO Auto-generated method stub
		String foodNameString = searchFoodNameTextField.getText().toString();
		Food food = new Food();
		food.setName(foodNameString);
		setTable(food);
	}

	protected void deleteFood(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = foodListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定要删除么？") != JOptionPane.OK_OPTION)return;
		int id = Integer.parseInt(foodListTable.getValueAt(row, 0).toString());
		FoodDao foodDao = new FoodDao();
		if(foodDao.delete(id)){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		foodDao.closeDao();
		setTable(new Food());
	}

	private void setTable(Food food){
		if("客户".equals(MainFrm.userType.getName())){
			Food tLogined = (Food) MainFrm.userObject;
			food.setName(tLogined.getName());
			searchFoodNameTextField.setText(food.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) foodListTable.getModel();
		dft.setRowCount(0);
		FoodDao foodDao = new FoodDao();
		List<Food> foodList = foodDao.getFoodList(food);
		for (Food t : foodList) {
			Vector v = new Vector();
			v.add(t.getId());
			v.add(t.getName());
			v.add(t.getType());
			v.add(t.getPrice());
			v.add(t.getProduct());
			dft.addRow(v);
		}
		foodDao.closeDao();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) foodListTable.getModel();
		editFoodNameTextField.setText(dft.getValueAt(foodListTable.getSelectedRow(), 1).toString());
		editFoodTypeTextField.setText(dft.getValueAt(foodListTable.getSelectedRow(), 2).toString());
		editFoodpriceTextField.setText(dft.getValueAt(foodListTable.getSelectedRow(), 3).toString());
		editFoodProductField.setText(dft.getValueAt(foodListTable.getSelectedRow(), 4).toString());
	}
	private void setAuthority(){
		if("客户".equals(MainFrm.userType.getName())){
			deleteFoodButton.setEnabled(false);
			searchFoodNameTextField.setEditable(false);
		}
	}
}
