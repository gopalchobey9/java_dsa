package codeforces;
import java.util.Scanner;

public class YetnotherrokenKeoard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String str = sc.next();
            int bc = 0, Bc = 0;

            StringBuilder str2 = new StringBuilder();

            for (int i = str.length() - 1; i >= 0; i--) {
                char ch = str.charAt(i);
                int n = (int)(ch);
            	if(ch=='B') {
					Bc++;
					continue;
				}
				if(ch=='b') {
					bc++;
					continue;
				}
                if (n < 97) {
                    if (Bc > 0) {
                        Bc--;
                    } else {
                        str2.append(ch);
                    }
                } else {
                    if (bc > 0) {
                        bc--;
                    } else {
                        str2.append(ch);
                    }
                }
            }

            System.out.println(str2.reverse());
        }
    }

}
