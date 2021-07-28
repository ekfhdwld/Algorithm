package greedy;

import java.util.*;

public class BOJ11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(arr);
		
		int waiting = 0, 
			res = 0;
		
		for(int i=0; i<n; i++) {
			res += (waiting + arr[i]);
			waiting += arr[i];
		}
		
		System.out.println(res);
		
	}
}

