package Bit_Assignment;

import java.util.Scanner;

public class Unique_Number_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();

		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans ^= arr[i];
		}
//		ans =(ans &-ans);
		ans = ans &1;
		
		int ans1 = 0;
		int ans2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & ans) > 0) {

				ans1 = (ans1 ^ arr[i]);
				

			}
			else {
				ans2 = (ans2 ^ arr[i]);
			}

		}
		if(ans1<ans2)
		System.out.println(ans1 +" "+ ans2);
		else
			System.out.println(ans2 +" "+ ans1);
	}

}
