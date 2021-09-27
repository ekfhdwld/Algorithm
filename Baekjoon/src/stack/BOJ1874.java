package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		
		//n����ŭ �ݺ�
		int max = 0;
		for(int i=0; i<n; i++) {
			int tmp = sc.nextInt();
			//���� �ִ� ���ڰ� tmp���� �������
			//���� �ִ� ����+1 ~ tmp���� ���ÿ� �׸�ŭ ���� �־������
			//���� ������ queue�� '+' �ֱ�
			while(max < tmp) {
				stack.add(++max);
				queue.add('+');
			}
			
			//stack�� peek�� tmp�̸� pop -> queue�� '-' �ֱ�
			//, �ƴϸ� "NO" ����ϰ� return
			if(stack.peek() == tmp) {
				stack.pop();
				queue.add('-');
			}
			else {
				System.out.println("NO");
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character c : queue) sb.append(c + "\n");
		
		System.out.println(sb.toString());
		return;
	}
}
