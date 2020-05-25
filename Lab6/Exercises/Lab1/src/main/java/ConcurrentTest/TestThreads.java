package ConcurrentTest;

public class TestThreads {
    static int sharedVariable=0;
    public static void main(String[] args) {
        new Inc().start();
        new Dec().start();
    }
}
class Inc extends Thread
{
    public void run() {
        for(int i=0;i<1000;i++){
//            TestThreads.sharedVariable++;
            System.out.println(
                    "I"+i);
        }
    }
}
class Dec extends Thread
{
    public void run(){
        for(int i=0;i<1000;i++){
//            TestThreads.sharedVariable--;
            System.out.println(
                    "D"+i);
        }
    }
}