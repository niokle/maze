package com.klenio.mazerest.mapper;

import com.klenio.maze.domain.Maze;
import com.klenio.maze.mapper.MazeMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeMapperTest {

    @Test
    void mazeDtoToMaze() {
        //given
        MazeMapper mazeMapper = new MazeMapper();
        String mazeDto = "9,8\n" +
                "000000000\n" +
                "111101110\n" +
                "010101010\n" +
                "010111010\n" +
                "010000010\n" +
                "011110010\n" +
                "010011111\n" +
                "000000000";
        //when
        Maze maze = mazeMapper.mazeDtoToMaze(mazeDto);
        //then
        assertEquals(9, maze.getMaxX());
        assertEquals(8, maze.getMaxY());
        assertEquals(0, maze.getWallOrRoad(0, 0));
        assertEquals(0, maze.getWallOrRoad(8, 7));
        assertEquals(1, maze.getWallOrRoad(3, 5));
        assertEquals(1, maze.getWallOrRoad(3, 5));
        assertEquals(1, maze.getWallOrRoad(6, 1));
    }
}