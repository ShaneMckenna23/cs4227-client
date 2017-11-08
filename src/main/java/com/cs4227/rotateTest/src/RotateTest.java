import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class RotateTest {
    public static boolean isToolsOpen, isAdjustmentsOpen, isImageOpen;
    public static JFrame aFrame, iFrame, mFrame;

    public static int height, width;

    public static void main(String[] args) throws Exception {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//centre of users screen
        //this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        File file = new File("./images/imageDefault.JPG");
        BufferedImage selectedImage = ImageIO.read(file);

        iFrame = new GUIImageViewer(selectedImage, 600, 600);//passing in default image
        //frame.pack();
        iFrame.setSize(620, 620);
        isImageOpen = true;

        iFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                isImageOpen = false;
            }});
        iFrame.setLocation(dim.width/2-iFrame.getSize().width/2, dim.height/2-iFrame.getSize().height/2);
        iFrame.setVisible(true);

        mFrame = new GUIMain();
        mFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //frame.pack();
        mFrame.setSize(600, 80);
        mFrame.setLocation((dim.width/2-mFrame.getSize().width/2), (dim.height/2-iFrame.getSize().height/2) - mFrame.getSize().height);
        mFrame.setVisible(true);

        aFrame = new GUIAdjustments();
        isAdjustmentsOpen = true;

        aFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                isAdjustmentsOpen = false;
            }});

        //frame.pack();
        aFrame.setSize(260, 300);
        aFrame.setLocation(dim.width/2+iFrame.getSize().width/2, dim.height/2-iFrame.getSize().height/2);
        aFrame.setVisible(true);
    }



    public static void refreshImage (BufferedImage image, int w, int h) throws Exception{
        iFrame.dispose();
        mFrame.dispose();
        aFrame.dispose();

        width = w;
        height = h;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//centre of users screen

        iFrame = new GUIImageViewer(image, width, height);
        iFrame.setSize(width, height);
        isImageOpen = true;

        iFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                isImageOpen = false;
            }});
        iFrame.setLocation(dim.width/2-iFrame.getSize().width/2, dim.height/2-iFrame.getSize().height/2);
        iFrame.setVisible(true);

        ///////////////////////////////////////////////////////////////////////////////////
        mFrame = new GUIMain();
        mFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //frame.pack();
        mFrame.setSize(600, 80);
        mFrame.setLocation((dim.width/2-mFrame.getSize().width/2), (dim.height/2-iFrame.getSize().height/2) - mFrame.getSize().height);
        mFrame.setVisible(true);

        aFrame = new GUIAdjustments();
        isAdjustmentsOpen = true;

        aFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                isAdjustmentsOpen = false;
            }});

        //frame.pack();
        aFrame.setSize(260, 300);
        aFrame.setLocation(dim.width/2+iFrame.getSize().width/2, dim.height/2-iFrame.getSize().height/2);
        aFrame.setVisible(true);
    }


    public static boolean isToolsOpened(){
        return isToolsOpen;
    }
    public static boolean isAdjustmentsOpened(){
        return isAdjustmentsOpen;
    }
    public static boolean isImageOpened(){
        return isImageOpen;
    }


    public int getImageWidth() {
        return width;
    }

    public int getImageHeight() {
        return height;
    }

    public static void setImageWidth(int value) {
        width = value;
    }

    public static void setImageHeight(int value) {
        height = value;
    }
}
