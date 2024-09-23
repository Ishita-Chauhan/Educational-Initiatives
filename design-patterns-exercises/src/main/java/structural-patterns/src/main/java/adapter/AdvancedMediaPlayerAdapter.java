package adapter;

public class AdvancedMediaPlayerAdapter implements AdvancedMediaPlayer {
    private AdvancedMediaPlayer player;

    public AdvancedMediaPlayerAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            player = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            player = new MP4Player();
        }
    }

    @Override
    public void play(String fileName) {
        player.play(fileName);
    }
}
