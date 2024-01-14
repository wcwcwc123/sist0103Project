package day0109;

public class QuizInOutRank_15 {
    public static void main(String[] args) {

        String[] name = {"홍수연", "김수연", "최수연", "민수연"};
        int[] kor = {90, 88, 100, 78};
        int[] eng = {100, 55, 100, 87};
        int[] mat = {44, 55, 100, 66};
        int[] tot = new int[4];
        double[] avg = new double[4];
        int[] rank = new int[4];

//        for (int i = 0; i < name.length; i++) {
//            tot[i] = kor[i] + eng[i] + mat[i];
//            avg[i] = (double)tot[i]/3;
//        }
        for (int i = 0; i < name.length; i++) {
            tot[i] = kor[i] + eng[i] + mat[i];
            avg[i] = (double)tot[i]/3;
        }

        for (int i = 0; i < name.length; i++) {
            rank[i] = 1;
            for (int j = 0; j < name.length; j++) {
                if (tot[i] < tot[j]) {
                    rank[i]++;
                }
            }
        }
        System.out.printf("%3s\t%3s\t%3s\t%3s\t%3s\t%3s\t%3s\t%3s\n","번호","이름","국어","영어","수학","총점","평균","등수");
        System.out.println("====================================================================");
        for(int i=0;i<name.length;i++){
            System.out.printf("%3d\t%7s\t%4d\t%4d\t%4d\t%4d\t%5.1f\t%3d\n",i+1,name[i],kor[i],eng[i],mat[i],tot[i],avg[i],rank[i]);

        }




    }
}
