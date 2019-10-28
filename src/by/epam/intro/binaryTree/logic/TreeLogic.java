package by.epam.intro.binaryTree.logic;

import by.epam.intro.binaryTree.beans.Node;
import by.epam.intro.binaryTree.beans.Tree;



public class TreeLogic {

    public static final boolean PARENT = true;
    public static final boolean NODE = false;

    public void add(Tree binaryTree, int value) {
        if (binaryTree.getRoot() == null) {
            binaryTree.setRoot(new Node(value));
        }else {
            add(binaryTree.getRoot(), value);
        }
    }

    private void add (Node node, int value){
        if(value>node.getData()){
            if (node.getRight() == null){
                node.setRight(new Node(value));
            }else {
                add(node.getRight(),value);
            }
        }else if(value<node.getData()){
            if (node.getLeft() == null){
                node.setLeft(new Node(value));
            }else {
                add(node.getLeft(),value);
            }
        }
    }

    public Node search (Tree tree, int value, boolean flag) {
        if (tree.getRoot() == null) {
            return null;
        }
        if(flag){
            return searchParent(tree.getRoot(), value);
        }
        else{
            return searchNode(tree.getRoot(), value);
        }
    }

    private Node searchNode(Node node, int value){
        if(node.getData() == value){
            return node;
        }
        if(node.getData() < value){
            return searchNode(node.getRight(),value);
        }
        else {
            return searchNode(node.getLeft(),value);
        }
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
        } else {
            if (node.getLeft() == null) {
                return null;
            }
            if (node.getLeft().getData() == value) {
                return node;
            }
            return searchParent(node.getLeft(), value);
        }
    }

    private Node minimum(Node node){
        if(node.getLeft() == null){
            return node;
        }
        return minimum(node.getLeft());
    }

    private Node next(Tree tree, Node node){
        if(node.getRight() != null){
            return minimum(node);
        }
        Node parent = search(tree,node.getData(),PARENT);
        while(parent != null && node == parent.getRight()) {
            node = parent;
            parent = search(tree,parent.getData(),PARENT);
        }
        return parent;
    }

    public void delete(Tree tree, int value) {
        if (tree.getRoot() == null) {
            return;
        }
        Node parent = search(tree, value, PARENT);
        Node node = search(tree, value, NODE);
        if (node == null || parent == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {// первый случай: удаляемый элемент - лист
            if (parent.getLeft() == node) {
                parent.setLeft(null);
            }
            if (parent.getRight() == node) {
                parent.setRight(null);
            }
        } else if (node.getLeft() == null || node.getRight() == null) {// второй случай: удаляемый элемент имеет одного потомка
            if (node.getLeft() == null) {
                if (parent.getLeft() == node) {
                    parent.setLeft(node.getRight());
                } else {
                    parent.setRight(node.getRight());
                }
                search(tree,node.getRight().getData(),PARENT).setData(parent.getData());
            } else {
                if (parent.getLeft() == node) {
                    parent.setLeft(node.getLeft());
                } else {
                    parent.setRight(node.getLeft());
                }
                search(tree,node.getLeft().getData(),PARENT).setData(parent.getData());
            }
        } else {// третий случай: удаляемый элемент имеет двух потомков
            Node successor = next(tree, node);
            node.setData(successor.getData());
            Node successorParent = search(tree,successor.getData(),PARENT);
            Node successorRightParent = search(tree,successor.getRight().getData(),PARENT);
            if (successorParent.getLeft() == successor) {
                successorParent.setLeft(successor.getRight());
                if (successor.getRight() != null) {
                    successorRightParent.setData(successorParent.getData());
                }
            } else{
                successorParent.setRight(successor.getLeft());
                if (successor.getLeft() != null) {
                    successorRightParent.setData(successorParent.getData());
                }
            }
        }
    }

    public void show(Tree tree) {
        if (tree.getRoot() == null) return;
        show(tree.getRoot(), 0);
    }

    private void show(Node node, int level) {
        if (node != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(node.getData());
            show(node.getLeft(), level + 1);
            show(node.getRight(), level + 1);
        }
    }
}
