public class ThreadA extends Thread {
    public ThreadA() {
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("A "+i);
        }
    }
}
