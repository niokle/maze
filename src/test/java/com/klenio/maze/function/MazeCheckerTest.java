package com.klenio.maze.function;

import com.klenio.maze.domain.Maze;
import com.klenio.maze.domain.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MazeCheckerTest {

    @Test
    void getLeftRightUpDown() {
        //given
        Maze maze = new Maze();
        maze.setMaxX(5);
        maze.setMaxY(7);
        maze.addPosition(new Position(0, 0, 0));
        maze.addPosition(new Position(1, 0, 0));
        maze.addPosition(new Position(2, 0, 0));
        maze.addPosition(new Position(3, 0, 0));
        maze.addPosition(new Position(4, 0, 0));
        maze.addPosition(new Position(0, 1, 1));
        maze.addPosition(new Position(1, 1, 1));
        maze.addPosition(new Position(2, 1, 0));
        maze.addPosition(new Position(3, 1, 0));
        maze.addPosition(new Position(4, 1, 0));
        maze.addPosition(new Position(0, 2, 0));
        maze.addPosition(new Position(1, 2, 1));
        maze.addPosition(new Position(2, 2, 1));
        maze.addPosition(new Position(3, 2, 1));
        maze.addPosition(new Position(4, 2, 0));
        maze.addPosition(new Position(0, 3, 0));
        maze.addPosition(new Position(1, 3, 0));
        maze.addPosition(new Position(2, 3, 0));
        maze.addPosition(new Position(3, 3, 1));
        maze.addPosition(new Position(4, 3, 1));
        maze.addPosition(new Position(0, 4, 0));
        maze.addPosition(new Position(1, 4, 0));
        maze.addPosition(new Position(2, 4, 0));
        maze.addPosition(new Position(3, 4, 0));
        maze.addPosition(new Position(4, 4, 1));
        maze.addPosition(new Position(0, 5, 0));
        maze.addPosition(new Position(1, 5, 0));
        maze.addPosition(new Position(2, 5, 0));
        maze.addPosition(new Position(3, 5, 0));
        maze.addPosition(new Position(4, 5, 1));
        maze.addPosition(new Position(0, 6, 0));
        maze.addPosition(new Position(1, 6, 0));
        maze.addPosition(new Position(2, 6, 1));
        maze.addPosition(new Position(3, 6, 1));
        maze.addPosition(new Position(4, 6, 1));
        MazeChecker mazeService = new MazeChecker(maze);
        //todo
        /*
        00000
        11000
        01110
        00011
        00001
        00001
        00111
        */
        //when
        Position startPosition1 = maze.getPositionByXY(0, 0);
        List<Position> leftRightUpDownPositions1 = mazeService.getLeftRightUpDown(startPosition1);
        Position startPosition2 = maze.getPositionByXY(0, 1);
        List<Position> leftRightUpDownPositions2 = mazeService.getLeftRightUpDown(startPosition2);
        Position startPosition3 = maze.getPositionByXY(4, 6);
        List<Position> leftRightUpDownPositions3 = mazeService.getLeftRightUpDown(startPosition3);
        Position startPosition4 = maze.getPositionByXY(3, 3);
        List<Position> leftRightUpDownPositions4 = mazeService.getLeftRightUpDown(startPosition4);
        //then
        assertNull(leftRightUpDownPositions1.get(0));
        assertNull(leftRightUpDownPositions1.get(1));
        assertNull(leftRightUpDownPositions1.get(2));
        assertEquals(maze.getPositionByXY(0, 1), leftRightUpDownPositions1.get(3));

        assertNull(leftRightUpDownPositions2.get(0));
        assertEquals(maze.getPositionByXY(1, 1), leftRightUpDownPositions2.get(1));
        assertNull(leftRightUpDownPositions2.get(2));
        assertNull(leftRightUpDownPositions2.get(3));

        assertEquals(maze.getPositionByXY(3, 6), leftRightUpDownPositions3.get(0));
        assertNull(leftRightUpDownPositions3.get(1));
        assertEquals(maze.getPositionByXY(4, 5), leftRightUpDownPositions3.get(2));
        assertNull(leftRightUpDownPositions3.get(3));

        assertNull(leftRightUpDownPositions4.get(0));
        assertEquals(maze.getPositionByXY(4, 3), leftRightUpDownPositions4.get(1));
        assertEquals(maze.getPositionByXY(3, 2), leftRightUpDownPositions4.get(2));
        assertNull(leftRightUpDownPositions4.get(3));
    }
}