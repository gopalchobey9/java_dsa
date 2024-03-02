package Rolling_Hash;
import java.util.*;

public class Longest_Duplicate_Substring {

	public static void main(String[] args) {
		String str = "banana";
		System.out.println(Longest(str));
	}
	public static String Longest(String s ) {
		int lo =1;
		int high =s.length();
		String ans ="";
		while(lo<=high) {
			int mid  = (lo+high)/2;
			String str  = result(s,mid);
			if(str.length()>0) {
				ans  = str;
				lo = mid+1;
				
			}
			else {
				high = mid-1;
				
			}
			
		}
		return ans;
	}
	private static String result(String s, int mid) {
		
		
		long hv  = 0;
		long mod = 1000_000_009;
		long pr =31;
		long pow =1;
		for(int i = mid -1;i>=0;i--) {
			hv = (hv+ ((s.charAt(i)-'a' +1)*pow)%mod )%mod;
			if(i>0) {
				pow = (pow*pr )%mod;
			}
			}
		HashMap<Long , ArrayList<Integer> >map = new HashMap<>();
		map.put(hv, new ArrayList<>());
		map.get(hv).add(0);
		for(int ei  = mid , si =0;ei<s.length();si++,ei++) {
			 hv = (hv -((s.charAt(si)-'a'+1)*pow)%mod+mod )%mod;
			 hv =(hv*pr)%mod;
			 hv = (hv +s.charAt(ei)-'a'+1)%mod;
			 if(map.containsKey(hv)) {
				 String curr = s.substring(si+1,ei+1);
				 for(int st: map.get(hv)) {
				  if(curr.equals(s.substring(st,st+mid)))
						  {
					  return curr;
					  
				  }
				  
			 }
				 
				 map.get(hv).add(si+1);
				 
		}
			 else {
				 map.put(hv, new ArrayList<>());
					map.get(hv).add(si+1);
			 }
				 
			 }
		return "";
	}
}
