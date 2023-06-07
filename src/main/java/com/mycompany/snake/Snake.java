/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import static com.mycompany.snake.Direction.DOWN;
import static com.mycompany.snake.Direction.LEFT;
import static com.mycompany.snake.Direction.UP;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;
import static com.mycompany.snake.Direction.RIGHT;

/**
 *
 * @author alu10191634
 */
public class Snake {

    private Direction direction;
    private List<Node> listOfNodes;
    private int initNodes;
    private int toGrow;

    public Snake(Direction direction, int initNodes) {
        this.direction = direction;
        this.initNodes = initNodes;
        initialSnake(initNodes);

    }

    public void initialSnake(int initNodes) {
        int rows = ConfigData.instance.getBoardRowCol();
        int cols = ConfigData.instance.getBoardRowCol();
        int initPos = cols / 4;
        listOfNodes = new ArrayList<>();
        for (int i = 0; i < initNodes; i++) {
            Node node = new Node(rows / 2, initPos);
            listOfNodes.add(node);
            initPos--;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean containNode(int row, int col) {
        for (int i = 0; i < listOfNodes.size(); i++) {
            Node nodeInSnake = listOfNodes.get(i);
            if (row == nodeInSnake.getRow() && col == nodeInSnake.getCol()) {
                return true;
            }
        }
        return false;
    }

    public void move() {
        Node node;
        int row = getHeadRow();
        int col = getHeadCol();
        if (ConfigData.instance.getWallLevel() == false) {
            int newRow = row;
            int newCol = col;
            switch (direction) {
                case UP:
                    newRow = (row - 1 < 0) ? getBoardRC() - 1 : row - 1;
                    break;
                case DOWN:
                    newRow = (row + 1 > getBoardRC() - 1) ? 0 : row + 1;
                    break;
                case LEFT:
                    newCol = (col - 1 < 0) ? getBoardRC() - 1 : col - 1;
                    break;
                case RIGHT:
                    newCol = (col + 1 > getBoardRC() - 1) ? 0 : col + 1;
                    break;
                default:
                    throw new AssertionError();
            }
            node = new Node(newRow, newCol);
            listOfNodes.add(0, node);
        } else {
            switch (direction) {
                case UP:
                    node = new Node(row - 1, col);
                    listOfNodes.add(0, node);
                    break;
                case DOWN:
                    node = new Node(row + 1, col);
                    listOfNodes.add(0, node);
                    break;
                case LEFT:
                    node = new Node(row, col - 1);
                    listOfNodes.add(0, node);
                    break;
                case RIGHT:
                    node = new Node(row, col + 1);
                    listOfNodes.add(0, node);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        if (toGrow <= 0) {
            listOfNodes.remove(listOfNodes.size() - 1);
        } else {
            toGrow--;
        }
    }

    public boolean canMove() {
        int row = getHeadRow();
        int col = getHeadCol();
        if (ConfigData.instance.getWallLevel() == false) {
            switch (direction) {
                case UP:
                    if (containNode(row - 1, col)) {
                        return false;
                    }
                    if (row - 1 < 0) {
                        if (containNode(getBoardRC() - 1, col)) {
                            return false;
                        }
                    }
                    break;
                case DOWN:
                    if (containNode(row + 1, col)) {
                        return false;
                    }
                    if (row + 1 >= getBoardRC()) {
                        if (containNode(0, col)) {
                            return false;
                        }
                    }
                    break;
                case LEFT:
                    if (containNode(row, col - 1)) {
                        return false;
                    }
                    if (col - 1 < 0) {
                        if (containNode(row, getBoardRC() - 1)) {
                            return false;
                        }
                    }
                    break;
                case RIGHT:
                    if (containNode(row, col + 1)) {
                        return false;
                    }
                    if (col + 1 >= getBoardRC()) {
                        if (containNode(row, 0)) {
                            return false;
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return true;
        } else {
            switch (direction) {
                case UP:
                    if (row - 1 < 0 || containNode(row - 1, col)) {
                        return false;
                    }
                    break;
                case DOWN:
                    if (row + 1 >= getBoardRC()|| containNode(row + 1, col)) {
                        return false;
                    }
                    break;
                case LEFT:
                    if (col - 1 < 0 || containNode(row, col - 1)) {
                        return false;
                    }
                    break;
                case RIGHT:
                    if (col + 1 >= getBoardRC() || containNode(row, col + 1)) {
                        return false;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return true;
        }
    }

    public boolean canMoveWithObstacles(List<Node> obstacles) {

        for (int i = 0; i < obstacles.size(); i++) {

            int row = obstacles.get(i).getRow();
            int col = obstacles.get(i).getCol();

            switch (direction) {
                case UP:
                    if (getHeadRow() - 1 == row && getHeadCol() == col) {
                        return false;
                    } else if (ConfigData.instance.getWallLevel() == false) {
                        if (getHeadRow() - 1 < 0) {
                            if (getBoardRC() - 1 == row && getHeadCol() == col) {
                                return false;
                            }
                        }
                    }
                    break;
                case DOWN:
                    if (getHeadRow() + 1 == row && getHeadCol() == col) {
                        return false;
                    } else if (ConfigData.instance.getWallLevel() == false) {
                        if (getHeadRow() + 1 >= getBoardRC()) {
                            if (0 == row && getHeadCol() == col) {
                                return false;
                            }
                        }
                    }
                    break;
                case RIGHT:
                    if (getHeadRow() == row && getHeadCol() + 1 == col) {
                        return false;
                    } else if (ConfigData.instance.getWallLevel() == false) {
                        if (getHeadCol() + 1 >= getBoardRC()) {
                            if (getHeadRow() == row && 0 == col) {
                                return false;
                            }
                        }
                    }
                    break;
                case LEFT:
                    if (getHeadRow() == row && getHeadCol() - 1 == col) {
                        return false;
                    } else if (ConfigData.instance.getWallLevel() == false) {
                        if (getHeadCol() - 1 < 0) {
                            if (getHeadRow() == row && getBoardRC() - 1 == col) {
                                return false;
                            }
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return true;
    }

    public int getHeadRow() {
        return listOfNodes.get(0).getRow();
    }

    public int getHeadCol() {
        return listOfNodes.get(0).getCol();
    }

    public int getBoardRC() {
        return ConfigData.instance.getBoardRowCol();
    }

    public boolean eatFood(Food food) {
        if (food == null) {
            return false;
        }
        int foodRow = food.getRow();
        int foodCol = food.getCol();
        int headRow = getHeadRow();
        int headCol = getHeadCol();
        if (foodRow == headRow && foodCol == headCol) {
            toGrow += food.nodesWhenEat();
            return true;
        } else {
            return false;
        }
    }

    public void printSnake(Graphics g, int squareWidth, int squareHeight) {
        
        for(int i = 0; i < listOfNodes.size(); i++) {
            
            Node nodeToPrint = listOfNodes.get(i);
            
            int row = nodeToPrint.getRow();
            int col = nodeToPrint.getCol();
            
            BodyType bodyType = BodyType.HEAD_UP;
            
            if (nodeToPrint == listOfNodes.get(0)) {
                
                switch (direction) {
                    case UP:
                        break;
                    case DOWN:
                        bodyType = BodyType.HEAD_DOWN;
                        break;
                    case RIGHT:
                        bodyType = BodyType.HEAD_RIGHT;
                        break;
                    case LEFT:
                        bodyType = BodyType.HEAD_LEFT;
                        break;
                    default:
                        throw new AssertionError();
                }
                
            } else if (nodeToPrint == listOfNodes.get(listOfNodes.size() - 1)) {
                
                Node previousNode = listOfNodes.get(listOfNodes.size() - 2);
                
                int rowPrev = previousNode.getRow();
                int colPrev = previousNode.getCol();
                
                if (row - 1 == rowPrev && col == colPrev) {
                    bodyType = BodyType.TAIL_UP;
                } else if (row + 1 == rowPrev && col == colPrev) {
                    bodyType = BodyType.TAIL_DOWN;
                } else if (row == rowPrev && col + 1 == colPrev) {
                    bodyType = BodyType.TAIL_RIGHT;
                } else {
                    bodyType = BodyType.TAIL_LEFT;
                }
                
            } else {
                bodyType = turns(row, col, i);
            }
            
            Util.drawSnake(g, row, col, squareWidth, squareHeight, bodyType);
        }
    }
    
    private BodyType turns(int row, int col, int i) {
        
        Node prevNode = listOfNodes.get(i - 1);
        Node nextNode = listOfNodes.get(i + 1);

        int prevRow = prevNode.getRow();
        int prevCol = prevNode.getCol();

        int nextRow = nextNode.getRow();
        int nextCol = nextNode.getCol();

        BodyType bodyType = BodyType.BODY_HORIZ;

        if (prevRow == nextRow) {
            //body horizontal
        } else if (prevCol == nextCol) {
            //body vertical
            bodyType = BodyType.BODY_VERT;
            
        } else {

            int boardRowCol = getBoardRC() - 1;

            if (nextRow == row && prevCol == col) {

                if (nextCol > col && prevRow < row) {
                    // Draw the north east with excepcions
                    if (nextRow == boardRowCol && prevRow == 0) {
                        bodyType = BodyType.TURN_SE;
                    } else if (nextCol == boardRowCol && prevCol == 0) {
                        bodyType = BodyType.TURN_NW;
                    } else {
                        bodyType = BodyType.TURN_NE;
                    }
                    
                } else if (nextCol > col && prevRow > row) {
                    // Draw the south east with excepcions
                    if (nextRow == 0 && prevRow == boardRowCol) {
                        bodyType = BodyType.TURN_NE;
                    } else if (nextCol == boardRowCol && prevCol == 0) {
                        bodyType = BodyType.TURN_SW;
                    } else {
                        bodyType = BodyType.TURN_SE;
                    }
                    
                } else if (nextCol < col && prevRow < row) {
                    // Draw the north west with excepcions 
                    if (nextCol == 0 && prevCol == boardRowCol) {
                        bodyType = BodyType.TURN_NE;
                    } else if (nextRow == boardRowCol && prevRow == 0) {
                        bodyType = BodyType.TURN_SW;
                    } else {
                        bodyType = BodyType.TURN_NW;
                    }
                    
                } else if (nextCol < col && prevRow > row) {
                    // Draw the south west with excepcions
                    if (nextCol == 0 && prevCol == boardRowCol) {
                        bodyType = BodyType.TURN_SE;
                    } else if (nextRow == 0 && prevRow == boardRowCol) {
                        bodyType = BodyType.TURN_NW;
                    } else {
                        bodyType = BodyType.TURN_SW;
                    }
                }

            } else if (nextCol == col && prevRow == row) {
                
                if (nextRow < row && prevCol > col) {
                    // Draw the north east with excepcions
                    if (nextRow == 0 && prevRow == boardRowCol) {
                        bodyType = BodyType.TURN_SE;
                    } else if (nextCol == 0 && prevCol == boardRowCol) {
                        bodyType = BodyType.TURN_NW;
                    } else {
                        bodyType = BodyType.TURN_NE;
                    }
                    
                } else if (nextRow > row && prevCol > col) {
                    // Draw the south east with excepcions
                    if (nextRow == boardRowCol && prevRow == 0) {
                        bodyType = BodyType.TURN_NE;
                    } else if (nextCol == 0 && prevCol == boardRowCol) {
                        bodyType = BodyType.TURN_SW;
                    } else {
                        bodyType = BodyType.TURN_SE;
                    }
                    
                } else if (nextRow < row && prevCol < col) {
                    // Draw the north west with excepcions
                    if (nextCol == boardRowCol && prevCol == 0) {
                        bodyType = BodyType.TURN_NE;
                    } else if (nextRow == 0 && prevRow == boardRowCol) {
                        bodyType = BodyType.TURN_SW;
                    } else {
                        bodyType = BodyType.TURN_NW;
                    }
                    
                } else if (nextRow > row && prevCol < col) {
                    // Draw the south west with excepcions
                    if (nextCol == boardRowCol && prevCol == 0) {
                        bodyType = BodyType.TURN_SE;
                    } else if (nextRow == boardRowCol && prevRow == 0) {
                        bodyType = BodyType.TURN_NW;
                    } else {
                        bodyType = BodyType.TURN_SW;
                    }
                }
            }
        }
        return bodyType;
    }

}
