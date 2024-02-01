package kiosk;

import day0131.ShopDbModel;
import day0131.ShopDto;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductAddForm extends JFrame {

    JTextField tfName,tfPrice;

    JComboBox<String> menuType;
    JLabel lblPhoto;

    String imageName;  //이미지 명
    JButton btnImage,btnInsert;

    //db모델생성
    ProductDbModel model = new ProductDbModel();

    //내부클래스 선언
    PhotoDraw photoDraw = new PhotoDraw();

    public ProductAddForm() {
        super("상품 추가폼");
        this.setBounds(789,262,559,385);

        initDesign();
        this.setVisible(true);

    }

    public void initDesign() {

        this.setLayout(null);

        //메뉴 이름, 필드
        JLabel lbl1 = new JLabel("메뉴 이름");
        lbl1.setBounds(30, 10, 60, 30);
        this.add(lbl1);


        tfName = new JTextField();
        tfName.setBounds(110, 10, 100, 30);
        this.add(tfName);


        //메뉴 종류 콤보박스
        JLabel lblType = new JLabel("종류");
        lblType.setBounds(30, 60, 60, 30);
        this.add(lblType);


        String [] typeList = {"커피","플랫치노","에이드","티", "빙수"};  //콤보 박스에 담을 문자 배열
        menuType = new JComboBox<String>(typeList);     //콤보 박스에 문자배열 연결

        menuType.setBounds(110,65,90,45);
        this.add(menuType);




        JLabel lbl2 = new JLabel("메뉴 이미지");
        lbl2.setBounds(30, 165, 70, 30);
        this.add(lbl2);

        btnImage = new JButton("사진 선택");
        btnImage.setBounds(110, 165, 100, 30);
        this.add(btnImage);

        //이미지
        photoDraw.setBounds(250, 10, 300, 300);
        this.add(photoDraw);

//        //이미지명
//        lblPhoto = new JLabel("이미지명");
//        lblPhoto.setBorder(new LineBorder(Color.pink));
//        lblPhoto.setBounds(20, 190, 300, 30);
//        this.add(lblPhoto);




        //메뉴 가격
        JLabel lbl4 = new JLabel("가격");
        lbl4.setBounds(30, 120, 50, 30);
        this.add(lbl4);

        tfPrice = new JTextField();
        tfPrice.setBounds(110, 120, 100, 30);
        this.add(tfPrice);

        //db추가버튼
        btnInsert = new JButton("메뉴 추가");
        btnInsert.setBounds(47, 231, 180, 90);
        this.add(btnInsert);


        btnImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog dlg = new FileDialog(ProductAddForm.this, "이미지 가져오기",FileDialog.LOAD);
                dlg.setVisible(true);

                //취소 누르면 메서드 종료
                if (dlg.getDirectory() == null) {
                    return;
                }
                //이미지명 얻기
                imageName = dlg.getDirectory()+dlg.getFile();

                //라벨에 이미지명 출력
                //lblPhoto.setText(imageName);

                //이미지출력
                photoDraw.repaint();
            }
        });

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //ShopDto생성
                ProductDto dto = new ProductDto();

                //dto에 4개의 데이터를 넣는다
                dto.setName(tfName.getText());
                dto.setImg(imageName);
                dto.setPrice(Integer.parseInt(tfPrice.getText()));
                dto.setMenu_type((String)menuType.getSelectedItem());



                //db모델에서 insert호출
                model.insertProduct(dto);

                //현재창 닫기
                ProductAddForm.this.setVisible(false);

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

        new ProductAddForm();

    }
}