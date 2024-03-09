package Tree_Of_Space;
import java.util.*;

public class TreeLockingSystem {
    static class Tree {
        String name;
        Tree head;
        List<Tree> childrens;
        boolean islocked;
        Set<Tree> bottom;
        int locked;

        public Tree(String n, Tree m) {
            name = n;
            locked = -1;
            head = m;
            childrens = new ArrayList<>();
            islocked = false;
            bottom = new HashSet<>();
        }

        public void add(List<String> str) {
            for(String it : str) {
                childrens.add(new Tree(it, this));
            }
        }
    }


    static class Tree2 {
        Tree val;
        Map<String, Tree> mp;

        public Tree2(String str) {
            val = new Tree(str, null);
            mp = new HashMap<>();
        }

        public void buildTree(List<String> str, int n) {
            Queue<Tree> q = new LinkedList<>();
            int k = 1, size = str.size();
            q.add(val);

            while(!q.isEmpty()) {
                Tree r = q.poll();
                mp.put(r.name, r);
                List<String> b = new ArrayList<>();
                for(int i = k; i < Math.min(size, k + n); i++) {
                    b.add(str.get(i));
                }
                r.add(b);
                for(Tree child : r.childrens) {
                    q.add(child);
                }
                k = k + n;
            }
        }

        public void update(Tree r, Tree current) {
            while(r != null) {
                r.bottom.add(current);
                r = r.head;
            }
        }

        public boolean lock(String name, int id) {
            Tree r = mp.get(name);
            if(r.islocked || !r.bottom.isEmpty()) return false;
            Tree par = r.head;
            while(par != null) {
                if(par.islocked) return false;
                par = par.head;
            }
            update(r.head, r);
            r.islocked = true;
            r.locked = id;
            return true;
        }

        public boolean upgrade(String name, int id) {
            Tree r = mp.get(name);
            if(r.islocked || r.bottom.isEmpty()) return false;
            for(Tree it : r.bottom) {
                if(it.locked != id) return false;
            }
            Tree par = r.head;
            while(par != null) {
                if(par.islocked) return false;
                par = par.head;
            }
            Set<Tree> st = new HashSet<>(r.bottom);
            for(Tree it : st) {
                unlock(it.name, id);
            }
            lock(name, id);
            return true;
        }

        public boolean unlock(String name, int id) {
            Tree r = mp.get(name);
            if(!r.islocked || r.locked != id) return false;
            Tree par = r.head;
            while(par != null) {
                par.bottom.remove(r);
                par = par.head;
            }
            r.islocked = false;
            r.locked = -1;
            return true;
        }
    }


    public static void main(String[] args) {
        int size = 3; // Number of nodes in the tree
        int m = 2; // Number of children per node
        int testcases = 2; // Number of test cases
        String[] nodes = {"World", "China", "India"}; // Names of the nodes
        String[] queries = {"1 India 1", "1 World 9"}; // Queries

        // Create a Tree2 object with the root node name
        Tree2 tree = new Tree2(nodes[0]);

        // Build the tree structure
        tree.buildTree(Arrays.asList(nodes), m);

        // Process each query
        for (int i = 0; i < testcases; i++) {
            Scanner scanner = new Scanner(queries[i]);
            int type = scanner.nextInt();
            String name = scanner.next();
            int id = scanner.nextInt();

            // Perform the corresponding operation based on the query type
            if (type == 1) {
                if (tree.lock(name, id)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else if (type == 2) {
                if (tree.unlock(name, id)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else if (type == 3) {
                if (tree.upgrade(name, id)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }

        }
    }
}
