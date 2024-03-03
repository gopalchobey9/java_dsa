package Bit_Assignment;
import java.util.*;

public class Unique_Number_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		 for(int i = 0;i<n;i++) {
			 arr[i] = sc.nextInt();
			 
		 }
		 int ans = 0;
		  for(int  i =0;i<n;i++) {
			  ans^= arr[i];
		  }
		  System.out.println(ans);
	}

}
