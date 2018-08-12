import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ASCIIConverter {
	
	private JFrame frame;
	private char temp;
	private String tempBinary;
	private String output = "";
	private int value = 0;
	
	private String convertToASCII(String str){
		output = "";
		tempBinary = "";
		for (int i = 0; i < str.length(); i ++){
			temp = str.charAt(i);
			tempBinary = Integer.toBinaryString((int) temp) + " ";
			while (tempBinary.length() < 9){
				tempBinary = "0" + tempBinary;
			}			
			output += tempBinary;
		}
		return output;
	}
	
	private String convertToText(String str){
		output = "";
		tempBinary = "";
		//replace aid characters
		str = str.replace(" ", "");
		str = str.replace("/", "");
		for (int i = 0; i < str.length(); i += 8){
			tempBinary = str.substring(i, i + 8);
			//convert binary to int
			value = 0;
			for (int x = 0; x < tempBinary.length(); x ++){
				temp = tempBinary.charAt(x);
				if (temp == '1'){
					value += (int) Math.pow(2, tempBinary.length() - x - 1);
				}
			}
			output += (char)value;
		}
		return output;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ASCIIConverter window = new ASCIIConverter();
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
	public ASCIIConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ASCII-Text Converter");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane asciiPanel = new JTextPane();
		asciiPanel.setBounds(73, 147, 227, 103);
		frame.getContentPane().add(asciiPanel);
		
		JTextPane textPanel = new JTextPane();
		textPanel.setBounds(73, 11, 227, 103);
		frame.getContentPane().add(textPanel);
		
		JLabel lblText = new JLabel("Text");
		lblText.setBounds(10, 59, 46, 14);
		frame.getContentPane().add(lblText);
		
		JLabel lblAscii = new JLabel("ASCII");
		lblAscii.setBounds(10, 172, 46, 14);
		frame.getContentPane().add(lblAscii);
		
		JButton textAscii = new JButton("ASCII to Text");
		textAscii.setBounds(73, 120, 110, 23);
		textAscii.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent arg0){
				try {
					textPanel.setText(convertToText(asciiPanel.getText()));
				} catch (StringIndexOutOfBoundsException e){
					textPanel.setText("Please enter valid 8-bit binary");
				}
			}
		});
		frame.getContentPane().add(textAscii);
		
		JButton asciiText = new JButton("Text to ASCII");
		asciiText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				asciiPanel.setText(convertToASCII(textPanel.getText()));
			}
		});
		asciiText.setBounds(190, 120, 110, 23);
		frame.getContentPane().add(asciiText);
	}
}
