package Graph_practice;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    HashMap< Integer , HashMap<Integer,Integer>> map = new HashMap<>();
    public Graph(int v){
        this.map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
         map.put(i,new HashMap<>());
        }

    }
    public void AddEdge(int v1 , int v2 , int cost ){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1, cost);
    }
    public boolean ContainsEdge(int v1 , int v2){
        return map.get(v1).containsKey(v2) &&  map.get(v2).containsKey(v1);

    }
    public boolean containVertex(int v1){
        return map.containsKey(v1);
    }
    public int noOfEdge(){
        int sum =0;
        for(int key :map.keySet()){
            sum+=map.get(key).size();
        }
        return sum/2;
    }
    public void removeEdge(int v1 , int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }
    public void removeVertex(int v1){
        for (int key : map.get(v1).keySet()){
            map.get(key).remove(v1);
        }
        map.remove(v1);
    }
    public void display(){
        for (int key : map.keySet()){
            System.out.println(key +"-->" + map.get(key));
        }
    }
    public boolean hasPath(int src , int des, HashSet<Integer> visited){
        if(src==des){
            return  true;
        }
        visited.add(src);
        for(int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                boolean ans = hasPath(nbrs, des,visited);
                if (ans) {
                    return ans;
                }
            }
        }
        return  false;
    }
    public void printallpath(int src, int des, HashSet<Integer> visited,String ans) {
        if (src == des) {
            System.out.println(ans+des);
            return ;
        }
        visited.add(src);
        for (int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                printallpath(nbrs, des, visited,ans+src);

            }
        }
        visited.remove(src);
    }


}