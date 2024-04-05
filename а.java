package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double win = 0, winAfterShift = 0, lose = 0, loseAfterShift = 0;

        for (int i = 0; i < 10; i++) {
            List<String> doors = createMontyHallDoors();
            int choice = new Random().nextInt(3);
            if (doors.get(choice).equals("car")) {
                win++;
                doors.remove(choice);
            } else lose++;
            doors.remove("goat");
            if (doors.contains("car")) {
                winAfterShift++;
            } else loseAfterShift++;
        }

        double result = win / (win + lose) * 100;
        double resultAfterShift = winAfterShift / (winAfterShift + loseAfterShift) * 100;

        System.out.printf("Процент побед, без смены выбора - %f%%\n", result);
        System.out.printf("Процент побед, при смене выбора - %s%%", resultAfterShift);
    }

    private static List<String> createMontyHallDoors() {
        List<String> threeDoors = new ArrayList<>();
        Collections.addAll(threeDoors, "goat", "goat", "goat");
        int carIndex = new Random().nextInt(3);
        threeDoors.set(carIndex, "car");
        return threeDoors;
    }
}