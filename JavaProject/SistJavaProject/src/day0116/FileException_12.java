package day0116;

import java.io.*;

public class FileException_12 {

    //점수의 총개수,합계,평균
    public static void scoreRead() throws IOException,FileNotFoundException {
        String fileName = "C:\\sist0103\\file\\score.txt";
        FileReader fr = null;
        BufferedReader br = null;
        int cnt =0; //개수
        int total = 0;
        double avg = 0;

        //파일읽기
        fr = new FileReader(fileName);
        System.out.println("파일 정상적으로 읽음!!");

        br = new BufferedReader(fr);

        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }

            // 문자열점수를 int로 변환해서 합계랑 개수 구하기
            cnt++;
            total += Integer.parseInt(s);
        }

        avg = (double) total/cnt;
        System.out.println("총갯수: " + cnt);
        System.out.println("총점: " + total);
        System.out.printf("평균:%.2f  ",avg);

        //자원들 닫기
        br.close();
        fr.close();

    }
    public static void main(String[] args) {
        try {
            scoreRead();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
