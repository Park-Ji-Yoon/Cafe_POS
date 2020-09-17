package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MasterGUI {
	public static void main(String args[]) {
		MasterPanel master_panel = new MasterPanel();
	}
}

class MasterPanel extends JPanel {
	ImageIcon background = new ImageIcon("images/background_4.png"); // 배경사진은 class못만들어서 그냥 넣음

	static BusanStore busan_store = new BusanStore();
	static DaeguStore daegu_store = new DaeguStore();
	static UlsanStore ulsan_store = new UlsanStore();
	
	static ChooseArea choose_area = new ChooseArea();
	
	static Object[] store_list = {busan_store, daegu_store, ulsan_store};

	MasterPanel() {
		MasterLabel master_label = new MasterLabel();
		add(master_label);

		AddManagerBtn add_manaber_btn = new AddManagerBtn();
		add(add_manaber_btn);

		DelManagerBtn del_manaber_btn = new DelManagerBtn();
		add(del_manaber_btn);

		ExitMasterBtn exit_master_btn = new ExitMasterBtn();
		add(exit_master_btn);

		add(choose_area);

		add(busan_store);
		add(daegu_store);
		add(ulsan_store);
		
		imsi i = new imsi();
		add(i);

		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public static ChooseArea getChoose_area() {
		return choose_area;
	}

	public static Object[] getStore_list() {
		return store_list;
	}

	public static BusanStore getBusan_store() {
		return busan_store;
	}

	public static DaeguStore getDaegu_store() {
		return daegu_store;
	}

	public static UlsanStore getUlsan_store() {
		return ulsan_store;
	}
}

class MasterLabel extends JLabel {
	MasterLabel() {
		setBounds(781, 0, 300, 120);
		setVisible(true);
		setText("관리자");
		setForeground(Color.black);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 45));
		setHorizontalAlignment(JLabel.CENTER);
	}
}

class ChooseArea extends JList {
	static String[] area = { "부산", "대구", "울산", "경주", "창원", "경남" };
	Vector vec;

	ChooseArea() {
		vec = new Vector();

		for (int i = 0; i < area.length; i++) {
			vec.addElement(area[i]);
		}

		setListData(vec);
		setSelectedIndex(0);
		setVisible(true);
		setBounds(981, 150, 416, 500);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));

		JListHandler handler = new JListHandler();
		addListSelectionListener(handler);
	}

	public static String[] getArea() {
		return area;
	}
}

class BusanStore extends JList {
	String[] busan = { "부산AA점", "부산BB점", "부산CC점", "부산DD점", "부산EE점" };
	Vector busan_vec;

	BusanStore() {
		busan_vec = new Vector();

		for (int i = 0; i < busan.length; i++) {
			busan_vec.addElement(busan[i]);
		}
		setListData(busan_vec);
//		setVisible(false);
		setBounds(1397, 150, 416, 500);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));

		JListHandler handler = new JListHandler();
		addListSelectionListener(handler);
	}

}

class DaeguStore extends JList {
	String[] daugu = { "대구AA점", "대구BB점", "대구CC점", "대구DD점", "대구EE점" };
	Vector daugu_vec;

	DaeguStore() {
		daugu_vec = new Vector();

		for (int i = 0; i < daugu.length; i++) {
			daugu_vec.addElement(daugu[i]);
		}
		setListData(daugu_vec);
		setVisible(false);
		setBounds(1397, 150, 416, 500);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));

		JListHandler handler = new JListHandler();
		addListSelectionListener(handler);
	}

}

class UlsanStore extends JList {
	String[] ulsan = { "울산AA점", "울산BB점", "울산CC점", "울산DD점", "울산EE점" };
	Vector ulsan_vec;

	UlsanStore() {
		ulsan_vec = new Vector();

		for (int i = 0; i < ulsan.length; i++) {
			ulsan_vec.addElement(ulsan[i]);
		}
		setListData(ulsan_vec);
		setVisible(false);
		setBounds(1397, 150, 416, 500);
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));

		JListHandler handler = new JListHandler();
		addListSelectionListener(handler);
	}

}

class JListHandler implements ListSelectionListener {
	public void valueChanged(ListSelectionEvent event) {
//		if(MasterPanel.getStore_list()[MasterPanel.getChoose_area().getSelectedIndex()].getClass().getName() == "BusanStore") {
//			BusanStore bs = new BusanStore();
//			bs.setVisible(true);
//		}
	}
}
class imsi extends JButton{
	imsi(){
		setBounds(300, 300, 50, 50);
		setForeground(Color.white);
		setBackground(Color.black);
		setText("임시 버튼");
		setVisible(true);
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getMaster_panel().setVisible(false);
				Main.MainFrame.getFranchise_panel().setVisible(true);
			}
		});
	}
}
class AddManagerBtn extends JButton {
	AddManagerBtn() {
		setBounds(92, 755, 498, 160);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(112, 151, 168));
		setText("지점장 추가");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getMaster_panel().setVisible(false);
				Main.MainFrame.getManager_join_panel().setVisible(true);
			}
		});
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
		} else {
			graphics.setColor(getBackground());
		}
		graphics.fillRoundRect(0, 0, width, height, 50, 50);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}

class DelManagerBtn extends JButton {
	DelManagerBtn() {
		setBounds(682, 755, 498, 160);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(112, 151, 168));
		setText("지점장 삭제");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
		} else {
			graphics.setColor(getBackground());
		}
		graphics.fillRoundRect(0, 0, width, height, 50, 50);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}

class ExitMasterBtn extends JButton {
	ExitMasterBtn() {
		setBounds(1272, 755, 498, 160);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(112, 151, 168));
		setText("취소");
		setFont(new Font("서울남산 장체 B", Font.BOLD, 40));
		setVisible(true);
		setHorizontalAlignment(SwingConstants.CENTER);

		decorate(); // 버튼 테두리 둥글게

		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.MainFrame.getLogin_panel().setVisible(true);
				Main.MainFrame.getMaster_panel().setVisible(false);
			}
		});
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
		} else {
			graphics.setColor(getBackground());
		}
		graphics.fillRoundRect(0, 0, width, height, 50, 50);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}