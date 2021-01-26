package com.example.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CheckCodeUtil {
    //生成验证码
    private static int width = 90;//定义图片width
    private static int height = 20;//定义图片height
    private static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'a', 'b', 'c', 'd', 'e', 'f', 'g', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static Map<String, Object> create() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.CYAN);
        graphics.fillRect(0, 0, width, height);
        Random r = new Random();
        graphics.setColor(Color.PINK);
        graphics.drawRect(0, 0, width - 1, height - 1);
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 6; i++) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            graphics.drawLine(x, y, x1, y1);
        }
        StringBuffer code = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            char c = codeSequence[r.nextInt(codeSequence.length)];
            graphics.setColor(Color.BLACK);
            graphics.drawString(String.valueOf(c), i * 15, 16);
            code.append(c);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("image", image);
        map.put("code", code);
        return map;

    }
}