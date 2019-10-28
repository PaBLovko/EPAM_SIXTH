package by.epam.intro.linkedList.entity;

public class List {

    private Node head;

    public List(){
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node elem) {
        this.head = elem;
    }
}
