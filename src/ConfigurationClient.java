import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigurationClient {
    String ACCESS_TOKEN = "tPq1exC2h5AAAAAAAAAAMU-nBVN_yx8ddMK4MCh8nBBsyCqVApnqBoL-hq7rM6dn";
    DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
    DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

    public void client() throws DbxException {
        try {
        ByteArrayOutputStream imageBytes = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(imageBytes.toByteArray());
                    FileMetadata metadata = client
                    .files()
                    .uploadBuilder("/" + dateFormat.format(new Date()) + ".png")
                    .uploadAndFinish(in);
        } catch (IOException e) { //почему ловит не DbxException, а все?
            e.printStackTrace();
        }
    }
}
