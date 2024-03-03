package Graph_practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstras_Algo {

    class Dijkstra_Pair{
        int vtx ;
         String acpath;
         int cost;
         public  Dijkstra_Pair(int vtx , String acpath , int cost){
             this.vtx=vtx;
             this.acpath=acpath;
             this.cost=cost;
         }

    }
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

    public Dijkstras_Algo(int v ){
        this.map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i,new HashMap<>());

        }
    }
    public  void  AddEdge(int v1 , int v2, int cost ){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

    public void DijkstrCost(){
        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<Dijkstra_Pair> pq = new PriorityQueue<>(new Comparator<Dijkstra_Pair>() {
            @Override
            public int compare(Dijkstra_Pair o1, Dijkstra_Pair o2) {
                return o1.cost-o2.cost;
            }
        });
        Dijkstra_Pair sb = new Dijkstra_Pair(1,"1",0);
        pq.add(sb);
        while(!pq.isEmpty()){
            //remove
            Dijkstra_Pair r = pq.remove();
            //ignore
            if(visited.contains(r.vtx)){
                continue;
            }
            //visited
            visited.add(r.vtx);
            //work
            System.out.println(r.vtx);

            //add nbrs
            for (int nbrs : map.get(r.vtx).keySet()){
                if (!visited.contains(nbrs)){
                    int noc= r.cost+ map.get(r.vtx).get(nbrs);
                    Dijkstra_Pair ndp  = new Dijkstra_Pair(nbrs ,r.acpath+ nbrs ,noc );
                }
            }

        }



    }


}
