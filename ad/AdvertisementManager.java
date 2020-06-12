package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {

    final public AdvertisementStorage storage = AdvertisementStorage.getInstance();
    //time for cooking
    private int timeSeconds;
    private ArrayList<Advertisement> advertisements = (ArrayList<Advertisement>) storage.videos;
    private Backpack backpack = new Backpack(0, 0, 0);

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.videos.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        recursive(storage.videos, new ArrayList<>(), "" );
        System.out.println(backpack);
        for (Advertisement ad : backpack.advertisementArrayList) {
            for (Advertisement storageVideos : storage.videos) {
                if (storageVideos.equals(ad)) {
                    storageVideos.revalidate();
                }
            }
        }
    }

    private void theBestAdvertisement(ArrayList<Advertisement> advert) {
        int duration = 0;
        int profit = 0;
        int countOfVideos = advert.size();
        for (Advertisement ad : advert) {
            duration += ad.getDuration();
            profit += ad.getAmountPerOneDisplaying();
        }
        if (duration <= timeSeconds) {
            if (profit > backpack.getMaxProfit()) {
                backpack.setAllField(duration, profit, countOfVideos, advert);
            } else if (profit == backpack.getMaxProfit()) {
                if (duration > backpack.getMaxDuration()) {
                    backpack.setAllField(duration, profit, countOfVideos, advert);
                } else if (duration == backpack.getMaxDuration()) {
                    if (backpack.getCountOfVideos() >= countOfVideos) {
                        backpack.setAllField(duration, profit, countOfVideos, advert);
                    }
                }
            }
        }
    }

    private void recursive(List<Advertisement> f, ArrayList<Advertisement> s, String tab) {
        if (f.isEmpty()) {
            //System.out.println(tab + "f is empty, print s");
            //System.out.println(tab + s);
            return;
        }
        for (int i = 0; i < f.size(); i++) {
            Advertisement current = f.remove(i);
            if (!s.contains(current)) {
                s.add(current);
            }
            theBestAdvertisement(s);
            //System.out.println(String.format(tab + "add %d from f to s. f = %s, s = %s", i, f, s));
            recursive(f, s, tab + "\t");
            if (!s.isEmpty()) {
                s.remove(s.size() - 1);
            }
            f.add(i, current);
            //System.out.println(String.format(tab + "add %d from s to f. f = %s, s = %s", i, f, s));
        }
    }
}