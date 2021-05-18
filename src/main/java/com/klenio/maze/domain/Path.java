package com.klenio.maze.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Path {
    private List<Position> positions = new ArrayList<>();

    public int getNumberOfTurns() {
        int turns = 0;
        int i = 2;
        while (i < positions.size()) {
            if (positions.get(i - 2).getX() != positions.get(i).getX() &&
                    positions.get(i - 2).getY() != positions.get(i).getY()) {
                turns++;
                i = i + 2;
            } else {
                i++;
            }
        }
        return turns;
    }
}
