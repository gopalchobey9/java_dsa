package juspay;

import java.util.*;

public class Remove_Neighbours {
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
        ArrayList<Integer> arr = dfs(map,n,src,des);
        if(arr.isEmpty()){
            System.out.println(-1);
        }else
            Collections.sort(arr);
        for(int i :arr)
        System.out.print(i+" ");

    }
    public static  ArrayList <Integer>  dfs(HashMap<Integer, ArrayList<Integer>> map,int n , int src,int des){
        ArrayList<Integer> arr = new ArrayList<>();
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
            //visited
            visited.add(r);
            //work
            for (int nbrs : map.get(r)){
                if(nbrs == des){
                    arr.add(r);
                }
            }

            //add nbrs
            for (int nbrs : map.get(r)){
                if(!visited.contains(nbrs)){
                    st.add(nbrs);
                }
            }
        }
        return arr; 
    }
}
