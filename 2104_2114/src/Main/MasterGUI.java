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
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Manager.ManagerDAO;
import Manager.Manager_List;

public class MasterGUI extends JFrame{
	public MasterGUI() {
	}
	public static void main(String args[]) {
		MasterPanel master_panel = new MasterPanel();
	}
}
class MasterPanel extends JPanel{
	static Icon icon = new ImageIcon("images/back_2.png");
	
	ImageIcon background = new ImageIcon("images/background_37.png");

	JButton master_exit_button = new JButton(icon);
	JLabel sname_label = new JLabel();
	JButton managerfix_button = new JButton(icon);
	JButton franchise_button = new JButton(icon);
	JButton mypage_button = new JButton(icon);

	MasterPanel() {
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);

		//로그인 취소
		master_exit_button.setBounds(273, 781, 196, 80);
		master_exit_button.setVisible(true);
		master_exit_button.setBorderPainted(false);
		master_exit_button.setContentAreaFilled(false);
		master_exit_button.setFocusPainted(false);
		master_exit_button.setOpaque(false);
		master_exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getLogin_panel().setVisible(true);
				Main.MainFrame.getMaster_panel().setVisible(false);
			}
		});
		add(master_exit_button);
		
		sname_label.setBounds(90, 203, 300, 80);
		sname_label.setText(getSname());
		sname_label.setHorizontalAlignment(JLabel.RIGHT);
		sname_label.setFont(new Font("인터파크고딕 M", Font.PLAIN, 40));
		add(sname_label);

		//지점장 관리 버튼
		managerfix_button.setBounds(908, 152, 780, 158);
		managerfix_button.setVisible(true);
		managerfix_button.setBorderPainted(false);
		managerfix_button.setContentAreaFilled(false);
		managerfix_button.setFocusPainted(false);
		managerfix_button.setOpaque(false);
		managerfix_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getMaster_panel().setVisible(false);
				Main.MainFrame.manager_list_frame = new Manager_List();
			}
		});
		add(managerfix_button);

		//지점별 정보 버튼
		franchise_button.setBounds(908, 448, 780, 158);
		franchise_button.setVisible(true);
		franchise_button.setBorderPainted(false);
		franchise_button.setContentAreaFilled(false);
		franchise_button.setFocusPainted(false);
		franchise_button.setOpaque(false);
		franchise_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Main.MainFrame.getMaster_panel().setVisible(false);
				Main.MainFrame.getChoice_area_master_panel().setVisible(true);				
			}
		});
		add(franchise_button);
		
		//정보 관리 버튼
		mypage_button.setBounds(908, 738, 780, 158);
		mypage_button.setVisible(true);
		mypage_button.setBorderPainted(false);
		mypage_button.setContentAreaFilled(false);
		mypage_button.setFocusPainted(false);
		mypage_button.setOpaque(false);
		mypage_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getMaster_panel().setVisible(false);
				//Main.MainFrame.getSMypage_panel().setVisible(true);
			}
		});
		add(mypage_button);		
	}
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
	public static String getSname() {
		String sname = "";
		
		String query;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rset = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "rootpassword");
            
            query = "SELECT S_NAME FROM MASTER_TABLE";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			boolean result = true;
			
            while (result = rset.next()) {
            	sname = rset.getString("S_NAME");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return sname;
	}
}
class ChoiceAreaMaster extends JPanel {
	static ArrayList<String> area_names = new ArrayList<String>(Arrays.asList("...", "부산", "대구", "울산", "경주", "창원"));

	ArrayList<String> busan_stores_name = new ArrayList<String>(Arrays.asList("..."));
	ArrayList<String> daegu_stores_name = new ArrayList<String>(Arrays.asList("..."));
	ArrayList<String> ulsan_stores_name = new ArrayList<String>(Arrays.asList("..."));
	ArrayList<String> kyeongju_stores_name = new ArrayList<String>(Arrays.asList("..."));
	ArrayList<String> changwon_stores_name = new ArrayList<String>(Arrays.asList("..."));

