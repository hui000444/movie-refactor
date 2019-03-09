import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StatementTests {
    @Test
    public void one_REGULAR_movie_two_days()
    {
        Movie movie = new Movie("疯狂的外星人",0);
        Rental rental = new Rental(movie,2);
        Customer customer = new Customer("Zhang San");
        customer.addRental(rental);
        assertThat(customer.statement(), is("Zhang San 的租赁详单如下 :\n" +
                "\t疯狂的外星人\t\t2.0\n" +
                "总金额为： \t2.0\n" +
                "您本次消费获取： 1 个积分点"));
    }
    @Test
    public void one_REGULAR_movie_more_than_two_days()
    {
        Movie movie = new Movie("疯狂的外星人",0);
        Rental rental = new Rental(movie,3);
        Customer customer = new Customer("Zhang San");
        customer.addRental(rental);
        assertThat(customer.statement(), is("Zhang San 的租赁详单如下 :\n" +
                "\t疯狂的外星人\t\t3.5\n" +
                "总金额为： \t3.5\n" +
                "您本次消费获取： 1 个积分点"));
    }

    @Test
    public void one_NEW_RELEASE_movie_one_day()
    {
        Movie movie = new Movie("流浪地球",1);
        Rental rental = new Rental(movie,1);
        Customer customer = new Customer("Zhang San");
        customer.addRental(rental);
        assertThat(customer.statement(), is("Zhang San 的租赁详单如下 :\n" +
                "\t流浪地球\t\t3.0\n" +
                "总金额为： \t3.0\n" +
                "您本次消费获取： 1 个积分点"));
    }

    @Test
    public void should_return_two_renter_points_when_NEW_RELEASE_movie_more_than_one_day()
    {
        Movie movie = new Movie("流浪地球",1);
        Rental rental = new Rental(movie,3);
        Customer customer = new Customer("Zhang San");
        customer.addRental(rental);
        assertThat(customer.statement(), is("Zhang San 的租赁详单如下 :\n" +
                "\t流浪地球\t\t9.0\n" +
                "总金额为： \t9.0\n" +
                "您本次消费获取： 2 个积分点"));
    }

    @Test
    public void one_CHILDRENS_movie_three_days()
    {
        Movie movie = new Movie("熊出没",2);
        Rental rental = new Rental(movie,3);
        Customer customer = new Customer("Zhang San");
        customer.addRental(rental);
        assertThat(customer.statement(), is("Zhang San 的租赁详单如下 :\n" +
                "\t熊出没\t\t1.5\n" +
                "总金额为： \t1.5\n" +
                "您本次消费获取： 1 个积分点"));
    }

    @Test
    public void one_CHILDRENS_movie_more_than_three_days()
    {
        Movie movie = new Movie("熊出没",2);
        Rental rental = new Rental(movie,5);
        Customer customer = new Customer("Zhang San");
        customer.addRental(rental);
        assertThat(customer.statement(), is("Zhang San 的租赁详单如下 :\n" +
                "\t熊出没\t\t4.5\n" +
                "总金额为： \t4.5\n" +
                "您本次消费获取： 1 个积分点"));
    }

    @Test
    public void when_rental_three_types_movie()
    {
        Movie movie1 = new Movie("疯狂的外星人",0);
        Movie movie2 = new Movie("流浪地球",1);
        Movie movie3 = new Movie("熊出没",2);
        Rental rental1 = new Rental(movie1,8);
        Rental rental2 = new Rental(movie2,3);
        Rental rental3 = new Rental(movie3,5);

        Customer customer = new Customer("Zhang San");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        assertThat(customer.statement(), is("Zhang San 的租赁详单如下 :\n" +
                "\t疯狂的外星人\t\t11.0\n" +
                "\t流浪地球\t\t9.0\n" +
                "\t熊出没\t\t4.5\n" +
                "总金额为： \t24.5\n" +
                "您本次消费获取： 4 个积分点"));
    }
}
