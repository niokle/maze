package com.klenio.maze.controller;

import com.klenio.maze.mapper.MazeMapper;
import com.klenio.maze.service.MazeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MazeController {

    @Autowired
    private MazeMapper mazeMapper;

    @PostMapping("/maze")
    public int createMazeObject(@RequestBody String mazeDto) {
        MazeService mazeService = new MazeService(mazeMapper.mazeDtoToMaze(mazeDto));
        return mazeService.getSmallestNumberOfTurns();
    }
}
