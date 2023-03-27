package com.boco.plane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
* 游戏主窗口
* */
public class MyGameFrame extends Frame{

    Image plane = GameUtil.getImages("images/J20.jpg");
    Image back = GameUtil.getImages("images/space.jpg");

    @Override
    public void paint(Graphics g) { //g相当于一支画笔
        g.drawImage(back,0,0,600,600,null);
        g.drawImage(plane,200,300,40,50,null);
    }

    public void launchFrame(){
        this.setTitle("Plane War");
        setVisible(true);
        setSize(600,600);//窗口大小
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
