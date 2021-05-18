package com.klenio.maze.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void getWallOrRoad() {
        //given
        Maze maze = new Maze();
        maze.setMaxX(5);
        maze.setMaxY(5);
        maze.addPosition(new Position(0,0, 0));
        maze.addPosition(new Position(1,0, 0));
        maze.addPosition(new Position(2,0, 0));
        maze.addPosition(new Position(3,0, 0));
        maze.addPosition(new Position(4,0, 0));
        maze.addPosition(new Position(0,1, 1));
        maze.addPosition(new Position(1,1, 1));
        maze.addPosition(new Position(2,1, 0));
        maze.addPosition(new Position(3,1, 0));
        maze.addPosition(new Position(4,1, 0));
        maze.addPosition(new Position(0,2, 0));
        maze.addPosition(new Position(1,2, 1));
        maze.addPosition(new Position(2,2, 1));
        maze.addPosition(new Position(3,2, 1));
        maze.addPosition(new Position(4,2, 0));
        maze.addPosition(new Position(0,3, 0));
        maze.addPosition(new Position(1,3, 0));
        maze.addPosition(new Position(2,3, 0));
        maze.addPosition(new Position(3,3, 1));
        maze.addPosition(new Position(4,3, 1));
        maze.addPosition(new Position(0,4, 0));
        maze.addPosition(new Position(1,4, 0));
        maze.addPosition(new Position(2,4, 0));
        maze.addPosition(new Position(3,4, 0));
        maze.addPosition(new Position(4,4, 0));
        //when
        Integer result1 = maze.getWallOrRoad(0, 0);
        Integer result2 = maze.getWallOrRoad(4, 0);
        Integer result3 = maze.getWallOrRoad(1, 1);
        Integer result4 = maze.getWallOrRoad(4, 3);
        Integer result5 = maze.getWallOrRoad(-1, 0);
        Integer result6 = maze.getWallOrRoad(2, 8);
        //then
        assertEquals(0, result1);
        assertEquals(0, result2);
        assertEquals(1, result3);
        assertEquals(1, result4);
        assertNull(result5);
        assertNull(result6);
    }
}