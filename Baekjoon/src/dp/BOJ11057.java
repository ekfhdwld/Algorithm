package dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11057 {
	
	static int n; //���� ����
	//dp[i][j] = ���̰� i�̸� j�� ������ ������ ���� ������ ������ �迭��
	static int[][] dp; 
	static final int MOD = 10007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new int[n+1][10];
		for(int i=0; i<10; i++)
			dp[1][i] = 1;

		if(n == 1) {
			System.out.println(10);
		}
		else dp();
		
	}
	
	public static void dp() {
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				if(j == 0) dp[i][j] = 1;
				else dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
			}
		}
		
		System.out.println(Arrays.stream(dp[n]).sum() % 10007);
	}
	
	
	
}
