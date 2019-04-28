package com.artisan.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.nio.channels.SelectionKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.artisan.dao.AreaDao;
import com.artisan.dao.CustomerDao;
import com.artisan.dao.CustomerDaoOnMain;
import com.artisan.model.Area;
import com.artisan.model.Customer;
import com.artisan.model.UserType;
import com.artisan.util.StringUtil;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenuItem addCustomerMenuItem ;
	private JMenu manageAreaMenu ;
	private JMenu manageFoodMenu;
	private JMenuItem addFoodMenuItem;
	private JRadioButton customerSexManRadioButton;
	private JRadioButton customerSexFemalRadioButton;
	private JRadioButton customerSexUnkonwRadioButton;
	private ButtonGroup sexButtonGroup;
	private JTextField customerNameTextField;
	private JTextField customerComputertextField;
	private JPasswordField customerPasswordField;
	private JComboBox customerAreaComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
     				MainFrm frame = new MainFrm(null,null);
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
	public MainFrm(UserType userType,Object userObject) {
		
		this.userType = userType;
		this.userObject = userObject;
		setTitle("\u7F51\u5496\u4FE1\u606F\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 774);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出么？") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51FA.png")));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5BA2\u6237\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8001\u5E08.png")));
		menuBar.add(menu_1);
		
		addFoodMenuItem = new JMenuItem("\u5BA2\u6237\u6DFB\u52A0");
		addFoodMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerFrm addCustomerFrm = new AddCustomerFrm();
				addCustomerFrm.setVisible(true);
				desktopPane.add(addCustomerFrm);
			}
		});
		
		addFoodMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		menu_1.add(addFoodMenuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5BA2\u6237\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageCustomerFrm customerManageFrm = new ManageCustomerFrm();
				customerManageFrm.setVisible(true);
				desktopPane.add(customerManageFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7528\u6237\u5217\u8868.png")));
		menu_1.add(menuItem_3);
		
		addFoodMenuItem = new JMenu("\u673A\u533A\u7BA1\u7406");
		addFoodMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(addFoodMenuItem);
		
		JMenuItem menuItem_4 = new JMenuItem("\u673A\u533A\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addCustomerArea(ae);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		addFoodMenuItem.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u673A\u533A\u7BA1\u7406");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageAreaFrm areaManageFrm = new ManageAreaFrm();
				areaManageFrm.setVisible(true);
				desktopPane.add(areaManageFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		addFoodMenuItem.add(menuItem_5);
		
		manageFoodMenu = new JMenu("\u98DF\u54C1\u7BA1\u7406");
		manageFoodMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		menuBar.add(manageFoodMenu);
		
		addFoodMenuItem = new JMenuItem("\u6DFB\u52A0\u98DF\u54C1");
		addFoodMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFoodFrm addFoodFrm = new AddFoodFrm();
				addFoodFrm.setVisible(true);
				desktopPane.add(addFoodFrm);
			}
		});
		addFoodMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		manageFoodMenu.add(addFoodMenuItem);
		
		JMenuItem menuItem_8 = new JMenuItem("\u98DF\u54C1\u5217\u8868");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageFoodFrm manageFoodFrm = new ManageFoodFrm();
				manageFoodFrm.setVisible(true);
				desktopPane.add(manageFoodFrm);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		manageFoodMenu.add(menuItem_8);
		
		JMenu menu_2 = new JMenu("\u6E38\u620F\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u804C\u79F0\u8BC4\u5B9A.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6DFB\u52A0\u98DF\u54C1");
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_7 = new JMenuItem("\u6E38\u620F\u5217\u8868");
		menuItem_7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		menu_2.add(menuItem_7);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5E2E\u52A9.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menu_3.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setBounds(14, 77, 90, 43);
		desktopPane.add(label);
		
		customerNameTextField = new JTextField();
		customerNameTextField.setColumns(10);
		customerNameTextField.setBounds(118, 87, 151, 24);
		desktopPane.add(customerNameTextField);
		
		JLabel label_2 = new JLabel("\u673A\u5668\u53F7\u7801:");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setBounds(14, 184, 79, 19);
		desktopPane.add(label_2);
		
		customerComputertextField = new JTextField();
		customerComputertextField.setColumns(10);
		customerComputertextField.setBounds(118, 182, 151, 24);
		desktopPane.add(customerComputertextField);
		
		JLabel label_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_3.setBounds(14, 275, 90, 19);
		desktopPane.add(label_3);
		
		customerPasswordField = new JPasswordField();
		customerPasswordField.setBounds(118, 273, 151, 24);
		desktopPane.add(customerPasswordField);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				customerAddAct(ae);
			}
		});
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitButton.setBounds(14, 340, 81, 27);
		desktopPane.add(submitButton);
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		resetButton.setBounds(184, 339, 85, 29);
		desktopPane.add(resetButton);
		
		sexButtonGroup = new ButtonGroup();
		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void addCustomerArea(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddAreaFrm sca = new AddAreaFrm();
		sca.setVisible(true);
		desktopPane.add(sca);
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}

	protected void aboutUs(ActionEvent ae) {
		
	}
	
	protected void customerAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String customerName = customerNameTextField.getText().toString();
		String customerPassword = customerPasswordField.getText().toString();
		Date date = new Date();//获得系统时间.

		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
		
		int customerComputer = 0;
		if(StringUtil.isEmpty(customerName)){
			JOptionPane.showMessageDialog(this, "请填写顾客姓名!");
			return;
		}
		if(StringUtil.isEmpty(customerPassword)){
			JOptionPane.showMessageDialog(this, "请填写登录密码!");
			return;
		}
		try {
			customerComputer = Integer.parseInt(customerComputertextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "机器号只允许输入数字！");
			return;
		}
		Customer customer = new Customer();
		customer.setName(customerName);
		customer.setPassword(customerPassword);
		customer.setComputer(customerComputer);
		customer.setontime(nowTime);
		CustomerDaoOnMain customerDao = new CustomerDaoOnMain();
		if(customerDao.addCustomer(customer)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		resetValue(ae);
	}
	
	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		customerNameTextField.setText("");
		customerPasswordField.setText("");
		customerComputertextField.setText(null);
	}
	
	private void setAuthority(){
		if("客户".equals(userType.getName())){
			addFoodMenuItem.setEnabled(false);
			addFoodMenuItem.setEnabled(false);
			manageFoodMenu.setEnabled(false);
		}
	}
}
