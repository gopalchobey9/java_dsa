package Bit_Assignment;

import java.util.*;

public class Missing_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int ans [] = new int[n];
        for(int i =0;i <n;i++){
            ans[i]=sc.nextInt();
        }
        int sum = (n*(n+1)/2 );
		
		for(int i =0;i<n;i++) {
            
			sum-=ans[i];
		}
		System.out.println(sum);
	}

}
