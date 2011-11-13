import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 
 * En klass som skapar ett JPanel-objekt
 * att skicka med i JOptionPane-dialogen
 * för skapande av ny användare
 * 
 * */
public class NewTimeDialog extends JPanel{
	private JPanel pStartingNr, pTime, pS1, pS2, pT1, pT2;
	private JTextField tStartingNr, tTime;
	private JLabel lStartingNr, lTime;
	
	public NewTimeDialog(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Startnummer
		pStartingNr = new JPanel();
		pStartingNr.setLayout(new GridLayout(1,2));
		lStartingNr = new JLabel("Startnummer:");
		tStartingNr = new JTextField(5);
		pS1 = new JPanel();
		pS2 = new JPanel();
		pStartingNr.add(pS1);
		pStartingNr.add(pS2);
		pS1.add(lStartingNr);
		pS2.add(tStartingNr);
		add(pStartingNr);
		
		//Tid
		pTime = new JPanel();
		pTime.setLayout(new GridLayout(1,2));
		lTime = new JLabel("Tid:");
		tTime = new JTextField(5);
		pT1 = new JPanel();
		pT2 = new JPanel();
		pT1.add(lTime);
		pT2.add(tTime);
		pTime.add(pT1);
		pTime.add(pT2);
		add(pTime);
		
	}
	
	public int getStartNr(){
		return Integer.parseInt(tStartingNr.getText());
	}
	public double getTime(){
		return Double.parseDouble(tTime.getText());
	}

}
