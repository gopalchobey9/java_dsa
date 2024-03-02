package codeforces;

import java.util.*;


public class problem_1242_B {

	private HashMap<Integer, HashMap<Integer, Integer>> map  = new HashMap<Integer, HashMap<Integer,Integer>>();
	
	
	public problem_1242_B(int v) {
		// TODO Auto-generated constructor stub
		for (int i = 1; i <=v ; i++) {
			map.put(i, new HashMap<>());
			
		}
	}
	public void AddEdge(int a , int b , int cost ) {
		map.get(a).put(b, cost);
		map.get(b).put(a, cost);
	}
	
	class PrimsPair{
		 int e1;
		 int e2;
		 int cost ;
		public PrimsPair(int e1 , int e2 , int cost) {
			// TODO Auto-generated constructor stub
			this.e1 = e1;
			this.e2=e2;
			this.cost = cost;
		}
		public String toString() {
			 return this.e1 +" "+ this.e2 +" " +"@" +this.cost;
		 }
	 }
	public void Prims() {
		 PriorityQueue< PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {
			 @Override
		public int compare(PrimsPair o1, PrimsPair o2) {
			// TODO Auto-generated method stub
			return o1.cost-o2.cost;
		}
		});
		 int ans =0;
		 pq.add(new PrimsPair(1, 1 , 0));
		 HashSet<Integer>  visited  = new HashSet<>();
		 while(!pq.isEmpty()) {
			 PrimsPair rp = pq.remove();
			 if(visited.contains(rp.e1)) {
				 continue;
			 }
			 visited.add(rp.e1);
//			 System.out.println(rp);
			 ans  = ans +rp.cost;
			 
			 for( int nbrs =1;nbrs<=map.size();nbrs++) {
				 if(!visited.contains(nbrs)) {
					 int cost =0;
					  if(map.get(rp.e1).containsKey(nbrs)) {
						  cost =1;
					  }
					pq.add(new PrimsPair(nbrs, rp.e1, cost));
				 }
			 } 
		 }
		 System.out.println(ans);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner  (System.in);
		int n = sc.nextInt(); // vtx
		int m =  sc.nextInt(); // edge
        problem_1242_B pb = new problem_1242_B(n);
		 for (int i = 0; i <m; i++) {
			 int a = sc.nextInt();
			 int b = sc.nextInt();
			 pb.AddEdge(a,b,1);
		}
		 pb.Prims();
		
	}

}
