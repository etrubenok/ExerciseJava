package com.etrubenok.exercise.crackcode;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene
 * Date: 07.10.13
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListNode {
    private LinkedListNode next = null;
    private Integer value;

    public LinkedListNode(Integer value) {
        this.value = value;
    }

    public LinkedListNode addNode(LinkedListNode node) {

        LinkedListNode currentNode = this;
        while ( currentNode.next != null ) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return this;
    }

    public LinkedListNode deleteNode(Integer val) {
        LinkedListNode currentNode = this;

        if ( val.equals(currentNode.value) ) {
            return currentNode.next;      //shift the head of the list
        }

        while ( currentNode.next != null ) {
            if ( val.equals(currentNode.next.value) )
            {
                currentNode.next = currentNode.next.next;
                break;
            }
            currentNode = currentNode.next;
        }
        return this;
    }

    public LinkedListNode getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
