package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9466 {
	
	static int[] arr;
	static boolean[] visited, done; //���� Ž�������� �湮����, �� Ȯ�� ����
	static int c; //�� Ȯ���� �л� ��
	
	/**
	 * �ð� �ʰ� ������ ���ؼ� dfs ���ȣ�� ���
	 * 
	 * visited�� ���� Ž�������� ��� �湮 ���θ� ���� ,, dfs() ���� ������ falseó���� �ʱ�ȭ��
	 * ���� Ž������ �湮�� ����� visited[i]�� true��� �̹� �湮�ߴµ� �湮�� �� ���� = cycle => ���� �� �л� �� ������Ű��
	 * 
	 * done[i]�� false��� ���� �� ���� ����� ������ ���� ��.. Ž���ؾ� ��
	 * true��� �� ���� ����� ���� �� - ���� ��, ���� ���� ����...
	 * 
	 * Ž�� �Ŀ��� �� ���� ����� ���� ���̹Ƿ� done[i] = true ó��
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int i = 1,
				n = Integer.parseInt(br.readLine());
			
			arr = new int[n+1];
			visited = new boolean[n+1];
			done = new boolean[n+1];
			c = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
			for(; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
			
			for(i=1; i<=n; i++) if(!done[i]) dfs(i);
			
			System.out.println(n - c);
		}
		
	}
	
	public static void dfs(int i) {
		if(visited[i]) {
			done[i] = true;
			c++;
		}else visited[i] = true;
		
		if(!done[arr[i]]) dfs(arr[i]);
		
		visited[i] = false;
		done[i] = true;
	}
}
