import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class KistaLopp extends JFrame {

	JButton bNy, bVisa, bTid;
	JRadioButton rbStart, rbNamn, rb≈lder, rbTid;
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

		JPanel pEast = new JPanel();
		JPanel pEast1 = new JPanel();
		JPanel pEast2 = new JPanel();
		pEast.setLayout(new GridLayout(2, 1));

		JLabel sort = new JLabel("Sortering");
		rbStart = new JRadioButton("Startnr");
		rbNamn = new JRadioButton("Namn");
		rb≈lder = new JRadioButton("≈lder");
		rbTid = new JRadioButton("Tid");

		pEast2.setLayout(new BoxLayout(pEast2, BoxLayout.Y_AXIS));
		pEast2.add(sort);
		pEast2.add(rbStart);
		pEast2.add(rbNamn);
		pEast2.add(rb≈lder);
		pEast2.add(rbTid);

		pEast.add(pEast1);
		pEast.add(pEast2);
		add(pEast, BorderLayout.EAST);

		// South Panel

		JPanel pSouth = new JPanel();
		pSouth.setLayout(new BoxLayout(pSouth, BoxLayout.X_AXIS));
		bNy = new JButton("Ny");
		bVisa = new JButton("Visa");
		bTid = new JButton("Tid");
		pSouth.add(bNy);
		pSouth.add(bVisa);
		pSouth.add(bTid);
		add(pSouth, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(280, 320);
		setVisible(true);
	}

	public static void main(String[] args) {
		new KistaLopp();
	}

}
