
/*
 * 
 * Skapar deltagarobjekt som kan delta i Kista-loppet
 * 
 * */
public class Deltagare {
	//statisk variabel vilket inneb�r att v�rdet kommer
	//att vara samma f�r alla deltagare som skapas
	private static int runners = 0; 
	
	private String land, name;
	private int startNr, age;
	private double time = Double.MAX_VALUE;
	
	public Deltagare (String name, String land, int age){
		runners++;
		startNr = runners;
		this.name = name;
		this.land = land;
		this.age = age;
		
	}
	
	//Returnerar deltagarens nationalitet
	public String getLand() {
		return land;
	}
	
	//Returnerar deltagarens namn
	public String getName() {
		return name;
	}
	
	//Returnerar deltagarens startnummer
	public int getStartNr() {
		return startNr;
	}

	//Returnerar deltagarens �lder
	public int getAge() {
		return age;
	}
	
	//returnerar det nuvarande v�rdet p� runners
	public static int getRunners() {
		return runners;
	}
	
	//Returnerar deltagarens sluttid
	public double getTime() {
		return time;
	}
	
	//S�tter deltagarens tid
	public void setTime(double time) {
		this.time = time;
	}

	public String toString() {
		String slutTid ="--";
		if(time != Double.MAX_VALUE )
				slutTid = String.valueOf(time);
		return startNr+". "+name+"\t"+land+"\t"+age+"\t"+slutTid;
	}
}
