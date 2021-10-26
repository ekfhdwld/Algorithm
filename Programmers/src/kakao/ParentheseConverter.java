package kakao;

import java.util.Stack;

public class ParentheseConverter {
	
	public static void main(String[] args) {
		ParentheseConverter pc = new ParentheseConverter();
		System.out.println(pc.solution(")("));
	}
	
	public String solution(String p) {
		if (p.equals("")) return p;
		else if(isAlright(p)) return p;
		
		String u = p.substring(0, getIndex(p)); 
		String v = p.substring(u.length());
		
		if(isAlright(u)) return u += solution(v);
		
		StringBuilder sb = new StringBuilder();
		sb.append("(" + solution(v) + ")");
				
		u = u.substring(1, u.length()-1);
		for(int i=0; i<u.length(); i++) 
			sb.append( u.charAt(i) == '(' ? ')' : '(');
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param p
	 * ���ڿ� w�� �� "�������� ��ȣ ���ڿ�" u, v�� �и��ϱ� ���ؼ� 
	 * ��ȣ�� �� ������ �´� ��ġ�� ��ȯ��.
	 * @return
	 */
	public int getIndex(String p) {
		int left = 0, right = 0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == ')') right++;
			else left++;
			
			if(left == right) return i+1;
		}
		return p.length();
	}
	
	/**
	 * 
	 * @param p
	 * 
	 * @return �־��� �Է� p�� �ùٸ� ��ȣ ���ڿ����� ���θ� ��ȯ
	 */
	public boolean isAlright(String p) {
		Stack<Character> st = new Stack<>();
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i) == ')') {
				if(!st.isEmpty() && st.peek() == '(') st.pop();
				else return false;
			}else st.push('(');
		}
		return true;
	}
}
