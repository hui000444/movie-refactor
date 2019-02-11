/**
 * 主方法，用于运行顾客租赁影片程序
 *
 * @author Chaohui Zhang
 * @create 2019-2-11 10:35s
 */
public class Run {
    public static void main(String[] args){
        Movie movie1 = new Movie("福尔摩斯",0);
        Movie movie2 = new Movie("雷神   ",1);
        Movie movie3 = new Movie("熊出没 ",2);
        Rental ren1 = new Rental(movie1,8);
        Rental ren2 = new Rental(movie2,3);
        Rental ren3 = new Rental(movie3,5);
        Customer cus = new Customer("Zhang San");
        cus.addRental(ren1);
        cus.addRental(ren2);
        cus.addRental(ren3);
        System.out.println(cus.statement());
    }
}
