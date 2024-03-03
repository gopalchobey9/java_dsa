package juspay;

import java.util.*;

public class checkPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> map =  new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
        map.put(a,new ArrayList<>());

        }
        int aa = sc.nextInt();
        for (int i = 0; i < aa; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            map.get(v1).add(v2);

        }
        int src = sc.nextInt();
        int des = sc.nextInt();
        System.out.println(bfs(map,n,src,des));

    }
    public static int  bfs(HashMap<Integer, ArrayList<Integer>> map, int n , int src , int des){
        Queue<Integer>  qq =new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        qq.add(src);
        while(!qq.isEmpty()){
            //remove
            int r = qq.remove();
            //ignore
            if(visited.contains(r)){
                continue;
            }
            //visited
            visited.add(r);
            //work
            if(r == des){
                return 1;
            }
            for (int nbrs : map.get(r)){
                if(!visited.contains(nbrs))
                {
                    qq.add(nbrs);
                }
            }

        }
        return 0;

    }
}
