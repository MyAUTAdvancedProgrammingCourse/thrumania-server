package com.poorgroupproject.thrumania.item.place.mine;

import com.poorgroupproject.thrumania.events.Event;
import com.poorgroupproject.thrumania.item.place.Place;
import com.poorgroupproject.thrumania.util.ResourcePath;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author amin
 * @version 1.0.0
 */
public class GoldMine extends Mine {

    private Image[] goldMineImages;
    private int toughness; // the toughness of place and the rang is 0 to 100

    /**
     * Constructor
     * @param x
     * @param y
     */
    public GoldMine(int x, int y) {
        super(x, y);
        goldMineImages = new Image[4];
        toughness = 100;
    }

    /**
     * loading images of gold mine that first element of array is incompleted gold mine and the last one is completed gold mine.
     */
    @Override
    public void loadResoure() {
        try {
            goldMineImages[0]= ImageIO.read(new File(ResourcePath.itemImagePath + "mine\\goldMine\\goldMine_1.png"));
            goldMineImages[1]= ImageIO.read(new File(ResourcePath.itemImagePath + "mine\\goldMine\\goldMine_2.png"));
            goldMineImages[2]= ImageIO.read(new File(ResourcePath.itemImagePath + "mine\\goldMine\\goldMine_3.png"));
        } catch (IOException e) {
            System.err.println("FILE NOT FOUND");
            e.printStackTrace();
        }
    }

    @Override
    public void processEvent(Event event) {

    }
}
