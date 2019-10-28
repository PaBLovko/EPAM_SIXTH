package by.epam.intro.linkedList;

import by.epam.intro.linkedList.entity.List;
import by.epam.intro.linkedList.logic.ListLogic;

public class Main {
    public static void main(String[] args){
        List list = new List();
        ListLogic listLogic = new ListLogic();
        listLogic.add(list,4);
        listLogic.add(list,2);
        listLogic.add(list,3);
        listLogic.show(list);
        listLogic.deleteByKey(list, 2);
        listLogic.deleteAtPosition(list,1);
        listLogic.show(list);
    }
}
