package dp;

import java.util.Scanner;

public class BOJ2579 {

	/**
	 * dp[i]�� i��° ����� ����� ��, ���� �� �ִ� �ִ� ������ ������ �迭
	 * 
	 * i��° ����� ����� ���� 2���� ���
	 * 1. i-1, i��° ����� �����Ͽ� ���� ���
	 * - i-2��° ����� ���� ���� 
	 * - i-3��° ����� ���� �� ���� = i-3��°���� ���� �� �ִ� �ִ� ����
	 * => dp[i-3] + stairs[i-1] + stairs[i] 
	 * 
	 * 2. i-1��° ����� ���� �ʰ� i��° ����� ���� ���
	 * - i-1��° ����� ���� ����
	 * - i-2��° ����� ���� �� ���� = i-2��°���� ���� �� �ִ� �ִ� ����
	 * => dp[i-2] + stairs[i]
	 * 
	 * �� ���� ��� �� �� ū ���� �����ϸ� ��
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] stairs = new int[n];
		
		for(int i=0; i<n; i++) {
			stairs[i] = sc.nextInt();
		}

		if(n == 1) System.out.println(stairs[0]);
		else if(n == 2) System.out.println(stairs[0] + stairs[1]);
		else {
			int[] dp = new int[n];

			dp[0] = stairs[0];
			dp[1] = dp[0] + stairs[1];
			dp[2] = Math.max(stairs[0], stairs[1]) + stairs[2];
			
			if(n == 3) System.out.println(dp[2]);
			else {
				for(int i=3; i<n; i++) {
					dp[i] = Math.max(stairs[i-1] + dp[i-3], dp[i-2]) + stairs[i];
				}
				
				System.out.println(dp[n-1]);
			}
		}
		
		
		
	}

}