	ImageIcon background = new ImageIcon("images/choice_3.png");

	static ChoiceBtnMaster area_choice_btn_master = new ChoiceBtnMaster();
	static ExitBtnMaster area_exit_btn_master = new ExitBtnMaster();
	
	static ChoiceMaster store_combobox_master;

	static ChoiceMaster area_combobox_master = new ChoiceMaster(area_names.toArray(new String[area_names.size()]));

	static String choisen_area_master, choisen_store_master;
	
	static ChoiceLabelMaster area_choice_label_master = new ChoiceLabelMaster("지역을 선택해 주세요");
	static ChoiceLabelMaster store_choice_label_master = new ChoiceLabelMaster("지점을 선택해 주세요");
	
	ChoiceAreaMaster() {
		String area = "";
		ArrayList<String> g_name_list = new ArrayList<String>();
		g_name_list = new ManagerDAO().getGnameList();	
		for(int i = 0; i < g_name_list.size(); i++) {
			area = g_name_list.get(i).substring(0,2);
			switch(area) {
			case "부산":
				busan_stores_name.add(g_name_list.get(i));
				break;
			case "대구":
				daegu_stores_name.add(g_name_list.get(i));				
				break;
			case "울산":
				ulsan_stores_name.add(g_name_list.get(i));
				break;
			case "경주":
				kyeongju_stores_name.add(g_name_list.get(i));
				break;
			case "창원":
				changwon_stores_name.add(g_name_list.get(i));
				break;
			}
		}
		
		setBounds(0, 0, 1862, 1055);
		setLayout(null);

		add(area_combobox_master);
		add(area_choice_btn_master);
		add(area_exit_btn_master);
		add(area_choice_label_master);
				
		area_combobox_master.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choisen_area_master = area_combobox_master.getSelectedItem().toString();		
				area_choice_label_master.setText(choisen_area_master + "이(가) 선택되었습니다");
			}
		});
		
		area_choice_btn_master.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;

				if (choisen_area_master == "부산") {
					store_combobox_master = new ChoiceMaster(busan_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_master_panel().add(store_combobox_master);
					flag = true;
				} else if (choisen_area_master == "대구") {
					store_combobox_master = new ChoiceMaster(daegu_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_master_panel().add(store_combobox_master);
					flag = true;
				} else if (choisen_area_master == "울산") {
					store_combobox_master = new ChoiceMaster(ulsan_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_master_panel().add(store_combobox_master);
					flag = true;
				} else if (choisen_area_master == "경주") {
					store_combobox_master = new ChoiceMaster(kyeongju_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_master_panel().add(store_combobox_master);
					flag = true;
				} else if (choisen_area_master == "창원") {
					store_combobox_master = new ChoiceMaster(changwon_stores_name.toArray(new String[area_names.size()]));
					Main.MainFrame.getChoice_store_master_panel().add(store_combobox_master);
					flag = true;
				} else {
					JOptionPane.showMessageDialog(null, "지역을 선택해주세요", "지역선택오류", JOptionPane.ERROR_MESSAGE);
				}
				if (flag == true) {
					Main.MainFrame.getChoice_area_master_panel().setVisible(false);
					Main.MainFrame.getChoice_store_master_panel().setVisible(true);
					store_combobox_master.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								choisen_store_master = ChoiceAreaMaster.store_combobox_master.getSelectedItem().toString();
								store_choice_label_master.setText(choisen_store_master + "이(가) 선택되었습니다");
							}catch(NullPointerException e1) {
								JOptionPane.showMessageDialog(null, "잘못된 지점을 선택했습니다", "지점 선택 오류", JOptionPane.ERROR_MESSAGE);
							}
							
						}
					});
				}
			}
		});
		area_exit_btn_master.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getChoice_area_master_panel().setVisible(false);
				Main.MainFrame.getMain_panel().setVisible(true);
				area_combobox_master.setSelectedIndex(0);
				ChoiceAreaMaster.area_choice_label_master.setText("지역을 선택해 주세요");
				ChoiceAreaMaster.store_choice_label_master.setText("지점을 선택해 주세요");
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}

