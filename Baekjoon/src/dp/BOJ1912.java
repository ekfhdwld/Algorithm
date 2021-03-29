package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] seq = new int[n];
		int[] dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = seq[0];
		int max = dp[0];
		
		/**
		 * dp[i]�� i��° ��Ҹ� �����Ͽ� ���� �� �ִ� ������ ��ҵ��� �� �� ���� ū ���� ������ ��
		 * ���� ��Ҹ� �����Ͽ� ���� �տ� ���� ��Ҹ� ���� ���� ���� ��� ��ü�� ���Ͽ� �� ū ���� ����
		 * ->  dp[i] = Math.max(dp[i-1] + seq[i], seq[i])
		 * seq[i]�� dp[i-1] + seq[i] ������ ũ�ٸ� dp[i-1] + seq[i]�� �������� �������ִٴ� ���� �ǹ���
		 * 
		 * dp[i]�� ���԰� ���ÿ� max���� ���
		 */
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1] + seq[i], seq[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}

}
