package weck3.WhatIsNumber;

public class PlayByRunnable implements Runnable {

    private String name;
    private int count;
    ControlGame controlGame;

    public PlayByRunnable(String name,ControlGame controlGame) {
        this.controlGame = controlGame;
        this.name = name;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        try {
            this.controlGame.play(this.name,this.count);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
