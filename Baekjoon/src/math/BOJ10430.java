package math;

import java.util.Scanner;

public class BOJ10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(),
			b = sc.nextInt(),
			c = sc.nextInt();
		
		sc.close();
		StringBuilder sb = new StringBuilder();
		
		//ù° �ٿ� (A+B)%C, ��° �ٿ� ((A%C) + (B%C))%C, ��° �ٿ� (A��B)%C, ��° �ٿ� ((A%C) �� (B%C))%C�� ���
		sb.append((a + b) % c + "\n");
		sb.append(((a % c) + (b % c)) % c + "\n");
		sb.append((a * b) % c + "\n");
		sb.append(((a % c) * (b % c)) % c + "\n");
		
		System.out.println(sb.toString());
	}
}
