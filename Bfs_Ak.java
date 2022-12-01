package com.mukul;

import java.util.*;
/*
Input Format
n - no. of edges
source - from where to start

n edges input

ex

6
2
0 1
0 2
2 0
2 3
3 3
1 2

Ans = 2 0 3 1
 */

public class Bfs_Ak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>(); //Unordered Map
        Queue<Integer> list = new LinkedList<>();

        int n = sc.nextInt();
        int src = sc.nextInt();
        //source from where bfs starts
        for (int i = 0; i < n; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();

            if (!adj.containsKey(a)) {
                adj.put(a, new ArrayList<>());
            }
            adj.get(a).add(b);
        }

        list.add(src);

        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();   //Unordered Set
        // System.out.println(adj);
        int val, length, dest;
        visited.add(src);
        while (!list.isEmpty()) {
            val = list.peek();
            if (adj.containsKey(val)) {
                length = adj.get(val).size();
            } else {
                length = 0;
            }

            for (int i = 0; i < length; i++) {
                dest = adj.get(val).get(i);

                if (!visited.contains(dest)) {
                    list.add(dest);
                    visited.add(dest);
                }
            }

            ans.add(list.remove());

        }
        System.out.println(ans);
    }
}