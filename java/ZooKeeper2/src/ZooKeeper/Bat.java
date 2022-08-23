package ZooKeeper;

public class Bat {

	int energyLevel;
	
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("Dum DUUUM..... I'm Batman");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("AHHHH the HORROR");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Batman STARTED THE FIRE! IT WAS ALWAYS BURNING...");
		this.energyLevel -= 100;
	}

}
