package ZooKeeper;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Gorilla has thrown something");
		this.energyLevel -= 5;
	}
	
	
	public void eatBananas() {
		System.out.println("Gorilla is full");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Gorilla is tired");
		this.energyLevel -= 10;
		
	}

}
