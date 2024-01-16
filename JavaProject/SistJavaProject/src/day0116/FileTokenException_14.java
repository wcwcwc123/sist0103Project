package day0116;

import java.io.*;
import java.util.StringTokenizer;

public class FileTokenException_14 {
    public static void fileRead() {
        String fName = "C:\\sist0103\\file\\info.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(fName);
            br = new BufferedReader(fr);

            System.out.println("**파일 읽기 결과**");
            System.out.println("이름\t주소\t나이");
            System.out.println("----------------------");
            while (true) {
                String s = br.readLine();

                if (s == null) {
                    break;
                }
                for (String data : s.split(",")) {
                    System.out.printf("%s\t",data);
                }
                StringTokenizer st = new StringTokenizer(s, ",");
                System.out.println(st.nextToken()+"\t"+st.nextToken()+"\t"+st.nextToken());
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        fileRead();
    }

}
