package algorithms.sorting;

import com.etrubenok.algorithms.sorting.MaximumSubarrayFinder;
import com.etrubenok.algorithms.sorting.Subarray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MaximumSubarrayFinderTest {
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {

    }

    @Test
    public void findTest() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(9);
        a.add(-1);
        a.add(0);

        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 0 && r.rightIndex == 0 && r.sum ==9);

    }

    @Test
    public void findTest1() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);


        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 0 && r.rightIndex == 0 && r.sum ==1);

    }

    @Test
    public void findTest2() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-3);
        a.add(2);

        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 1 && r.rightIndex == 1 && r.sum ==2);

    }

    @Test
    public void findTest3() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-3);
        a.add(-1);

        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 1 && r.rightIndex == 1 && r.sum ==-1);

    }

    @Test
    public void findTest4() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 0 && r.rightIndex == 3 && r.sum ==10);

    }

    @Test
    public void findTest5() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(-3);

        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 0 && r.rightIndex == 0 && r.sum ==2);

    }

    @Test
    public void findTest6() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(13);
        a.add(-3);
        a.add(-25);
        a.add(20);
        a.add(-3);
        a.add(-16);
        a.add(-23);
        a.add(18);
        a.add(20);
        a.add(-7);
        a.add(12);
        a.add(-5);
        a.add(-22);
        a.add(15);
        a.add(-4);
        a.add(7);

        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 7 && r.rightIndex == 10 && r.sum ==43);

    }

    @Test
    public void findTest7() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(-4);
        a.add(3);
        a.add(-4);


        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 2 && r.rightIndex == 2 && r.sum ==3);

    }

    @Test
    public void findTest8() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-2);
        a.add(-3);
        a.add(-1);
        a.add(-4);
        a.add(-5);

        Subarray r = MaximumSubarrayFinder.find(a);
        assert(r.leftIndex == 2 && r.rightIndex == 2 && r.sum ==-1);

    }

    @Test
    public void findViaIterationsTest() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(9);
        a.add(-1);
        a.add(0);

        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 0 && r.rightIndex == 0 && r.sum ==9);

    }

    @Test
    public void findViaIterationsTest1() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);


        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 0 && r.rightIndex == 0 && r.sum ==1);

    }

    @Test
    public void findViaIterationsTest2() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-3);
        a.add(2);

        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 1 && r.rightIndex == 1 && r.sum ==2);

    }

    @Test
    public void findViaIterationsTest3() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-3);
        a.add(-1);

        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 1 && r.rightIndex == 1 && r.sum ==-1);

    }

    @Test
    public void findViaIterationsTest4() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 0 && r.rightIndex == 3 && r.sum ==10);

    }

    @Test
    public void findViaIterationsTest5() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(-3);

        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 0 && r.rightIndex == 0 && r.sum ==2);

    }

    @Test
    public void findViaIterationsTest6() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(13);
        a.add(-3);
        a.add(-25);
        a.add(20);
        a.add(-3);
        a.add(-16);
        a.add(-23);
        a.add(18);
        a.add(20);
        a.add(-7);
        a.add(12);
        a.add(-5);
        a.add(-22);
        a.add(15);
        a.add(-4);
        a.add(7);

        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 7 && r.rightIndex == 10 && r.sum ==43);

    }

    @Test
    public void findViaIterationsTest7() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(-4);
        a.add(3);
        a.add(-4);


        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 2 && r.rightIndex == 2 && r.sum ==3);

    }

    @Test
    public void findViaIterationsTest8() throws Exception {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-2);
        a.add(-3);
        a.add(-1);
        a.add(-4);
        a.add(-5);

        Subarray r = MaximumSubarrayFinder.findViaIterations(a);
        assert(r.leftIndex == 2 && r.rightIndex == 2 && r.sum ==-1);

    }
}
