public class Main {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB obj = new ThreadB();
        Thread threadB = new Thread(obj);
    threadA.start();
    threadB.start();
    }
}
