/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10191634
 */
public class ConfigData {

    private int level;
    private String name;
    private int size;
    private int walls;
    private int obstacles;
    public static ConfigData instance = new ConfigData();

    private ConfigData() {
        level = 0;
        name = "NoName";
        size = 0;
        walls = 0;
        obstacles = 0;
    }

    /*----Name and Level----*/
    public void setLevel(int level) {
        if (level < 0) {
            this.level = 0;
        } else if (level > 2) {
            this.level = 2;
        } else {
            this.level = level;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    /*----Board----*/
    public int getBoardRowCol() {
        switch (ConfigData.instance.getBoardSize()) {
            case 0:
                return 20;
            case 1:
                return 25;
            case 2:
                return 30;
            default:
                return 20;
        }
    }

    public int getBoardSize() {
        return size;
    }

    public void setBoardSize(int size) {
        if (size < 0) {
            this.size = 0;
        } else if (size > 2) {
            this.size = 2;
        } else {
            this.size = size;
        }
    }

    /*----Walls----*/
    public int getWall() {
        return walls;
    }

    public void setWallLevel(int walls) {
        if (walls < 0) {
            this.walls = 0;
        } else if (walls > 1) {
            this.walls = 1;
        } else {
            this.walls = walls;
        }
    }

    public boolean getWallLevel() {
        return ConfigData.instance.getWall() == 0;
    }

    /*----Obstacles----*/
    public int getObstacle() {
        return obstacles;
    }

    public void setObstaclesLevel(int obstacles) {
        if (obstacles < 0) {
            this.obstacles = 0;
        } else if (obstacles > 1) {
            this.obstacles = 1;
        } else {
            this.obstacles = obstacles;
        }
    }

    public boolean getObstaclesLevel() {
        if (ConfigData.instance.getObstacle() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
