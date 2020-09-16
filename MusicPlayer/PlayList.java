import java.util.*;
public class PlayList
{
    private String playListName;
    private ArrayList<Track> tracks;
     
    public PlayList(){
        this.playListName = "My Playlist"; //auto filled name
        this.tracks = new ArrayList<Track>();
    }
    public PlayList(String playListName){
        this.playListName = playListName;
        this.tracks = new ArrayList<Track>();
    }
    
    public void setPlayListName(String playListName){
        this.playListName = playListName; //change playlist name
    }
    public String getPlayListName(){
        return this.playListName; //return playlist name
    }
    
    public void add(String title, String artist){
        Track song = new Track(title, artist);
        tracks.add(song); //add song w/ artist only
    }
    public void add(String title, String artist, int year, int duration){
        Track song = new Track(title, artist, year, duration);
        tracks.add(song); //add song w/ artist, year, duration
    }
    public void add(Track t){
        tracks.add(t); //add track
    }
    
    public boolean remove(String title){
        for(Track t : tracks){
            if(t.getTitle().compareToIgnoreCase(title) == 0){// case insensetive
                tracks.remove(t); //remove track
                return true; //found and removed
            }
        }
        return false; //not found
    }
    
    public String toString(){
        return this.playListName + "\n" + tracks; 
    }
    
    public void showList(){
        String song = "";
        if(tracks.size() == 0){ //playlist empty
           System.out.println(this.playListName + ":");
           System.out.println("The List is Empty"); 
           System.out.println();
        } else {
           System.out.println(this.playListName + ":");
           for(Track t : tracks){//print each track
               System.out.println(t);
           }
            System.out.println();
        }
    }
    
    public void playAll(boolean random){
        ArrayList<Track> shuffled = new ArrayList<Track>();//new arrayList to retain order
        shuffled = tracks;
        if(random == false){
            showList();//no shuffle
        } else {
            System.out.println(this.playListName + ":");
            while(shuffled.size() > 0){
                int shuffle = (int)(Math.random() * shuffled.size());
                System.out.println(shuffled.get(shuffle));//print random song
                shuffled.remove(shuffle);//remove song
            }
        }
        System.out.println();
    }
    public void playOnly(String artist){
        artist = artist.toUpperCase();// for case insensitive
        System.out.println("Songs by " + artist + ":");
        for(Track t : tracks){//check each artist name
            if((t.getArtist()).toUpperCase().contains(artist)){
                System.out.println(t);
            }
        }
        System.out.println();
    }
    public void playOnly(int year){
        System.out.println("Songs from " + year + ":");
        for(Track t : tracks){//check each track year
            if(t.getYear() == year){
                System.out.println(t);
            }
        }
        System.out.println();
    }
}
