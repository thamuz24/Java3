package week3.Prime;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        LazyPrimeFactorization prime1 = new LazyPrimeFactorization();
        OptimizedPrimeFactorization prime2 = new OptimizedPrimeFactorization();
        Thread thread1 = new Thread(prime1);
        Thread thread2 = new Thread(prime2);
        thread1.start();
        thread2.start();
    }
}
