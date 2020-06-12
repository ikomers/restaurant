package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;

    public Tablet(int id) {
        this.number = id;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            setChanged();
            if (!order.isEmpty()) {
                notifyObservers(order);
                ConsoleHelper.writeMessage(order.toString());
                new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
            }
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
            return null;
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}