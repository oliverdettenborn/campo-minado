package org.campominado.models;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private final Integer line;
    private final Integer column;
    private final FieldStatus status;
    private final List<Field> neighborhoods = new ArrayList<>();

    public Field(final Integer line, final Integer column, FieldStatus status) {
        this.line = line;
        this.column = column;
        this.status = status;
    }

    public Field(final Integer line, final Integer column) {
        this.line = line;
        this.column = column;
        this.status = null;
    }

    boolean addNeighbor(final Field possibleNeighbor) {
        if(possibleNeighbor.line == 0 || possibleNeighbor.column  == 0) return false;

        final Integer deltaLine = line - possibleNeighbor.line;
        final Integer deltaColumn = column - possibleNeighbor.column;
        final Integer finalDelta = Math.abs(deltaLine) + Math.abs(deltaColumn);

        final boolean isDiagonal = line != possibleNeighbor.line && column != possibleNeighbor.column;
        final boolean isCross = line == possibleNeighbor.line || column == possibleNeighbor.column;

        boolean canAdd = (isCross && finalDelta == 1) || (isDiagonal && finalDelta == 2);

        if (canAdd) neighborhoods.add(possibleNeighbor);

        return canAdd;
    }
}
