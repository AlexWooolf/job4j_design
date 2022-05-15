package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        if (data[row].length > row) {
            rsl = true;
        } else if (data.length > 1) {
            for (int[] datum : data) {
                if (datum.length > 0) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    @Override
    public Integer next() {
        Integer rsl = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else if (data[row].length == 0) {
        while (data[row].length == 0) {
            row++;
        }
        rsl = data[row][column];
        } else if ((data[row].length != 0) && (data[row].length - 1 == column)) {
            rsl = data[row][column];
            row++;
        } else if ((data[row].length != 0)) {
            rsl = data[row][column];
            column++;
        }
        return rsl;
    }
}
