package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.artisan.dao.FoodDao;
import com.artisan.model.Food;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddFoodFrm extends JInternalFrame {
	private JTextField foodNameTextField;
	private JTextField foodTypeTextField;
	private JTextField foodPriceTextField;
	private JTextField foodProductField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFoodFrm frame = new AddFoodFrm();
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
	public AddFoodFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u98DF\u54C1");
		setBounds(100, 100, 450, 371);
		
		JLabel label = new JLabel("\u98DF\u54C1\u540D\u79F0\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setIcon(null);
		
		foodNameTextField = new JTextField();
		foodNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u98DF\u54C1\u7C7B\u578B\uFF1A");
		label_2.setIcon(null);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		foodTypeTextField = new JTextField();
		foodTypeTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u98DF\u54C1\u4EF7\u683C\uFF1A");
		label_3.setIcon(null);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		foodPriceTextField = new JTextField();
		foodPriceTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addFoodAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddFoodFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E\u8868\u5355");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddFoodFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JLabel lblid = new JLabel("\u98DF\u54C1ID\uFF1A");
		lblid.setIcon(null);
		lblid.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		foodProductField = new JTextField();
		foodProductField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(foodNameTextField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(resetButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_3)
								.addComponent(lblid))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(foodProductField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(foodPriceTextField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
								.addComponent(foodTypeTextField, 152, 168, Short.MAX_VALUE))))
					.addGap(95))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(foodNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(foodTypeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(foodPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(foodProductField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		foodNameTextField.setText("");
		foodTypeTextField.setText("");
		foodPriceTextField.setText("");
		foodProductField.setText("");
	}

	protected void addFoodAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String foodName = foodNameTextField.getText().toString();
		String foodType = foodTypeTextField.getText().toString();
		String foodProduct = foodProductField.getText().toString();
		int foodPrice = 0;
		try {
			foodPrice = Integer.parseInt(foodPriceTextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "价格只允许输入数字！");
			return;
		}
		if(StringUtil.isEmpty(foodName)){
			JOptionPane.showMessageDialog(this, "食品名必须填写！");
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
			JOptionPane.showMessageDialog(this, "生产日期码必须填写！");
			return;
		}
		Food food = new Food();
		food.setName(foodName);
		food.setType(foodType);
		food.setPrice(foodPrice);
		food.setProduct(foodProduct);
		FoodDao foodDao = new FoodDao();
		if(foodDao.addFood(food)){
			JOptionPane.showMessageDialog(this, "食品添加成功！");
		}else{
			JOptionPane.showMessageDialog(this, "食品添加失败！");
		}
		resetValue(ae);
	}
}
