import java.util.ArrayList;
import java.util.Collections;

public class PlaylistOrganizer
{
    private ArrayList<Playlist> playlists;
    private int playlistCount;

    // Constructor method
    public PlaylistOrganizer()
    {
        this.playlists = new ArrayList<Playlist>();
        this.playlistCount = 0;
    }

    // Prints the names of all created playlists in a numbered list
    public void printAllPlaylists()
    {
        System.out.println("Playlists:");

        if (playlistCount > 0)
        {
            for (int i = 0; i < playlists.size(); i++) {
                Playlist current = playlists.get(i);
                System.out.println(i + 1 + ". " + current.getName());
            }
        }
        else
        {
            System.out.println("No playlists have been made.");
        }

        System.out.println("__________________");
    }

    // Prints the songs within a given playlists
    public void printPlaylistSongs(String indexStr) throws UnknownPlaylistException
    {
        Playlist selectedPlaylist = obtainPlaylist(indexStr);

        if (selectedPlaylist == null) {throw new UnknownPlaylistException("Playlist [#" + indexStr + "] does not exist.");}

        selectedPlaylist.print();
    }

    // Helper method that checks if a string is numerical or not
    private boolean isNumeric(String input)
    {
        if (input.length() == 0) {return false;}

        for (int i = 0; i < input.length(); i++)
        {
            if(!Character.isDigit(input.charAt(i))) {return false;}
        }

        return true;
    }

    // Creates new playlist and adds it to the list of playlists
    public void newPlaylist(String name) throws DuplicatePlaylistException, InvalidPlaylistNameException
    {
        if (name.trim().equals(""))  {throw new InvalidPlaylistNameException("Invalid playlist name entered.");}

        Playlist givenPlaylist = new Playlist(name);

        if (isDuplicate(givenPlaylist)) {throw new DuplicatePlaylistException("A playlist of the same name already exists.");}

        playlists.add(givenPlaylist);
        playlistCount++;
    }

    // Removes given playlist from list if exists
    public void remPlaylist(String index) throws UnknownPlaylistException
    {
        Playlist selectedPlaylist = obtainPlaylist(index);

        if (selectedPlaylist == null) {throw new UnknownPlaylistException("Playlist [#" + index + "] does not exist.");}

        for (Playlist currPlaylist : playlists)
        {
            if (currPlaylist.equals(selectedPlaylist))
            {
                playlists.remove(selectedPlaylist);
                playlistCount--;
                break;
            }
        }
    }

    // Helper method that returns a playlist object based on the index given. Returns null if invalid
    private Playlist obtainPlaylist(String index)
    {
        if (!isNumeric(index)) {return null;}

        int indexNum = Integer.parseInt(index);

        if(indexNum < 1 || indexNum > playlists.size()) {return null;}

        return playlists.get(indexNum - 1);
    }

    // Helper method that returns true if a playlist of the same name already exists
    private boolean isDuplicate(Playlist givenPlaylist)
    {
        return playlists.contains(givenPlaylist);
    }

    // Renames a selected playlist with the given name
    public void renamePlaylist(String index, String name) throws UnknownPlaylistException, DuplicatePlaylistException, InvalidPlaylistNameException
    {
        Playlist selectedPlaylist = obtainPlaylist(index);

        if (selectedPlaylist == null) {throw new UnknownPlaylistException("Playlist [#" + index + "] does not exist.");}

        if (name.trim().equals("")) {throw new InvalidPlaylistNameException("Invalid playlist name entered.");}

        Playlist givenPlaylist = new Playlist(name);
        if (isDuplicate(givenPlaylist)) {throw new DuplicatePlaylistException("A playlist of the same name already exists.");}

        selectedPlaylist.setName(name);
    }

    // Adds a song to a given playlist
    public void addPlaylistSong(String index, String title, String artist) throws UnknownPlaylistException, InvalidSongTitleException, InvalidSongArtistException
    {
        Playlist selectedPlaylist = obtainPlaylist(index);
        if (selectedPlaylist == null) {throw new UnknownPlaylistException("Playlist [#" + index + "] does not exist.");}

        if (title.trim().equals("")) {throw new InvalidSongTitleException("Invalid song title entered.");}

        if (artist.trim().equals("")) {throw new InvalidSongArtistException("Invalid song artist entered.");}

        selectedPlaylist.addSong(new Song(title, artist));
    }

    // Helper method that obtains a Song reference from a playlist if it exists
    private Song obtainPlaylistSong(Playlist selectedList, String songIndex)
    {
        ArrayList<Song> selectedSongList= selectedList.getSongList();

        if(!isNumeric(songIndex)) {return null;}

        int songIndexNum = Integer.parseInt(songIndex);
        if (songIndexNum < 1 || songIndexNum > selectedSongList.size()) {return null;}

        return selectedSongList.get(songIndexNum - 1);
    }

    // Removes a given song from a selected playlist. Returns Song reference of removed song
    public Song remPlaylistSong(String index, String songIndex) throws UnknownSongException, UnknownPlaylistException
    {
        Playlist selectedPlaylist = obtainPlaylist(index);
        if(selectedPlaylist == null) {throw new UnknownPlaylistException("Playlist [#" + index + "] does not exist.");}

        Song selectedSong = obtainPlaylistSong(selectedPlaylist, songIndex);
        if(selectedSong == null) {throw new UnknownSongException("Song [#" + songIndex + "] does not exist.");}

        selectedPlaylist.removeSong(selectedSong);
        return selectedSong;
    }

    // Shuffles the song list of a given playlist if it contains songs
    public void shufflePlaylist(String index) throws UnknownPlaylistException, EmptyPlaylistException
    {
        Playlist selectedPlaylist = obtainPlaylist(index);
        if (selectedPlaylist == null) {throw new UnknownPlaylistException("Playlist [#" + index + "] does not exist.");}

        if(selectedPlaylist.getSongCount() == 0) {throw new EmptyPlaylistException("Selected playlist has no songs to shuffle.");}

        Collections.shuffle(selectedPlaylist.getSongList());
    }
}