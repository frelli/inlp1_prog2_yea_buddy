import java.util.Comparator;

public class TimeComparator implements Comparator<Deltagare> {

	public int compare(Deltagare d1, Deltagare d2) {
		
		//Om d1 har en högre tid än d2 så returneras 1
		if (d1.getTime() > d2.getTime())
			return 1;
		
		//Om de är lika så returneras 0
		else if (d1.getTime() == d2.getTime())
			return 0;
		
		//Om d1 har en lägre tid än d2 så returneras -1
		else
			return -1;
	}

}
