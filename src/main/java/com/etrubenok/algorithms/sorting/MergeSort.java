package com.etrubenok.algorithms.sorting;


import java.util.ArrayList;

public class MergeSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> a) {
        ArrayList<Integer>  _a = new ArrayList<Integer>(a);
        mergeSort(_a, 0, _a.size()-1);

        return _a;
    }

    private static void mergeSort(ArrayList<Integer> a, int p, int r) {

        if ( p < r ) {
            int q = (int) Math.floor((p + r) / 2);
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    private static void merge(ArrayList<Integer> a, int p, int q, int r) {

        ArrayList<Integer> result = new ArrayList<Integer>(a);

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        for ( int k = p; k <= q; k++ ) {
            a1.add(a.get(k));
        }
        a1.add(Integer.MAX_VALUE);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        for ( int k =  q+1; k <= r; k++ ) {
            a2.add(a.get(k));
        }
        a2.add(Integer.MAX_VALUE);

        int i = 0;
        int j = 0;
        for ( int k = p; k <= r; k++ ) {
            if ( a1.get(i) < a2.get(j) ) {
                a.set(k, a1.get(i));
                i++;
            } else {
                a.set(k, a2.get(j));
                j++;
            }
        }
    }
}
