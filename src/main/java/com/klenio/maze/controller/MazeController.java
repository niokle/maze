package com.klenio.maze.controller;

import com.klenio.maze.collection.MazeCollection;
import com.klenio.maze.domain.Maze;
import com.klenio.maze.exception.IncorrectDataExeption;
import com.klenio.maze.mapper.MazeMapper;
import com.klenio.maze.service.MazeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class MazeController {

    @Autowired
    private MazeMapper mazeMapper;

    @Autowired
    private MazeCollection mazeCollection;

    @PostMapping("/maze")
    public int createMazeObject(@RequestBody String mazeDto) throws IncorrectDataExeption {
        MazeService mazeService = new MazeService(mazeCollection.addMaze(mazeMapper.mazeDtoToMaze(mazeDto)));
        return mazeService.getSmallestNumberOfTurns();
    }

    @GetMapping("/mazes")
    public List<Maze> getAllMazes() {
        return mazeCollection.getMazes();
    }

    @GetMapping("/maze/{id}")
    public Maze getMaze(@PathVariable int id) {
        return mazeCollection.getMaze(id);
    }
}
