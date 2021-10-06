package weekly;

public class MutualEvaluation {
	
	//i���� i�� �л��� ���� ������...
    //j���� j�� �л��� ���� ������
    public String solution(int[][] scores) {
    
    	//j��° �л��� ���� �� ���� ���
        //j��° �л��� �ڽſ��� �� ������ ����
        //j��° �л��� ���� ������ �� ����, �ְ� ����
        //���ο��� ����, �ְ� ������ ��ٸ� �� �������� ����
        //����� ����
        int r = scores.length, c = scores[0].length;
        double[] avgs = new double[r];
        
        for(int j=0; j<c; j++){
            double sum = 0; //j��°�� ���� �� ����
            
            int min = 101, max = -1;
            //�ڱ� �ڽſ��� �� ������ ������ �ִ�, �ּ� ������ ����
            for(int i=0; i<r; i++) {
                if(i != j){
                    if(scores[i][j] < min) min = scores[i][j];
                    if(scores[i][j] > max) max = scores[i][j];
                }                
                sum += scores[i][j];
            }
            
            double n = scores.length;
            //���ο��� �� ������ ������ �ִ� �ּҺ��� ũ�ų� ������
            //�ߺ����� ���� ��¥ �ִ�, �ּ� �����̹Ƿ� ������
            if(scores[j][j] < min || scores[j][j] > max){
                sum -= scores[j][j];
                n--;
            }
            avgs[j] = sum / n;
        }
        
        StringBuilder sb = new StringBuilder();
        for(double d : avgs){
            int grade = (int) d / 10;
            switch(grade){
                case 9 : 
                    sb.append('A');    
                    break;
                case 8 : 
                    sb.append('B');    
                    break;
                case 7 : 
                    sb.append('C');    
                    break;
                case 5 : 
                	sb.append('D');
                	break;
                case 6 : 
                	sb.append('D');
                	break;
                default : 
                    sb.append('F');    
                    break;
            }
        }
        
        return sb.toString();
    }
}
