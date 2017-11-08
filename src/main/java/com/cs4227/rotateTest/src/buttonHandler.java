import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class buttonHandler implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        CommandInterface CommandObj = (CommandInterface) e.getSource();
        try {
            CommandObj.processEvent();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}