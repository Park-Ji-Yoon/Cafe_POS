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
	JPasswordField pfPwd; // 비밀번호
	JButton btnInsert, btnCancel, btnUpdate, btnDelete; // 가입, 취소, 수정 , 탈퇴 버튼

	GridBagLayout gb;
	GridBagConstraints gbc;
	Manager_List mList;

	public ManagerProc() { // 가입용 생성자
		createUI(); // UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		// 프레임 위 앱 아이콘
		ImageIcon icon = new ImageIcon("images/logo_2.png");
		setIconImage(icon.getImage());
	}// 생성자

	public ManagerProc(Manager_List mList) { // 가입용 생성자
		createUI(); // UI작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.mList = mList;

		// 프레임 위 앱 아이콘
		ImageIcon icon = new ImageIcon("images/logo_2.png");
		setIconImage(icon.getImage());
	}// 생성자

	public ManagerProc(String id, Manager_List mList) { // 수정/삭제용 생성자
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mList = mList;

		System.out.println("id=" + id);

		ManagerDAO dao = new ManagerDAO();
		ManagerDTO vMem = dao.getMemberDTO(id);
		viewData(vMem);

		// 프레임 위 앱 아이콘
		ImageIcon icon = new ImageIcon("images/logo_2.png");
		setIconImage(icon.getImage());

	}// id를 가지고 생성

	// MemberDTO 의 회원 정보를 가지고 화면에 셋팅해주는 메소드
	private void viewData(ManagerDTO vMem) {

		String g_name = vMem.getG_name();
		String g_id = vMem.getG_id();
		String g_pw = vMem.getG_pw();
		String g_bname = vMem.getG_bname();
		String g_bphone = vMem.getG_bphone();
		String g_em = String.valueOf(vMem.getG_em());
		System.out.print(g_name + g_id + g_pw + g_bname + g_bphone + g_em);

		// 화면에 세팅
		tfG_name.setText(String.valueOf(g_name));
		tfG_id.setText(g_id);
		tfG_id.setEditable(false); // 편집 안되게
		pfPwd.setText(g_pw); // 비밀번호는 안보여준다.
		tfG_bname.setText(g_bname);
		tfG_bphone.setText(g_bphone);
		tfG_em.setText(String.valueOf(g_em));
	}// viewData

	private void createUI() {
		this.setTitle("회원정보");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		// 이름
		JLabel bName = new JLabel("이름 :");
		bName.setFont(new Font("인터파크고딕 M", Font.PLAIN, 18));
		tfG_name = new JTextField(20);
		tfG_name.setFont(new Font("인터파크고딕 L", Font.PLAIN, 18));
		gbAdd(bName, 0, 0, 1, 1);
		gbAdd(tfG_name, 1, 0, 3, 1);

		// 아이디
		JLabel bId = new JLabel("아이디 : ");
		bId.setFont(new Font("인터파크고딕 M", Font.PLAIN, 18));
		tfG_id = new JTextField(20);
		tfG_id.setFont(new Font("인터파크고딕 L", Font.PLAIN, 18));
		// 그리드백에 붙이기
		gbAdd(bId, 0, 1, 1, 1);
		gbAdd(tfG_id, 1, 1, 3, 1);

		// 비밀번호
		JLabel bPwd = new JLabel("비밀번호 : ");
		bPwd.setFont(new Font("인터파크고딕 M", Font.PLAIN, 18));
		pfPwd = new JPasswordField(20);
//		pfPwd.setFont(new Font("인터파크고딕 L", Font.PLAIN, 18));
		gbAdd(bPwd, 0, 2, 1, 1);
		gbAdd(pfPwd, 1, 2, 3, 1);

		// 이름
		JLabel bbname = new JLabel("지점명 :");
		bbname.setFont(new Font("인터파크고딕 M", Font.PLAIN, 18));
		tfG_bname = new JTextField(20);
		tfG_bname.setFont(new Font("인터파크고딕 L", Font.PLAIN, 18));
		gbAdd(bbname, 0, 4, 1, 1);
		gbAdd(tfG_bname, 1, 4, 3, 1);

		// 아이디
		JLabel bbphone = new JLabel("지점전화번호 : ");
		bbphone.setFont(new Font("인터파크고딕 M", Font.PLAIN, 18));
		tfG_bphone = new JTextField(20);
		tfG_bphone.setFont(new Font("인터파크고딕 L", Font.PLAIN, 18));
		// 그리드백에 붙이기
		gbAdd(bbphone, 0, 5, 1, 1);
		gbAdd(tfG_bphone, 1, 5, 3, 1);

		// 비밀번호
		JLabel bbem = new JLabel("직원 수 : ");
		bbem.setFont(new Font("인터파크고딕 M", Font.PLAIN, 18));
		tfG_em = new JTextField(5);
		tfG_em.setFont(new Font("인터파크고딕 L", Font.PLAIN, 18));
		gbAdd(bbem, 0, 6, 1, 1);
		gbAdd(tfG_em, 1, 6, 3, 1);

		// 버튼
		JPanel pButton = new JPanel();
//		pButton.setBackground(new Color(255, 199, 194));
		btnInsert = new JButton("가입");
		btnInsert.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
		btnUpdate = new JButton("수정");
		btnUpdate.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
		btnDelete = new JButton("탈퇴");
		btnDelete.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
		btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("인터파크고딕 M", Font.PLAIN, 22));
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

		// 버튼에 감지기를 붙이자
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCancel.addActionListener(this);
		btnDelete.addActionListener(this);

		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //프로그램종료
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // dispose(); //현재창만 닫는다.
		setBounds(681, 275, 500, 500);

	}// createUI

	// 그리드백레이아웃에 붙이는 메소드
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
			System.out.println("insertMember() 호출 종료");
		} else if (ae.getSource() == btnCancel) {
			this.dispose(); // 창닫기 (현재창만 닫힘)
			// system.exit(0)=> 내가 띄운 모든 창이 다 닫힘
		} else if (ae.getSource() == btnUpdate) {
			UpdateMember();
		} else if (ae.getSource() == btnDelete) {
			// int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?");
			int x = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);

			if (x == JOptionPane.OK_OPTION) {
				deleteMember();
			} else {
				JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
			}
		}

		// jTable내용 갱신 메소드 호출
		mList.jTableRefresh();

	}// actionPerformed

	private void deleteMember() {
		String id = tfG_id.getText();
		String pwd = pfPwd.getText();
		if (pwd.length() == 0) { // 길이가 0이면
			JOptionPane.showMessageDialog(this, "비밀번호를 꼭 입력하세요!");
			return; // 메소드 끝
		}
		// System.out.println(mList);
		ManagerDAO dao = new ManagerDAO();
		boolean ok = dao.deleteMember(pwd);

		if (ok) {
			JOptionPane.showMessageDialog(this, "삭제완료");
			dispose();

		} else {
			JOptionPane.showMessageDialog(this, "삭제실패");

		}

	}// deleteMember

	private void UpdateMember() {

		// 1. 화면의 정보를 얻는다.
		ManagerDTO dto = getViewData();
		// 2. 그정보로 DB를 수정
		ManagerDAO dao = new ManagerDAO();
		boolean ok = dao.updateMember(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "수정되었습니다.");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");
		}
	}

	private void insertMember() {

		// 화면에서 사용자가 입력한 내용을 얻는다.
		ManagerDTO dto = getViewData();
		ManagerDAO dao = new ManagerDAO();
		boolean ok = dao.insertMember(dto);

		if (ok) {
			JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
		}
	}// insertMember

	public ManagerDTO getViewData() {

		// 화면에서 사용자가 입력한 내용을 얻는다.
		ManagerDTO dto = new ManagerDTO();
		String g_name = tfG_name.getText();
		String g_id = tfG_id.getText();
		String g_pw = pfPwd.getText();
		String g_bname = tfG_bname.getText();
		String g_bphone = tfG_bphone.getText();
		int g_em = Integer.parseInt(tfG_em.getText());

		// dto에 담는다.
		dto.setG_name(g_name);
		dto.setG_id(g_id);
		dto.setG_pw(g_pw);
		dto.setG_bname(g_bname);
		dto.setG_bphone(g_bphone);
		dto.setG_em(g_em);

		return dto;
	}

}// end