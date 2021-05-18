package com.klenio.maze.function;

import com.klenio.maze.domain.Maze;
import com.klenio.maze.domain.Position;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Component
public class MazeChecker {
    private Maze maze;

    public int getNumberOfMoves(Position currentPosition) {
        return (int) (4 - getLeftRightUpDown(currentPosition).stream().filter(Objects::isNull).count());
    }

    public List<Position> getLeftRightUpDown(Position currentPosition) {
        List<Position> positions = new ArrayList<>();
        positions.add(getLeftPosition(currentPosition));
        positions.add(getRightPosition(currentPosition));
        positions.add(getUpPosition(currentPosition));
        positions.add(getDownPosition(currentPosition));
        return positions;
    }

    private Position getLeftPosition(Position currentPosition) {
        Position position = maze.getPositionByXY(currentPosition.getX() - 1, currentPosition.getY());
        if (position != null && position.getMazeWallOrRoad() == 1 ) {
            return position;
        }
        return null;
    }

    private Position getRightPosition(Position currentPosition) {
        Position position = maze.getPositionByXY(currentPosition.getX() + 1, currentPosition.getY());
        if (position != null && position.getMazeWallOrRoad() == 1) {
            return position;
        }
        return null;
    }

    private Position getDownPosition(Position currentPosition) {
        Position position = maze.getPositionByXY(currentPosition.getX(), currentPosition.getY() + 1);
        if (position != null && position.getMazeWallOrRoad() == 1) {
            return position;
        }
        return null;
    }

    private Position getUpPosition(Position currentPosition) {
        Position position = maze.getPositionByXY(currentPosition.getX(), currentPosition.getY() - 1);
        if (position != null && position.getMazeWallOrRoad() == 1) {
            return position;
        }
        return null;
    }
}
