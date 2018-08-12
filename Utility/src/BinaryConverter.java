/*
 * Binary Converter
 * Very Simple Converter to and from binary
 * Allen Liu
 * June 14, 2017
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BinaryConverter {
	
	private JFrame frame;
	private JTextField binaryInput;
	private JTextField numberInput;
	private int binary;
	private String temp;
	private String rawBinary;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinaryConverter window = new BinaryConverter();
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
	public BinaryConverter() {
		initialize();
	}

	public int convertNumber(String input){
		rawBinary = input;
		binary = 0;
		temp = "";
		
		//Clear spaces from inputs
		rawBinary = rawBinary.replaceAll(" ", "");
		//For user friendliness
		rawBinary = rawBinary.replaceAll("/", "");
		//DEBUG
		//System.out.println(rawBinary);
		for (int i = 0; i < rawBinary.length(); i ++){
			//Set temporary string for each character
			temp = rawBinary.substring(i, i + 1);
			if (temp.equals("1")){
				binary += Math.pow(2, rawBinary.length() - i - 1);
			} else if (temp.equals("0")) {
				//do nothing
			} else {
				binary += Integer.valueOf("t");
			}
			//System.out.println(input.substring(input.length() - i - 1, input.length() - i));
		}
		
		return binary;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Binary-Number Converter");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Used for user to enter binary value
		binaryInput = new JTextField("");
		binaryInput.setBounds(10, 39, 174, 20);
		frame.getContentPane().add(binaryInput);
		binaryInput.setColumns(10);
		
		//Used for user to enter number value
		numberInput = new JTextField();
		numberInput.setColumns(10);
		numberInput.setBounds(250, 39, 174, 20);
		frame.getContentPane().add(numberInput);
		
		//Shows converted binary value (to number)
		JTextPane numberOutput = new JTextPane();
		numberOutput.setBounds(10, 106, 174, 144);
		numberOutput.setEditable(false);
		frame.getContentPane().add(numberOutput);
		
		//Shows converted numeric value (from binary)
		JTextPane binaryOutput = new JTextPane();
		binaryOutput.setBounds(250, 106, 174, 144);
		binaryOutput.setEditable(false);
		frame.getContentPane().add(binaryOutput);
		
		//These are just labels
		JLabel binaryNumberLabel = new JLabel("Binary to Number");
		binaryNumberLabel.setBounds(10, 14, 174, 14);
		frame.getContentPane().add(binaryNumberLabel);
		
		JLabel numberBinaryLabel = new JLabel("Number to Binary");
		numberBinaryLabel.setBounds(250, 14, 174, 14);
		frame.getContentPane().add(numberBinaryLabel);
		
		//Conversion button for binary to number
		JButton numberButton = new JButton("Convert");
		numberButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//Convert number to binary
				try{
					//numberOutput
					numberOutput.setText(String.valueOf(convertNumber(binaryInput.getText())));
				} catch (NumberFormatException e){
					//If input is invalid
					numberOutput.setText("Please enter a valid binary number (Only '1' or '0', spaces , '\' and '/' are allowed)");
				}
			}
		});
		numberButton.setBounds(47, 72, 89, 23);
		frame.getContentPane().add(numberButton);
		
		//Conversion button for number to binary
		JButton binaryButton = new JButton("Convert");
		binaryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0){
				try{
					binaryOutput.setText(Integer.toBinaryString(Integer.valueOf(numberInput.getText().replaceAll(" ", ""))));
				} catch(NumberFormatException e){
					//runs if the textfield does not contain integers
					binaryOutput.setText("Please enter a valid integer (No decimals)");
				}
			}
		});
		binaryButton.setBounds(290, 72, 89, 23);
		frame.getContentPane().add(binaryButton);
		
		
	}
}
