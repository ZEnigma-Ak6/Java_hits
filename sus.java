// Adjacency list

import java.util.ArrayList;

class AList {

    ArrayList<ArrayList<Integer>> list;
    int size = 5;

    AList() {
        list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < size; i++)
            list.add(new ArrayList<>());

    }

    void insertEdge(int source, int destination) {

        list.get(source).add(destination);
        list.get(destination).add(source);

    }


    void display() {
        for (int i = 0; i < list.size(); i++) {

            System.out.print(i + ":");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();

        }
    }

    void depthFirstTraversal() {

        boolean isVisited[] = new boolean[size];
        dfsHelper(isVisited, 0);

    }

    void dfsHelper(boolean isVisited[], int current) {

        isVisited[current] = true;
        System.out.print(current + " ");

        for (int i : list.get(current))
            if (isVisited[i]==false)
                dfsHelper(isVisited, i);

    }
}

public class Graph {

    public static void main(String[] args) {

        AList aList = new AList();
        aList.insertEdge(0, 1);
        aList.insertEdge(0, 2);
        aList.insertEdge(1, 3);
        aList.insertEdge(1, 4);
        aList.insertEdge(2, 3);
        aList.insertEdge(3, 4);

//        aList.display();
        aList.depthFirstTraversal();
    }

}
