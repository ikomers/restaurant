package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {
        if (isEmpty()) {
            return 0;
        }
        int totalCookingTime = 0;
        for (Dish dish: dishes) {
            totalCookingTime = totalCookingTime + dish.getDuration();
        }
        return totalCookingTime;
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @SuppressWarnings("checkstyle:LineLength")
    @Override
    public String toString() {
        //TODO norm return
        StringBuilder builder = new StringBuilder("Your order: [");
        if (isEmpty()) {
            return null;
        } else {
            for (Dish dish : dishes) {
                builder.append(dish).append(", ");
            }
            return (String.valueOf(builder).trim() + "] of " + tablet.toString()).replaceAll(",]", "]");
        }
    }
}