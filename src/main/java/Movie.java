/**
 * 影片类，分为不同类型价格不同
 *
 * @author Chaohui Zhang
 * @create 2019-2-11 10:35
 */
public class Movie {
    public static final int REGULAR = 0;            //普通影片
    public static final int NEW_RELEASE = 1;        //新片
    public static final int CHILDRENS = 2;          //儿童影片

    private String title;        //影片名
    private int priceCode;       //价格码

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
