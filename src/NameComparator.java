import java.util.Comparator;

class NameComparator implements Comparator<Deltagare> {
	public int compare(Deltagare p1, Deltagare p2) {
		
		return p1.getName().compareTo(p2.getName());
	}
}