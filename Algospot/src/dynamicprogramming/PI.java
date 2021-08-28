package dynamicprogramming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class PI {

	static int n;
	static final int INF = 987654321;
	static String str;
	static int[] cache;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = sc.nextInt();
		
		while (--c >= 0) {
			str = sc.next();
			n = str.length();
			cache = new int[n];
			Arrays.fill(cache, -1);
			
			bw.write(memorize(0) + "\n");
		}
		
		bw.flush();
		bw.close();
		sc.close();
	}
	

	public static int memorize(int start) {
		if(start == n) return 0;
		
		if(cache[start] != -1) return cache[start];
		
		int res = INF;
		for(int L=3; L<=5; ++L) {
			if(start + L <= n) {
				res = Math.min(res, memorize(start + L) + classify(start, start+L));
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
		String piece = str.substring(a, b);
			  
		if(piece.equals(sameStr(a, b))) return 1;
		
		//���� �������� �˻�
		boolean progressive = true;
		int length = piece.length(); 
		int diff = piece.charAt(1) - piece.charAt(0); 
		for(int i=0; i< length - 1; ++i) {
			if(piece.charAt(i+1) - piece.charAt(i) != diff) {
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
			if(piece.charAt(i) != piece.charAt(i%2)) {
				alternating = false;
				break;
			}
		}
		
		if(alternating) return 4;
		
		return 10;
	}
	
	public static String sameStr(int a, int b) {
		char[] arr = new char[b-a];
		Arrays.fill(arr, str.charAt(a));
		return new String(arr);
	}
}
