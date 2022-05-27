import java.util.ArrayList;

/* Playlist class contains an array list of the songs users have entered and song count
*/
public class Playlist

{
    private String name;
    private int songCount;
    private ArrayList<Song> songList;

    // Constructor method for Playlist object
    Playlist(String name)
    {
        this.name = name;
        this.songList = new ArrayList<Song>();
        this.songCount = 0;
    }

    // Obtains name of playlist
    public String getName()
    {
        return this.name;
    }

    // Obtains the array list of songs
    public ArrayList<Song> getSongList()
    {
        return this.songList;
    }

    // Renames playlist
    public void setName(String name)
    {
        this.name = name;
    }

    // Adds given song to the playlist
    public void addSong(Song song)
    {
        this.songList.add(song);
        this.songCount++;
    }

    // Obtains the song count of the playlist
    public int getSongCount()
    {
        return this.songCount;
    }

    // Removes the FIRST instance of a given song in the playlist
    public void removeSong(Song song)
    {
        for (Song currentSong : this.songList)
        {
            if (currentSong.equals(song))
            {
                songList.remove(song);
                break;
            }
        }

        this.songCount--;
    }

    // Returns true if given Song exists within the song arraylist
    public boolean containsSong(Song song)
    {
        for (Song currentSong : this.songList)
        {
            if (currentSong.equals(song))
            {
                return true;
            }
        }

        return false;
    }

    // 2 playlists are equal if they have the same name (Case insensitive)
    public boolean equals(Object other)
    {
        Playlist otherP = (Playlist) other;
        return this.name.equalsIgnoreCase(otherP.getName());
    }

    // Prints the playlist name and all songs within it in a numbered list
    public void print()
    {
        System.out.println("Playlist: " + this.name + "\n__________________");

        if (songCount > 0)
        {
            for(int i = 0; i < songList.size(); i++)
            {
                Song currentSong = songList.get(i);

                System.out.print(i + 1 + ". ");
                currentSong.print();
            }
        }
        else
        {
            System.out.println("This playlist is empty.");
        }
    }
}
