package codeforces;

import java.util.Scanner;

public class codeforces_535B {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String str = sc.next();
		System.out.println(Index(str));
		
		
	}
	public static int Index(String str) {
		int n = str.length();
		int x = (1<<n)-2;
		int y =0, pos =0;
		for (int i = n-1; i>=0; i--) {
			if(str.charAt(i)=='7') {
				y=y+(1<<pos);
			}
			pos++;
			
			
		}
		
		return x+y+1;
	}

}
