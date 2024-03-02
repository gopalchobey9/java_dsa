package Graph_practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Bi_partite {

    class partitePair {
        int vtx;
        int d;

        public partitePair(int vtx, int d) {
            this.vtx = vtx;
            this.d = d;
        }
    }
    class Solution{


    public boolean isBipartite(int[][] graph) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i,new HashMap<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {

                map.get(i).put(graph[i][j],1);
            }
        }
        return isBipartite(map);
    }
        public boolean  isBipartite(HashMap<Integer,HashMap<Integer,Integer>> map){
            Queue<partitePair> qq = new LinkedList<>();
            HashMap<Integer,Integer> visited = new HashMap<>();

            for (int src : map.keySet()){
                if(visited.containsKey(src)){
                    continue;
                }
                partitePair sd = new partitePair(src,0);
                qq.add(sd);
                while (!qq.isEmpty()){
                    partitePair r = qq.remove();

                    if(visited.containsKey(r.vtx) && r.d != visited.get(r.vtx)){
                        return false;
                    }
                    visited.put(r.vtx,r.d);

                    //nbrs
                    for (int nbrs : map.get(r.vtx).keySet()){
                        if (!visited.containsKey(nbrs)){
                            partitePair pr = new  partitePair(nbrs , r.d +1);
                            qq.add(pr);
                        }
                    }
                }

            }
            return true;
        }
    }
}
