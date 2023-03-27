package com.boco.plane;

import java.awt.*;

/*
* 炮弹类
* */
public class Shell extends GameObject{
    double degree;  //炮弹任意角度

    public Shell() {
        this.x = 300;
        this.y = 300;
        this.width = 10;
        this.height = 10;
        this.speed = 7;
        this.degree = Math.random()*Math.PI*2;
    }

    public Shell(double x, double y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.degree = Math.random()*Math.PI*2;
    }

    @Override
    public void drawMyself(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int)x,(int)y,width,height);
        g.setColor(c);
        //根据自己的算法改变移动路径
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);
        //碰到边界返回
        if(y>Constant.GAME_HITH-this.height || y<40){
            degree = -degree;
        }
        if(x<0 || x>Constant.GAME_WITH-this.width){
            degree = Math.PI-degree;
        }

    }
}
