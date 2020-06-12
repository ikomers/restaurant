package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bis.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        List<Dish> orderedDishes = new ArrayList<>();
        while (true) {
            int countOfOrderedDishes = orderedDishes.size();
            int countOfDishes = countOfOrderedDishes;
            writeMessage("Please, enter the name of dish");
            String dishName = readString();
            if (dishName.contains("exit")) {
                break;
            }
            List<String> dishes = new ArrayList<>();
            if (!dishName.equals("")) {
                for (Dish dish : Dish.values()) {
                    if (String.valueOf(dish).contains(dishName)) {
                        orderedDishes.add(dish);
                        countOfDishes++;
                    }
                }
            }
            if (countOfDishes == countOfOrderedDishes) {
                    writeMessage("Sorry, we don't have such kind of dishes. Please select from list above");
            }
        }
        return orderedDishes;
    }
}