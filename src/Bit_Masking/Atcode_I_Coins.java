package Bit_Masking;

public class Atcode_I_Coins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] c= {0.30,0.60,0.80};
		int n = c.length;
		double [][] dp = new double[n][(n+4)/2];
		System.out.println(probability_Head(c, 0,((n+1)/2),dp));
	}
	public static double probability_Head(double[]c,int i, int h , double [][]dp) {
		if(h==0)return 1;
		if(i==c.length) {
			return 0;
			
		}
		if(dp[i][h]!=-1) {
			return dp[i][h];
		}
		double ans = c[i]*probability_Head(c, i+1, h-1,dp) + (1- c[i])*probability_Head(c, i+1, h,dp);
		
		return ans;
	}
	

}
