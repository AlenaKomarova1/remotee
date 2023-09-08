import java.util.ArrayList;

import java.util.Collections;

import java.util.Iterator;

import java.util.List;

/*
 * В методе `main` создается объект `stream` класса `StudentStream` с номеромпотока 1. 
 * Затем создаются три объекта `group1`, `group2`, `group3` класса`StudentGroup` с разным количеством студентов, 
 * и каждая группа добавляется всписок групп потока.
 */
 
 public class Main {


    public static void main(String[] args) {

        StudentStream stream = new StudentStream(1);



        StudentGroup group1 = new StudentGroup("Group 1", 20);

        StudentGroup group2 = new StudentGroup("Group 2", 15);

        StudentGroup group3 = new StudentGroup("Group 3", 10);


        stream.addGroup(group1);

        stream.addGroup(group2);

        stream.addGroup(group3);
/*
 * Цикл `for` используется для вывода списка групп на консоль, 
 * а после этогосписок сортируется методом `sort` класса `Collections`, используя интерфейс`Comparable`.
 */
 
        for (StudentGroup group : stream) {

            System.out.println(group);

        }

        Collections.sort(stream.getGroups());

        for (StudentGroup group : stream) {

            System.out.println(group);

        }

    }

/*
 * После сортировки группы выводятся на консоль в отсортированном порядке.
 */
} 