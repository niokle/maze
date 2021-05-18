package com.klenio.maze.collection;

import com.klenio.maze.domain.Maze;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
public class MazeCollection {
    private List<Maze> mazes = new ArrayList<>();

    public Maze addMaze(Maze maze) {
        mazes.add(maze);
        return maze;
    }

    public Maze getMaze(int id) {
        Maze maze = null;
        try {
            maze = mazes.get(id);
        } catch (Exception ex) {

        }
        return maze;
    }

    public List<Maze> getMazes() {
        return mazes;
    }
}
