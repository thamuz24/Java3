package weck3.Prime;

import java.util.ArrayList;

public class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        boolean isPrime;
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        primeList.add(2);
        for (int i = 3; i < 100000; i += 2) {
            isPrime = true;
            for (int j : primeList) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primeList.add(i);
                System.out.println(i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time Optimized is: "  + (end - start));
    }
}
