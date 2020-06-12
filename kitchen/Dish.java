package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    Dish(int i) {
        this.duration  = i ;
    }

    public int getDuration() {
        return duration;
    }

    private int duration;

    public static String allDishesToString() {
        StringBuilder builder = new StringBuilder();
        for (Dish enStr : Dish.values()) {
            builder.append(enStr).append(" ");
        }
        return String.valueOf(builder).trim().replaceAll(" ", ", ");
    }
}