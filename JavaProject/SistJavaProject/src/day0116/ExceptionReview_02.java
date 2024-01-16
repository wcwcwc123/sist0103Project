package day0116;

public class ExceptionReview_02 {

    public static void process() {
        int[] arr = {1, 3, 9, 7};

        for (int i = 0; i <= arr.length; i++) {
            try {
                System.out.println(arr[i]);
            } catch (Exception e) {
                System.out.println("오류메세지 1: "+e.getMessage());
            }
        }
    }

    //익셉션 처리를 직접하지 않고 호출하는곳으로 해당 익셉션을 던진다
    public static void process2() throws NumberFormatException {

        String a = "12a";
        String b = "30";
        int sum =0;

        sum = Integer.parseInt(a) + Integer.parseInt(b);
        System.out.println("두수의 합은"+sum);

    }
    public static void main(String[] args) {
        process();

        try {
            process2();
        } catch (NumberFormatException e) {
            System.out.println("예외처리를 메인에서 했어요");
        }
        System.out.println("정상종료");
    }
}
