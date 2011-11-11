import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/*
 * 
 * Huvudklassen. Här ligger mainmetodet 
 * och huvuddelen av GUIt skapas här
 * 
 * */
public class KistaLopp extends JFrame {

	JButton bNew, bShow, bTime;
	JRadioButton rbStart, rbName, rbAge, rbTime;
	JTextArea taDisplay = new JTextArea();

	public KistaLopp() {
		super("DSV Kista Marathon");

		// North panel

		JPanel pNorth = new JPanel();
		pNorth.add(new JLabel("DSV Kista Marathon"));
		add(pNorth, BorderLayout.NORTH);

		// Center Panel

		add(new JScrollPane(taDisplay), BorderLayout.CENTER);

		// East Panel

		JPanel pEast = new JPanel(); //hela east
		JPanel pEast1 = new JPanel(); //för att putta ner pEast2
		JPanel pEast2 = new JPanel(); //radioknapparna
		pEast.setLayout(new GridLayout(2, 1));

		JLabel sort = new JLabel("Sortering");
		rbStart = new JRadioButton("Startnr");
		rbName = new JRadioButton("Namn");
		rbAge = new JRadioButton("Ålder");
		rbTime = new JRadioButton("Tid");
		
		ButtonGroup bg = new ButtonGroup(); //Radiogrupp, gör att bara en knapp
		bg.add(rbAge);						// åt gången kan vara markerad
		bg.add(rbName);
		bg.add(rbStart);
		bg.add(rbTime);
		

		pEast2.setLayout(new BoxLayout(pEast2, BoxLayout.Y_AXIS));
		pEast2.add(sort);
		pEast2.add(rbStart);
		pEast2.add(rbName);
		pEast2.add(rbAge);
		pEast2.add(rbTime);

		pEast.add(pEast1);
		pEast.add(pEast2);
		add(pEast, BorderLayout.EAST);

		// South Panel

		JPanel pSouth = new JPanel();
		pSouth.setLayout(new BoxLayout(pSouth, BoxLayout.X_AXIS));
		bNew = new JButton("Ny");
		bShow = new JButton("Visa");
		bTime = new JButton("Tid");
		pSouth.add(bNew);
		pSouth.add(bShow);
		pSouth.add(bTime);
		add(pSouth, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(280, 320);
		setVisible(true);
	}

	public static void main(String[] args) {
		new KistaLopp();
	}

}
