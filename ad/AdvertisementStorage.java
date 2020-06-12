package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;

    final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "1 Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "2 Video", 5000, 100, 4 * 60));
        add(new Advertisement(someContent, "3 Video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "4 Video", 100, 10, 16 * 60));
        add(new Advertisement(someContent, "5 Video", 400, 2, 10 * 60));
        add(new Advertisement(someContent, "6 Video", 400, 2, 11 * 60));
        add(new Advertisement(someContent, "7 Video", 1500, 5, 20 * 60));
        add(new Advertisement(someContent, "8 Video", 1500, 5, 2 * 60));
        add(new Advertisement(someContent, "9 Video", 1500, 5, 3 * 60));
        add(new Advertisement(someContent, "10 Video", 1500, 5, 21 * 60));
        add(new Advertisement(someContent, "11 Video", 1500, 5, 21 * 61));
        add(new Advertisement(someContent, "12 Video", 1500, 5, 21 * 62));
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }
}