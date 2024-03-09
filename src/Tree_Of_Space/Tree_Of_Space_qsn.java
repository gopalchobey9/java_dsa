package Tree_Of_Space;

import java.util.*;

public class Tree_Of_Space_qsn {

    public static class Node {
        Node parent ;
        int id ;
        boolean islocked;
        int ans_lock;
        int des_lock;
        ArrayList<Node>  child=  new ArrayList<>();

    }
    public static void change(Node nn , int val){
        if(nn == null) return ;

        nn.des_lock+=val;
        for(Node ne : nn.child){
            change(ne,val);
        }
    }
    public static boolean lock(Node  nn , int id){
        if(nn.islocked){
            return false;
        }
        if(nn.ans_lock>0|| nn.des_lock>0){
            return false;
        }
        Node root= nn;
        while(root!=null){
            root.ans_lock+=1;
            root = root.parent;
        }
        change(nn,1);
        nn.islocked =true;
        nn.id=id;
        return true;
    }
    public static boolean unlock(Node  nn , int id){
        if(!nn.islocked || nn.id!=id) return false;

        Node root = nn;
         while(root!=null){
             nn.ans_lock -=1;
             nn =nn.parent;

         }
         change(nn,-1);
        nn.islocked =false;
        nn.id=0;
        return true;
    }
    public  static boolean  getLocked(Node nn , int id,ArrayList<Node> ar){
        if(nn ==null){
            return true;
        }
        if(nn.islocked){
            if(nn.id !=id){
                return false;
            }
            else {
                ar.add(nn);
            }
        }
        if(nn.des_lock ==0){
            return true;
        }
        for (Node ch :nn.child){
            boolean ans = getLocked(nn,id,ar);
            if (ans==false) return false;
        }
        return  true;

    }
    public static boolean upgrade(Node  nn , int id){
        if(nn.islocked || nn.ans_lock >0 || nn.des_lock ==0){
            return false;
        }
        ArrayList<Node> ar = new ArrayList<>();
        if(!getLocked(nn , id,ar))
        {
            return false;
        }
        change(nn,1);
        for(Node ne :ar){
            unlock(ne,id);
        }
        nn.islocked = true;
        nn.id =id;
        return true;
    }

    public static   void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String arr[] = new String[n];
        for(int i =0;i<arr.length;i++){
            arr[i] = sc.next();
        }
        HashMap<String, Node> map = new HashMap<>();

        Queue<Node> qq = new LinkedList<>();
        Node root = new Node();
        map.put(arr[0],root);
        qq.add(root);
        int index=1;
        while(!qq.isEmpty()){
            int size = qq.size();
            while(size -- >0){
                Node rem = qq.remove();
                for(int i =1;i<=m & index<n;i++){
                    Node nn = new Node();
                    nn.parent =rem;
                    rem.child.add(nn);
                    map.put(arr[index] , nn);
                    index+=1;
                    qq.add(nn);
                }
            }

        }
        int q = sc.nextInt();
        while(q-->0){
            int op = sc.nextInt();
            String word= sc.next();
            int id = sc.nextInt();
            if(op ==1){

                System.out.println( lock(map.get(word),id));
            }
            else if (op ==2){
                System.out.println(unlock(map.get(word),id));
            }
            else{
                System.out.println(upgrade(map.get(word),id));
            }
        }


    }
}
