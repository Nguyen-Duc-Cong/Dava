public class Fibonacci {
    public int Fibonacci(int num) {
        if(num < 2)
            return 1;
        return  Fibonacci(num- 1) - Fibonacci(num-2);
    }
}
