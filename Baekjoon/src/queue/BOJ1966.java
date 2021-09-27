package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		PriorityQueue<Integer> pq;
		Queue<int[]> queue;

		while (--c >= 0) {
			// �Է� �ޱ�
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), idx = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			pq = new PriorityQueue<>(Collections.reverseOrder());
			queue = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				pq.add(tmp);
				queue.add(new int[] { i, tmp });
			}

			while (!queue.isEmpty()) {
				// pq.peek�̶� queue�� peek�̶� ���� ������
				// queue.poll()�� ���� queue�� add

				while (pq.peek() != queue.peek()[1]) {
					queue.add(queue.poll());
				}

				// pq.peek�̶� queue�� peek�̶� ���ٸ�
				// queue.poll() & pq.poll()
				// queue.poll�� �̸� ������ ����
				// ���� �˰���� �������� �ƴ��� Ȯ��
				// �˰���� ������ ��ü ������ �� - ���� queue.size ����ϰ� ����
				int[] document = queue.poll();
				pq.poll();
				if (idx == document[0]) {
					sb.append((n - queue.size()) + "\n");
					break;
				}
			}

		}
		System.out.println(sb.toString());

	}

}
