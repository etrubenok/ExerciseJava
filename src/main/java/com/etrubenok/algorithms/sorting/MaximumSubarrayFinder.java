package com.etrubenok.algorithms.sorting;


import java.util.ArrayList;

public class MaximumSubarrayFinder {
    public static Subarray find(ArrayList<Integer> a) {
        return findInner(a, 0, a.size()-1);
    }

    public static Subarray findViaIterations(ArrayList<Integer> a) {

        Subarray r = new Subarray(a.get(0), 0, 0);

        for ( int i = 1; i < a.size(); i++ ) {
            int sum2 = 0;
            int prevSum = a.get(i);
            int leftIndex = i;
            for ( int j = i; j >=r.leftIndex; j-- ) {
                sum2 += a.get(j);
                if ( sum2 > prevSum ) {
                    prevSum = sum2;
                    leftIndex = j;
                }
            }

            if ( prevSum > r.sum ) {
                r.sum = prevSum;
                r.leftIndex = leftIndex;
                r.rightIndex = i;
            }
        }
        return r;
    }
    private static Subarray findInner(ArrayList<Integer> a, int leftIndex, int rightIndex) {

        if ( leftIndex < rightIndex )
        {
            int midIndex = (int)Math.floor( ( rightIndex + leftIndex ) / 2 );
            Subarray left = findInner(a, leftIndex, midIndex);
            Subarray right = findInner(a, midIndex+1, rightIndex);
            Subarray crossed = findCrossedSubarray(a, leftIndex, midIndex, rightIndex);

            if ( left.sum > right.sum && left.sum > crossed.sum ) {
                return left;
            } else if ( right.sum > left.sum && right.sum > crossed.sum ) {
                return right;
            } else {
                return crossed;
            }
        } else {
            return new Subarray(a.get(leftIndex), leftIndex, rightIndex);
        }

    }

    private static Subarray findCrossedSubarray(ArrayList<Integer> a, int leftIndex, int midIndex, int rightIndex) {

        int leftBorder = midIndex;
        int leftSum = a.get(midIndex);
        int sum = 0;
        for ( int i = midIndex; i >= leftIndex; i-- ) {
            sum += a.get(i);
            if ( sum > leftSum )
            {
                leftSum = sum;
                leftBorder = i;
            }
        }

        int rightBorder = midIndex;
        int rightSum = 0;
        sum = 0;
        for ( int i = midIndex+1; i <= rightIndex; i++ ) {
            sum += a.get(i);
            if ( sum > rightSum ) {
                rightSum = sum;
                rightBorder = i;
            }
        }
        return new Subarray(leftSum + rightSum, leftBorder, rightBorder);
    }
}
