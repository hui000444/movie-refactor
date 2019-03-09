public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    abstract int getFrequentRenterPoints(int daysRented);
}

class ChildrensPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result += 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

class NewReleasePrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}

class RegularPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
    @Override
    public double getCharge(int daysRented) {
        double result = 0;
        result += 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}