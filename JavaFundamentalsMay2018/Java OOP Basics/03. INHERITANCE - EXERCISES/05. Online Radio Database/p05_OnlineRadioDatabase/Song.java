package p05_OnlineRadioDatabase;

/**
 * Created by Nino Bonev - 23.6.2018 г., 14:13
 */
public class Song {
    private String artistName;
    private String songName;
    private int songMinutes;
    private int songSeconds;
    private int songLength;

    public Song(String artistName, String songName, int songMinutes, int songSeconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setSongMinutes(songMinutes);
        this.setSongSeconds(songSeconds);
        this.setSongLength();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20){
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 30){
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    public int getSongMinutes() {
        return songMinutes;
    }

    public void setSongMinutes(int songMinutes) {
        if (songMinutes < 0 || songMinutes > 14){
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }
        this.songMinutes = songMinutes;
    }

    public int getSongSeconds() {
        return songSeconds;
    }

    public void setSongSeconds(int songSeconds) {
        if (songSeconds < 0 || songSeconds > 59){
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }
        this.songSeconds = songSeconds;
    }

    public int getSongLength() {
        return songLength;
    }

    public void setSongLength() {
        this.songLength = songMinutes * 60 + songSeconds;
    }
}
