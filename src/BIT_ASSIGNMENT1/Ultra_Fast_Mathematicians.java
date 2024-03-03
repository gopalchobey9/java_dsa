package Bit_Assignment;

import java.util.Scanner;

public class Ultra_Fast_Mathematicians {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n-->0) {
			String a = sc.next();
			String b = sc.next();
			String ans ="";
			for(int i =0;i<a.length();i++) {
				if(a.charAt(i)!=b.charAt(i)) {
					ans+= '1';
				}
				else {
					ans+='0';
				}
			}
			System.out.println(ans);
		}
	}

}
