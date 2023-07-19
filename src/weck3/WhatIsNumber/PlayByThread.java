package weck3.WhatIsNumber;

public class PlayByThread extends Thread{
    private String name;
    private int count;
    ControlGame controlGame;
    public PlayByThread(String name,ControlGame controlGame) {
        this.controlGame = controlGame;
        this.name = name;
        this.count = 0;
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
