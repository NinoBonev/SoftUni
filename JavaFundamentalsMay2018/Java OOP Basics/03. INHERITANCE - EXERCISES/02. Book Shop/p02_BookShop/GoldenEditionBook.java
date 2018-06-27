package p02_BookShop;

/**
 * Created by Nino Bonev - 23.6.2018 г., 11:42
 */
public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price + price * 0.3);
    }
}
