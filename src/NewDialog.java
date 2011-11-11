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
	private JPanel pName, pLand, pAge;
	private JTextField tName, tLand, tAge;
	private JLabel lName, lLand, lAge, lNr;
	
	public NewDialog(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Översta lappen som agerar rubrik
		int startNrInt = Deltagare.getRunners()+1;
		lNr = new JLabel("Startnummer "+startNrInt);
		add(lNr);
		
		//Namn
		pName = new JPanel();
		lName = new JLabel("Namn:");
		tName = new JTextField(15);
		pName.add(lName);
		pName.add(tName);
		add(pName);
		
		//Land
		pLand = new JPanel();
		lLand = new JLabel("Land:");
		tLand = new JTextField(15);
		pLand.add(lLand);
		pLand.add(tLand);
		add(pLand);
		
		//Ålder
		pAge = new JPanel();
		lAge = new JLabel("Ålder:");
		tAge = new JTextField(5);
		pAge.add(lAge);
		pAge.add(tAge);
		add(pAge);
	}

}
