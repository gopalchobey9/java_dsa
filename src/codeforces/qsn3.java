package codeforces;
import java.util.*;
public class qsn3 {
		  public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        int subs = scanner.nextInt();

		        while (subs-- > 0) {
		        long n = scanner.nextLong();

		        // Using HashMap to store the frequency of characters
		        HashMap<Character, Long> map = new HashMap<>();
		        long maxc = 0;
		        String str = scanner.next();
		        for (int i = 0; i < n; i++) {
		            char type = str.charAt(i);
		            map.put(type, map.getOrDefault(type, 0L) + 1);
		            maxc = Math.max(maxc,map.get(type));
		        }

		        if (maxc > n / 2) {
		            System.out.println(2 * maxc - n);
		        } else {
		            if (n % 2 == 1) {
		                System.out.println(1);
		            } else {
		                System.out.println(0);
		            }
		        }
		  }
		  }
		    }