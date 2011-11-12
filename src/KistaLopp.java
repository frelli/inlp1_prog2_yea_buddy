import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//test fran barbara

/*
 * 
 * Huvudklassen. H�r ligger mainmetodet YEEEEEEEEA
 * och huvuddelen av GUIt skapas h�r
 * 
 * */
public class KistaLopp extends JFrame {

	JButton bNew, bShow, bTime;
	JRadioButton rbStart, rbName, rbAge, rbTime;
	JTextArea taDisplay = new JTextArea();
	ArrayList<Deltagare> all = new ArrayList<Deltagare>();

	// Konstruktorn
	public KistaLopp() {
		super("DSV Kista Marathon");

		// North panel
		JPanel pNorth = new JPanel();
		pNorth.add(new JLabel("DSV Kista Marathon"));
		add(pNorth, BorderLayout.NORTH);

		// Center Panel
		add(new JScrollPane(taDisplay), BorderLayout.CENTER);

		// East Panel
		JPanel pEast = new JPanel(); // hela east
		JPanel pEast1 = new JPanel(); // f�r att putta ner pEast2
		JPanel pEast2 = new JPanel(); // radioknapparna
		pEast.setLayout(new GridLayout(2, 1));

		JLabel sort = new JLabel("Sortering");
		rbStart = new JRadioButton("Startnr");
		rbStart.setSelected(true); // startnummer f�rvalt som sorteringsmetod
		rbName = new JRadioButton("Namn");
		rbAge = new JRadioButton("�lder");
		rbTime = new JRadioButton("Tid");

		ButtonGroup bg = new ButtonGroup(); // Radiogrupp, g�r att bara en knapp
		bg.add(rbAge); // �t g�ngen kan vara markerad
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
		bNew.addActionListener(new NewListener());

		bShow = new JButton("Visa");
		bShow.addActionListener(new ShowListener());

		bTime = new JButton("Tid");
		bTime.addActionListener(new TimeListener());

		pSouth.add(bNew);
		pSouth.add(bShow);
		pSouth.add(bTime);
		add(pSouth, BorderLayout.SOUTH);

		// Metoder f�r huvudramen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(280, 320);
		setVisible(true);
		setLocationRelativeTo(null);
	}// KistaLopp

	// Lyssnare till knappen bNew, f�r att skapa nya deltagare
	private class NewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NewDialog nd = new NewDialog();

			for (;;) {
				try {
					JOptionPane.showConfirmDialog(null, nd, "Ny deltagare",
							JOptionPane.YES_NO_OPTION);

				} catch (NumberFormatException err) {

				}
			}
		}// ap

	}// NewListener-klass

	// Lyssnare till knappen bShow, f�r att uppdatera listan som visas
	private class ShowListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (rbStart.isSelected()) {

			} else if (rbName.isSelected()) {

			} else if (rbAge.isSelected()) {

			} else if (rbTime.isSelected()) {

			}

		}// aP

	}// ShowListener-klass

	// Lyssnare till knappen bTime, f�r att l�gga till en deltagares tid
	private class TimeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}// aP

	}// TimeListener-klass

	// Main
	public static void main(String[] args) {
		new KistaLopp();
	}// Main

}// Klass
