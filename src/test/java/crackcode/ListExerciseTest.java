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
} 
