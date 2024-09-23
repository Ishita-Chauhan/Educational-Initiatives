package adapter;

public class AudioPlayer implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new AdvancedMediaPlayerAdapter(audioType);
            advancedMediaPlayer.play(fileName); // Change this line to only pass fileName
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }

}
