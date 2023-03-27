package com.boco.plane;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.stream.IntStream;

/*
* 游戏主窗口
* */
public class MyGameFrame extends Frame{

    Image plane = GameUtil.getImages("images/J20.jpg");
    Image back = GameUtil.getImages("images/space.jpg");
//    static int count = 0;
    Plane p1 = new Plane(plane,500,600,17);

    Shell[] shells = new Shell[5];
    Date start = new Date();
    Date end;
    Long period = 0L;
    @Override
    public void paint(Graphics g) { //g相当于一支画笔
//        System.out.println("窗口绘制次数："+count);
//        count++;
        g.drawImage(back,0,0,Constant.GAME_WITH,Constant.GAME_HITH,null);
        //调用计时器
        drawTime(g);
        p1.drawMyself(g);
//        p2.drawMyself(g);
//        p3.drawMyself(g);
//        s1.drawMyself(g);
//        s2.drawMyself(g);
//        s3.drawMyself(g);
        for (int i=0;i<shells.length;i++) {
            shells[i].drawMyself(g);
            boolean peng = shells[i].getRec().intersects(p1.getRec());
            if(peng){
                p1.live=false;
            }

        }


    }

    public void drawTime(Graphics g){
        Color c = g.getColor();
        Font f = g.getFont();
        g.setColor(Color.green);
        if(p1.live){
            period = (System.currentTimeMillis()-start.getTime())/1000;
            g.drawString("计时：" + period,30,50);
        }else{
            if(end == null){
                end = new Date();
                period = (end.getTime()-start.getTime())/1000;

            }
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑",Font.BOLD,30));
            g.drawString("GAME OVER!",400,400);

        }
        g.setColor(c);
        g.setFont(f);
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
        this.addKeyListener(new keyMonitor());
        IntStream.range(0, shells.length).forEach(i -> shells[i] = new Shell());


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

    //内部类，实现键盘的监听处理
    class keyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("按下"+e.getKeyCode());
                p1.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
//            System.out.println("抬起"+e.getKeyCode());
            p1.minusDirection(e);

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
