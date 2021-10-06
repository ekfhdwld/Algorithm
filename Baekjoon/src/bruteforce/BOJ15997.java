package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ15997 {

	static double[] resProb; //������ Ȯ�� �迭
	static HashMap<String, Integer> nations; //�����̸�, ��ȣ
	static int[] score; //������ ���� �迭
	static Game[] games; //���Ӻ� ���� 1,2 Ȯ�� w,d,l
	static LinkedList<int[]> tempScore; //���� ������ �� ����, ���� ��ȣ
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		resProb = new double[4];
		score = new int[4];
		games = new Game[6];
		nations = new HashMap<>();
		
		for(int i=0; i<4; i++) nations.put(sc.next(), i);
		
		for(int i=0; i<games.length; i++) {
			games[i] = new Game(nations.get(sc.next()),
								nations.get(sc.next()),
								sc.nextDouble(),
								sc.nextDouble(),
								sc.nextDouble());
		}
		
		dfs(0, 1.0);
		
		for(double d : resProb) System.out.println(d);
	}
	
	public static void dfs(int depth, double prob) {
		if(prob == 0) return;
		if(depth == 6) {
			tempScore = new LinkedList<int[]>();
			for(int i=0; i<score.length; i++) 
				tempScore.add(new int[] {score[i], i});
			
			//��������
			Collections.sort(tempScore, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[0] - o1[0];
				}
			});
			
			if(tempScore.get(1)[0] != tempScore.get(2)[0]) {
//				1. ���� 2�� ����
				resProb[tempScore.get(0)[1]] += prob;
				resProb[tempScore.get(1)[1]] += prob;
			}else if(tempScore.get(0)[0] == tempScore.get(1)[0] &&
					tempScore.get(2)[0] == tempScore.get(3)[0] ) {
//				2. 4�� ���� ��� ������ ������
				resProb[tempScore.get(0)[1]] += prob/2;
				resProb[tempScore.get(1)[1]] += prob/2;
				resProb[tempScore.get(2)[1]] += prob/2;
				resProb[tempScore.get(3)[1]] += prob/2;
			}else if(tempScore.get(2)[0] == tempScore.get(3)[0]) {
//				3. �ֻ��� ������ ���������� �ι�° ������ �����Ѱ� 3�� �������
				resProb[tempScore.get(0)[1]] += prob;
				resProb[tempScore.get(1)[1]] += prob/3;
				resProb[tempScore.get(2)[1]] += prob/3;
				resProb[tempScore.get(3)[1]] += prob/3;
			}else if(tempScore.get(0)[0] == tempScore.get(1)[0]){
//				4. �ֻ��� ������ �����Ѱ� 3�� ���� ���
				resProb[tempScore.get(0)[1]] += prob*2 / 3;
				resProb[tempScore.get(1)[1]] += prob*2 / 3;
				resProb[tempScore.get(2)[1]] += prob*2 / 3;
			}else {
//				5. �ֻ��� ������ ���������� �ι�° ������ �����Ѱ� 2�� �������
				resProb[tempScore.get(0)[1]] += prob;
				resProb[tempScore.get(1)[1]] += prob/2;
				resProb[tempScore.get(2)[1]] += prob/2;
			}
			return;
		}
		
		
		
		Game g = games[depth];
		//�� Ʈ��ŷ
		//�� ���Ӵ� ���� �Ǵ� ��� ������� ������ �ְ� dfs ���� �� ���� ���
		
		//n1�� �̰��� �� 
		score[g.n1] += 3;
		dfs(depth+1, prob * g.w);
		score[g.n1] -= 3;
		
		//n1 & n2�� ����� ��
		score[g.n1] += 1;
		score[g.n2] += 1;
		dfs(depth+1, prob * g.d);
		score[g.n1] -= 1;
		score[g.n2] -= 1;
		
		//n2�� �̰��� ��
		score[g.n2] += 3;
		dfs(depth+1, prob * g.l);
		score[g.n2] -= 3;
	}
}


class Game{
	int n1;
	int n2;
	
	double w;
	double d;
	double l;
	
	Game(int n1, int n2, double w, double d, double l) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.w = w;
		this.d = d;
		this.l = l;
	}

}