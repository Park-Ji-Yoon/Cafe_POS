package Manager;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

import Manager.ManagerDAO;
import Manager.ManagerDTO;

public class ManagerProc extends JFrame implements ActionListener {

	JPanel p;
	JTextField tfG_name, tfG_id, tfG_bname, tfG_bphone, tfG_em;
	JPasswordField pfPwd; // ��й�ȣ
	JButton btnInsert, btnCancel, btnUpdate, btnDelete; // ����, ���, ���� , Ż�� ��ư

	GridBagLayout gb;
	GridBagConstraints gbc;
	Manager_List mList;

	public ManagerProc() { // ���Կ� ������
		createUI(); // UI�ۼ����ִ� �޼ҵ�
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		// ������ �� �� ������
		ImageIcon icon = new ImageIcon("images/logo_2.png");
		setIconImage(icon.getImage());
	}// ������

	public ManagerProc(Manager_List mList) { // ���Կ� ������
		createUI(); // UI�ۼ����ִ� �޼ҵ�
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.mList = mList;

		// ������ �� �� ������
		ImageIcon icon = new ImageIcon("images/logo_2.png");
		setIconImage(icon.getImage());
	}// ������

	public ManagerProc(String id, Manager_List mList) { // ����/������ ������
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mList = mList;

		System.out.println("id=" + id);

		ManagerDAO dao = new ManagerDAO();
		ManagerDTO vMem = dao.getMemberDTO(id);
		viewData(vMem);

		// ������ �� �� ������
		ImageIcon icon = new ImageIcon("images/logo_2.png");
		setIconImage(icon.getImage());

	}// id�� ������ ����

	// MemberDTO �� ȸ�� ������ ������ ȭ�鿡 �������ִ� �޼ҵ�
	private void viewData(ManagerDTO vMem) {

		String g_name = vMem.getG_name();
		String g_id = vMem.getG_id();
		String g_pw = vMem.getG_pw();
		String g_bname = vMem.getG_bname();
		String g_bphone = vMem.getG_bphone();
		String g_em = String.valueOf(vMem.getG_em());
		System.out.print(g_name + g_id + g_pw + g_bname + g_bphone + g_em);

		// ȭ�鿡 ����
		tfG_name.setText(String.valueOf(g_name));
		tfG_id.setText(g_id);
		tfG_id.setEditable(false); // ���� �ȵǰ�
		pfPwd.setText(g_pw); // ��й�ȣ�� �Ⱥ����ش�.
		tfG_bname.setText(g_bname);
		tfG_bphone.setText(g_bphone);
		tfG_em.setText(String.valueOf(g_em));
	}// viewData

	private void createUI() {
		this.setTitle("ȸ������");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		// �̸�
		JLabel bName = new JLabel("�̸� :");
		bName.setFont(new Font("������ũ��� M", Font.PLAIN, 18));
		tfG_name = new JTextField(20);
		tfG_name.setFont(new Font("������ũ��� L", Font.PLAIN, 18));
		gbAdd(bName, 0, 0, 1, 1);
		gbAdd(tfG_name, 1, 0, 3, 1);

		// ���̵�
		JLabel bId = new JLabel("���̵� : ");
		bId.setFont(new Font("������ũ��� M", Font.PLAIN, 18));
		tfG_id = new JTextField(20);
		tfG_id.setFont(new Font("������ũ��� L", Font.PLAIN, 18));
		// �׸���鿡 ���̱�
		gbAdd(bId, 0, 1, 1, 1);
		gbAdd(tfG_id, 1, 1, 3, 1);

		// ��й�ȣ
		JLabel bPwd = new JLabel("��й�ȣ : ");
		bPwd.setFont(new Font("������ũ��� M", Font.PLAIN, 18));
		pfPwd = new JPasswordField(20);
//		pfPwd.setFont(new Font("������ũ��� L", Font.PLAIN, 18));
		gbAdd(bPwd, 0, 2, 1, 1);
		gbAdd(pfPwd, 1, 2, 3, 1);

		// �̸�
		JLabel bbname = new JLabel("������ :");
		bbname.setFont(new Font("������ũ��� M", Font.PLAIN, 18));
		tfG_bname = new JTextField(20);
		tfG_bname.setFont(new Font("������ũ��� L", Font.PLAIN, 18));
		gbAdd(bbname, 0, 4, 1, 1);
		gbAdd(tfG_bname, 1, 4, 3, 1);

		// ���̵�
		JLabel bbphone = new JLabel("������ȭ��ȣ : ");
		bbphone.setFont(new Font("������ũ��� M", Font.PLAIN, 18));
		tfG_bphone = new JTextField(20);
		tfG_bphone.setFont(new Font("������ũ��� L", Font.PLAIN, 18));
		// �׸���鿡 ���̱�
		gbAdd(bbphone, 0, 5, 1, 1);
		gbAdd(tfG_bphone, 1, 5, 3, 1);

		// ��й�ȣ
		JLabel bbem = new JLabel("���� �� : ");
		bbem.setFont(new Font("������ũ��� M", Font.PLAIN, 18));
		tfG_em = new JTextField(5);
		tfG_em.setFont(new Font("������ũ��� L", Font.PLAIN, 18));
		gbAdd(bbem, 0, 6, 1, 1);
		gbAdd(tfG_em, 1, 6, 3, 1);

		// ��ư
		JPanel pButton = new JPanel();
//		pButton.setBackground(new Color(255, 199, 194));
		btnInsert = new JButton("����");
		btnInsert.setFont(new Font("������ũ��� M", Font.PLAIN, 22));
		btnUpdate = new JButton("����");
		btnUpdate.setFont(new Font("������ũ��� M", Font.PLAIN, 22));
		btnDelete = new JButton("Ż��");
		btnDelete.setFont(new Font("������ũ��� M", Font.PLAIN, 22));
		btnCancel = new JButton("���");
		btnCancel.setFont(new Font("������ũ��� M", Font.PLAIN, 22));
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancel);
		gbAdd(pButton, 0, 10, 5, 1);
		
