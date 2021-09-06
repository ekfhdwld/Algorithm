package mst;

import java.util.Arrays;
import java.util.Scanner;

public class LAN{
	
	static int[] x, y;
	static double[][] map;
	
	public static void main(String args[]) throws Exception {
		
		x = new int[501];
		y = new int[501];
		map = new double[3][3];
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		int M, N;
		int a, b;
		
		for(int i = 0; i < test; ++i){
			for(int j = 0; j < map.length; ++j) Arrays.fill(map[j], 1);
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			for(int j = 0; j < N; ++j) x[j] = sc.nextInt();
			for(int j = 0; j < N; ++j) y[j] = sc.nextInt();
			
			for(int j = 0; j < M; ++j){
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = map[b][a] = 0;
			}
			
			distance(N);
			System.out.println(prem(N));
		}
	}
	
	
	//���� ��� ���������� �Ÿ��� ��� �� map�� ����
	static void distance(int N){
		
		for(int i = 0; i < N-1; ++i) 
			for(int j = i+1; j < N; ++j)
				if(map[i][j] != 0) 
					map[i][j] = map[j][i] = Math.sqrt(Math.pow((x[i]-x[j]), 2) + Math.pow((y[i]-y[j]), 2));
	}
	
	//���� �˰���
	static double prem(int N){
		double sum = 0;
		boolean [] visit = new boolean[N];
		//Ʈ���� ������ ���� �� �ش� ������ ��� �ּ� ������ ������ ����
		double [] minWeight = new double[N]; 
		
		Arrays.fill(minWeight, 0x7fffffff);
		
		//0�� ������ ���������� : �׻� Ʈ���� ���� ���� �߰�
		minWeight[0] = 0;
		for(int i = 0; i < N; ++i){
			int now = 0;
			double nowd = 0x7fffffff;
			for(int j = 0; j < N; ++j){
				if(!visit[j] && (minWeight[j] < nowd)){
					now = j;
					nowd = minWeight[j];
				}
			}
			
			if(nowd == 0x7fffffff) break;
			
			visit[now] = true; 
			sum += nowd;
			
			for(int j = 0; j < N; ++j)
				if(map[now][j] < minWeight[j]) 
					minWeight[j] = map[now][j];
		}
		return sum;
	}
}