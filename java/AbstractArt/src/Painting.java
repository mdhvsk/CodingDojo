
public class Painting extends Art {
	
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.paintType = paintType;
		museum.add(this);
		
	}
	public void viewArt(){
		System.out.printf("Title: %s, Author: %s, Desc: %s, Paint Type: %s", this.title, this.author, this.description, this.paintType);
	}
	

}
