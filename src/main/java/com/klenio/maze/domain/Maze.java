package com.klenio.maze.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Maze {
    private List<Position> positionList = new ArrayList<>();
    private int maxX;
    private int maxY;

    public void addPosition(Position position) {
        positionList.add(position);
    }

    public Integer getWallOrRoad(int x, int y) {
        Position position = positionList.stream().filter(p -> p.getX() == x && p.getY() == y).findFirst().orElse(null);
        return position == null ? null : position.getMazeWallOrRoad();
    }
}
