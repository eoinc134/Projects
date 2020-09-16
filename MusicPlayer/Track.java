
public class Track implements Comparable<Track>
{
    private String title;
    private String artist;
    private int year;
    private int duration;
    
    public Track(String title, String artist){//new track (t,a)
        this.title = title;
        this.artist = artist;
        this.year = 0;
        this.duration = 0;
    }
    public Track(String title, String artist, int year, int duration){//new track (t,a,y,d)
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.duration = duration;
    }
    
    public void setTitle(String title){//change title
        this.title = title;
    }
    public String getTitle(){//return title
        return this.title;
    }
    
    public void setArtist(String artist){//change artist
        this.artist = artist;
    }
    public String getArtist(){//return artist
        return this.artist;
    }
    
    public void setYear(int year){//change year
        this.year = year;
    }
    public int getYear(){//return year
        return this.year;
    }
    
    public void setDuration(int seconds){//change duration
        this.duration = duration;
    }
    public int getDuration(){//get duration
        return this.duration;
    }
    
    public String toString(){
        int s = this.duration % 60; //seconds
        int m = this.duration / 60; //minutes
        String durationString = String.format("%02d", m) + ":" + String.format("%02d", s);//MM:SS format
        
        return this.title + " by " + this.artist + " (" + this.year + ") - " + durationString;// title by artist (year) - MM:SS
    }
    
    public int compareTo(Track other){
        return this.title.compareToIgnoreCase(other.title);//natural ordering
    }
}
