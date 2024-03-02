package Graph_practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_valid_Tree {
    public boolean validTree(int n , int [][]edges){
        HashMap<Integer ,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int v1  =edges[i][0];
            int v2 = edges[i][1];
            map.get(v1).put(v2,1);
            map.get(v2).put(v1,1);

        }
        return isTree(map);

    }
    public boolean isTree(HashMap<Integer ,HashMap<Integer,Integer>> map){
        Queue<Integer> qq = new LinkedList<>();
        HashSet<Integer>  visited = new HashSet<>();
        int c=0;
        for (int src : map.keySet()){
            if(visited.contains(src)){
                continue;
            }
            c++;
            qq.add(src);
            while(!qq.isEmpty()){
                int r = qq.remove();
                if (visited.contains(r)){
                    return false;

                }
                visited.add(src);
                System.out.println(r+" ");
                for(int nbrs: map.get(r).keySet()){
                    if(!visited.contains(nbrs)){
                        qq.add(nbrs);
                    }
                }
            }
        }
                return c==1;
    }

}
