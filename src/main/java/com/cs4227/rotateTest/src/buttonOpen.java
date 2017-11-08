import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

class buttonOpen extends JButton implements CommandInterface {

    public void processEvent() throws IOException {

        JFrame frame = new imageOpener();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
       // frame.setSize(450, 300); // get image size and scale it
        frame.setVisible(true);
    }

    public buttonOpen(String name) {
        super(name);
    }
}