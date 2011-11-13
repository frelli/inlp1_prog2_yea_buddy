import java.util.Comparator;

public class StartComparator implements Comparator<Deltagare> {

	public int compare(Deltagare d1, Deltagare d2) {
		
		return d1.getStartNr() - d2.getStartNr();
	}

}
