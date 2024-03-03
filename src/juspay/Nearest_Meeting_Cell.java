package juspay;

import java.util.*;

public class Nearest_Meeting_Cell {
    public static int solve(int[] arr, int a, int b) {
        HashSet<Integer> set2 = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int t = a;
        int c = 1;
        while (true) {
            if (map.containsKey(t)) break;
            if (t == -1) break;
            map.put(t, c++);
            t = arr[t];
        }

        t = b;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        while (true) {
            if (set2.contains(t)) break;
            if (t == -1) break;
            if (map.get(t) == null || map.get(t) == 0) {
                j++;
                set2.add(t);
                t = arr[t];
                continue;
            }
            int sum = map.get(t) + j++;
            if (sum < min) {
                min = sum;
                ans = t;
            }
            set2.add(t);
            t = arr[t];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(solve(arr,a,b));
    }
}





























