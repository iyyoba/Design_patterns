import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static final Logger instance = new Logger();

    private BufferedWriter writer;
    private String fileName = "default_log.txt";

    private Logger() {
        openFile(fileName);
    }

    public static Logger getInstance() {
        return instance;
    }

    private void openFile(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Failed to open log file: " + fileName);
            e.printStackTrace();
        }
    }

    public synchronized void setFileName(String newFileName) {
        close();
        this.fileName = newFileName;
        openFile(newFileName);
    }

    public synchronized void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Failed to write to log file");
            e.printStackTrace();
        }
    }

    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
                writer = null;
            }
        } catch (IOException e) {
            System.err.println("Failed to close log file");
            e.printStackTrace();
        }
    }
}
