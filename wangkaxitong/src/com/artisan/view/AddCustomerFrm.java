package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.artisan.dao.AreaDao;
import com.artisan.dao.CustomerDao;
import com.artisan.model.Customer;
import com.artisan.model.Area;
import com.artisan.util.StringUtil;

public class AddCustomerFrm extends JInternalFrame {
	private JTextField customerNameTextField;
	private JPasswordField customerPasswordField;
	private JComboBox customerAreaComboBox;
	private ButtonGroup sexButtonGroup;
	private JRadioButton customerSexManRadioButton;
	private JRadioButton customerSexFemalRadioButton;
	private JRadioButton customerSexUnkonwRadioButton;
	private JTextField customerComputertextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerFrm frame = new AddCustomerFrm();
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
	public AddCustomerFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u5BA2\u6237");
		setBounds(100, 100, 432, 344);
		
		JLabel label = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddCustomerFrm.class.getResource("/images/\u8001\u5E08.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		customerNameTextField = new JTextField();
		customerNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5728\u673A\u533A\uFF1A");
		label_1.setIcon(new ImageIcon(AddCustomerFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		customerAreaComboBox = new JComboBox();
		customerAreaComboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddCustomerFrm.class.getResource("/images/password.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		customerPasswordField = new JPasswordField();
		
		JLabel label_3 = new JLabel("\u5BA2\u6237\u6027\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(AddCustomerFrm.class.getResource("/images/\u6027\u522B.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		customerSexManRadioButton = new JRadioButton("\u7537");
		customerSexManRadioButton.setSelected(true);
		
		customerSexFemalRadioButton = new JRadioButton("\u5973");
		
		customerSexUnkonwRadioButton = new JRadioButton("\u4FDD\u5BC6");
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(customerSexManRadioButton);
		sexButtonGroup.add(customerSexFemalRadioButton);
		sexButtonGroup.add(customerSexUnkonwRadioButton);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				customerAddAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddCustomerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddCustomerFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u673A\u5668\u53F7\u7801:");
		label_4.setIcon(new ImageIcon(AddCustomerFrm.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		customerComputertextField = new JTextField();
		customerComputertextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(customerPasswordField, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(customerNameTextField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_4))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(customerComputertextField, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
										.addComponent(customerAreaComboBox, 0, 151, Short.MAX_VALUE))))
							.addGap(92))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(submitButton)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(resetButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(customerSexManRadioButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(customerSexFemalRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(customerSexUnkonwRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(78))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(customerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(customerAreaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(customerComputertextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(customerPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(customerSexManRadioButton)
						.addComponent(customerSexFemalRadioButton)
						.addComponent(customerSexUnkonwRadioButton))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(21))
		);
		getContentPane().setLayout(groupLayout);
		setCustomerAreaInfo();
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		customerNameTextField.setText("");
		customerPasswordField.setText("");
		customerAreaComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
		customerComputertextField.setText(null);
		customerSexManRadioButton.setSelected(true);
	}

	protected void customerAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String customerName = customerNameTextField.getText().toString();
		String customerPassword = customerPasswordField.getText().toString();
		Date date = new Date();//»ñµÃÏµÍ³Ê±¼ä.

		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//½«Ê±¼ä¸ñÊ½×ª»»³É·ûºÏTimestampÒªÇóµÄ¸ñÊ½.
		
		int customerComputer = 0;
		if(StringUtil.isEmpty(customerName)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´¹Ë¿ÍÐÕÃû!");
			return;
		}
		if(StringUtil.isEmpty(customerPassword)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´µÇÂ¼ÃÜÂë!");
			return;
		}
		try {
			customerComputer = Integer.parseInt(customerComputertextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "»úÆ÷ºÅÖ»ÔÊÐíÊäÈëÊý×Ö£¡");
			return;
		}
		Area sc = (Area)customerAreaComboBox.getSelectedItem();
		String sex = customerSexManRadioButton.isSelected() ? customerSexManRadioButton.getText() : (customerSexFemalRadioButton.isSelected() ? customerSexFemalRadioButton.getText() : customerSexUnkonwRadioButton.getText());
		Customer customer = new Customer();
		customer.setName(customerName);
		customer.setAreaId(sc.getId());
		customer.setPassword(customerPassword);
		customer.setSex(sex);
		customer.setComputer(customerComputer);
		customer.setontime(nowTime);
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.addCustomer(customer)){
			JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦!");
		}else{
			JOptionPane.showMessageDialog(this, "Ìí¼ÓÊ§°Ü!");
		}
		resetValue(ae);
	}
	
	private void setCustomerAreaInfo(){
		AreaDao areaDao = new AreaDao();
		List<Area> areaList = areaDao.getAreaList(new Area());
		for (Area sc : areaList) {
			customerAreaComboBox.addItem(sc);
		}
		areaDao.closeDao();
	}
}
