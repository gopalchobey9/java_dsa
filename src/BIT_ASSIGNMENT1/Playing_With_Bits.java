package Bit_Assignment;

import java.util.Scanner;

public class Playing_With_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c=0;
			for(int i =a ;i <=b;i++) {
				int tes=i;
				while(tes>0) {
					tes=tes &(tes-1);
					c++;
				}
			}
		System.out.println(c);
		}
	}

}
