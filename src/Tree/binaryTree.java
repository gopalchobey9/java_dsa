package Tree;

import java.net.Socket;


import java.util.Scanner;

public class binaryTree {
	Scanner sc = new Scanner (System.in);
public class Node{
	int data;
	Node left;
	Node right;
	
	
}
   private Node root;
public binaryTree() {
	this.root=CreateTree();
}
private Node CreateTree() {
	// TODO Auto-generated method stub

	int item = sc.nextInt();
	Node nn = new Node();
	nn.data= item;
	boolean hlc = sc.nextBoolean();
	if(hlc == true) {
		nn.left=CreateTree();
	}
	boolean hlr = sc.nextBoolean();
	if(hlr ==true) {
		nn.right=CreateTree();
	}
	return nn;
	
	
}
   
public void Display() {
	Display(this.root); 
}
private void Display(Node nn) {
	if(nn==null) {
		return;  
	}
	String str ="";
	str = str+nn.data;
	str="<--" +str+"-->";
	if(nn.left!=null) {
		str=nn.left.data+str;
	}
	else {
		str="."+str;
	}
	if(nn.right!=null) {
		str=str+nn.right.data;
	}
	else {
		str=str+",";
	}
	System.out.println(str);
	Display(nn.left);
	Display(nn.right);
	
}
public int max() {
	return max(this.root);
}
private int max(Node nn) {
	if(nn==null ) {
		 return Integer.MIN_VALUE;
	}
	int lmax=max(nn.left);
	int rmax= max(nn.right);
	return Math.max(lmax, Math.max(rmax, nn.data));
}
    public boolean find(int item ) {
    	return find(this.root,item);
    }
    private boolean find(Node nn,int item  ) {
    	if(nn==null) {
    		return false ;
    	}
    	if(nn.data==item) {
    		return true;
    	}
    	return find(nn.left,item)|| find(nn.right,item); 
    }

public int ht() {
	return ht(this.root);
}
private int ht(Node nn) {
	if(nn==null ) {
		 return -1;
	}
	int lh=ht(nn.left);
	int rh= ht(nn.right);
	return Math.max(lh,rh)+1;
}



}



















//
//  Private Node createTree() {
//	int item = sc.nextInt();
//	Node nn = new Node ();
//	nn.data=item ;
//	boolean hlc = sc.nextBoolean();
//	if(hlc) {
//		nn.left=createTree();
//	}   
//	boolean hrc = sc.nextBoolean();
//	if(hrc) {
//		nn.right = createTree();
//	}
//	return nn ;
//
//}
//
//private void display (Node nn ) {
//	if(nn ==null) {
//		return ;
//	}
//	String str = "";
//	str = "<--"+nn.data+"-->";
//	if(nn.left!=null) {
//	str= nn.left.data+str;
//	
//	}
//	else {
//		str="."+str;
//	}
//	if(nn.right!=null) {
//		str= str+nn.right.data;
//		
//		}
//		else {
//			str+=".";
//		}
//		System.out.println(str);
//		display(nn.left);
//		display(nn.right);
//}
//  
//private int max() {
//	return max(this.root);
//}
//public int max(Node nn) {
//	if( nn == null ) {
//		return Integer.MIN_VALUE;
//	}
//	int left= max(nn.left);
//	int right = max(nn.right);
//	return Math.max(left,Math.max(right, nn.data));
//	
//}
//  
//private boolean find(int item ) {
//	return find(this.root, item );
//	
//}
//
//
//public boolean find( Node nn,int item) {
//	if(nn == null) {
//		return false ;
//		
//	}
//	if(nn.data==item) {
//		return true;
//	}
//	return find(nn.left,item)|| find(nn.right,item );
//
//}
//  
//  
  
  
  
  
  
 
  
        
  



