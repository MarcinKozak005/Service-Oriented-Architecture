package ConcurrentTest;

public class ConcurrentMain {
    public static void main(String[] args) {
        System.out.println("Start");
//        new Thread(new Concurrent1()).start();
//        new Thread(new Concurrent2()).start();
        new Thread(new Concurrent1()).start();
        new Thread(new Concurrent2()).start();
        System.out.println("End");
    }
}

