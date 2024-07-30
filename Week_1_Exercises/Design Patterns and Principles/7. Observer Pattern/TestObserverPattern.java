public class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("Mobile App");
        Observer webApp = new WebApp("Web App");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(100.00);
        stockMarket.setStockPrice(105.50);
        stockMarket.setStockPrice(98.75);

        stockMarket.removeObserver(webApp);
        stockMarket.setStockPrice(102.00);
    }
}
