package com.klenio.maze.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Position {
    private int x;
    private int y;
    private int mazeWallOrRoad;

    public Position(int x, int y, int mazeWallOrRoad) {
        this.x = x;
        this.y = y;
        this.mazeWallOrRoad = mazeWallOrRoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && mazeWallOrRoad == position.mazeWallOrRoad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, mazeWallOrRoad);
    }
}
