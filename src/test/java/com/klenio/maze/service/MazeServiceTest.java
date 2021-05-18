package com.klenio.maze.service;

import com.klenio.maze.domain.Maze;
import com.klenio.maze.domain.Path;
import com.klenio.maze.domain.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MazeServiceTest {

    @Test
    void getPaths() {
        //given
        Maze maze1 = new Maze();
        maze1.setMaxX(9);
        maze1.setMaxY(8);
        maze1.addPosition(new Position(0, 0, 0));
        maze1.addPosition(new Position(1, 0, 0));
        maze1.addPosition(new Position(2, 0, 0));
        maze1.addPosition(new Position(3, 0, 0));
        maze1.addPosition(new Position(4, 0, 0));
        maze1.addPosition(new Position(5, 0, 0));
        maze1.addPosition(new Position(6, 0, 0));
        maze1.addPosition(new Position(7, 0, 0));
        maze1.addPosition(new Position(8, 0, 0));
        maze1.addPosition(new Position(0, 1, 1));
        maze1.addPosition(new Position(1, 1, 1));
        maze1.addPosition(new Position(2, 1, 1));
        maze1.addPosition(new Position(3, 1, 1));
        maze1.addPosition(new Position(4, 1, 0));
        maze1.addPosition(new Position(5, 1, 1));
        maze1.addPosition(new Position(6, 1, 1));
        maze1.addPosition(new Position(7, 1, 1));
        maze1.addPosition(new Position(8, 1, 0));
        maze1.addPosition(new Position(0, 2, 0));
        maze1.addPosition(new Position(1, 2, 1));
        maze1.addPosition(new Position(2, 2, 0));
        maze1.addPosition(new Position(3, 2, 1));
        maze1.addPosition(new Position(4, 2, 0));
        maze1.addPosition(new Position(5, 2, 1));
        maze1.addPosition(new Position(6, 2, 0));
        maze1.addPosition(new Position(7, 2, 1));
        maze1.addPosition(new Position(8, 2, 0));
        maze1.addPosition(new Position(0, 3, 0));
        maze1.addPosition(new Position(1, 3, 1));
        maze1.addPosition(new Position(2, 3, 0));
        maze1.addPosition(new Position(3, 3, 1));
        maze1.addPosition(new Position(4, 3, 1));
        maze1.addPosition(new Position(5, 3, 1));
        maze1.addPosition(new Position(6, 3, 0));
        maze1.addPosition(new Position(7, 3, 1));
        maze1.addPosition(new Position(8, 3, 0));
        maze1.addPosition(new Position(0, 4, 0));
        maze1.addPosition(new Position(1, 4, 1));
        maze1.addPosition(new Position(2, 4, 0));
        maze1.addPosition(new Position(3, 4, 0));
        maze1.addPosition(new Position(4, 4, 0));
        maze1.addPosition(new Position(5, 4, 0));
        maze1.addPosition(new Position(6, 4, 0));
        maze1.addPosition(new Position(7, 4, 1));
        maze1.addPosition(new Position(8, 4, 0));
        maze1.addPosition(new Position(0, 5, 0));
        maze1.addPosition(new Position(1, 5, 1));
        maze1.addPosition(new Position(2, 5, 1));
        maze1.addPosition(new Position(3, 5, 1));
        maze1.addPosition(new Position(4, 5, 1));
        maze1.addPosition(new Position(5, 5, 0));
        maze1.addPosition(new Position(6, 5, 0));
        maze1.addPosition(new Position(7, 5, 1));
        maze1.addPosition(new Position(8, 5, 0));
        maze1.addPosition(new Position(0, 6, 0));
        maze1.addPosition(new Position(1, 6, 1));
        maze1.addPosition(new Position(2, 6, 0));
        maze1.addPosition(new Position(3, 6, 0));
        maze1.addPosition(new Position(4, 6, 1));
        maze1.addPosition(new Position(5, 6, 1));
        maze1.addPosition(new Position(6, 6, 1));
        maze1.addPosition(new Position(7, 6, 1));
        maze1.addPosition(new Position(8, 6, 1));
        maze1.addPosition(new Position(0, 7, 0));
        maze1.addPosition(new Position(1, 7, 0));
        maze1.addPosition(new Position(2, 7, 0));
        maze1.addPosition(new Position(3, 7, 0));
        maze1.addPosition(new Position(4, 7, 0));
        maze1.addPosition(new Position(5, 7, 0));
        maze1.addPosition(new Position(6, 7, 0));
        maze1.addPosition(new Position(7, 7, 0));
        maze1.addPosition(new Position(8, 7, 0));
        MazeService mazeService1 = new MazeService(maze1);
        /*
        000000000
        111101110
        010101010
        010111010
        010000010
        011110010
        010011111
        000000000
        */

        Maze maze2 = new Maze();
        maze2.setMaxX(4);
        maze2.setMaxY(4);
        maze2.addPosition(new Position(0, 0, 0));
        maze2.addPosition(new Position(1, 0, 0));
        maze2.addPosition(new Position(2, 0, 0));
        maze2.addPosition(new Position(3, 0, 0));
        maze2.addPosition(new Position(0, 1, 1));
        maze2.addPosition(new Position(1, 1, 0));
        maze2.addPosition(new Position(2, 1, 0));
        maze2.addPosition(new Position(3, 1, 0));
        maze2.addPosition(new Position(0, 2, 0));
        maze2.addPosition(new Position(1, 2, 0));
        maze2.addPosition(new Position(2, 2, 0));
        maze2.addPosition(new Position(3, 2, 1));
        maze2.addPosition(new Position(0, 3, 0));
        maze2.addPosition(new Position(1, 3, 0));
        maze2.addPosition(new Position(2, 3, 0));
        maze2.addPosition(new Position(3, 3, 0));
        MazeService mazeService2 = new MazeService(maze2);
        /*
        0000
        1000
        0001
        0000
         */

        //when
        List<Path> paths1 = mazeService1.getPaths();
        List<Path> paths2 = mazeService2.getPaths();
        //then
        assertEquals(2, paths1.size());
        assertEquals(0, paths2.size());
    }
}