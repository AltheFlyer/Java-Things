import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BitConverter {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BitConverter window = new BitConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BitConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Bit Converter");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane bitPane = new JTextPane();
		bitPane.setBounds(178, 10, 246, 35);
		frame.getContentPane().add(bitPane);
		
		JTextPane bytePane = new JTextPane();
		bytePane.setBounds(178, 61, 246, 35);
		frame.getContentPane().add(bytePane);
		
		JTextPane kiloPane = new JTextPane();
		kiloPane.setBounds(178, 112, 246, 35);
		frame.getContentPane().add(kiloPane);
		
		JTextPane megaPane = new JTextPane();
		megaPane.setBounds(178, 163, 246, 35);
		frame.getContentPane().add(megaPane);
		
		JTextPane gigaPane = new JTextPane();
		gigaPane.setBounds(178, 214, 246, 35);
		frame.getContentPane().add(gigaPane);
		
		JButton bitButton = new JButton("Convert Bits");
		bitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					bytePane.setText(String.format("%.4f", Float.valueOf(bitPane.getText()) / 8));
					kiloPane.setText(String.format("%.4f", Float.valueOf(bitPane.getText()) / (8 * 1024)));
					megaPane.setText(String.format("%.4f", Float.valueOf(bitPane.getText()) / (8 * Math.pow(1024, 2))));
					gigaPane.setText(String.format("%.4f", Float.valueOf(bitPane.getText()) / (8* Math.pow(1024, 3))));
				} catch (NumberFormatException e) {
					bitPane.setText("Please enter a valid number");
				}
			}
		});
		bitButton.setBounds(10, 10, 140, 35);
		frame.getContentPane().add(bitButton);
		
		JButton byteButton = new JButton("Convert Bytes");
		byteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					bitPane.setText(String.format("%.4f", Float.valueOf(bytePane.getText()) * 8));
					kiloPane.setText(String.format("%.4f", Float.valueOf(bytePane.getText()) / 1024));
					megaPane.setText(String.format("%.4f", Float.valueOf(bytePane.getText()) / (Math.pow(1024, 2))));
					gigaPane.setText(String.format("%.4f", Float.valueOf(bytePane.getText()) / (Math.pow(1024, 3))));	
				} catch (NumberFormatException e) {
					bytePane.setText("Please enter a valid number");
				}
			}
		});
		byteButton.setBounds(10, 61, 140, 35);
		frame.getContentPane().add(byteButton);
		
		JButton kiloButton = new JButton("Convert Kilobytes");
		kiloButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					bitPane.setText(String.format("%.4f", Float.valueOf(kiloPane.getText()) * 8 * 1024));
					bytePane.setText(String.format("%.4f", Float.valueOf(kiloPane.getText()) * 1024));
					megaPane.setText(String.format("%.4f", Float.valueOf(kiloPane.getText()) / 1024));
					gigaPane.setText(String.format("%.4f", Float.valueOf(kiloPane.getText()) / (Math.pow(1024, 2))));	
				} catch (NumberFormatException e) {
					kiloPane.setText("Please enter a valid number");
				}
			}
		});
		kiloButton.setBounds(10, 112, 140, 35);
		frame.getContentPane().add(kiloButton);
		
		JButton megaButton = new JButton("Convert Megabytes");
		megaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					bitPane.setText(String.format("%.4f", Float.valueOf(megaPane.getText()) * 8 * (Math.pow(1024, 2))));
					bytePane.setText(String.format("%.4f", Float.valueOf(megaPane.getText()) * (Math.pow(1024, 2))));
					kiloPane.setText(String.format("%.4f", Float.valueOf(megaPane.getText()) * 1024));
					gigaPane.setText(String.format("%.4f", Float.valueOf(megaPane.getText()) / 1024));	
				} catch (NumberFormatException e) {
					megaPane.setText("Please enter a valid number");
				}
			}
		});
		megaButton.setBounds(10, 163, 140, 35);
		frame.getContentPane().add(megaButton);
		
		JButton gigaButton = new JButton("Convert Gigabytes");
		gigaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				try {
					bitPane.setText(String.format("%.4f", Float.valueOf(gigaPane.getText()) * 8 * (Math.pow(1024, 3))));
					bytePane.setText(String.format("%.4f", Float.valueOf(gigaPane.getText()) * (Math.pow(1024, 3))));
					kiloPane.setText(String.format("%.4f", Float.valueOf(gigaPane.getText()) * (Math.pow(1024, 2))));
					megaPane.setText(String.format("%.4f", Float.valueOf(gigaPane.getText()) * 1024));	
				} catch (NumberFormatException e) {
					gigaPane.setText("Please enter a valid number");
				}
			}
		});
		gigaButton.setBounds(10, 214, 140, 35);
		frame.getContentPane().add(gigaButton);
		
		
	}
}
