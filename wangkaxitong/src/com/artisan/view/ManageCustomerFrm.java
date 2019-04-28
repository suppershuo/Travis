package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.AreaDao;
import com.artisan.dao.CustomerDao;
import com.artisan.model.Customer;
import com.artisan.model.Area;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageCustomerFrm extends JInternalFrame {
	private JTextField serachCustomerNameTextField;
	private JTable customerListTable;
	private JTextField editCustomerNameTextField;
	private JPasswordField editCustomerPasswordPasswordField;
	private JComboBox searchCustomerComboBox;
	private List<Area> customerAreaList ;
	private JComboBox editCustomerAreaComboBox;
	private ButtonGroup editSexButtonGroup;
	private JRadioButton editCustomerSexManRadioButton;
	private JRadioButton editCustomerSexFemalRadioButton;
	private JRadioButton editCustomerSexUnkonwRadioButton;
	private JButton deleteCustomerButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCustomerFrm frame = new ManageCustomerFrm();
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
	public ManageCustomerFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/\u8001\u5E08.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		serachCustomerNameTextField = new JTextField();
		serachCustomerNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5728\u673A\u533A\uFF1A");
		label_1.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		searchCustomerComboBox = new JComboBox();
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchCustomer(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/\u8001\u5E08.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editCustomerNameTextField = new JTextField();
		editCustomerNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6240\u5728\u673A\u533A\uFF1A");
		label_3.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editCustomerAreaComboBox = new JComboBox();
		
		JLabel label_4 = new JLabel("\u5BA2\u6237\u6027\u522B\uFF1A");
		label_4.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/\u6027\u522B.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editSexButtonGroup = new ButtonGroup();
		editCustomerSexManRadioButton = new JRadioButton("\u7537");
		editCustomerSexManRadioButton.setSelected(true);
		
		editCustomerSexFemalRadioButton = new JRadioButton("\u5973");
		
		editCustomerSexUnkonwRadioButton = new JRadioButton("\u4FDD\u5BC6");
		editSexButtonGroup.add(editCustomerSexManRadioButton);
		editSexButtonGroup.add(editCustomerSexFemalRadioButton);
		editSexButtonGroup.add(editCustomerSexUnkonwRadioButton);
		
		JLabel label_5 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_5.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/password.png")));
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editCustomerPasswordPasswordField = new JPasswordField();
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		deleteCustomerButton = new JButton("\u5220\u9664\u5BA2\u6237");
		deleteCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteCustomer(ae);
			}
		});
		deleteCustomerButton.setIcon(new ImageIcon(ManageCustomerFrm.class.getResource("/images/\u5220\u9664.png")));
		deleteCustomerButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(93, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(editCustomerAreaComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(editCustomerNameTextField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_4)
							.addGap(18)
							.addComponent(editCustomerSexManRadioButton)
							.addGap(2)
							.addComponent(editCustomerSexFemalRadioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editCustomerSexUnkonwRadioButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_5)
							.addGap(18)
							.addComponent(editCustomerPasswordPasswordField)))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(submitEditButton)
						.addComponent(deleteCustomerButton))
					.addGap(33))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(140)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(serachCustomerNameTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(searchCustomerComboBox, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(searchButton)
					.addContainerGap(67, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(serachCustomerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchCustomerComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchButton))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editCustomerSexManRadioButton)
						.addComponent(editCustomerSexFemalRadioButton)
						.addComponent(editCustomerSexUnkonwRadioButton)
						.addComponent(submitEditButton)
						.addComponent(editCustomerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editCustomerAreaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(editCustomerPasswordPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteCustomerButton)
						.addComponent(label_3))
					.addGap(20))
		);
		
		customerListTable = new JTable();
		customerListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		customerListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u5BA2\u6237\u59D3\u540D", "\u6240\u5728\u673A\u533A", "\u5BA2\u6237\u6027\u522B", "\u767B\u5F55\u5BC6\u7801", "\u673A\u5668\u53F7", "\u767B\u5F55\u65F6\u95F4", "\u7F51\u8D39"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		customerListTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		customerListTable.getColumnModel().getColumn(1).setPreferredWidth(35);
		customerListTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		customerListTable.getColumnModel().getColumn(3).setPreferredWidth(20);
		customerListTable.getColumnModel().getColumn(5).setPreferredWidth(20);
		customerListTable.getColumnModel().getColumn(7).setPreferredWidth(35);
		scrollPane.setViewportView(customerListTable);
		getContentPane().setLayout(groupLayout);
		setCustomerAreaInfo();
		setTable(new Customer());
		setAuthority();
	}
	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = customerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÖÐÒªÐÞ¸ÄµÄÊý¾Ý£¡");
			return;
		}
		String customerName = editCustomerNameTextField.getText().toString();
		String customerPassword = editCustomerPasswordPasswordField.getText().toString();
		if(StringUtil.isEmpty(customerName)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´¿Í»§ÐÕÃû£¡");
			return;
		}
		if(StringUtil.isEmpty(customerPassword)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´ÃÜÂë£¡");
			return;
		}
		
		Customer customer = new Customer();
		customer.setName(customerName);
		customer.setPassword(customerPassword);
		Area sc = (Area)editCustomerAreaComboBox.getSelectedItem();
		
		customer.setAreaId(sc.getId());
		customer.setId(Integer.parseInt(customerListTable.getValueAt(row, 0).toString()));
		customer.setComputer(Integer.parseInt(customerListTable.getValueAt(row, 0).toString()));
		if(editCustomerSexManRadioButton.isSelected())customer.setSex(editCustomerSexManRadioButton.getText().toString());
		if(editCustomerSexFemalRadioButton.isSelected())customer.setSex(editCustomerSexFemalRadioButton.getText().toString());
		if(editCustomerSexUnkonwRadioButton.isSelected())customer.setSex(editCustomerSexUnkonwRadioButton.getText().toString());
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.update(customer)){
			JOptionPane.showMessageDialog(this, "¸üÐÂ³É¹¦£¡");
		}else{
			JOptionPane.showMessageDialog(this, "¸üÐÂÊ§°Ü£¡");
		}
		customerDao.closeDao();
		setTable(new Customer());
	}

	protected void deleteCustomer(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		int row = customerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÖÐÒªÉ¾³ýµÄÊý¾Ý£¡");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "ÄúÈ·¶¨É¾³ýÃ´£¿") != JOptionPane.OK_OPTION){
			return;
		}
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.delete(Integer.parseInt(customerListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "É¾³ý³É¹¦£¡");
		}else{
			JOptionPane.showMessageDialog(this, "É¾³ýÊ§°Ü£¡");
		}
		customerDao.closeDao();
		setTable(new Customer());
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) customerListTable.getModel();
		editCustomerNameTextField.setText(dft.getValueAt(customerListTable.getSelectedRow(), 1).toString());
		editCustomerPasswordPasswordField.setText(dft.getValueAt(customerListTable.getSelectedRow(), 4).toString());
		String areaName = dft.getValueAt(customerListTable.getSelectedRow(), 2).toString();
		for(int i=0;i<editCustomerAreaComboBox.getItemCount();i++){
			Area sc = (Area)editCustomerAreaComboBox.getItemAt(i);
			if(areaName.equals(sc.getName())){
				editCustomerAreaComboBox.setSelectedIndex(i);
			}
		}
		String sex = dft.getValueAt(customerListTable.getSelectedRow(), 3).toString();
		editSexButtonGroup.clearSelection();
		if(sex.equals(editCustomerSexManRadioButton.getText()))editCustomerSexManRadioButton.setSelected(true);
		if(sex.equals(editCustomerSexFemalRadioButton.getText()))editCustomerSexFemalRadioButton.setSelected(true);
		if(sex.equals(editCustomerSexUnkonwRadioButton.getText()))editCustomerSexUnkonwRadioButton.setSelected(true);
	}
	protected void searchCustomer(ActionEvent ae) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName(serachCustomerNameTextField.getText().toString());
		Area sc = (Area)searchCustomerComboBox.getSelectedItem();
		customer.setAreaId(sc.getId());
		setTable(customer);
	}

	private void setTable(Customer customer){
		if("¿Í»§".equals(MainFrm.userType.getName())){
			Customer s = (Customer)MainFrm.userObject;
			customer.setName(s.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) customerListTable.getModel();
		dft.setRowCount(0);
		CustomerDao customerDao = new CustomerDao();
		List<Customer> customerList = customerDao.getStudentList(customer);
		for (Customer s : customerList) {
			Vector v = new Vector();
			v.add(s.getId());
			v.add(s.getName());
			v.add(getAreaNameById(s.getAreaId()));
			v.add(s.getSex());
			v.add(s.getPassword());
			v.add(s.getComputer());
			v.add(s.getontime());
			dft.addRow(v);
		}
		customerDao.closeDao();
	}
	private void setCustomerAreaInfo(){
		AreaDao areaDao = new AreaDao();
		customerAreaList = areaDao.getAreaList(new Area());
		for (Area sc : customerAreaList) {
			searchCustomerComboBox.addItem(sc);
			editCustomerAreaComboBox.addItem(sc);
		}
		areaDao.closeDao();
	}
	private String getAreaNameById(int id){
		for (Area sc : customerAreaList) {
			if(sc.getId() == id)return sc.getName();
		}
		return "";
	}
	private void setAuthority(){
		if("¿Í»§".equals(MainFrm.userType.getName())){
			Customer s = (Customer)MainFrm.userObject;
			serachCustomerNameTextField.setText(s.getName());
			serachCustomerNameTextField.setEnabled(false);
			deleteCustomerButton.setEnabled(false);
			for(int i=0;i<searchCustomerComboBox.getItemCount();i++){
				Area sc = (Area) searchCustomerComboBox.getItemAt(i);
				if(sc.getId() == s.getAreaId()){
					searchCustomerComboBox.setSelectedIndex(i);
					break;
				}
			}
			searchCustomerComboBox.setEnabled(false);
			for(int i=0;i<editCustomerAreaComboBox.getItemCount();i++){
				Area sc = (Area) editCustomerAreaComboBox.getItemAt(i);
				if(sc.getId() == s.getAreaId()){
					editCustomerAreaComboBox.setSelectedIndex(i);
					break;
				}
			}
			editCustomerAreaComboBox.setEnabled(false);
		}
	}
}
