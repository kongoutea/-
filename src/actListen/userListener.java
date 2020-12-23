package actListen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userListener implements ActionListener {
    //用户界面监听器
    public userListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonName = e.getActionCommand();
        if(buttonName.equals("退出")) {
            System.exit(0);
        }
        else if(buttonName.equals("查询成绩")) {

        }
        else if(buttonName.equals("修改密码")) {

        }
        else if(buttonName.equals("")) {

        }
    }
}
