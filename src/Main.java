import com.dropbox.core.DbxException;

public class Main {
    public static void main(String[] args) {

        MyThread screen = new MyThread();
        screen.run();

        try {
        ConfigurationClient dropClient = new ConfigurationClient();
        dropClient.client();
        } catch (DbxException e) {
            e.printStackTrace();
        }
    }
}
