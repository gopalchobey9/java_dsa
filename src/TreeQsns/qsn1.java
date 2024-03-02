package TreeQsns;

import java.util.Arrays;
import java.util.Scanner;

public class qsn1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tes = sc.nextInt();

        while (tes-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int c=0;
            int re=arr[0];
            boolean flag =true;;
            for(int i =0;i<n;i++) {
            	if(arr[i]==1) {
            		continue;
            	}
            	else {
            		if(arr[i]==0) {c++;}
            		
            		if(i!=0) {
            			if(arr[i]!=arr[i-1]) {
            				c+=arr[i]-arr[i-1];
            			}
            		}
//            		else if(arr[i]==0) {c++;}
            		
            		
            		
            		
            	}
            }
            if(n==1) {
            	c=arr[0]-1;
            }
            
            System.out.println(c);
        }

    }
}
