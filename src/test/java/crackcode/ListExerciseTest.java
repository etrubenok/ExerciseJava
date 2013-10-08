package crackcode;

import com.etrubenok.exercise.crackcode.LinkedListNode;
import com.etrubenok.exercise.crackcode.ListExercise;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* ListExercise Tester. 
* 
* @author <Authors name> 
* @since <pre>��� 7, 2013</pre> 
* @version 1.0 
*/ 
public class ListExerciseTest { 

    private LinkedListNode head;
    private ListExercise exerciseObj;

    @Before
    public void before() throws Exception {
        exerciseObj = new ListExercise();
        head = new LinkedListNode(3).addNode(new LinkedListNode(10)).addNode(new LinkedListNode(10)).addNode(new LinkedListNode(11)).addNode(new LinkedListNode(11));
        head.addNode(new LinkedListNode(11)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(11)).addNode(new LinkedListNode(10));
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: deleteDuplicates(LinkedListNode head)
    *
    */
    @Test
    public void testDeleteDuplicates() throws Exception {
        head = exerciseObj.deleteDuplicates(head);
        assert(head.getValue() == 3 &&
               head.getNext().getValue() == 11 &&
                head.getNext().getNext().getValue() == 10 &&
                head.getNext().getNext().getNext() == null);

    }

    @Test
    public void testDeleteDuplicates2() throws Exception {
        head = new LinkedListNode(3);

        head = exerciseObj.deleteDuplicates(head);
        assert(head.getValue() == 3 &&
                head.getNext() == null);

    }

    @Test
    public void testDeleteDuplicates3() throws Exception {
        head = new LinkedListNode(3).addNode(new LinkedListNode(3));

        head = exerciseObj.deleteDuplicates(head);
        assert(head.getValue() == 3 &&
                head.getNext() == null);

    }

    @Test
    public void testDeleteDuplicatesNoBuffer() throws Exception {
        head = exerciseObj.deleteDuplicatesNoBuffer(head);
        assert(head.getValue() == 3 &&
                head.getNext().getValue() == 11 &&
                head.getNext().getNext().getValue() == 10 &&
                head.getNext().getNext().getNext() == null);

    }

    @Test
    public void testDeleteDuplicatesNoBuffer2() throws Exception {
        head = new LinkedListNode(3);

        head = exerciseObj.deleteDuplicatesNoBuffer(head);
        assert(head.getValue() == 3 &&
                head.getNext() == null);


    }

    @Test
    public void testDeleteDuplicatesNoBuffer3() throws Exception {
        head = new LinkedListNode(3).addNode(new LinkedListNode(3));

        head = exerciseObj.deleteDuplicatesNoBuffer(head);
        assert(head.getValue() == 3 &&
                head.getNext() == null);


    }

    @Test
    public void testDeleteDuplicatesNoBuffer4() throws Exception {
        head = null;

        head = exerciseObj.deleteDuplicatesNoBuffer(head);
        assert(head == null);


    }

    @Test
    public void testGetListSize() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(new LinkedListNode(9));

        int size = exerciseObj.getListSize(head);
        assert(size == 9);
    }

    @Test
    public void testFindNthNodeFromTail() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(new LinkedListNode(9));

        LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, 5);
        assert(nthNode.getValue() == 4);
    }

    @Test
         public void testFindNthNodeFromTail2() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(new LinkedListNode(9));

        LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, 8);
        assert(nthNode.getValue() == 1);
    }

    @Test
    public void testFindNthNodeFromTail3() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(new LinkedListNode(9));

        LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, 0);
        assert(nthNode.getValue() == 9);
    }

    @Test
    public void testFindNthNodeFromTail4() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(new LinkedListNode(9));

        Throwable caught = null;
        try {
            LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, -1);
        } catch (Throwable e) {
            caught = e;
        }

        assert(caught != null && caught.getClass() == IllegalArgumentException.class);
    }

    @Test
    public void testFindNthNodeFromTail5() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(new LinkedListNode(9));

        Throwable caught = null;
        try {
            LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, 10);
        } catch (Throwable e) {
            caught = e;
        }
        assert(caught != null && caught.getClass() == IllegalArgumentException.class);
    }

    @Test
    public void testFindNthNodeFromTail6() throws Exception {
        head = new LinkedListNode(1);

        Throwable caught = null;
        try {
            LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, 1);
        } catch (Throwable e) {
            caught = e;
        }
        assert(caught != null && caught.getClass() == IllegalArgumentException.class);
    }

    @Test
    public void testFindNthNodeFromTail7() throws Exception {
        head = new LinkedListNode(1);

        LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, 0);
        assert(nthNode.getValue() == 1);
    }

    @Test
    public void testFindNthNodeFromTail8() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2));

        LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, 1);
        assert(nthNode.getValue() == 1);
    }

    @Test
    public void testFindNthNodeFromTail9() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2));

        Throwable caught = null;
        try {
            LinkedListNode nthNode = exerciseObj.findNthNodeFromTail(head, 2);
        } catch (Throwable e) {
            caught = e;
        }
        assert(caught != null && caught.getClass() == IllegalArgumentException.class);
    }

    @Test
    public void testDeleteMiddleNode() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        LinkedListNode middleNode = new LinkedListNode(6);
        head.addNode(middleNode).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(new LinkedListNode(9));

        exerciseObj.deleteMiddleNode(middleNode);

        assert(head.getValue() == 1 &&
                head.getNext().getValue() == 2 &&
                head.getNext().getNext().getValue() == 3 &&
                head.getNext().getNext().getNext().getValue() == 4 &&
                head.getNext().getNext().getNext().getNext().getValue() == 5 &&
                head.getNext().getNext().getNext().getNext().getNext().getValue() == 7 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getValue() == 8 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getValue() == 9 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext() == null);

    }

    @Test
    public void testDeleteMiddleNode2() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        LinkedListNode middleNode = new LinkedListNode(9);
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(middleNode);

        Throwable caught = null;
        try {
            exerciseObj.deleteMiddleNode(middleNode);
        } catch (Throwable e) {
            caught = e;
        }
        assert(caught != null && caught.getClass() == IllegalArgumentException.class);
    }

    @Test
    public void testDeleteMiddleNode3() throws Exception {
        head = new LinkedListNode(1).addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        LinkedListNode middleNode = new LinkedListNode(8);
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(middleNode).addNode(new LinkedListNode(9));

        exerciseObj.deleteMiddleNode(middleNode);

        assert(head.getValue() == 1 &&
                head.getNext().getValue() == 2 &&
                head.getNext().getNext().getValue() == 3 &&
                head.getNext().getNext().getNext().getValue() == 4 &&
                head.getNext().getNext().getNext().getNext().getValue() == 5 &&
                head.getNext().getNext().getNext().getNext().getNext().getValue() == 6 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getValue() == 7 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getValue() == 9 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext() == null);

    }

    @Test
    public void testDeleteMiddleNode4() throws Exception {
        LinkedListNode middleNode = new LinkedListNode(1);

        head = middleNode.addNode(new LinkedListNode(2)).addNode(new LinkedListNode(3)).addNode(new LinkedListNode(4)).addNode(new LinkedListNode(5));
        head.addNode(new LinkedListNode(6)).addNode(new LinkedListNode(7)).addNode(new LinkedListNode(8)).addNode(new LinkedListNode(9));

        exerciseObj.deleteMiddleNode(middleNode);

        assert(head.getValue() == 2 &&
                head.getNext().getValue() == 3 &&
                head.getNext().getNext().getValue() == 4 &&
                head.getNext().getNext().getNext().getValue() == 5 &&
                head.getNext().getNext().getNext().getNext().getValue() == 6 &&
                head.getNext().getNext().getNext().getNext().getNext().getValue() == 7 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getValue() == 8 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getValue() == 9 &&
                head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext() == null);

    }
} 
