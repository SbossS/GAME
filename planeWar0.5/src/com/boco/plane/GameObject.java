package com.boco.plane;

import java.awt.*;

public class GameObject{
    Image img;  //物体图片
    double x,y;  //物体坐标
    int speed;   //物体的移动速度
    int width,height;   //物体的宽度和长度

    public GameObject() {
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y, int speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    public void drawMyself(Graphics g){
        g.drawImage(img,(int)x,(int)y,width,height,null);
    }
    //所有的物体都是矩形，获得对应的矩形，做一些判断
    public Rectangle getRec(){
        return new Rectangle((int)x,(int)y,width,height);
    };
}
