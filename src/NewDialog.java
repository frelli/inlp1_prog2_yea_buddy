import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 
 * En klass som skapar ett JPanel-objekt
 * att skicka med i JOptionPane-dialogen
 * f�r skapande av ny anv�ndare
 * 
 * */
public class NewDialog extends JPanel{
	private JPanel pName, pLand, pAge;
	private JTextField tName, tLand, tAge;
	private JLabel lab;
	
	public NewDialog(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		lab = new JLabel("Startnr "+Deltagare.runners++);
		
	}

}
