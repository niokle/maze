package com.klenio.maze.controller;

import com.klenio.maze.collection.MazeCollection;
import com.klenio.maze.domain.Maze;
import com.klenio.maze.exception.IncorrectDataExeption;
import com.klenio.maze.mapper.MazeMapper;
import com.klenio.maze.service.FileService;
import com.klenio.maze.service.MazeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class MazeController {

    @Autowired
    private MazeMapper mazeMapper;

    @Autowired
    private MazeCollection mazeCollection;

    @Autowired
    private FileService fileService;

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

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public int importFile(@RequestParam("file") MultipartFile file) throws IOException, IncorrectDataExeption {
        MazeService mazeService = new MazeService(mazeCollection.addMaze(mazeMapper.mazeDtoToMaze(fileService.getDataFromFile(file))));
        return mazeService.getSmallestNumberOfTurns();
     }
}
