package day0118;

import javax.swing.*;
import java.awt.*;

public class SwingStart extends JFrame {

    Container cp;

    public SwingStart(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 540, 480);
        cp.setBackground(new Color(0xff0066));
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new SwingStart("스윙기본2");
    }
}
