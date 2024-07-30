public class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Images will be loaded from the remote server when display is called for the first time
        image1.display();
        image1.display(); // This time it should not load from the remote server

        // Second image
        image2.display();
        image2.display(); // This time it should not load from the remote server
    }
}
