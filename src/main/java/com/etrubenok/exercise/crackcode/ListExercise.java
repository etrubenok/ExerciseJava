package com.etrubenok.exercise.crackcode;


import java.util.HashSet;
import java.util.Set;

public class ListExercise {

    public LinkedListNode deleteDuplicates(LinkedListNode head) {
        if ( head == null )
            return null;

        Set<Integer> valuesSet = new HashSet<Integer>();

        LinkedListNode currentNode = head;
        valuesSet.add(currentNode.getValue());

        while (currentNode.getNext() != null )
        {
            currentNode = currentNode.getNext();
            if ( valuesSet.contains(currentNode.getValue()) ) {
                head = head.deleteNode(currentNode.getValue());
            }
            else {
                valuesSet.add(currentNode.getValue());
            }
        }
        return head;
    }

    public LinkedListNode deleteDuplicatesNoBuffer(LinkedListNode head) {
        if ( head == null )
            return null;

        LinkedListNode currentNode = head;

        while (currentNode.getNext() != null ) {
            currentNode = currentNode.getNext();

            LinkedListNode runningNode = head;

            while (runningNode != currentNode ) {
                if ( runningNode.getValue() == currentNode.getValue() ) {
                    head = head.deleteNode(runningNode.getValue());
                }

                runningNode = runningNode.getNext();
            }
        }

        return head;
    }

    public int getListSize(LinkedListNode head) {
        if ( head == null )
            return 0;

        LinkedListNode currentNode = head;
        int size = 1;

        while ( currentNode.getNext() != null ) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

//    public LinkedListNode findNthNodeFromTail(LinkedListNode head, int n) {
//        if ( n < 0 )
//            throw new IllegalArgumentException("N is out of bounds");
//
//        int size = getListSize(head);
//        int nFromHead = size - n;
//
//        if ( nFromHead <= 0 ) {
//           throw new IllegalArgumentException("N is out of bounds");
//        }
//
//        LinkedListNode currentNode = head;
//
//        for ( int i = 1; i < nFromHead; i++ ) {
//            currentNode = currentNode.getNext();
//        }
//
//        return currentNode;
//    }

    public LinkedListNode findNthNodeFromTail(LinkedListNode head, int n) {
        if ( n < 0 )
            throw new IllegalArgumentException("N is out of bounds");


        LinkedListNode currentNode1 = head;
        LinkedListNode currentNode2 = head;

        for ( int i = 0; i < n; i++ ) {
            currentNode1 = currentNode1.getNext();
            if ( currentNode1 == null )
                throw new IllegalArgumentException("N is out of bounds");
        }

        while ( currentNode1.getNext() != null ) {
            currentNode1 = currentNode1.getNext();
            currentNode2 = currentNode2.getNext();
        }

        return currentNode2;
    }

    public void deleteMiddleNode(LinkedListNode node) {

        LinkedListNode currentNode = node;

        if ( currentNode.getNext() == null ) {
            throw new IllegalArgumentException("Node must not be the last node of the list");
        }

        currentNode.setValue(currentNode.getNext().getValue());
        currentNode.setNext(currentNode.getNext().getNext());
    }
}
