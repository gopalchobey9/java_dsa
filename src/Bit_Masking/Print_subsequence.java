package Bit_Masking;

import java.util.*;

public class Print_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		Subsequence(str);

	}
	public static void  Subsequence(String str ) {
		int n = str.length();
		for (int i = 0; i < (1<<n); i++) {
			pattern(i,str );
			
			
		}
	}
	private static void pattern(int i,String str ) {
		// TODO Auto-generated method stub
		String ans ="";
		int pos =0;
		while(i>0) {
			if((i&1)!=0) {
				System.out.print(str.charAt(pos));
			}
			pos++;
			i>>=1;
		}
		System.out.println();
		
	}

}
