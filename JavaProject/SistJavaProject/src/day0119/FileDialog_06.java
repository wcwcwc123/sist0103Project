package day0119;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileDialog_06 extends JFrame {

    Container cp;
    JButton btnOpen;
    JButton btnSave;
    JTextArea area;

    public FileDialog_06(String title) {
        super(title);

        cp = this.getContentPane();
        this.setBounds(300, 100, 400, 500);
        cp.setBackground(new Color(255, 204, 204));

        initDesign();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initDesign() {
        this.setLayout(null);

        btnOpen = new JButton("파일불러오기");
        btnOpen.setBounds(40, 20, 120, 30);
        this.add(btnOpen);

        //불러오기 이벤트
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(FileDialog_06.this, "파일열기", FileDialog.LOAD);
                dlg.setVisible(true);

                //선택한 디렉토리
                String dir=dlg.getDirectory();
                //선택한 파일명
                String file = dlg.getFile();
                if (dir == null) {
                    return;
                }
                System.out.println(dir);
                System.out.println(file);

                FileReader fr = null;
                BufferedReader br = null;

                try {
                    fr = new FileReader(dir + file);
                    br = new BufferedReader(fr);

                    //기존데이터 삭제후 불러오기
                    area.setText("");
                    while (true) {
                        String s = br.readLine();

                        if (s == null) {
                            break;
                        }

                        //읽은 데이터를 area에 출력
                        area.append(s + "\n");
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }finally {
                        try {
                            br.close();
                            fr.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                }


            }
        });


        btnSave = new JButton("파일저장");
        btnSave.setBounds(200, 20, 120, 30);
        this.add(btnSave);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg =
                        new FileDialog(FileDialog_06.this, "파일저장", FileDialog.SAVE);
                dlg.setVisible(true);

                String dir = dlg.getDirectory();
                String file = dlg.getFile();

                if (dir == null) {
                    return;
                }

                //파일저장
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir + file);

                    //area의 내용을 가져와서 파일에 저장
                    fw.write(area.getText() + "\n");

                    //저장메세지
                    area.setText(file + " 파일로 저장됨");
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        //출력영역
        area = new JTextArea();
        area.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        JScrollPane js = new JScrollPane(area);
        js.setBounds(20,70,360,300);
        this.add(js);
    }

    public static void main(String[] args) {
        new FileDialog_06("file dialog6");
    }
}
