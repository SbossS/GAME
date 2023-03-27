package boco.plane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
* 游戏主窗口
* */
public class MyGameFrame extends Frame{

    @Override
    public void paint(Graphics g) { //g相当于一支画笔

        Color c = g.getColor();//保存原始颜色
        //设置颜色
       // g.setColor(Color.red);
        g.setColor(new Color(255,0,255));


        //画直线
        g.drawLine(100,100,400,300);
        //画矩形
        g.drawRect(100,100,300,200);
        //画椭圆
        g.drawOval(100,100,300,200);
        //画字符串
        g.drawString("boco.com.cn",300,300);

        g.setColor(c);//恢复原来的颜色
    }

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
