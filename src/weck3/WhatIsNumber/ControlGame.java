package weck3.WhatIsNumber;

public class ControlGame {
    public int hideNumber;
    public boolean isEnd;

    public void play(int hideNumber) {
        this.hideNumber = hideNumber;
        this.isEnd = false;
    }

    public synchronized void play(String name, int count) throws InterruptedException {
        int numberChose ;

        while (!isEnd) {
            notify();
            numberChose = (int) (Math.random()*20 +1) ;
            count++;
            System.out.println("Player " + name + " choose " + numberChose);
            if (numberChose == hideNumber) {
                isEnd = true;
                System.out.println("Player " + name + " guess right after " + count + " time");
                break;
            }
            wait();
        }
    }
}
