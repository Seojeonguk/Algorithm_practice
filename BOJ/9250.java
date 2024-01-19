import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int setSize = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < setSize; i++) {
            char[] word = br.readLine().toCharArray();
            trie.add(word, 0);
        }

        createFail(trie);

        int queryCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < queryCnt; i++) {
            char[] word = br.readLine().toCharArray();

            Trie cur = trie;
            boolean result = false;

            for (int j = 0; j < word.length; j++) {
                int next = word[j] - 'a';
                while (cur != trie && cur.tries[next] == null) {
                    cur = cur.fail;
                }

                if (cur.tries[next] != null) {
                    cur = cur.tries[next];
                }

                if (cur.isEnd) {
                    result = true;
                    break;
                }
            }

            sb.append(result ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void createFail(Trie root) {
        root.fail = root;
        Queue<Trie> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Trie cur = q.poll();

            for (int i = 0; i < 26; i++) {
                Trie next = cur.tries[i];
                if (next == null) {
                    continue;
                }

                if (cur == root) {
                    next.fail = root;
                } else {
                    Trie fail = cur.fail;
                    while (fail != root && fail.tries[i] == null) {
                        fail = fail.fail;
                    }
                    if (fail.tries[i] != null) {
                        fail = fail.tries[i];
                    }
                    next.fail = fail;
                }

                if (next.fail.isEnd) {
                    next.isEnd = true;
                }

                q.add(next);
            }
        }
    }

    static class Trie {
        boolean isEnd;

        Trie[] tries;
        Trie fail;

        Trie() {
            this.isEnd = false;
            tries = new Trie[26];
        }

        public void add(char[] word, int idx) {
            if (word.length == idx) {
                this.isEnd = true;
                return;
            }

            int nextTrieIdx = word[idx] - 'a';
            if (this.tries[nextTrieIdx] == null) {
                this.tries[nextTrieIdx] = new Trie();
            }

            this.tries[nextTrieIdx].add(word, idx + 1);
        }
    }
}
