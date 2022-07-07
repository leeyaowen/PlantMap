package plantmap.home;

import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class mapframe extends JFrame {

	private JPanel mapPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mapframe frame = new mapframe();
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
	public mapframe() {
		setTitle("PlantMap");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		mapPanel = new JPanel();
		
		mapPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mapPanel);
		mapPanel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(31, 28, 46, 15);
		mapPanel.add(lblX);
		
		JLabel lblY = new JLabel("Y");
		lblY.setBounds(87, 28, 46, 15);
		mapPanel.add(lblY);
		
		mapPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = MouseInfo.getPointerInfo().getLocation();
				SwingUtilities.convertPointFromScreen(p, mapPanel);
				Double mouseX = p.getX();
				Double mouseY = p.getY();
				lblX.setText(String.valueOf(mouseX.intValue()));
				lblY.setText(String.valueOf(mouseY.intValue()));
			}
		});
	}
}
