import java.util.Scanner;

// User interface of the program. Contains command and program description within menu options
public class PlaylistOrganizerUserInterface
{
    public static void main(String[] args)
    {
        PlaylistOrganizer organizer = new PlaylistOrganizer();

        Scanner scanner = new Scanner(System.in);

        // Displays program menu
        System.out.println(" Menu:\n 1 - Command Help\n 2 - About\n Q - Quit \n________________________");

        while (true)
        {
            System.out.print("\n>>");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) // Terminates program
            {
                System.out.println("Program terminated.");
                break;
            }
            else if(input.equalsIgnoreCase("1")) // Displays the command list and describes them
            {
                System.out.println("Command Menu:\n");
                System.out.println("Note: All commands are case insensitive\n");
                System.out.println("Playlists - Displays all created playlists.");
                System.out.println("ViewList - Displays all songs in a playlist");
                System.out.println("NewList - Create a new empty playlist");
                System.out.println("RemList - Delete an existing playlist");
                System.out.println("RenameList - Rename an existing playlist");
                System.out.println("AddSong - Add a song to an existing playlist");
                System.out.println("RemSong - Remove a song from an existing playlist");
                System.out.println("Shuffle - Shuffles the song order of a playlist");
                System.out.println("SortTitle - Orders the songs in a playlist by title");
                System.out.println("SortArtist - Orders the songs in a playlist by artist");
                System.out.println("SortDate - Orders the songs in a playlist by date added");
            }
            else if(input.equalsIgnoreCase("2")) // Describes the program's purpose
            {
                System.out.println("About: \nThis program allows the user to create playlists of songs and organize them.");
            }
            else if(input.equalsIgnoreCase("PLAYLISTS")) // Displays all playlists
            {
                organizer.printAllPlaylists();
            }
            else if(input.equalsIgnoreCase("VIEWLIST")) // Displays all songs of given playlist
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                try
                {
                    organizer.printPlaylistSongs(index);
                }
                catch (RuntimeException error) {System.out.println(error.getMessage());}
            }
            else if(input.equalsIgnoreCase("NEWLIST")) // Creates a new empty playlist
            {
                System.out.print("New playlist name: ");
                String name = scanner.nextLine();
                name = name.trim();

                try
                {
                    organizer.newPlaylist(name);
                    System.out.println("Playlist [" + name + "] created.");
                }
                catch (RuntimeException error) {System.out.println(error.getMessage());}
            }
            else if(input.equalsIgnoreCase("REMLIST")) // Deletes given playlist if exists
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                try
                {
                    organizer.remPlaylist(index);
                    System.out.println("Playlist [#" + index + "] has been removed.");
                }
                catch (RuntimeException error) {System.out.println(error.getMessage());}
            }
            else if (input.equalsIgnoreCase("RENAMELIST")) // Renames a selected playlist
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                System.out.print("New playlist name: ");
                String name = scanner.nextLine();
                name = name.trim();

                try
                {
                    organizer.renamePlaylist(index, name);
                    System.out.println("Playlist [#" + index + "] renamed.");
                }
                catch (RuntimeException error) {System.out.println(error.getMessage());}
            }
            else if (input.equalsIgnoreCase("ADDSONG")) // Adds a song to a selected playlist
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                System.out.print("Song title: ");
                String title = scanner.nextLine();
                title = title.trim();

                System.out.print("Song artist: ");
                String artist = scanner.nextLine();
                artist = artist.trim();

                try
                {
                    organizer.addPlaylistSong(index, title, artist);
                    System.out.println("Song [" + artist + " - " + title + "] has been added to playlist [#" + index + "].");
                }
                catch (RuntimeException e) {System.out.println(e.getMessage());}
            }
            else if (input.equalsIgnoreCase("REMSONG")) // Removes a song from a selected playlist
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                try {
                    organizer.printPlaylistSongs(index);
                    System.out.print("Song number: ");
                    String songIndex = scanner.nextLine();
                    songIndex = songIndex.trim();

                    Song removedSong = organizer.remPlaylistSong(index, songIndex);
                    System.out.print("Song [" + removedSong.getArtist() + " - " + removedSong.getTitle() + "] has been removed.");
                }
                catch (RuntimeException e) {System.out.println(e.getMessage());}
            }
            else if (input.equalsIgnoreCase("SHUFFLE")) // Shuffles the order of songs within a selected playlist
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                try
                {
                    organizer.shufflePlaylist(index);
                    System.out.println("Shuffled playlist [#" + index + "].\n");
                    organizer.printPlaylistSongs(index);
                }
                catch (RuntimeException e) {System.out.println(e.getMessage());}
            }
            else if (input.equalsIgnoreCase("SORTTITLE")) // Orders a playlist's songs by their titles (A-Z)
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                try
                {
                    organizer.sortPlaylistTitle(index);
                    System.out.println("Sorted playlist [#" + index + "].\n");
                    organizer.printPlaylistSongs(index);
                }
                catch (RuntimeException e) {System.out.println(e.getMessage());}
            }
            else if (input.equalsIgnoreCase("SORTARTIST")) // Orders a playlist's songs by their artist (A-Z)
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                try
                {
                    organizer.sortPlaylistArtist(index);
                    System.out.println("Sorted playlist [#" + index + "].\n");
                    organizer.printPlaylistSongs(index);
                }
                catch (RuntimeException e) {System.out.println(e.getMessage());}
            }
            else if (input.equalsIgnoreCase("SORTDATE")) // Orders a playlist's songs by their dates (first added - last added)
            {
                organizer.printAllPlaylists();
                System.out.print("Playlist number: ");
                String index = scanner.nextLine();
                index = index.trim();

                try
                {
                    organizer.sortPlaylistDate(index);
                    System.out.println("Sorted playlist [#" + index + "].\n");
                    organizer.printPlaylistSongs(index);
                }
                catch (RuntimeException e) {System.out.println(e.getMessage());}
            }
        }
    }
}
