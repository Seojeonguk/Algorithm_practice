import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                int nodeCnt = Integer.parseInt(br.readLine());

                ArrayList<Integer>[] childs = new ArrayList[nodeCnt + 1];
                boolean[] hasParents = new boolean[nodeCnt + 1];
                for (int i = 1; i <= nodeCnt; i++) {
                    childs[i] = new ArrayList<>();
                }

                for (int i = 0; i < nodeCnt - 1; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int parent = Integer.parseInt(st.nextToken());
                    int child = Integer.parseInt(st.nextToken());

                    childs[parent].add(child);
                    hasParents[child] = true;
                }

                StringTokenizer findNodes = new StringTokenizer(br.readLine());
                int findA = Integer.parseInt(findNodes.nextToken());
                int findB = Integer.parseInt(findNodes.nextToken());

                sb.append(calFurthestCommonAncestor(nodeCnt, childs, hasParents, findA, findB)).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int calFurthestCommonAncestor(int n, ArrayList<Integer>[] edges, boolean[] hasParents, int a, int b) {
        int root = findRoot(n, hasParents);

        int[] heights = new int[n + 1];
        int[] parents = new int[n + 1];
        calHeights(root, edges, heights, parents, 1);

        if (heights[a] > heights[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (heights[a] != heights[b]) {
            b = parents[b];
        }

        if (a == b) {
            return a;
        }

        while (a != b) {
            a = parents[a];
            b = parents[b];
        }

        return a;
    }

    public static int findRoot(int n, boolean[] hasParents) {
        int root = -1;
        for (int i = 1; i <= n; i++) {
            if (!hasParents[i]) {
                root = i;
                break;
            }
        }

        return root;
    }

    public static void calHeights(int node, ArrayList<Integer>[] edges, int[] heights, int[] parents, int curHeight) {
        heights[node] = curHeight;

        for (int nextNode : edges[node]) {
            parents[nextNode] = node;
            calHeights(nextNode, edges, heights, parents, curHeight + 1);
        }
    }
}
