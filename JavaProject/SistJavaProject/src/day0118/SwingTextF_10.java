package day0118;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class SwingTextF_10 extends JFrame {

//2개의 텍스트필드에 숫자를 넣고 버튼을 만든후 클릭하면 라벨에 출력 2+3=5 <<

    Container cp;
    JTextField tf1,tf2;
    JButton btnAdd;
    JButton btnMinus;
    JButton btnMultiple;
    JButton btnDivide;
    JLabel lbl1,lbl2,lblResult;



    public SwingTextF_10() {
        super("텍스트필드 문제");

        cp = this.getContentPane();

        this.setBounds(300, 100, 500, 300);
        cp.setBackground(new Color(255, 204, 204));

        setDesign();
        this.setVisible(true);
    }
    public void setDesign() {
        this.setLayout(null);
        lbl1 = new JLabel("숫자1");
        lbl2 = new JLabel("숫자2");

        lbl1.setBounds(20, 20, 50, 30);
        this.add(lbl1);

        lbl2.setBounds(20, 60, 50, 30);
        this.add(lbl2);

        tf1 = new JTextField();
        tf1.setBounds(80, 20, 60, 30);

        tf2 = new JTextField();
        tf2.setBounds(80, 60, 60, 30);

        this.add(tf1);
        this.add(tf2);

        btnAdd = new JButton("숫자 더하기");
        btnAdd.setBounds(40, 110, 100, 40);

        this.add(btnAdd);

        btnMinus = new JButton("숫자 빼기");
        btnMinus.setBounds(140, 110, 100, 40);

        this.add(btnMinus);

        btnMultiple = new JButton("숫자 곱하기");
        btnMultiple.setBounds(240, 110, 100, 40);

        this.add(btnMultiple);

        btnDivide = new JButton("숫자 나누기");
        btnDivide.setBounds(340, 110, 100, 40);

        this.add(btnDivide);



        lblResult = new JLabel("결과 나오는곳...");
        lblResult.setBounds(20, 170, 250, 60);

//        lblResult.setBorder(new LineBorder(Color.RED));
        lblResult.setBorder(new TitledBorder("결과 확인"));
        lblResult.setFont(new FontUIResource("",Font.BOLD,25));
        this.add(lblResult);

        //익명내부클래스
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(tf1.getText().trim());
                int b = Integer.parseInt(tf2.getText().trim());

                int sum = a+b;
                String result = a+"+"+b+"="+sum;
                /*lblResult.setText(String.valueOf(a)+"+"+String.valueOf(b)
                        +"="+Integer.toString(sum));
                */
                lblResult.setText(result);
            }
        });
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(tf1.getText().trim());
                int b = Integer.parseInt(tf2.getText().trim());

                int sum = a-b;
                String result = a+"-"+b+"="+sum;
                /*lblResult.setText(String.valueOf(a)+"+"+String.valueOf(b)
                        +"="+Integer.toString(sum));
                */
                lblResult.setText(result);
            }
        });
        btnMultiple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(tf1.getText().trim());
                int b = Integer.parseInt(tf2.getText().trim());

                int sum = a*b;
                String result = a+"*"+b+"="+sum;
                /*lblResult.setText(String.valueOf(a)+"+"+String.valueOf(b)
                        +"="+Integer.toString(sum));
                */
                lblResult.setText(result);
            }
        });
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(tf1.getText().trim());
                int b = Integer.parseInt(tf2.getText().trim());

                DecimalFormat df = new DecimalFormat("#.###");


                double sum = (double)a/b;
                String result = a+"/"+b+"="+df.format(sum);
                /*lblResult.setText(String.valueOf(a)+"+"+String.valueOf(b)
                        +"="+Integer.toString(sum));
                */
                lblResult.setText(result);
            }
        });




    }

    public static void main(String[] args) {
        new SwingTextF_10();

    }

}
