import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

/*
 * 
 * Huvudklassen. H�r ligger mainmetodet 
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
		taDisplay.setEditable(false);
		taDisplay.setTabSize(7);

		// East Panel
		JPanel pEast = new JPanel(); // hela east
		JPanel pEast1 = new JPanel(); // f�r att putta ner pEast2
		JPanel pEast2 = new JPanel(); // radioknapparna
		pEast.setLayout(new GridLayout(2, 1));

		JLabel sort = new JLabel("Sortering");
		rbStart = new JRadioButton("Startnr");
		rbStart.setSelected(true); // startnummer f�rvalt som sorteringsmetod
		rbStart.addActionListener(new ShowListener());
		rbName = new JRadioButton("Namn");
		rbName.addActionListener(new ShowListener());
		rbAge = new JRadioButton("�lder");
		rbAge.addActionListener(new ShowListener());
		rbTime = new JRadioButton("Tid");
		rbTime.addActionListener(new ShowListener());

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
		
		JButton bAddppl = new JButton("Addera folk");
		bAddppl.addActionListener(new AdderaListener());

		pSouth.add(bNew);
		pSouth.add(bShow);
		pSouth.add(bTime);
		pSouth.add(bAddppl);
		add(pSouth, BorderLayout.SOUTH);

		// Metoder f�r huvudramen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 320);
		setVisible(true);
		setLocationRelativeTo(null);
	}// KistaLopp

	// Lyssnare till knappen bNew, f�r att skapa nya deltagare
	private class NewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NewDialog nd = new NewDialog();
			int answer = 0;
			for (;;) {
				try {

					// dialogrutan
					answer = JOptionPane.showConfirmDialog(null, nd,
							"Ny deltagare", JOptionPane.YES_NO_OPTION);

					// Variabler fr�n dialogen som anv�nds f�r att skapa den nya
					// deltagaren
					String n = nd.getName();
					String l = nd.getLand();
					int a = nd.getAge();

					// Om anv�ndaren trycker p� nej eller x s� st�ngs
					// dialogen oavsett om tomma f�lt finns eller inte
					if (answer != JOptionPane.YES_OPTION)
						return;

					// Kollar s� att man inte l�mnat namn tomt
					if (n.equals("")) {
						JOptionPane.showMessageDialog(null,
								"Uppgifter om deltagarens namn saknas.");

						// Kollar s� att man inte l�mnat namn tomt
					} else if (l.equals("")) {
						JOptionPane
								.showMessageDialog(null,
										"Uppgifter om deltagarens nationalitet saknas.");

						// Om alla f�lt �r korrekt ifyllda s� sparas deltagaren
						// i arraylistan
						// all, sedan avslutas dialogrutan
					} else {

						// Om anv�ndaren trycker p� YES, s� sparas deltagaren
						if (answer == JOptionPane.YES_OPTION) {
							Deltagare d = new Deltagare(n, l, a);
							all.add(d);
							return; // avslutar metoden och st�nger dialogen
						}
					}

				} catch (NumberFormatException err) {

					// om no eller x s� st�ngs det �ven om fel input
					if (answer == JOptionPane.YES_OPTION)
						JOptionPane.showMessageDialog(null, "Fel �lder");
					else
						return; // avslutar metoden och st�nger dialogen
				}
			}
		}// aP

	}// NewListener-klass

	// Lyssnare till knappen bShow, f�r att uppdatera listan som visas
	private class ShowListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			taDisplay.setText("");// t�mmer textarean

			if (rbStart.isSelected()) {
				
				Collections.sort(all, new StartComparator());

			} else if (rbName.isSelected()) {
				Collections.sort(all, new NameComparator());
			
			} else if (rbAge.isSelected()) {
				Collections.sort(all, new AgeComparator());
				
			} else if (rbTime.isSelected()) {
				Collections.sort(all, new TimeComparator());
			}
			
			for (Deltagare d : all){
				taDisplay.append(d.toString()+ "\n");
			}

		}// aP

	}// ShowListener-klass

	// Lyssnare till knappen bTime, f�r att l�gga till en deltagares tid
	private class TimeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int answer = 0;
			NewTimeDialog nTd = new NewTimeDialog();
			Deltagare del = null;

			for (;;) {
				try {
					answer = JOptionPane.showConfirmDialog(null, nTd,
							"Registrera tid", JOptionPane.YES_NO_OPTION);

					// Om anv�ndaren trycker p� nej eller x s� st�ngs
					// dialogen oavsett om tomma f�lt finns eller inte
					if (answer != JOptionPane.YES_OPTION)
						return;

					// Hitta r�tt deltagare
					for (Deltagare d : all) {
						if (d.getStartNr() == nTd.getStartNr()) {
							del = d;
							break;
						}
					}
					// Om deltagaren hittas s� sparas tiden till denna
					if (del != null) {
						del.setTime(nTd.getTime());
						return;
					}

					// Om deltagaren inte hittas s� ber�ttar vi det f�r
					// anv�ndaren
					else if (del == null) {
						JOptionPane
								.showMessageDialog(null,
										"Det finns ingen deltagare med det angivna startnumret.");
					}

				} catch (NumberFormatException err) {

					// om no eller x s� st�ngs det �ven om fel input
					if (answer == JOptionPane.YES_OPTION)
						JOptionPane.showMessageDialog(null,
								"Fel tid eller startnummer");
					else
						return; // avslutar metoden och st�nger dialogen
				}
			}
		}// aP

	}// TimeListener-klass

	// Main
	public static void main(String[] args) {
		new KistaLopp();
	}// Main

	private class AdderaListener implements ActionListener {

		public void actionPerformed(ActionEvent ave) {
			Deltagare d1 = new Deltagare("Johan", "SWE", 15);
			all.add(d1);
			d1.setTime(2.51);
			Deltagare d2 = new Deltagare("Kalle", "SWE", 12);
			all.add(d2);
			d2.setTime(3.21);
			Deltagare d3 = new Deltagare("Bengt", "SWE", 22);
			all.add(d3);
			d3.setTime(1.52);
			Deltagare d4 = new Deltagare("�rjan", "SWE", 19);
			all.add(d4);
			d4.setTime(7.31);
			Deltagare d5 = new Deltagare("Andreas", "SWE", 20);
			all.add(d5);
			d5.setTime(5.43);
			Deltagare d6 = new Deltagare("Lisa", "SWE", 38);
			all.add(d6);
			d6.setTime(1.07);
			Deltagare d7 = new Deltagare("Fabian", "SWE", 32);
			all.add(d7);
			d7.setTime(3.30);
			Deltagare d8 = new Deltagare("Yngve", "SWE", 6);
			all.add(d8);
			d8.setTime(0.58);
			Deltagare d9 = new Deltagare("Goostave", "SWE", 10);
			all.add(d9);
			d9.setTime(1.21);
			Deltagare d10 = new Deltagare("Kajsa", "SWE", 18);
			all.add(d10);
			d10.setTime(2.22);

		}

	}

}// Klass

