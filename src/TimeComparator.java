import java.util.Comparator;

public class TimeComparator implements Comparator<Deltagare> {

	public int compare(Deltagare d1, Deltagare d2) {
		
		//Om d1 har en h�gre tid �n d2 s� returneras 1
		if (d1.getTime() > d2.getTime())
			return 1;
		
		//Om de �r lika s� returneras 0
		else if (d1.getTime() == d2.getTime())
			return 0;
		
		//Om d1 har en l�gre tid �n d2 s� returneras -1
		else
			return -1;
	}

}
