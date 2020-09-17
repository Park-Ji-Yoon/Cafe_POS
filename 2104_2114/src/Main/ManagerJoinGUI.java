package Main;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManagerJoinGUI {
	public static void main(String[] args) {
	}
}

class ManagerJoinPanel extends JPanel {
	ImageIcon background = new ImageIcon("images/background_4.png");

	public ManagerJoinPanel() {
		setBounds(0, 0, 1862, 1055); // 위치와 크기 지정
		setLayout(null);
		setVisible(true);
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
}