		btnInsert.setBorderPainted(false);
		btnInsert.setContentAreaFilled(false);
		btnInsert.setFocusPainted(false);
		btnInsert.setOpaque(false);
		
		btnUpdate.setBorderPainted(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setFocusPainted(false);
		btnUpdate.setOpaque(false);
		
		btnDelete.setBorderPainted(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setFocusPainted(false);
		btnCancel.setOpaque(false);
		
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setFocusPainted(false);
		btnCancel.setOpaque(false);

		// ��ư�� �����⸦ ������
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCancel.addActionListener(this);
		btnDelete.addActionListener(this);

		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //���α׷�����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // dispose(); //����â�� �ݴ´�.
		setBounds(681, 275, 500, 500);

	}// createUI

	// �׸���鷹�̾ƿ��� ���̴� �޼ҵ�
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}// gbAdd

	public static void main(String[] args) {
		new ManagerProc();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnInsert) {
			insertMember();
			System.out.println("insertMember() ȣ�� ����");
		} else if (ae.getSource() == btnCancel) {
			this.dispose(); // â�ݱ� (����â�� ����)
			// system.exit(0)=> ���� ��� ��� â�� �� ����
		} else if (ae.getSource() == btnUpdate) {
			UpdateMember();
		} else if (ae.getSource() == btnDelete) {
			// int x = JOptionPane.showConfirmDialog(this,"���� �����Ͻðڽ��ϱ�?");
			int x = JOptionPane.showConfirmDialog(this, "���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);

			if (x == JOptionPane.OK_OPTION) {
				deleteMember();
			} else {
				JOptionPane.showMessageDialog(this, "������ ����Ͽ����ϴ�.");
			}
		}

		// jTable���� ���� �޼ҵ� ȣ��
		mList.jTableRefresh();

	}// actionPerformed

	private void deleteMember() {
		String id = tfG_id.getText();
		String pwd = pfPwd.getText();
		if (pwd.length() == 0) { // ���̰� 0�̸�
			JOptionPane.showMessageDialog(this, "��й�ȣ�� �� �Է��ϼ���!");
			return; // �޼ҵ� ��
		}
		// System.out.println(mList);
		ManagerDAO dao = new ManagerDAO();
		boolean ok = dao.deleteMember(pwd);

		if (ok) {
			JOptionPane.showMessageDialog(this, "�����Ϸ�");
			dispose();

		} else {
			JOptionPane.showMessageDialog(this, "��������");

		}

	}// deleteMember

	private void UpdateMember() {

		// 1. ȭ���� ������ ��´�.
		ManagerDTO dto = getViewData();
		// 2. �������� DB�� ����
		ManagerDAO dao = new ManagerDAO();
		boolean ok = dao.updateMember(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�.");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "��������: ���� Ȯ���ϼ���");
		}
	}

	private void insertMember() {

		// ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
		ManagerDTO dto = getViewData();
		ManagerDAO dao = new ManagerDAO();
		boolean ok = dao.insertMember(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "������ ���������� ó������ �ʾҽ��ϴ�.");
		}
	}// insertMember

	public ManagerDTO getViewData() {

		// ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
		ManagerDTO dto = new ManagerDTO();
		String g_name = tfG_name.getText();
		String g_id = tfG_id.getText();
		String g_pw = pfPwd.getText();
		String g_bname = tfG_bname.getText();
		String g_bphone = tfG_bphone.getText();
		int g_em = Integer.parseInt(tfG_em.getText());

		// dto�� ��´�.
		dto.setG_name(g_name);
		dto.setG_id(g_id);
		dto.setG_pw(g_pw);
		dto.setG_bname(g_bname);
		dto.setG_bphone(g_bphone);
		dto.setG_em(g_em);

		return dto;
	}

}// end