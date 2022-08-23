import java.util.ArrayList;

public class Museum {
	
	public static void main(String [] args) {
		
		Painting picasso = new Painting("Weeping Woman", "Picasso", "Artsy", "Acrylic");
		Painting kahlo = new Painting("Painting 2", "Kahlo", "Artsyyy", "Watercolor");
		Painting vinci = new Painting("Mona Lisa", "Vinci", "Starlight", "Wax");
		
		Sculpture michealangelo = new Sculpture(" Lisa", "Vin", "Light", "Marble");
		Sculpture donatello = new Sculpture("Mona ", "Vci", "Star", "Bronze");
		
		ArrayList artList = new ArrayList<Object>(picasso.museum);

		for (int i = 0; i < artList.size(); i++) {
			System.out.println(artList.get(i));
		}
		System.out.println(picasso.museum);

		
	}

}
