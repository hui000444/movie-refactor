import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客类，可进行多种租赁，需要打印详单
 *
 * @author Chaohui Zhang
 * @create 2019-2-11 10:35
 */
public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    //打印详单方法
    public String statement() {
        Enumeration items = rentals.elements();
        String result = getName() + " 的租赁详单如下 :" + "\n";
        while (items.hasMoreElements()) {
            Rental each = (Rental) items.nextElement();
            //添加详单
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    "\t"
                    + String.valueOf(each.getCharge()) + "\n";
        }
        //添加脚注
        result += "总金额为： \t" + String.valueOf(getTotalCharge()) + "\n";
        result += "您本次消费获取： " + String.valueOf(getTotalFrequentRenterPoints())
                + " 个积分点";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration items = rentals.elements();
        while (items.hasMoreElements()) {
            Rental each = (Rental) items.nextElement();
            result+=each.getCharge();
        }
        return result;
    }
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration items = rentals.elements();
        while (items.hasMoreElements()) {
            Rental each = (Rental) items.nextElement();
            result+=each.getFrequentRenterPoints();
        }
        return result;
    }

}
