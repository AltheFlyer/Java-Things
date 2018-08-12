import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class RandomCiv {

	/* Allen Liu
	 * Apr 23, 2018
	 * A random Civ generator that doesn't give everyone Venice
	 */
	public static void main(String[] args) {
		
		ArrayList<String> civs = new ArrayList<String>();
		JFrame window = new JFrame("Civ Generator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(450, 110));
		
		JList<String> list = new JList<String>();
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scroll.add(list);
		window.getContentPane().add(scroll, BorderLayout.CENTER);
		window.pack();
		window.setVisible(true);
		
	}

}
