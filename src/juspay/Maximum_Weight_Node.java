package juspay;

import java.util.*;

public class Maximum_Weight_Node {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();

        }
        System.out.println(maxWeightCell(arr,n));

    }
    public static int maxWeightCell( int Edge[],int N){
        int dp [] = new int [N];
        for(int i =0;i<N;i++){
            if(Edge[i]!=-1){
                dp[ Edge[i]]+=i;
            }
        }
        int max =0;
        int ans=0;
        for(int i =0;i<N;i++){
            if(max<=dp[i]){
                ans=i;
                max=dp[i];
            }
        }
        return ans;
    }
}
