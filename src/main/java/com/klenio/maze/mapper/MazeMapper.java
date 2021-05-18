package com.klenio.maze.mapper;

import com.klenio.maze.domain.Maze;
import com.klenio.maze.domain.Position;
import com.klenio.maze.exception.IncorrectDataExeption;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class MazeMapper {
    public Maze mazeDtoToMaze(String mazeDto) throws IncorrectDataExeption {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(mazeDto);
        String xy = scanner.nextLine();
        maze.setMaxX(Integer.parseInt(xy.split(",")[0]));
        maze.setMaxY(Integer.parseInt(xy.split(",")[1]));
        int x = 0;
        int y = 0;
        List<Integer> check = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            check.add(line.length());
            for (char c : line.toCharArray()) {
                maze.addPosition(new Position(x, y, Integer.parseInt(String.valueOf(c))));
                x++;
            }
            x = 0;
            y++;
        }
        if (isCorrectData(maze, check)) {
            return maze;
        } else {
            throw new IncorrectDataExeption("incorrect input data");
        }
    }

    private boolean isCorrectData(Maze maze, List<Integer> check) {
        int y = (int) check.stream().filter(x -> x >= 7 && x <= 10000 && x == maze.getMaxX()).count();
        return y == maze.getMaxY() && y >= 7 && y <= 10000 && maze.getPositionByXY(0, 1).getMazeWallOrRoad() == 1 &&
                maze.getPositionByXY(maze.getMaxX() - 1, maze.getMaxY() - 2).getMazeWallOrRoad() == 1;
    }

}
