import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public class SimpleFrame {
	
	public static void display() {
		//Window title
		String name = "First Window";
		//Color
		Color bg = Color.BLACK;
		//Menu color
		Color top = Color.DARK_GRAY;
		
		//Main Window
		JFrame window = new JFrame(name);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add colored area
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(bg);
		label.setPreferredSize(new Dimension(200, 200));
		
		//Add Menubar
		JMenuBar menu = new JMenuBar();
		menu.setOpaque(true);
		menu.setBackground(top);
		menu.setPreferredSize(new Dimension(200, 20));
	    
		//Add everything
		window.setJMenuBar(menu);
		window.getContentPane().add(label, BorderLayout.CENTER);
		window.pack();
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		//I don't know
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                display();
            }
        });
	}

}