class ChoiceStoreMaster extends JPanel {
	ImageIcon background = new ImageIcon("images/choice_4.png");

	static ChoiceBtnMaster store_choice_btn = new ChoiceBtnMaster();
	static ExitBtnMaster store_exit_btn = new ExitBtnMaster();
	
	ChoiceStoreMaster() {
		setBounds(0, 0, 1862, 1055);
		setLayout(null);
		
		add(store_choice_btn);
		add(store_exit_btn);
		add(ChoiceAreaMaster.store_choice_label_master);
		
		store_choice_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ChoiceAreaMaster.choisen_store_master == "...") {
					JOptionPane.showMessageDialog(null, "지점을 선택해주세요", "지점선택오류", JOptionPane.ERROR_MESSAGE);									
				}else {
					Main.MainFrame.getFranchise_panel().setVisible(true);
					Main.MainFrame.getChoice_area_master_panel().setVisible(false);
					// String에 저장시키기========================================================================================================================
					FranchisePanel.store_name_label.setText(ChoiceAreaMaster.choisen_store_master);	
					SCoffeeSalesPanel.store_name_label_coffee.setText(ChoiceAreaMaster.choisen_store_master);	
					SSmoothieSalesPanel.store_name_label_smoothie.setText(ChoiceAreaMaster.choisen_store_master);
					STeaSalesPanel.store_name_label_tea.setText(ChoiceAreaMaster.choisen_store_master);	
					SBubbleSalesPanel.store_name_label_bubble.setText(ChoiceAreaMaster.choisen_store_master);
					SCakeSalesPanel.store_name_label_cake.setText(ChoiceAreaMaster.choisen_store_master);	
					SMacaronSalesPanel.store_name_label_macaron.setText(ChoiceAreaMaster.choisen_store_master);
					Main.MainFrame.getChoice_store_master_panel().remove(ChoiceAreaMaster.store_combobox_master);
					ChoiceAreaMaster.area_combobox_master.setSelectedIndex(0);		
					ChoiceAreaMaster.store_combobox_master.setSelectedIndex(0);
					ChoiceAreaMaster.area_choice_label_master.setText("지역을 선택해 주세요");
					ChoiceAreaMaster.store_choice_label_master.setText("지점을 선택해 주세요");
				}
			}
		});
		store_exit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getChoice_area_master_panel().setVisible(true);
				Main.MainFrame.getChoice_store_master_panel().setVisible(false);
				Main.MainFrame.getChoice_store_master_panel().remove(ChoiceAreaMaster.store_combobox_master);
				ChoiceAreaMaster.area_combobox_master.setSelectedIndex(0);		
				ChoiceAreaMaster.store_combobox_master.setSelectedIndex(0);
				ChoiceAreaMaster.area_choice_label_master.setText("지역을 선택해 주세요");
				ChoiceAreaMaster.store_choice_label_master.setText("지점을 선택해 주세요");
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}

class ChoiceMaster extends JComboBox {
	ChoiceMaster(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			addItem(arr[i]);
		}
		setBounds(781, 350, 300, 70);
		setVisible(true);
		setBackground(Color.MAGENTA);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 36));
		setBackground(new Color(255, 191, 148));
	}
}

class ChoiceBtnMaster extends JButton {
	ChoiceBtnMaster() {
		setBounds(732, 700, 160, 80);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
}

class ExitBtnMaster extends JButton {
	ExitBtnMaster() {
		setBounds(972, 700, 160, 80);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
}
class ChoiceLabelMaster extends JLabel{
	ChoiceLabelMaster(String text){
		setText(text);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 32));
		setBounds(581, 500, 700, 60);
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(new Color(255, 145, 71));
		setVisible(true);
	}
}
class WhichStoreLabelMaster extends JLabel{
	WhichStoreLabelMaster() {
		setBounds(120, 30, 400, 100);
		setFont(new Font("인터파크고딕 M", Font.PLAIN, 28));
		setForeground(new Color(255, 145, 71));
		setVisible(true);
	}
}