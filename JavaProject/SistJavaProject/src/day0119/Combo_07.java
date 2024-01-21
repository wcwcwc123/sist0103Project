package day0119;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Combo_07 extends JFrame implements ActionListener, ItemListener {

    JComboBox<String> comboBox;
    String[] names = {"박모씨", "김모씨", "최모씨", "이모씨"};
    JTextField tfName;
    JButton btnAdd,btnDel;
    JLabel lblResult;

    int idx = -1; //멤버변수는 0을 자동초기화 되는데 0번 삭제를 막기위해서



    public Combo_07(String title) {
        super(title);

        this.setBounds(300, 100, 600, 600);
        this.getContentPane().setBackground(new Color(255, 204, 204));

        initDesign();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    public void initDesign() {
        this.setLayout(null);

        comboBox = new JComboBox<String>(names);
        comboBox.setBounds(30, 30, 100, 30);
        this.add(comboBox);

        tfName = new JTextField();
        tfName.setBounds(30, 90, 80, 30);
        this.add(tfName);

        btnAdd = new JButton("추가");
        btnAdd.setBounds(150, 90, 80, 30);
        this.add(btnAdd);

        btnDel = new JButton("삭제");
        btnDel.setBounds(250, 90, 80, 30);
        this.add(btnDel);

        lblResult = new JLabel("Result", JLabel.CENTER);
        lblResult.setBorder(new LineBorder(Color.pink, 8));
        lblResult.setBounds(20, 200, 350, 60);
        this.add(lblResult);

        //이벤트
        comboBox.addItemListener(this);
        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);

    }

    public static void main(String[] args) {
        new Combo_07("today final quiz");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object ob = e.getSource();

        if (ob == btnAdd) {
            //입력한 이름을 읽어옴
            String text = tfName.getText().trim();

            if (text.length() == 0) {
                JOptionPane.showMessageDialog(this, "이름을 입력후 추가버튼 눌러주세요");
            } else {
                comboBox.addItem(text); //콤보에 추가
                tfName.setText("");
            }
        } else if (ob == btnDel) {
            if (idx == -1) {
                JOptionPane.showMessageDialog(this, "삭제할 항목을 선택후 삭제해주세요");
            } else {
                comboBox.removeItemAt(idx);
                lblResult.setText("해당 항목을 삭제했습니다");
                idx=-1;
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        idx = comboBox.getSelectedIndex();
        String item=(String)comboBox.getSelectedItem();

        lblResult.setText(idx + "번 인덱스의 " + item + " 선택됨!!!");

    }
}
