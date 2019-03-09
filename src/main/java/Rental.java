/**
 * 租赁类，用于绑定某个顾客租赁的影片，包含影片名和租期
 *
 * @author Chaohui Zhang
 * @create 2019-2-11 10:35
 */
public class Rental {
    //租赁的影片
    private Movie movie;
    //租期
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return getMovie().getCharge(getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(getDaysRented());
    }

}