package crackcode;

import com.etrubenok.exercise.crackcode.LinkedListNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* LinkedListNode Tester. 
* 
* @author <Authors name> 
* @since <pre>��� 7, 2013</pre> 
* @version 1.0 
*/ 
public class LinkedListNodeTest { 

    private LinkedListNode headNode;

    @Before
    public void before() throws Exception {
        headNode = new LinkedListNode(10);
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: addNode(LinkedListNode node)
    *
    */
    @Test
    public void testAddNode() throws Exception {
        headNode.addNode(new LinkedListNode(11));
        assert(headNode.getValue() == 10 && headNode.getNext().getValue() == 11);
    }

    @Test
    public void testAddNode2() throws Exception {
        headNode.addNode(new LinkedListNode(11)).addNode(new LinkedListNode(12));
        assert(headNode.getValue() == 10 && headNode.getNext().getValue() == 11 && headNode.getNext().getNext().getValue() == 12);
    }

    /**
    *
    * Method: deleteNode(Integer val)
    *
    */
    @Test
    public void testDeleteNode() throws Exception {
        headNode.addNode(new LinkedListNode(11)).addNode(new LinkedListNode(12));
        headNode = headNode.deleteNode(10);
        assert(headNode.getValue() == 11 && headNode.getNext().getValue() == 12);
    }

    @Test
    public void testDeleteNode2() throws Exception {
        headNode.addNode(new LinkedListNode(11)).addNode(new LinkedListNode(12));
        headNode = headNode.deleteNode(11);
        assert(headNode.getValue() == 10 && headNode.getNext().getValue() == 12);
    }

    @Test
    public void testDeleteNode3() throws Exception {
        headNode.addNode(new LinkedListNode(11)).addNode(new LinkedListNode(12));
        headNode = headNode.deleteNode(12);
        assert(headNode.getValue() == 10 && headNode.getNext().getValue() == 11 && headNode.getNext().getNext() == null);
    }

    @Test
    public void testDeleteNode4() throws Exception {
        headNode.addNode(new LinkedListNode(11)).addNode(new LinkedListNode(12));
        headNode = headNode.deleteNode(12);
        assert(headNode.getValue() == 10 && headNode.getNext().getValue() == 11 && headNode.getNext().getNext() == null);
        headNode = headNode.deleteNode(10);
        assert(headNode.getValue() == 11 && headNode.getNext() == null);
        headNode = headNode.deleteNode(11);
        assert(headNode == null);
    }

    /**
    *
    * Method: getValue()
    *
    */
    @Test
    public void testGetValue() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: setValue(Integer value)
    *
    */
    @Test
    public void testSetValue() throws Exception {
    //TODO: Test goes here...
    }


} 
