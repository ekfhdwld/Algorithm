package graphSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> arrayLists; // �׷���

    static final int RED = 1;
    static final int BLUE = -1;
    static int[] colors; // �� {RED 1 or BLUE -1}
    static boolean checkBipartite; // �̺� �׷������� �ƴ��� Ȯ��

    public static void main(String[] args) {
        int testCase = scanner.nextInt(); // �׽�Ʈ ���̽�

        while (testCase-- > 0) {
            int V = scanner.nextInt(); // ������ ���� V (1��V��20,000)
            int E = scanner.nextInt(); // ������ ���� E (1��E��200,000)

            arrayLists = new ArrayList<>();
            colors = new int[V + 1]; // �� ������ ���� ����
            checkBipartite = true; // �ʱ�: �̺� �׷����̴�.

            for (int i = 0; i < V + 1; i++) {
                arrayLists.add(new ArrayList<Integer>()); // ������ �� + 1��ŭ �ʱ�ȭ
                colors[i] = 0; // �湮���� ���� ������ ���� 0���� �ʱ�ȭ
            }

            // ����� �׷��� ����
            while (E-- > 0) {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();

                arrayLists.get(v1).add(v2);
                arrayLists.get(v2).add(v1);
            }

            // �̺� �׷���: ���� ������ ������������ ������ ���� ��, ������ ���� ���̴� �ٸ� ��
            // ����! ���� �׷����� �񿬰� �׷���(��� ������ ���鼭 Ȯ��) ��� ���!!
            for (int i = 1; i < V + 1; i++) {
                // �̺� �׷����� �ƴϸ� �ݺ��� Ż��
                if (!checkBipartite)
                    break;

                // �湮���� ���� ������ ���ؼ� Ž�� ����
                if (colors[i] == 0) {
//                    dfs(i, RED); /* ���� �켱 Ž�� */
                    bfs(i, RED); /* �ʺ� �켱 Ž�� */
                }
            }

            System.out.println(checkBipartite ? "YES" : "NO");
        }

    }

   

    /* �ʺ� �켱 Ž�� */
    static void bfs(int startV, int color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startV); // root ������ ť�� ����
        colors[startV] = color; // root ���� �湮 ǥ�� + �� ǥ��

        // ť�� ������� �ʰ� �̺� �׷��� == ture �� �ݺ�
        while (!queue.isEmpty() && checkBipartite) {
            int v = queue.poll(); // ť���� ���� ����

            // �ش� ������ ����� ��� ���� ������ �湮
            for (int adjV : arrayLists.get(v)) {
                // �湮���� ���� �����̸�
                if (colors[adjV] == 0) {
                    queue.offer(adjV); // ���� ������ ť�� ����
                    colors[adjV] = colors[v] * -1; // ������ ������ �ٸ� ������ ����
                }
                // ���� ������ ������ ���� ���� ���̸� �̺� �׷����� �ƴϴ�.
                else if (colors[v] + colors[adjV] != 0) {
                    checkBipartite = false;
                    return;
                }
            }
        }
    }
}

