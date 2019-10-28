package by.epam.intro.linkedList.entity;

public class Node {
    private int data;
    private Node next;
    private Node previous;

    public Node(int data, Node previous) {
        this.data = data;
        this.next = null;
        this.previous = previous;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}