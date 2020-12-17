package actListen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String buttonName = e.getActionCommand();
        if(buttonName.equals("退出")) {

        }
    }
}
