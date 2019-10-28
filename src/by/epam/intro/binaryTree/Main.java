package by.epam.intro.binaryTree;

import by.epam.intro.binaryTree.beans.Tree;
import by.epam.intro.binaryTree.logic.TreeLogic;

import static by.epam.intro.binaryTree.logic.TreeLogic.PARENT;
import static by.epam.intro.binaryTree.logic.TreeLogic.NODE;

public class Main {
    public static void main(String[] args){
        Tree tree = new Tree();
        TreeLogic treeLogic = new TreeLogic();
        treeLogic.add(tree,4);
        treeLogic.add(tree,2);
        treeLogic.add(tree,3);
        treeLogic.show(tree);
        System.out.println(treeLogic.search(tree,3,PARENT).getData());
        System.out.println(treeLogic.search(tree,2,NODE).getData());
        treeLogic.delete(tree,2);
        treeLogic.show(tree);
    }
}
