package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.artisan.dao.AreaDao;
import com.artisan.model.Area;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAreaFrm extends JInternalFrame {
	private JTextField areaNameTextField;
	private JTextArea areaInfotextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAreaFrm frame = new AddAreaFrm();
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
	public AddAreaFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u673A\u533A\u4FE1\u606F");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u673A\u533A\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(AddAreaFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		areaNameTextField = new JTextField();
		areaNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u673A\u533A\u4FE1\u606F\uFF1A");
		label_1.setIcon(new ImageIcon(AddAreaFrm.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		areaInfotextArea = new JTextArea();
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitClass(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddAreaFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JButton restButton = new JButton("\u91CD\u7F6E");
		restButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		restButton.setIcon(new ImageIcon(AddAreaFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		restButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(submitButton)
							.addGap(72)
							.addComponent(restButton))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(73)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(areaInfotextArea))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(areaNameTextField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(areaNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(areaInfotextArea, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(restButton)
						.addComponent(submitButton))
					.addGap(18))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void submitClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		String className = areaNameTextField.getText().toString();
		String classInfo = areaInfotextArea.getText().toString();
		if(StringUtil.isEmpty(className)){
			JOptionPane.showMessageDialog(this, "�������Ʋ���Ϊ�գ�");
			return;
		}
		Area scl = new Area();
		scl.setName(className);
		scl.setInfo(classInfo);
		AreaDao classDao = new AreaDao();
		if(classDao.addClass(scl)){
			JOptionPane.showMessageDialog(this, "�������ӳɹ���");
		}else{
			JOptionPane.showMessageDialog(this, "��������ʧ�ܣ�");
		}
		classDao.closeDao();
		resetValue(ae);
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		areaNameTextField.setText("");
		areaInfotextArea.setText("");
	}
}
