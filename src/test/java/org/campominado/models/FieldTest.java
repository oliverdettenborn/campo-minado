package org.campominado.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FieldTest {

    @ParameterizedTest
    @CsvSource({
            "3,3, 2,2, true",
            "3,3, 2,3, true",
            "3,3, 2,4, true",
            "3,3, 3,2, true",
            "3,3, 3,4, true",
            "3,3, 4,2, true",
            "3,3, 4,3, true",
            "3,3, 4,4, true",
            "3,3, 3,3, false",
            "1,1, 0,0, false",
            "1,1, 1,0, false",
            "1,1, 0,1, false",
            "1,1, 1,2, true",
            "1,1, 2,2, true",
            "1,1, 2,1, true",
            "1,1, 1,3, false",
            "1,1, 2,3, false",
            "1,1, 3,3, false",
            "1,1, 3,2, false",
            "1,1, 3,1, false"
    })
    void shouldReturnIfAddNeighbor(int lin1, int col1, int lin2, int col2, boolean expected) {
        final Field field = new Field(lin1,col1);
        final Field possibleNeighbor = new Field(lin2, col2);

        Assertions.assertEquals(expected, field.addNeighbor(possibleNeighbor));
    }
}