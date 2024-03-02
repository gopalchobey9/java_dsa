package Graph_practice;

import java.util.*;

public class Graph_2 {
    HashMap< Integer , HashMap<Integer,Integer>> map = new HashMap<>();
    public Graph_2(int v){
        this.map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i,new HashMap<>());
        }

    }
    public void AddEdge(int v1 , int v2 , int cost ){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1, cost);
    }
    public boolean BFS (int src , int des){
        Queue<Integer> qq = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        qq.add(src);
        while(!qq.isEmpty()){
            //remove
            int r = qq.remove();
            //ignore

            if(visited.contains(r)){
                continue;
            }
            //visited mark
            visited.add(r);
            if(r==des){
                return true;
            }
            //add nbrs;
            for (int key : map.get(r).keySet()){
                if(!visited.contains(key)){
                    qq.add(key);
                }
            }
        }
            return false;

    }
    public boolean BFT (){
        Queue<Integer> qq = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int src : map.keySet()) {
            if(visited.contains(src)){
                continue;
            }
            qq.add(src);

            while (!qq.isEmpty()) {
                //remove
                int r = qq.remove();
                //ignore

                if (visited.contains(r)) {
                    continue;
                }
                //visited mark
                visited.add(r);
                System.out.println(r+ " ");
                //add nbrs;
                for (int key : map.get(r).keySet()) {
                    if (!visited.contains(key)) {
                        qq.add(key);
                    }
                }
            }
        }
        return false;

    }



    public boolean DFS (int src , int des){
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        st.add(src);
        while(!st.isEmpty()){
            //remove
            int r = st.pop();
            //ignore

            if(visited.contains(r)){
                continue;
            }
            //visited mark
            visited.add(r);
            if(r==des){
                return true;
            }
            //add nbrs;
            for (int key : map.get(r).keySet()){
                if(!visited.contains(key)){
                    st.push(key);
                }
            }
        }
        return false;

    }

    public boolean DFT (){
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int src : map.keySet()){
            if(visited.contains(src)){
                continue;
            }

        st.add(src);
        while(!st.isEmpty()) {
            //remove
            int r = st.pop();
            //ignore

            if (visited.contains(r)) {
                continue;
            }
            //visited mark
            visited.add(r);
            System.out.print(r+ " ");
            //add nbrs;
            for (int key : map.get(r).keySet()) {
                if (!visited.contains(key)) {
                    st.push(key);
                }
            }
        }
        }
        return false;

    }
    public boolean isCycle() {
        Queue<Integer> qq = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int src : map.keySet()) {
            if (visited.contains(src)) {
                continue;
            }
            qq.add(src);

            while (!qq.isEmpty()) {
                //remove
                int r = qq.remove();
                //ignore

                if (visited.contains(r)) {
                    return true;
                }
                //visited mark
                visited.add(r);
                System.out.println(r + " ");
                //add nbrs;
                for (int key : map.get(r).keySet()) {
                    if (!visited.contains(key)) {
                        qq.add(key);
                    }
                }
            }
        }


        return false;
    }


}
