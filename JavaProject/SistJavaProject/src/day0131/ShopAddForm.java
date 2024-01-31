package day0131;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopAddForm extends JFrame {

    JTextField tfSang,tfSu,tfDan;
    JLabel lblPhoto;
    String imageName;
    JButton btnImage,btnInsert;

    //db모델생성
    ShopDbModel model = new ShopDbModel();
    //내부클래스 선언
    PhotoDraw photoDraw = new PhotoDraw();

    public ShopAddForm() {
        super("상품 추가폼");
        this.setBounds(600, 0, 900, 900);
        initDesign();
        this.setVisible(true);

    }

    public void initDesign() {

        this.setLayout(null);

        JLabel lbl1 = new JLabel("상품명");
        lbl1.setBounds(30, 10, 60, 30);
        this.add(lbl1);

        tfSang = new JTextField();
        tfSang.setBounds(110, 10, 100, 30);
        this.add(tfSang);

        JLabel lbl2 = new JLabel("사진선택");
        lbl2.setBounds(30, 60, 60, 30);
        this.add(lbl2);

        btnImage = new JButton("사진 선택");
        btnImage.setBounds(110, 60, 100, 30);
        this.add(btnImage);

        //이미지
        photoDraw.setBounds(250, 10, 300, 300);
        this.add(photoDraw);

        //이미지명
        lblPhoto = new JLabel("이미지명");
        lblPhoto.setBorder(new LineBorder(Color.pink));
        lblPhoto.setBounds(20, 120, 300, 30);
        this.add(lblPhoto);

        //수량
        JLabel lbl3 = new JLabel("수량");
        lbl3.setBounds(30, 150, 50, 30);
        this.add(lbl3);

        tfSu = new JTextField();
        tfSu.setBounds(110, 150, 50, 30);
        this.add(tfSu);

        //단가
        JLabel lbl4 = new JLabel("단가");
        lbl4.setBounds(30, 190, 50, 30);
        this.add(lbl4);

        tfDan = new JTextField();
        tfDan.setBounds(110, 190, 50, 30);
        this.add(tfDan);

        //db추가버튼
        btnInsert = new JButton("DB추가");
        btnInsert.setBounds(110, 240, 100, 30);
        this.add(btnInsert);


        btnImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(ShopAddForm.this, "이미지 가져오기",FileDialog.LOAD);
                dlg.setVisible(true);

                //취소 누르면 메서드 종료
                if (dlg.getDirectory() == null) {
                    return;
                }
                //이미지명 얻기
                imageName = dlg.getDirectory()+dlg.getFile();

                //라벨에 이미지명 출력
                lblPhoto.setText(imageName);

                //이미지출력
                photoDraw.repaint();
            }
        });

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //ShopDto생성
                ShopDto dto = new ShopDto();

                //dto에 4개의 데이터를 넣는다
                dto.setSangpum(tfSang.getText());
                dto.setPhoto(imageName);
                dto.setDan(Integer.parseInt(tfSu.getText()));
                dto.setSu(Integer.parseInt(tfSu.getText()));

                //db모델에서 insert호출
                model.insertShop(dto);


                //현재창 닫기
                ShopAddForm.this.setVisible(false);

            }
        });
    }

    //내부클래스..이미지 삽입을 위하여
    class PhotoDraw extends Canvas {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            if (imageName != null) {
                Image image = new ImageIcon(imageName).getImage();
                g.drawImage(image,10,10,300,300,this);
            }
        }
    }


    public static void main(String[] args) {
        new ShopAddForm();

    }
}
