package Graph_practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prims_Algorithm {

    class PrimsPair{
        int vtx;
        int acvtx;
        int co;
        public  PrimsPair(int vtx,int acvtx , int co){
            this.vtx = vtx;
            this.acvtx = acvtx;
            this.co = co;
        }
        public String toString() {
            return this.vtx +" " + this.acvtx +" " + this.co;
        }
    }
    HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();

    public Prims_Algorithm(int v ) {
        this.map= new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i,new HashMap<>());

        }
    }
    public void AddEdge(int v1 , int v2,int cost ){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

    public  void PrimsAlgo(){
        int c=0;
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {
            @Override
            public int compare(PrimsPair o1, PrimsPair o2) {
                return o1.co -o2.co;
            }
        });
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new PrimsPair(1,1,0));
        while(!pq.isEmpty()){
            //remove
            PrimsPair r = pq.remove();
            //ignore
            if(visited.contains(r.vtx)){
                continue;
            }
            // visited
            visited.add(r.vtx);
            c+=r.co;
            //print
            System.out.println(r.toString());
            // add nbrs
            for (int nbrs : map.get(r.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    PrimsPair np = new PrimsPair(nbrs ,r.vtx ,map.get(r.vtx).get(nbrs) );
                    pq.add(np);
                }
            }


        }
        System.out.println(c);
    }
    public static void main(String[] args) {
        Prims_Algorithm g = new Prims_Algorithm(7);
        g.AddEdge(1, 4, 6);
        g.AddEdge(1, 2, 10);
        g.AddEdge(2, 3, 7);
        g.AddEdge(3, 4, 5);
        g.AddEdge(4, 5, 1);
        g.AddEdge(5, 6, 4);
        g.AddEdge(7, 5, 2);
        g.AddEdge(6, 7, 3);
        g.PrimsAlgo();

    }



}
