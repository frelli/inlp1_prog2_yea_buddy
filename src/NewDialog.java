import java.awt.Dimension;

import javax.swing.Box;
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
public class NewDialog extends JPanel{
	private JPanel pTitle, pName, pLand, pAge;
	private JTextField tName, tLand, tAge;
	private JLabel lName, lLand, lAge, lNr;
	
	public NewDialog(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Översta lappen som agerar rubrik
		pTitle = new JPanel();
		pTitle.setLayout(new BoxLayout(pTitle, BoxLayout.X_AXIS));
		
		int startNrInt = Deltagare.getRunners()+1;
		lNr = new JLabel("Startnummer "+startNrInt);
		
		pTitle.add(lNr);
		pTitle.add(Box.createRigidArea(new Dimension(80,0)));
		add(pTitle);
		add(Box.createRigidArea(new Dimension(0,10)));
		
		
		//Namn
		pName = new JPanel();
//		pName.setLayout(new GridLayout(1,2));
		pName.setLayout(new BoxLayout(pName, BoxLayout.X_AXIS));
		lName = new JLabel("Namn:");
		tName = new JTextField(5);
		pName.add(Box.createRigidArea(new Dimension(50,0)));
		pName.add(lName);
		pName.add(Box.createRigidArea(new Dimension(15,0)));
		pName.add(tName);
		pName.add(Box.createRigidArea(new Dimension(100,0)));
		add(pName);
		add(Box.createRigidArea(new Dimension(0,10)));
		
		//Land
		pLand = new JPanel();
//		pLand.setLayout(new GridLayout(1,2));
		pLand.setLayout(new BoxLayout(pLand, BoxLayout.X_AXIS));
		lLand = new JLabel("Land:");
		tLand = new JTextField(15);
		pLand.add(Box.createRigidArea(new Dimension(50,0)));
		pLand.add(lLand);
		pLand.add(Box.createRigidArea(new Dimension(20,0)));
		pLand.add(tLand);
		pLand.add(Box.createRigidArea(new Dimension(100,0)));
		add(pLand);
		add(Box.createRigidArea(new Dimension(0,10)));
		
		//Ålder
		pAge = new JPanel();
//		pAge.setLayout(new GridLayout(1,2));
		pAge.setLayout(new BoxLayout(pAge, BoxLayout.X_AXIS));
		lAge = new JLabel("Ålder:");
		tAge = new JTextField(5);
		pAge.add(Box.createRigidArea(new Dimension(50,0)));
		pAge.add(lAge);
		pAge.add(Box.createRigidArea(new Dimension(18,0)));
		pAge.add(tAge);
		pAge.add(Box.createRigidArea(new Dimension(200,0)));
		add(pAge);
		add(Box.createRigidArea(new Dimension(0,10)));
		
	}
	
	public String getName(){
		return tName.getText();
	}
	public String getLand(){
		return tLand.getText();
	}
	public int getAge(){
		return Integer.parseInt(tAge.getText());
	}

}
