package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;

public class Backpack {
    private int maxDuration;
    private int maxProfit;
    private int countOfVideos;
    ArrayList<Advertisement> advertisementArrayList = new ArrayList<>();

    Backpack(int maxDuration, int maxProfit, int countOfVideos) {
        this.maxDuration = maxDuration;
        this.maxProfit = maxProfit;
        this.countOfVideos = countOfVideos;
    }

    int getMaxDuration() {
        return maxDuration;
    }

    int getMaxProfit() {
        return maxProfit;
    }

    int getCountOfVideos() {
        return countOfVideos;
    }

    void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    void setMaxProfit(int maxProfit) {
        this.maxProfit = maxProfit;
    }

    void setCountOfVideos(int countOfVideos) {
        this.countOfVideos = countOfVideos;
    }


    void setAdvertisementArrayList(ArrayList<Advertisement> advertisements) {
        //clean before fill in
        advertisementArrayList.removeAll(advertisementArrayList);
        advertisementArrayList.addAll(advertisements);
    }

    void setAllField(int maxDuration,
                     int maxProfit,
                     int countOfVideos,
                     ArrayList<Advertisement> advertisements) {
        setMaxDuration(maxDuration);
        setMaxProfit(maxProfit);
        setCountOfVideos(countOfVideos);
        setAdvertisementArrayList(advertisements);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        advertisementArrayList.sort((o1, o2) -> {
            int compare = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying()) * -1;
            if (compare == 0)
                compare = Long.compare(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration(), o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
            return compare;
        });
        for (Advertisement ad : advertisementArrayList) {
            stringBuilder.append(ad.getName()).append(" is displaying... ");
            stringBuilder.append(ad.getAmountPerOneDisplaying()).append(", ");
            stringBuilder.append(String.format("%.3f", ad.getAmountPerSecond()));
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder).trim();
    }
}
