package dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1699 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] dp = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			dp[i] = i; // 1^2���θ� �̷�����ٰ� ����(�ִ�)
			for (int j = 1; j * j <= i; j++) {
				//i���� ���� ���������� �̿��Ͽ� �񱳸� �ؼ� ���� ���� ���� ���� ����
				dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
			}
		}
		
		System.out.println(dp[n]);

	}

}
