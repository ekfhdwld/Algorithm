package dynamicprogramming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class PI {

	static int n;
	static String str;
	static int[] cache;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = sc.nextInt();

		while (--c >= 0) {
			str = sc.next();
			n = str.length();
			cache = new int[n+2];
			
			bw.write(memorize(0) + "\n");
			System.out.println(Arrays.toString(cache));
		}
		
		bw.flush();
		bw.close();
		sc.close();
	}

	public static int memorize(int start) {
		if(start == n) return 0;
		
		if(cache[start] != 0) return cache[start];
		
		int res = Integer.MAX_VALUE;
		for(int L=3; L<=5; ++L) {
			if(start + L <= n) {
				res = Math.min(res, memorize(start + L) 
									+ classify(start, start+L));
			}
		}
		
		return cache[start] = res;
	}
	
	/**
	 * 
	 * @param a ���̵��� üũ�ϴ� ������ ���� �ε��� 
	 * @param b ���̵��� üũ�ϴ� ������ ������ �ε���
	 * @return N[a .. b]�� ���̵� 
	 */
	public static int classify(int a, int b) {
		//��� ���ڰ� ���� ��
		String piece = str.substring(a, b),
				tmp = sameStr(a, b);
			  
		int length = tmp.length();
		if(piece.equals(tmp)) return 1;
		
		//���� �������� �˻�
		boolean progressive = true;
		int diff = tmp.charAt(1)  - tmp.charAt(0);
		for(int i=0; i< length - 1; ++i) {
			if(tmp.charAt(i+1) - tmp.charAt(i) != diff) {
				progressive = false;
				break;
			}
		}
		
		//������������ �Ǵ� �������������̸� ���̵� 2
		if(progressive && Math.abs(diff) == 1) return 2;
		
		if(progressive) return 5;
		
		//�� ���� ������ �����ϴ��� Ȯ��
		boolean alternating = true;
		for(int i=0; i<length; ++i) {
			if(tmp.charAt(i) != tmp.charAt(i%2)) {
				alternating = false;
				break;
			}
		}
		
		if(alternating) return 4;
		
		return 10;
	}
	
	public static String sameStr(int a, int b) {
		String tmp = "";
		for(int i=a; i<b; ++i) tmp += str.charAt(a);
		return tmp;
	}
}
