package hashmatique;

import java.util.HashMap;

public class SongTable {
    
    public HashMap<String,String> trackList(){
        HashMap<String, String> trackMap = new HashMap<String, String>();
        trackMap.put("Get Lucky","I'm up all night to get lucky");
        trackMap.put("3005","I'll be right by your side till 3005");
        trackMap.put("As it Was","You know it's not the same");
        trackMap.put("Smoking out the Window","Tell me how could you do this to me");
        String sampleSongValue = trackMap.get("3005");

        System.out.println("3005: "+sampleSongValue);
        return trackMap;
    }
}
