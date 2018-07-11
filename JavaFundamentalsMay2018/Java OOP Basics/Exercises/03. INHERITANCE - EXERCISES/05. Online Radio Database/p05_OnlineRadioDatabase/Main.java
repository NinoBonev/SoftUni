package p05_OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 23.6.2018 г., 13:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Song> songs = new ArrayList<>();


        int songNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < songNumber; i++) {
            try {
                String[] songInfo = scanner.nextLine().split(";");
                String artistName = songInfo[0];
                String songName = songInfo[1];
                int songMinutes = Integer.parseInt(songInfo[2].split(":")[0]);
                int songSeconds = Integer.parseInt(songInfo[2].split(":")[1]);
                Song song = new Song(artistName, songName, songMinutes, songSeconds);
                songs.add(song);
                System.out.println("Song added.");
            } catch (IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", songs.size());
        int totalPlaylistTime = 0;
        for (Song song:
             songs) {
            totalPlaylistTime += song.getSongLength();
        }

        System.out.println(playlistTime(totalPlaylistTime));
    }

    private static String playlistTime(int seconds){
        int hours = 0;
        if (seconds > 3600) {
            hours = seconds % 3600;
        }
        int minutes = 0;
        if (seconds - (hours * 3600) > 60){
            minutes = (seconds - (hours * 3600)) / 60;
        }
        int sec = seconds % 60;
        return String.format("Playlist length: %dh %dm %ds", hours, minutes, sec);
    }
}
