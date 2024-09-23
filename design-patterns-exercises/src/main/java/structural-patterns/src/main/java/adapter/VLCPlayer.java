package adapter;

public class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}