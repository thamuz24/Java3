package week3.WhatIsNumber;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter hide number: ");

        ControlGame controlGame = new ControlGame();
        controlGame.play(input.nextInt());

        PlayByRunnable playByRunnable = new PlayByRunnable("Minh",controlGame);
        Thread thread = new Thread(playByRunnable);

        PlayByThread playByThread = new PlayByThread("Gia",controlGame);

        thread.start();
        playByThread.start();

    }
}
