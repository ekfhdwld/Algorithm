package string;

import java.io.*;
import java.util.*;

public class BOJ1662 {
	static int[] paren = new int[50];
	static char[] s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		s = br.readLine().toCharArray();

		for (int i = 0; i < s.length; i++) {
			if (s[i] == '(') st.push(i); //��ȣ ��ġ push
			else if (s[i] == ')') paren[st.pop()] = i; // '('��ȣ�� ���� ��ġ ����
		}
		System.out.println(traversal(0, s.length));
	}

	static int traversal(int start, int end) {
		int sLength = 0;

		for (int i = start; i < end; i++) {
			if (s[i] == '(') {
				// -1�� �ϴ� ������ ( ���� ���ڴ� K�� �ϳ��� ���ڼ��� ���� ���� �ƴϱ� ������
				sLength += (s[i - 1] - '0') * traversal(i + 1, paren[i]) - 1; //��ȣ ��ø�� ���� �־ ��ͷ� ȣ��
				i = paren[i]; // ������ ��ȣ ��ġ�� �ٲ㼭 ���� ���ڿ��� ���� Ž���ϱ� ����
			} else sLength++; //��ȣ�� �ƴϸ� ���� ���ֱ� 
		}

		return sLength;
	}

}
