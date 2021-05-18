package com.klenio.maze.collection;

import com.klenio.maze.domain.Maze;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Component
public class MazeCollection {
    private List<Maze> mazes = new ArrayList<>();

    public Maze addMaze(Maze maze) {
        mazes.add(maze);
        return maze;
    }
}
