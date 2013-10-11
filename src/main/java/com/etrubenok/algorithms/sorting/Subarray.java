package com.etrubenok.algorithms.sorting;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene
 * Date: 11.10.13
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
public class Subarray {
    public int sum = -1;
    public int leftIndex = -1;
    public int rightIndex = -1;

    public Subarray(int sum, int leftIndex, int rightIndex) {
        this.sum = sum;
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }
}
