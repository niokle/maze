package com.klenio.maze.service;

import com.klenio.maze.domain.Maze;
import com.klenio.maze.domain.Path;
import com.klenio.maze.domain.Position;
import com.klenio.maze.function.MazeChecker;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import org.jgrapht.*;
import org.jgrapht.graph.*;

@Service
public class MazeService {
    private Maze maze;
    private MazeChecker mazeChecker;

    Graph<Position, DefaultEdge> mazeGraph =
            new DefaultDirectedGraph<Position, DefaultEdge>(DefaultEdge.class);

    public MazeService(Maze maze) {
        this.maze = maze;
        mazeChecker = new MazeChecker(maze);
    }

    public List<Path> getPaths() {
        List<Path> paths = new ArrayList<>();

        fillGraph();
        AllDirectedPaths<Position, DefaultEdge> allDirectedPaths = new AllDirectedPaths<>(mazeGraph);
        List<GraphPath<Position, DefaultEdge>> allPaths = allDirectedPaths.getAllPaths(maze.getPositionByXY(0, 1),
                                                                                        maze.getPositionByXY(maze.getMaxX() - 1,
                                                                                                maze.getMaxY() - 2),
                                                                                                true, null);
        for (GraphPath<Position, DefaultEdge> graphPath : allPaths) {
            Path path = new Path();
            for (Position p : new ArrayList<>(graphPath.getVertexList())) {
                path.getPositions().add(p);
            }
            paths.add(path);
        }

        return paths;
    }

    private void fillGraph() {
        for (Position position : maze.getPositionList().stream().filter(position -> position.getMazeWallOrRoad() == 1).collect(Collectors.toList())) {
            mazeGraph.addVertex(position);
        }
        for (Position position : maze.getPositionList().stream().filter(position -> position.getMazeWallOrRoad() == 1).collect(Collectors.toList())) {
            for (Position p : mazeChecker.getLeftRightUpDown(position)) {
                if (p != null) {
                    mazeGraph.addEdge(position, p);
                    mazeGraph.addEdge(p, position);
                }
            }
        }
    }
}
