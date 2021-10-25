package kakao;

public class Keypad {
	 static int[] row = {3, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3};  // 0 ~ 9, *, # �� ��
	    static int[] col = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 2}; // 0 ~ 9, *, # �� ��
	    
	    public String solution(int[] numbers, String hand) {
	        boolean isRight = hand.equals("right") ? true : false;
	        
	        int left = 10, right = 11; //�޼�, �������� ��ġ���ִ� Ű�е� ��ȣ(* : 10, # : 11)
	        int leftCnt = 0,  rightCnt = 0;
	        StringBuilder sb = new StringBuilder();
	        
	        for(int num : numbers){
	            switch(num) {
	                case 1, 4, 7:
	                    left = num;
	                    sb.append('L');
	                    break;
	                case 3, 6, 9 :
	                    right = num;
	                    sb.append('R');
	                    break;
	                case 2, 5, 8, 0:
	                    //left,right �� ��ġ���� �ش� num���� �ʿ� �̵� Ƚ��
	                    leftCnt = Math.abs(row[left] - row[num]) + Math.abs(col[left] - col[num]); 
	                    rightCnt = Math.abs(row[right] - row[num]) + Math.abs(col[right] - col[num]); 
	                    
	                    //���� ���ؼ� �� ���� �ָ� �ش� �̵���Ű��
	                    //���ٸ� �������������� �޼��������� Ȯ���ؼ� ����
	                    if(leftCnt < rightCnt || (leftCnt == rightCnt) && !isRight) {
	                        left = num;
	                        sb.append('L');      
	                    }else{
	                        right = num;
	                        sb.append('R');
	                    }
	                    break;
	            }
	        }
	        
	        return sb.toString();
	    }    
}
