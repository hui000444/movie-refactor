import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客类，可进行多种租赁，需要打印详单
 *
 * @author Chaohui Zhang
 * @create 2019-2-11 10:35
 */
public class Customer {
    private String name;           //顾客名
    private Vector rentals = new Vector();  //租赁列表

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //添加租赁信息
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    //打印详单方法
    public String statement() {
        double totalAmount = 0;     //总金额
        int frequentRenterPoints = 0;  //积分点
        Enumeration items = rentals.elements(); //用户所有租赁列表
        String result = getName() + " 的租赁详单如下 :" + "\n";
        //循环遍历租赁影片，计算消费金额
        while (items.hasMoreElements()) {
            double thisAmount = 0;  //当前单个租赁金额
            Rental each = (Rental) items.nextElement();

            //租赁计费规则
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:   //普通片，起步价为2元，租期超过2天的部分每天1.5元
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE: //新片，每天3元
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:  //儿童片，起步价1.5元，租期超过3天的部分每天1.5元
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
            frequentRenterPoints++;     //每借一张加1个积分点
            //积分累加条件：新版本的片子，借的时间大于1天
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            //添加详单
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        //添加脚注
        result += "总金额为： \t" + String.valueOf(totalAmount) + "\n";
        result += "您本次消费获取： " + String.valueOf(frequentRenterPoints)
                + " 个积分点";
        return result;
    }

}
