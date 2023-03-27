package com.boco.plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 游戏里的工具类
 */

public class GameUtil{
    private GameUtil(){};//构造器私有，防止别人创建本类对象

    public static Image getImages(String path){
        BufferedImage img = null;
        URL u = GameUtil.class.getClassLoader().getResource(path);
        try {
            img = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static void main(String[] args) {
        Image g = GameUtil.getImages("images/J20.jpg");
        System.out.println(g);
    }
}
