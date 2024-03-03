package Bit_Assignment;
 import java.util.*;
public class Tavas_and_SaDDas {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str= sc.next();
        int n = str.length();
        int ans = (1<<n)-2;
        for(int i =n-1;i>=0;i--)
        {
            if(str.charAt(i)=='7')
            {
                ans+= (1<<i);
            }
        }
        System.out.println(ans+1);
    }
}
