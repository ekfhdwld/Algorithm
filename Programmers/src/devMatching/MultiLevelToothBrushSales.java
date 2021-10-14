package devMatching;

import java.util.Arrays;
import java.util.HashMap;

public class MultiLevelToothBrushSales {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		
		HashMap<String, String> t = new HashMap<>(); //�θ� �ڽ�
		HashMap<String, Integer> a = new HashMap<>(); //���ͱ�
		
		for (int i = 0; i < enroll.length; i++) t.put(enroll[i], referral[i]); //�θ��ڽ� ����
		
		for (int i = 0; i < seller.length; i++) {
			int r = amount[i] * 100;
			String person = seller[i];
			while (r > 0 && person != null) {
				int c = r / 10; //10�ۼ�Ʈ ���
				r -= c; // 90% ���� ����
				a.put(person, a.getOrDefault(person, 0) + r);
				r = c;
				person = t.get(person);
			}
		}
		int[] answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = a.getOrDefault(enroll[i], 0);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		MultiLevelToothBrushSales mt = new MultiLevelToothBrushSales();
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] sellers = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4,2,5,10};
		int[] res = mt.solution(enroll, referral, sellers, amount);
		System.out.println();
		System.out.println(Arrays.toString(res));
		
	}
	
	
}


