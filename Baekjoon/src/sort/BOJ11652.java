package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ11652 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = Long.parseLong(br.readLine());
		
		Arrays.sort(arr);
		
		int cnt = 1;
        int max = 1;
        long res = arr[0];
        
        for(int i = 1; i < n; i++) {
            if(arr[i] == arr[i-1]) cnt++; //���� �ߺ��ȴٸ� �ߺ��Ǵ� Ƚ���� üũ
            else cnt = 1; // �ߺ����� �ʴ´ٸ� 1�� �ٽ� �ʱ�ȭ
            
            //���� ���� �ִ� �ߺ� Ƚ������ ���� �ߺ�Ƚ���� �� ���ٸ�
            //���� �ߺ�Ƚ���� �ִ� �ߺ� Ƚ���� �����ϰ�
            //�ߺ��Ǵ� ���� res�� ����
            //cnt == max�� ������� �ʴ� ������ ? �̹� �ߺ�Ƚ���� ���ٸ� ���� ���� �����ؾߵǴµ�
            //�̹� arr�� ���Ľ�Ų �����̹Ƿ� ������ ����� ���� ���� ���̹Ƿ� ����� �ʿ䰡 ����
            if(cnt > max) {
                max = cnt;
                res = arr[i];
            }
        }
        
        System.out.println(res);
	}
}
