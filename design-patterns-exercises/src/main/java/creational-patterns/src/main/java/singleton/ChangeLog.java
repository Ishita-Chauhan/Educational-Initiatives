package singleton;

import java.util.ArrayList;
import java.util.List;

public class ChangeLog {
    private List<String> logEntries;

    public ChangeLog() {
        logEntries = new ArrayList<>();
    }

    public void addEntry(String entry) {
        logEntries.add(entry);
    }

    public List<String> getEntries() {
        return logEntries;
    }
}
