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
}
