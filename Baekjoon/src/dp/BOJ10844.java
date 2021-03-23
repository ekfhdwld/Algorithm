package dp;

import java.util.Arrays;
import java.util.Scanner;

/*
 * DP[i][j] : ���̰� i�̸� j�� ������ ��� ���� ������ �ǹ�
 * 
 * DP[0][X]�� �������� ���̰� 0�� ���� �����Ƿ� PASS
 * DP[1][1] ~ DP[1][9]�� ���̰� 1�� ��� �� �̹Ƿ� 0~9�̹Ƿ� �� 1�� �ʱ�ȭ
 *  
 * DP[2] ~ DP[N]���� �ݺ��Ͽ� �� ���� ���
 * - DP[X][0] : 0�� ���̰� 1�� ���� ���� 1�ۿ� ����(-1 ����) 
 * - DP[X][9] : 9�� ���̰� 1�� ���� ���� 8�ۿ� ����(10 ����)
 * ���� DP[X][0]�� DP[X-1][1], DP[X][9]�� DP[X-1][8]
 * 
 * - DP[X][Y] : Y(=1~8)�� ���̰� 1�� ���� ���� 2���� ����.. Y-1, Y+1
 * ���� DP[X][Y] = DP[X-1][Y-1] + DP[X-1][Y+1]  
 * 
 * ��������  1,000,000,000���� ���� �������� ����϶� �Ͽ����Ƿ�
 * ���� DP[i][j]�� ������ �� 1,000,000,000���� ���� �������� ����
 * ����, ���̰� N�� ��� ���� ������ ����ϴ� ���̹Ƿ� DP[N][0] ~ DP[N][9]�� ���� ��� ����
 * �� ���� 1,000,000,000���� ���� �������� ���
 */

public class BOJ10844 {
	
	static long[][] dp;
	static int n;
	static final long MOD = 1000000000L;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new long[n+1][10];
		
		System.out.println(dp());
	}
	
	private static long dp() {
		
		for(int i=1; i<10; i++) 
			dp[1][i] = 1;
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<10; j++) {
				if(j == 0) dp[i][j] = dp[i-1][j+1] % MOD;
				else if(j == 9) dp[i][j] = dp[i-1][j-1] % MOD;
				else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
			}
		}
		
		return Arrays.stream(dp[n]).sum() % MOD;
	}
}
