package devMatching;

import java.util.HashSet;

/**
 * 	2021 Dev-Matching : �� �鿣�� ����
 * �ζ��� �ְ� ������ ���� ����
 */
public class LottoBestRankingWorstRanking {
	
	public int[] solution(int[] lottos, int[] win_nums) {
        int numOfZero = 0, cnt = 0;
        
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0) numOfZero++;
            else if(isContained(lottos[i], win_nums)) cnt++;
        }
       
       
       //���� ���� : cnt 
       //�ְ� ���� (���� ���� + 0���� �� �´� ���) : 7 - (cnt + numOfZero) > 6 ? 6 : 7 - (cnt + numOfZero)
       //���� ���� (���� ������ ���� ���) : 7 - cnt > 6 ? 6 : 7 - cnt
       
       return new int[] {7 - (cnt + numOfZero) > 6 ? 6 : 7 - (cnt + numOfZero), 7 - cnt > 6 ? 6 : 7 - cnt};
      
    }
    
    public boolean isContained(int num, int[] win_nums){
        for(int i : win_nums)
            if(i == num) 
                return true;
        
        return false;
    }
}
