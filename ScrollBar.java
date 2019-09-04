package finalproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;

public class ScrollBar extends JPanel {
	private JLabel nub;
	private int maxLength;
	private int minLength;

	/**
	 * Create the panel.
	 */
	public ScrollBar() {
		
		maxLength = 519;
		minLength = 5;//Equal to width of draggable bar
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int relativeX = MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x;
				int relativeY = getLocationOnScreen().y - getLocationOnScreen().y;
				
				if(relativeX < 0){
					relativeX = 0;
				}else if(relativeX > maxLength - minLength){
					relativeX = maxLength - minLength;
				}
				
					double percent = relativeX / (double)(maxLength - minLength);
					int getVal = 14 + (int)(percent * 14386); // 14400 - 14 = 4386
					//System.out.println("getVal = " + getVal);
					nub.setLocation(relativeX, relativeY);
					UserPanel.draggedPeg(getVal);
					//GraphTimer.setSkew(getVal);
					//GraphTimer.refreshGraph(GraphTimer.getDataSet(), getVal);
					//Stochastics.predict(DatabaseAL.getPointIntervals(dataSet, getVal, 14));
					
			}
		});
		
		setLayout(null);
		nub = new JLabel("");
		nub.setIcon(new ImageIcon(ScrollBar.class.getResource("/finalproject/tick.png")));
		nub.setBounds(0, 0, 5, 20);
		add(nub);
		
		JLabel label = new JLabel("");
		label.setIcon(null);
		label.setBounds(0, 0, 300, 20);
		add(label);

	}
	
	public static void main(String[] args){
        JFrame frame = new JFrame("DrawGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ScrollBar());
        frame.pack();
		frame.setSize(317, 60);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
}
