package day0117;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileWrite_03 {
    public static void fileWrite() {
        FileWriter fw = null;
        String fileName = "C:\\sist0103\\file\\test1.txt";

        try {
            fw = new FileWriter(fileName);
            fw.write("안녕");
            fw.write("하세요\n");
            fw.write("오늘은 수요일");
            fw.write(new Date().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void fileWrite2() {
        FileWriter fw = null;
        String fileName = "C:\\sist0103\\file\\test2.txt";

        try {
            fw = new FileWriter(fileName,true);
            fw.write("추가모드1");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        fileWrite();
        fileWrite2();

    }
}
