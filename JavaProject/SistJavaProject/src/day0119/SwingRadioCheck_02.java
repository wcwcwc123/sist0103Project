package day0119;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingRadioCheck_02 extends JFrame implements ActionListener {

    Container cp;
    JRadioButton[] radioButtons = new JRadioButton[4];
    JCheckBox[] checkBoxes = new JCheckBox[4];
    Color[] colors = {Color.RED, Color.GREEN, Color.YELLOW, Color.CYAN};
    JLabel lblMessage;

    public void initDesign() {

        //상단패널 보더로 감싼 4개의 라디오 버튼
        String[] str1 = {"빨강", "초록", "노랑색", "연파랑"};
        JPanel pTop = new JPanel();
        pTop.setBorder(new TitledBorder("글자색"));

        this.add("North",pTop);

        //라디오버튼 하나만 선택되도록 하려면 그룹을 지어줘야함
        ButtonGroup bg = new ButtonGroup();

        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton(str1[i],i==1?true:false); //라디오버튼새성(텍스트,기본체크)
            radioButtons[i].addActionListener(this);

            bg.add(radioButtons[i]);
            pTop.add(radioButtons[i]);
        }

        //가운데 라벨
        lblMessage = new JLabel("안녕하세요~~즐거운 금요일",JLabel.CENTER);
        this.add("Center",lblMessage);
        lblMessage.setBorder(new LineBorder(Color.RED, 2)); // 라인굵기

        //하단패널에 보더로 감싼 4개의 체크박스 만들기
        JPanel pBottom = new JPanel();
        pBottom.setBorder(new TitledBorder("가능 언어"));
        this.add("South",pBottom);

        String[] str2 = {"자바", "오라클", "HTML", "JSP"};
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox(str2[i]);
            checkBoxes[i].addActionListener(this);
            pBottom.add(checkBoxes[i]);
        }
    }

    public SwingRadioCheck_02(String title) {
        super(title);

        cp = this.getContentPane();

        this.setBounds(300, 100, 500, 400);
        this.setBackground(new Color(255, 204, 204));

        initDesign();
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new SwingRadioCheck_02("swing2");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();

        //라디오버튼 호출처리, 메세지 출력이 컬러별로 출력되도록
        for (int i = 0; i < checkBoxes.length; i++) {
            if (ob == radioButtons[i]) {
                cp.setBackground(colors[i]);
                //JOptionPane.showMessageDialog(cp,radioButtons.getClass());
                lblMessage.setForeground(Color.BLACK);
                lblMessage.setFont(new Font("",Font.BOLD,22));
                //lblMessage.setText("radio");
                return;

            }
        }

        String msg = "";

        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                msg += checkBoxes[i].getText() + " ";
            }
        }

        lblMessage.setText(msg);
    }
}
