/*
 *  class Customer defines a registered customer. It keeps track of the customer's name and address. 
 *  A unique id is generated  when a new customer is created.
 *  
 *  Implement the Comparable interface and compare two customers based on name // CHANGE
 */
public class Song
{
    private String title;
    private String artist;
    private int songNum;

    // Constructor method
    public Song(int songNum, String title, String artist)
    {
        this.songNum = songNum;
        this.title = title;
        this.artist = artist;
    }

    // Obtains song number
    public int getSongNum()
    {
        return this.songNum;
    }

    // Obtains song title
    public String getTitle()
    {
        return this.title;
    }

    // Obtains song artist
    public String getArtist()
    {
        return this.artist;
    }

    // Returns true if 2 songs have the same title and artist
    public boolean equals(Object other)
    {
        Song otherS = (Song) other;
        return this.title.equalsIgnoreCase(otherS.getTitle()) && this.artist.equalsIgnoreCase(otherS.getArtist());
    }

    // Prints song title and artist (Format: Artist - Title)
    public void print()
    {
        System.out.println(this.artist + " - " + this.title);
    }
}