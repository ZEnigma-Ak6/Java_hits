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
Ans = 2 0 1 3
 */
public class Dfs_Ak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        HashMap<Integer , ArrayList<Integer>> adj = new HashMap<>();
        Queue<Integer> qt = new LinkedList<>();

        int n = sc.nextInt() ;
        int src = sc.nextInt() ;
        //source from where dfs start
        for (int i = 0; i < n; i++) {
            int a , b ;
            a = sc.nextInt();
            b = sc.nextInt();

            if(!adj.containsKey(a)){
                adj.put(a , new ArrayList<>());
            }
            adj.get(a).add(b) ;
        }

        Stack<Integer> ak = new Stack<>();
        HashSet<Integer> visited = new HashSet<>() ;
        ak.add(src);
        visited.add(src) ;
        ArrayList<Integer> ans = new ArrayList<>();
        boolean flag = false ;
        int val , dest;
        ans.add(src) ;
        int len ;
        while (!ak.isEmpty()){
            val = ak.peek() ;
            flag = false;
            if(adj.containsKey(val)){
                len = adj.get(val).size() ;
            }
            else {
                len = 0 ;
            }


            for (int i = 0; i < len ; i++) {
                dest = adj.get(val).get(i) ;
                if(!visited.contains(dest)){
                    ans.add(dest) ;
                    visited.add(dest) ;
                    ak.add(dest) ;
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                ak.pop();
            }
        }
        System.out.println(ans);
    }
}