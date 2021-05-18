package com.klenio.maze.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Position {
    private int x;
    private int y;
    private int mazeWallOrRoad;
    private Position leftPosition;
    private Position rightPosition;
    private Position upPosition;
    private Position downPosition;
    private boolean leftNodeAvailable;
    private boolean rightNodeAvailable;
    private boolean upNodeAvailable;
    private boolean downNodeAvailable;

    public Position(int x, int y, int mazeWallOrRoad) {
        this.x = x;
        this.y = y;
        this.mazeWallOrRoad = mazeWallOrRoad;
    }
}
