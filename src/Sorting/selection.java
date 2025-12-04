import java.util.*;

public class selection {
     public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        selection_sort(arr,n);
    }
    public static void selection_sort(int[] arr , int n ){
        for(int i =0;i<=n-2;i++){
            int miniVal= i;
            for(int j=i;j<=n-1;j++){
                if(arr[j]<arr[miniVal]) {miniVal =j;
                }
            }
            swap_func(arr,i,miniVal);
        }
        for(int i =0;i<n;i++){
        System.out.print( arr[i]+" ");
        }
    }
    public static void swap_func(int[] arr , int i ,int j ){
        int temp =arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}