import java.util.ArrayList;


public abstract class Art {
	
	protected String title;
	protected String author;
	protected String description;
	static ArrayList<Object> museum = new ArrayList<>();
	
	
	public abstract void viewArt();
		
	
}
