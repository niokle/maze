package com.klenio.maze.mapper;

import com.klenio.maze.domain.Maze;
import com.klenio.maze.domain.Position;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MazeMapper {
    public Maze mazeDtoToMaze(String mazeDto) {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(mazeDto);
        String xy = scanner.nextLine();
        maze.setMaxX(Integer.parseInt(xy.split(",")[0]));
        maze.setMaxY(Integer.parseInt(xy.split(",")[1]));
        int x = 0;
        int y = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (char c : line.toCharArray()) {
                maze.addPosition(new Position(x, y, Integer.parseInt(String.valueOf(c))));
                x++;
            }
            x = 0;
            y++;
        }
        return maze;
    }
}
