package day0119;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Quiz extends JFrame implements ActionListener {

    Container cp;

    JCheckBox genderCheck;
    JRadioButton[] radioButtons = new JRadioButton[3]; // 색상
    JCheckBox[] checkBoxes = new JCheckBox[4];  //나라
    Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW};
    JLabel lblMessage;
    JLabel lblMessage2;
    JPanel lbl1;

    public void initDesign() {

        JPanel g = new JPanel();
        g.setBorder(new LineBorder(Color.GRAY));
        genderCheck = new JCheckBox("남자");
        g.add(genderCheck);
        genderCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (genderCheck.isSelected()) {
                    lblMessage.setText("남자입니다");
                } else {
                    lblMessage.setText("여자입니다");
                }

            }
        });
        //상단패널 보더로 감싼 4개의 라디오 버튼
        String[] str1 = {"빨강", "초록", "노랑색"};
        JPanel pTop = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setBorder(new TitledBorder("색상"));
        pTop.add("Center", p1);
        pTop.add("North", g);

        this.add("North",pTop);

        //라디오버튼 하나만 선택되도록 하려면 그룹을 지어줘야함
        ButtonGroup bg = new ButtonGroup();

        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton(str1[i]); //라디오버튼새성(텍스트,기본체크)
            radioButtons[i].addActionListener(this);

            bg.add(radioButtons[i]);
            p1.add(radioButtons[i]);
        }

        JPanel pBottom = new JPanel();
        pBottom.setBorder(new TitledBorder("내가 가본 나라"));
        pTop.add("South",pBottom);

        String[] str2 = {"일본", "이탈리아", "미국", "싱가폴"};
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox(str2[i]);
            checkBoxes[i].addActionListener(this);
            pBottom.add(checkBoxes[i]);
        }

        //가운데 라벨
        lblMessage = new JLabel("여자입니다",JLabel.CENTER);
        lblMessage2 = new JLabel("내가 가본 나라는 없습니다", JLabel.CENTER);
        lbl1 = new JPanel(new GridLayout(2,1));
        lbl1.add(lblMessage);
        lbl1.add(lblMessage2);
        this.add("Center",lbl1);
        lblMessage.setBorder(new EmptyBorder(1,1,1,1)); // 라인굵기


    }

    public Quiz(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 500, 400);
        this.setBackground(new Color(255, 204, 204));

        initDesign();
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new Quiz("0119 Quiz");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();


        //라디오버튼 호출처리, 메세지 출력이 컬러별로 출력되도록
        for (int i = 0; i < radioButtons.length; i++) {
            if (ob == radioButtons[i]) {
                lbl1.setBackground(colors[i]);
                //JOptionPane.showMessageDialog(cp,radioButtons.getClass());
                //lblMessage.setForeground(Color.BLACK);
                //lblMessage.setFont(new Font("",Font.BOLD,22));
                //lblMessage.setText("radio");
                //return;

            }
        }

        String msg = "";
        String out = "내가 가본 나라는 ";
        int count =0;

        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                msg += checkBoxes[i].getText() + " ";
                count++;
            }
        }
        if (count == 0) {
            lblMessage2.setText("내가 가본 나라는 없습니다");
        } else {
            String[] trip = msg.split(" ");
            for (int i = 0; i < count; i++) {
                out += "["+trip[i]+"]";
            }
            out += " 입니다";
            lblMessage2.setText(out);
        }
    }
}
