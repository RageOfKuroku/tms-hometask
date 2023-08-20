public class ThreadMainApp {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new ThreadName("thread1");

        Thread thread2 = new ThreadName("thread2");

        Thread thread3 = new ThreadName("thread3");

        thread3.start();
        thread3.join();
        thread2.start();
        thread2.join();
        thread1.start();
        thread1.join();

    }
}
