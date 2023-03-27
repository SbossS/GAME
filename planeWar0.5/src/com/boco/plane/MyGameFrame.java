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
    static int count = 0;
    plane p1 = new plane(plane,200,200,2);
    plane p2 = new plane(plane,200,300,3);
    plane p3 = new plane(plane,200,400,4);
    @Override
    public void paint(Graphics g) { //g相当于一支画笔
        System.out.println("窗口绘制次数："+count);
        count++;
        g.drawImage(back,0,0,Constant.GAME_WITH,Constant.GAME_HITH,null);
        p1.drawMyself(g);
        p2.drawMyself(g);
        p3.drawMyself(g);

    }

    public void launchFrame(){
        this.setTitle("Plane War");
        setVisible(true);
        setSize(Constant.GAME_WITH,Constant.GAME_HITH);//窗口大小
        setLocation(0,0); //窗口打开的位置

        //增加关闭窗口动作
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new paintThread().start();
    }
    /*
    * 定义一个重画窗口的线程类
    * 定义成内部类是为了使用窗口类的相关方法
    * */
    class paintThread extends Thread{
        public void run(){
            while(true){
                repaint(); //内部类可以直接使用外部类的成员
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WITH,Constant.GAME_HITH);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        MyGameFrame m = new MyGameFrame();
        m.launchFrame();
    }
}
