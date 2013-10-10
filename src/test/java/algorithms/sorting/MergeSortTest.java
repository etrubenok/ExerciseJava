package algorithms.sorting;


import com.etrubenok.algorithms.sorting.MergeSort;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;

public class MergeSortTest {

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {

    }

    @Test
    public void sortTest() throws Exception {

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0, 2);
        a.add(1, 1);
        a.add(2, 0);

        ArrayList<Integer> r = MergeSort.sort(a);
        assert(r.get(0) == 0 && r.get(1) == 1 && r.get(2) == 2);
    }

    @Test
    public void sortTest2() throws Exception {

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0, 2);
        a.add(1, 1);
        a.add(2, 0);
        a.add(3, 1);

        ArrayList<Integer> r = MergeSort.sort(a);
        assert(r.get(0) == 0 && r.get(1) == 1 && r.get(2) == 1 && r.get(3) == 2);
    }

    @Test
    public void sortTest3() throws Exception {

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0, 2);

        ArrayList<Integer> r = MergeSort.sort(a);
        assert(r.get(0) == 2);
    }

    @Test
    public void sortTest4() throws Exception {

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(1);

        ArrayList<Integer> r = MergeSort.sort(a);
        assert(r.get(0) == 1 && r.get(1) == 2);
    }

    @Test
    public void sortTest5() throws Exception {

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(1);
        a.add(10);
        a.add(4);
        a.add(3);

        ArrayList<Integer> r = MergeSort.sort(a);
        assert(r.get(0) == 1 && r.get(1) == 2 && r.get(2) == 3 && r.get(3) == 4 && r.get(4) == 10);
    }

    @Test
    public void sortTest6() throws Exception {

        ArrayList<Integer> a = new ArrayList<Integer>();

        ArrayList<Integer> r = MergeSort.sort(a);
        assert(r.isEmpty());
    }
}
