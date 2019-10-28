package by.epam.intro.linkedList.logic;

import by.epam.intro.linkedList.entity.List;
import by.epam.intro.linkedList.entity.Node;

public class ListLogic {

    public void add(List list, int value){
        list.getElem().setNext(new Node(value,list.getElem()));
    }

    public void delete(List list, int value){

    }

    public Node search(List list, int value){
        if(list.getElem() == null){
            return null;
        }
        return search(list.getElem(),value);
    }

    private Node search(List list, int value){
        if (list.getElem() == null){
            return null;
        }
        return search(list.getElem(),value);
    }

    private Node searchParent (Node node, int value) {
        if (value > node.getData()) {
            if (node.getRight() == null) {
                return null;
            }
            if (node.getRight().getData() == value) {
                return node;
            }
            return searchParent(node.getRight(), value);
    }

    public void show(List list){
        if (list.getElem() == null){
            return;
        }
        show(list.getElem());
    }

    public void show(Node node){
        if(node != null){
            System.out.println(node.getData()+" ");
        }
        show(node.getNext());
    }
}
