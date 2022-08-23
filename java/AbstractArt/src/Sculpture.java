
public class Sculpture extends Art {
	
	private String material; 
	
	public Sculpture(String title, String author, String description, String material) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.material = material;
		museum.add(this);
		
	}
	
	public void viewArt() {
		System.out.printf("Title: %s, Author: %s, Desc: %s, Material: %s", this.title, this.author, this.description, this.material);

		
	}

}
