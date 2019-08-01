import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import static java.awt.event.KeyEvent.VK_ESCAPE;

public class MyThread extends Thread {

    public void run()
    {
        for (;;)
        {
            try {
               BufferedImage Image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
               ByteArrayOutputStream imageBytes = new ByteArrayOutputStream();
               ImageIO.write(Image, "PNG", imageBytes);
               sleep(5000);

               if (System.in.available() == VK_ESCAPE) {
                    System.out.println("I'm quitting! Bye!");
                    break;
               }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
