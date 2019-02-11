/**
 * 租赁类，用于绑定某个顾客租赁的影片，包含影片名和租期
 *
 * @author Chaohui Zhang
 * @create 2019-2-11 10:35
 */
public class Rental {
    private Movie movie;              //租赁的影片
    private int daysRented;           //租期

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
}