// Custom exception classes for PlaylistGenerator

class UnknownSongException extends  RuntimeException
{
    public UnknownSongException() {}

    public UnknownSongException(String message) {super (message);}
}

class UnknownPlaylistException extends RuntimeException
{
    public UnknownPlaylistException() {}

    public UnknownPlaylistException(String message) {super (message);}
}

class EmptyPlaylistException extends RuntimeException
{
    public EmptyPlaylistException() {}

    public EmptyPlaylistException(String message) {super (message);}
}

class DuplicatePlaylistException extends RuntimeException
{
    public DuplicatePlaylistException() {}

    public DuplicatePlaylistException(String message) {super (message);}
}

class InvalidSongTitleException extends RuntimeException
{
    public InvalidSongTitleException() {}

    public InvalidSongTitleException(String message) {super (message);}
}

class InvalidSongArtistException extends RuntimeException
{
    public InvalidSongArtistException() {}

    public InvalidSongArtistException(String message) {super (message);}
}

class InvalidPlaylistNameException extends RuntimeException
{
    public InvalidPlaylistNameException() {}

    public InvalidPlaylistNameException(String message) {super (message);}
}