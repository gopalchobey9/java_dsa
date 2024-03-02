package codeforces;
import java.util.*;
public class qsn33 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int t = scanner.nextInt();

	        while (t-- > 0) {
	            int n = scanner.nextInt();
	            HashMap<Character, Long> map = new HashMap<>();
	            long maxCount = 0;

	            for (int i = 0; i < n; i++) {
	                char type = scanner.next().charAt(0);
	                map.put(type, map.getOrDefault(type, 0L) + 1);
	                maxCount = Math.max(maxCount, map.get(type));
	            }

	            if (maxCount > n / 2) {
	                System.out.println(2 * maxCount - n);
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