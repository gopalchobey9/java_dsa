package juspay;

import java.util.*;

public class Minimum_Cost {
    static  class Pair{
        int vtx;
        int cost ;
        public Pair(int vtx, int cost ){
            this.vtx = vtx;
            this.cost = cost ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, HashMap<Integer,Integer>> map =  new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            map.put(a,new HashMap<>());

        }
        int aa = sc.nextInt();
        for (int i = 0; i < aa; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            map.get(v1).put(v2,cost);
        }
        int src = sc.nextInt();
        int des = sc.nextInt();
        System.out.println(dijkstra(map,n,src,des));

    }
    public static int dijkstra(HashMap<Integer, HashMap<Integer,Integer>> map, int n , int src , int des){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.cost-o2.cost;
            }
        });

        Pair sb = new Pair(src , 0);
        pq.add(sb);
        HashSet<Integer>  visited = new HashSet<>();

        while(!pq.isEmpty()){
            //remove
            Pair r = pq.remove();
            //ignore
            if(visited.contains(r.vtx)){
                continue;
            }
            //visited
            visited.add(r.vtx);
            //work
            if(r.vtx == des){
                return r.cost;
            }
            //add nbrs
            for (int  nbrs : map.get(r.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    int newcost = r.cost + map.get(r.vtx).get(nbrs);
                    pq.add(new Pair(nbrs,newcost));
                }
            }

        }

        return -1;
    }
}
