package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ManagerGUI extends JFrame{
	public ManagerGUI() {
	}
	public static void main(String args[]) {
		ManagerPanel manager_panel = new ManagerPanel();
	}
}

// �Ŵ��� �г� class
class ManagerPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_19.png");
	
	// �α��� ��� ��ư
	JButton manager_exit_button = new JButton(icon);
	static JLabel bname_label = new JLabel();
	JButton sales_button = new JButton(icon);
	JButton stock_button = new JButton(icon);
	JButton employee_button = new JButton(icon);
	JButton mypage_button = new JButton(icon);

	ManagerPanel() {
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);

		// �α��� ��� ��ư �Ӽ� ����
		manager_exit_button.setBounds(273, 781, 196, 80);
		manager_exit_button.setVisible(true);
		manager_exit_button.setBorderPainted(false);
		manager_exit_button.setContentAreaFilled(false);
		manager_exit_button.setFocusPainted(false);
		manager_exit_button.setOpaque(false);
		manager_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getLogin_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);
			}
		});
		add(manager_exit_button); // ManagerPanel�� ��ư �߰�
		
		bname_label.setBounds(20, 203, 370, 80);
		bname_label.setHorizontalAlignment(JLabel.RIGHT);
		bname_label.setFont(new Font("������ũ��� M", Font.PLAIN, 40));
		add(bname_label);

		// ���� ���� ��ư
		sales_button.setBounds(908, 98, 780, 158); // ��ġ�� ũ�� ����
		sales_button.setVisible(true);
		sales_button.setBorderPainted(false);
		sales_button.setContentAreaFilled(false);
		sales_button.setFocusPainted(false);
		sales_button.setOpaque(false);
		// ���� ���� ��ư �̺�Ʈ
		sales_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getSales_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);
			}
		});
		add(sales_button);

		// ��� ���� ��ư
		stock_button.setBounds(908, 329, 780, 158); // ��ġ�� ũ�� ����
		stock_button.setVisible(true);
		stock_button.setBorderPainted(false);
		stock_button.setContentAreaFilled(false);
		stock_button.setFocusPainted(false);
		stock_button.setOpaque(false);
		// ��� ���� ��ư �̺�Ʈ
		stock_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getStock_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);
			}
		});
		add(stock_button);

		// ���� ���� ��ư
		employee_button.setBounds(908, 560, 780, 158); // ��ġ�� ũ�� ����
		employee_button.setVisible(true);
		employee_button.setBorderPainted(false);
		employee_button.setContentAreaFilled(false);
		employee_button.setFocusPainted(false);
		employee_button.setOpaque(false);
		// ���� ���� ��ư �̺�Ʈ
		employee_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getEmployee_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);				
			}
		});
		add(employee_button);
		
		//���� ���� ��ư
		mypage_button.setBounds(908, 791, 780, 158); // ��ġ�� ũ�� ����
		mypage_button.setVisible(true);
		mypage_button.setBorderPainted(false);
		mypage_button.setContentAreaFilled(false);
		mypage_button.setFocusPainted(false);
		mypage_button.setOpaque(false);
		// ���� ���� ��ư �̺�Ʈ
		mypage_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getManager_info_panel().setVisible(true);
				Main.MainFrame.getManager_panel().setVisible(false);
			}
		});
		add(mypage_button);		
	}
	
	// ��� ĥ�ϴ� �޼���
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
}

// ������ ���� �г�
class ManagerInfo extends JPanel{
	ImageIcon background = new ImageIcon("images/manager1.png");
	GoBackBtn2 go_back_btn2 = new GoBackBtn2(); // �ڷΰ��� ��ư
	
	static ManagerNameLabel manager_name_label = new ManagerNameLabel(); // ������ �̸� label
	static ManagerIdLabel manager_id_label = new ManagerIdLabel(); // ������ id label
	static ManagerPwLabel manager_pw_label = new ManagerPwLabel(); // ������ pw label
	static ManagerBNameLabel manager_bname_label = new ManagerBNameLabel(); // ���� �̸� ��
	static ManagerBPhoneLabel manager_bphone_label = new ManagerBPhoneLabel(); // ���� ��ȭ��ȣ ��
	static ManagerEmLabel manager_em_label = new ManagerEmLabel(); // ���� �� ��
	
	// ManagerInfo ������
	ManagerInfo() {
		setBounds(0, 0, 1862, 1055); // ��ġ�� ũ�� ����
		setLayout(null);
		setVisible(true);
		
		// ������Ʈ �߰�
		add(go_back_btn2);
		add(manager_name_label);
		add(manager_id_label);
		add(manager_pw_label);
		add(manager_bname_label);
		add(manager_bphone_label);
		add(manager_em_label);
	}
	
	// �ٸ� class���� setText �ϱ� ���� getter�޼���
	public static ManagerNameLabel getManager_name_label() {
		return manager_name_label;
	}

	public static ManagerIdLabel getManager_id_label() {
		return manager_id_label;
	}

	public static ManagerPwLabel getManager_pw_label() {
		return manager_pw_label;
	}

	public static ManagerBNameLabel getManager_bname_label() {
		return manager_bname_label;
	}

	public static ManagerBPhoneLabel getManager_bphone_label() {
		return manager_bphone_label;
	}

	public static ManagerEmLabel getManager_em_label() {
		return manager_em_label;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}

// �ڷΰ��� ��ư
class GoBackBtn2 extends JButton{
	GoBackBtn2() {
		setBounds(20, 20, 200, 70);
		setVisible(true);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Main.MainFrame.getManager_info_panel().setVisible(false);
				Main.MainFrame.getManager_panel().setVisible(true);				
			}
		});
	}
}

// ������ �̸� label Ŭ����
class ManagerNameLabel extends JLabel{
	ManagerNameLabel() {
		setBounds(950, 245, 400, 50);
		setFont(new Font("������ũ��� M", Font.PLAIN, 36));
	}
}

// ������ id label Ŭ����
class ManagerIdLabel extends JLabel{
	ManagerIdLabel() {
		setBounds(950, 367, 400, 50);
		setFont(new Font("������ũ��� M", Font.PLAIN, 36));
	}
}

// ������ pw label Ŭ����
class ManagerPwLabel extends JLabel{
	ManagerPwLabel() {
		setBounds(950, 480, 400, 50);
		setText("123456789");
		setFont(new Font("������ũ��� M", Font.PLAIN, 36));
	}
}

// ������ label Ŭ����
class ManagerBNameLabel extends JLabel{
	ManagerBNameLabel() {
		setBounds(950, 590, 400, 50);
		setText("��������ȭ����");
		setFont(new Font("������ũ��� M", Font.PLAIN, 36));
	}
}

// ������ȭ��ȣ label Ŭ����
class ManagerBPhoneLabel extends JLabel{
	ManagerBPhoneLabel() {
		setBounds(950, 713, 400, 50);
		setText("010-5135-4735");
		setFont(new Font("������ũ��� M", Font.PLAIN, 36));
	}
}

// ���� �� label Ŭ����
class ManagerEmLabel extends JLabel{
	ManagerEmLabel() {
		setBounds(950, 825, 400, 50);
		setText("������������");
		setFont(new Font("������ũ��� M", Font.PLAIN, 36));
	}
}