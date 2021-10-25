package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *	�ڽ��丮 ������ �°� �־��� ��ǰ�޴� ���ո��� 
 *	�ڽ��丮 �޴� ���� ������ ����� map�� ���� (key : �޴� ����, value : �ش� ������ �ֹ� Ƚ��)
 *	map�� ������ ������ �ڽ� �丮 ������ �ִ� �ֹ� Ƚ���� m�� ����
 *	�޴� ������ ������ map���� �ֹ� Ƚ���� �ִ����� 2���� �Ѵ� ��츸 pq�� ����
 *	
 *	�ڽ� �迭��ŭ ������ ������ pq �����ŭ �迭�� �����Ͽ� pq�� ��� ��� ����
 *	-> pq�� ���� �迭�� �������� �����Ͽ� ������ �� ����.
 *
 */
public class MenuRenewal {
	static HashMap<String, Integer> map;
	static int m;

	public String[] solution(String[] orders, int[] course) {
		PriorityQueue<String> pq = new PriorityQueue<>();

		for (int cnt : course) {
			map = new HashMap<String, Integer>();
			m = 0;

			for (String order : orders)
				findMenu(0, "", cnt, 0, order);

			for (String key : map.keySet())
				if (map.get(key) == m && m > 1)
					pq.add(key);
		}

		String ans[] = new String[pq.size()];
		int k = 0;
		while (!pq.isEmpty()) {
			ans[k++] = pq.poll();
		}
		return ans;
	}

	public void findMenu(int depth, String str, int cnt, int start, String order) {
		if (depth == cnt) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = String.valueOf(arr);
			map.put(key, map.getOrDefault(key, 0) + 1);
			m = Math.max(map.get(key), m);
			return;
		}

		for (int i = start; i < order.length(); i++) {
			findMenu(depth + 1, str + order.charAt(i), cnt, i + 1, order);
		}
	}
}
