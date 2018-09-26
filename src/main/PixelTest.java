package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
public class PixelTest {


    private JFrame window;
    //objekt pro zapisovani pixelu
    private BufferedImage img;
    private JPanel panel;


    public PixelTest(){
        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setTitle("PRGF1 cv");

        img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paintComponents(g);
                    g.drawImage(img,0, 0,null);
            }
        };
                window.add(panel);

        window.setVisible(true);
        drawPixel(100, 50, Color.GREEN.getRGB());

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPixel(e.getX(), e.getY(), Color.YELLOW.getRGB());
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                drawPixel(e.getX(), e.getY(), Color.YELLOW.getRGB());
            }
        });
        }




    private void drawPixel(int x, int y, int color){
        img.setRGB(x, y, color);
        panel.getGraphics().drawImage(img, 0,0, null);

    }
    public static void main(String[] args) {
        new PixelTest();

    }
}
