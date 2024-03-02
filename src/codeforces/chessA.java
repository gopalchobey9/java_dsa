package codeforces;
import java.util.*;
public class chessA {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int t = scanner.nextInt();

	        while (t-- > 0) {
	        	String  str = scanner.next();
	        	char abc = str.charAt(0);
	        	char bcd = str.charAt(1);
	        	int arr = bcd-'0';
	        	for(int i =1;i<9;i++) {
	        		if(i!=arr)
	        		System.out.println(abc+""+i);
	        		
	        	}
	        	String v ="abcdefgh";
	        	for(int i =0;i<v.length();i++) {
	        		if(abc!=v.charAt(i))
	        		System.out.println(v.charAt(i)+""+bcd);
	        		
	        	}
	        }
	}

}
