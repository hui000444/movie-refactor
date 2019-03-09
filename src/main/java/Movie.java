/**
 * 影片类，分为不同类型价格不同
 *
 * @author Chaohui Zhang
 * @create 2019-2-11 10:35
 */
public class Movie {
    //普通影片
    public static final int REGULAR = 0;
    //新片
    public static final int NEW_RELEASE = 1;
    //儿童影片
    public static final int CHILDRENS = 2;

    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg){
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
    public double getCharge(int daysRented){
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

}
