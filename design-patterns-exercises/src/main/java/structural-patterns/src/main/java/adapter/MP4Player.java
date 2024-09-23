package adapter;

public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}
