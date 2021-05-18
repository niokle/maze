package com.klenio.maze.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    void getNumberOfTurns() {
        //given
        Path path1 = new Path();
        path1.getPositions().add(new Position(0, 0, 0));
        path1.getPositions().add(new Position(1, 0, 0));
        path1.getPositions().add(new Position(2, 0, 0));
        path1.getPositions().add(new Position(3, 0, 0));
        path1.getPositions().add(new Position(4, 0, 0));
        path1.getPositions().add(new Position(0, 1, 1));
        path1.getPositions().add(new Position(1, 1, 1));
        path1.getPositions().add(new Position(2, 1, 0));
        path1.getPositions().add(new Position(3, 1, 0));
        path1.getPositions().add(new Position(4, 1, 0));
        path1.getPositions().add(new Position(0, 2, 0));
        path1.getPositions().add(new Position(1, 2, 1));
        path1.getPositions().add(new Position(2, 2, 1));
        path1.getPositions().add(new Position(3, 2, 0));
        path1.getPositions().add(new Position(4, 2, 0));
        path1.getPositions().add(new Position(0, 3, 0));
        path1.getPositions().add(new Position(1, 3, 0));
        path1.getPositions().add(new Position(2, 3, 1));
        path1.getPositions().add(new Position(3, 3, 1));
        path1.getPositions().add(new Position(4, 3, 1));
        path1.getPositions().add(new Position(0, 4, 0));
        path1.getPositions().add(new Position(1, 4, 0));
        path1.getPositions().add(new Position(2, 4, 0));
        path1.getPositions().add(new Position(3, 4, 0));
        path1.getPositions().add(new Position(4, 4, 0));
        /*
        00000
        11000
        01100
        00111
        00000
         */
        //when
        int turns1 = path1.getNumberOfTurns();
        //then
        assertEquals(4, turns1);
    }
}