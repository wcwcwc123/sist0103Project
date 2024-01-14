package day0110;

class Ipgo{
    private String sangName;
    private int price;

    //set메서드
    public void setSangName(String name) {
        this.sangName = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    //get메서드
    public String getSangName(){
        return this.sangName;
    }
    public int getPrice(){
        return this.price;
    }
}

public class SangpumIpgo_13 {
    public static void main(String[] args) {
        Ipgo ipgo1 = new Ipgo();
        ipgo1.setSangName("애플워치");
        ipgo1.setPrice(580000);

        String name1 = ipgo1.getSangName();
        int price1 = ipgo1.getPrice();

        Ipgo ipgo2 = new Ipgo();
        ipgo2.setSangName("에어팟");
        ipgo2.setPrice(320000);

        String name2 = ipgo2.getSangName();
        int price2 = ipgo2.getPrice();

        System.out.println(name1+", "+price1+"원");
        System.out.println(name2+", "+price2+"원");


    }
}
