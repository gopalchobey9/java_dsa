package Bit_Masking;

import java.util.Scanner;

public class Divisible_Subarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		 for(int i = 0;i<n;i++) {
			 arr[i] = sc.nextInt();
			 
		 }
		 

	}
	public static long NoberOfSubArrays(int []arr) {
		long [] freq = new long[arr.length];
		long sum =1;
		int n =arr.length;
		freq[0] =1;
		for (int i = 1; i < freq.length; i++) {
			sum +=arr[i];
			int idx = (int)((sum)%n);
			if(idx<0) {
				idx+=n;
			}
			freq[idx]++;
			
		}
		long c=0;
		for (int i = 0; i < freq.length; i++) {
			long p = freq[i];
			if(p>=2) {
				c+=(p*(p-1))/2;
				
			}
		}
		return c; 
		
		
	}

}
