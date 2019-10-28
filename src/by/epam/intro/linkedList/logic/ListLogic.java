package by.epam.intro.linkedList.logic;

import by.epam.intro.linkedList.entity.List;
import by.epam.intro.linkedList.entity.Node;

public class ListLogic {

    public List add(List list, int value){
        Node newNode = new Node(value);
        newNode.setNext(null);
        if (list.getHead() == null) {
            list.setHead(newNode);
        }
        else {
            Node last = list.getHead();
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
        }
        return list;
    }

    public List deleteByKey(List list, int key) {
        Node currNode = list.getHead(), prev = null;
        if (currNode != null && currNode.getData() == key) {
            list.setHead(currNode.getNext());
            return list;
        }
        while (currNode != null && currNode.getData() != key) {
            prev = currNode;
            currNode = currNode.getNext();
        }
        if (currNode != null) {
            prev.setNext(currNode.getNext());
        }
        if (currNode == null) {
            return list;
        }
        return list;
    }

    public List deleteAtPosition(List list, int index) {
        Node currNode = list.getHead(), prev = null;
        if (index == 0 && currNode != null) {
            list.setHead(currNode.getNext());
            return list;
        }
        int counter = 0;
        while (currNode != null) {
            if (counter == index) {
                prev.setNext(currNode.getNext());
                break;
            }
            else {
                prev = currNode;
                currNode = currNode.getNext();
                counter++;
            }
        }
        if (currNode == null) {
            return list;
        }
        return list;
    }

    public void show(List list) {
        Node currNode = list.getHead();
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.getData() + " ");
            currNode = currNode.getNext();
        }
    }
}
