import java.util.Comparator;


public class AgeComparator implements Comparator<Deltagare>{

	public int compare(Deltagare d1, Deltagare d2) {
		
		return d1.getAge() - d2.getAge();
	}

}
