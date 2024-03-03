package Bit_Assignment;

import java.util.Scanner;

public class Unique_NumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();

		}
		int [] ans = new int [32];
		 
		for(int i =0;i<ans.length;i++) {
			for(int j =0 ;j<n;j++) {
				if((arr[j] & (1<<i)) !=0) {
					ans[i] +=1;
				}
			}
		}
		int res =0;
		 for (int i =0;i<32 ;i++) {
			 res += (ans[i]%3) *(1<<i);
			 
		 }
		 System.out.println(res);
		 
		
		

	}

}
