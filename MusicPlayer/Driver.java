public class Driver
{
    public static void main(String[] args){
        PlayList karaokeSongs = new PlayList("Karaoke Songs"); //playlist name inputted
        PlayList technoSongs = new PlayList(); //autofill playlist name
        PlayList emptyList = new PlayList("Favourite Band"); 
        Track favouriteSong = new Track("Moving On", "Sarah and the Sundays", 2018, 189); //example song for add(t)
        
        karaokeSongs.add("Bohemian Rhapsody", "Queen", 1975, 354); //add(t, a, y, d)
        karaokeSongs.add("I Wanna Dance With Somebody", "Whitney Houston", 1995, 214);
        karaokeSongs.add("Wonderwall", "Oasis", 1995, 258);
        karaokeSongs.add("We Will Rock You", "Queen"); //add(t, a)
        karaokeSongs.add("Don't Stop Believing", "Journey", 1995, 261);
        karaokeSongs.add("Another One Bites the Dust", "Queen", 1995, 284);
        karaokeSongs.add("Africa", "Toto");
        
        karaokeSongs.remove("I Wanna Dance With Somebody"); //remove example
        
        karaokeSongs.showList(); //showList() - not empty
        
        karaokeSongs.playOnly("Queen"); //playOnly(artist)
        karaokeSongs.playOnly(1995); //playOnly(year)
        
        technoSongs.setPlayListName("Cans on Campus - Volume 1"); //change playlist name
        
        technoSongs.add("Liverpool Streets In The Rain", "Mall Grab", 2018, 356);
        technoSongs.add("Sharp Like a Razor", "Clouds");
        technoSongs.add("Keep the Funk", "FJAAK", 2018, 378);
        technoSongs.add("Panzer", "Joshua Naughton");
        technoSongs.add("Bim Bim", "Casual Gabberz", 1912, 123);
        
        technoSongs.playAll(true); //shuffle example
        
        emptyList.showList(); // showList() - empty
        
        emptyList.add(favouriteSong); //add(t)
        emptyList.add("Sweet Dreams", "Sarah and the Sundays");
        emptyList.add("Ruby Fields", "Sarah and the Sundays");
        
        emptyList.playAll(false); //non-shuffles example
    }
}
