class Stock {
    // Default values of stock
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    // Construct a stock object
    Stock(String symbol_, String name_, double previousClosingPrice_, double currentPrice_) {
        symbol = symbol_;
        name = name_;
        previousClosingPrice = previousClosingPrice_;
        currentPrice = currentPrice_;
    }

    double getChangePercent() {
        return (currentPrice - previousClosingPrice)/previousClosingPrice * 100;
    }

}

public class TestStock {
    public static void main(String[] args) {
        Stock stock1 = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35 );
        System.out.println(stock1.getChangePercent() + "%");
    }
}