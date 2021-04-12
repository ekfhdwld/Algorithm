package graphSearch;

import java.util.Scanner;

public class BaekJoon6603 {

	static int N;
	static int[] arr;
	static boolean[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			N = sc.nextInt();

			if (N == 0) break; //���� ����
			
			arr = new int[N];
			result = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			DFS(0, 0);
			System.out.println();
		}
	}

	/**
	 * @param start : arr[start]�� ��Ҵ� ����Ѵٴ� �ǹ̷� -> result[]�� T�� �����ϹǷ� depth�� 6�� �� T�� ��Ҹ� ����ϴ� ��!
	 * 				   �ݺ����� ���ؼ� �� ����ϴ� ��Ҹ� �ٲ㰡�鼭 Ž����.
	 * 				  (x���� ����ٸ� n-x������ 6-x���� ������)  
	 * @param depth : �� 6���� ���ڸ� �����ϹǷ� 0~5��°���� ���ڸ� ���� 6��°���� Ż��! 
	 * 				  (depth�� 6�̶�� 6���� �� ����ٴ� ��
	 * 				    -> �迭�� �ε����� 0���� �����ϹǷ� 0~5 = 6���̹Ƿ� 6���� ��Ұ� ���ǹǷ� result[]�� T�� 6�� ���������)
	 * 
	 * result[] : �ش� ��Ҹ� ����Ѵٴ� ���� depth�� 6�� �� Ȯ���ϴ� �뵵�� �ش� �޼ҵ尡 ���� return�Ǹ� ���� �ܰ� �ݺ������� ����ؾ� �ϹǷ� Fó��
	 */
	private static void DFS(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < N; i++) {
				if (result[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}

		for (int i = start; i < N; i++) {
			result[i] = true;
			DFS(i + 1, depth + 1);
			// ����ϰ� ���ƿö� �ٸ� ���ڰ� start�� �� ����ؾ� �ϱ� ������ F ó��
			result[i] = false;
		}

	}

}


