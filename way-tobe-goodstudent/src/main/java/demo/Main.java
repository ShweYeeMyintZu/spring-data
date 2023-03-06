package demo;

public class Main {
    public static void main(String[] args) {

        //Template design pattern is To control methods order we want

        Ways ways=new AGoodStudent();
        ways.GoodWays();
        System.out.println("________________________________________");

        Ways ways1=new ANormalStudent();
        ways1.GoodWays();

    }


}
