package boco.plane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
* 游戏主窗口
* */
public class MyGameFrame extends Frame{

    public void launchFrame(){
        this.setTitle("Plane War");
        setVisible(true);
        setSize(500,500);//窗口大小
        setLocation(300,200); //窗口打开的位置

        //增加关闭窗口动作
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        MyGameFrame m = new MyGameFrame();
        m.launchFrame();
    }
}
