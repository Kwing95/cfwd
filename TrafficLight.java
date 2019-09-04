package finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class TrafficLight extends JFrame {
	private static final long serialVersionUID = -7360120401302591912L;
	private Color left;
	private Color middle;
	private Color right;
	private JButton button;
	private int count;

	public TrafficLight() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		count = 0;

		button = new JButton("Click to change");
		button.addActionListener(new ButtonButtonListener());
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(new DrawingPanel());
		panel.setBackground(new Color(Integer.parseInt("112"), Integer.parseInt("128"), Integer.parseInt("144")));

		getContentPane().add(panel);

		setSize(Integer.parseInt("420"), Integer.parseInt("250"));
		setVisible(true);
	}

	private class ButtonButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			count++;
			count %=Integer.parseInt("3");

			if (count == Integer.parseInt("0")) {
				turnRed();
			} if (count == Integer.parseInt("1")) {
				turnGreen();
			} else if (count == Integer.parseInt("2")) {
				turnAmber();
			}
			repaint();
		}
		public void turnGreen() {
			left = Color.GREEN;
			middle = Color.GRAY;
			right = Color.GRAY;
		}
		public void turnAmber() {
			left = Color.GRAY;
			middle = Color.YELLOW;
			right = Color.GRAY;
		}
		public void turnRed() {
			left = Color.GRAY;
			middle = Color.GRAY;
			right = Color.RED;
		}
	}

	class DrawingPanel extends JPanel {
		private static final long serialVersionUID = -1936027174564215297L;

		public DrawingPanel() {
			setPreferredSize(new Dimension(Integer.parseInt("340"), 
				Integer.parseInt("150")));
			setBackground(new Color(0, 0, 0));
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(left);
			g.fillOval(Integer.parseInt("10"), Integer.parseInt("30"),
				Integer.parseInt("100"), Integer.parseInt("100"));
			g.setColor(middle);
			g.fillOval(Integer.parseInt("120"), Integer.parseInt("30"),
				Integer.parseInt("100"), Integer.parseInt("100"));
			g.setColor(right);
			g.fillOval(Integer.parseInt("230"), Integer.parseInt("30"),
				Integer.parseInt("100"), Integer.parseInt("100"));
		}
	}
	public static void main(String[] args) {
		new TrafficLight();
	}
}