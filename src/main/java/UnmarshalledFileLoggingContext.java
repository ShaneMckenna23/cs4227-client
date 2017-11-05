import java.awt.*;

public class UnmarshalledFileLoggingContext implements UnmarshalledBaseContext {

    private long startTime;
    private String fileName;
    private String directory;
    private String method;
    private boolean outcome;
    private long time;


    @Override
    public String getDirectory() {
        return directory;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public long getStartTime() {
        return time;
    }

    @Override
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public void setStartTime(long time) {
        this.time = time;
    }
}
