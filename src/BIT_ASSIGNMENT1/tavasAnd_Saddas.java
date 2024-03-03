package Bit_Assignment;
import java.util.*;
public class tavasAnd_Saddas {
	public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str= sc.next();
        int n = str.length();
        int ans = (1<<n)-2;
        for(int i =n-1,count =0;i>=0;i--,count++)
        {
            if(str.charAt(i)=='7')
            {
                ans+= (1<<count);
            }
        }
        System.out.println(ans+1);
    }


}
