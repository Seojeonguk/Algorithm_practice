import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String totalWordStr = "";
        while ((totalWordStr = br.readLine()) != null && !"".equals(totalWordStr)) {
            int totalWord = Integer.parseInt(totalWordStr);

            Trie trie = new Trie();

            int totalInputCnt = 0;
            char[][] words = new char[totalWord][];
            for (int i = 0; i < totalWord; i++) {
                words[i] = br.readLine().toCharArray();
                trie.addWord(words[i], 0);
            }

            for (int i = 0; i < totalWord; i++) {
                int inputCnt = trie.calInputCnt(words[i], 0, 0);
                totalInputCnt += inputCnt;
            }

            sb.append(String.format("%.2f\n", 1.0f * totalInputCnt / totalWord));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        int size;
        boolean isEnd;

        Trie[] tries;

        Trie() {
            this.size = 0;
            this.isEnd = false;
            tries = new Trie[26];
        }

        public void addWord(char[] word, int idx) {
            if (word.length == idx) {
                this.isEnd = true;
                return;
            }

            int nextIdx = word[idx] - 'a';
            if (this.tries[nextIdx] == null) {
                this.tries[nextIdx] = new Trie();
                this.size++;
            }

            this.tries[nextIdx].addWord(word, idx + 1);
        }

        public int calInputCnt(char[] word, int idx, int inputCnt) {
            if (word.length == idx) {
                return inputCnt;
            }
            int nextTrieIdx = word[idx] - 'a';
            int nextIdx = idx + 1;
            Trie trie = this.tries[nextTrieIdx];
            while (trie.size == 1 && !trie.isEnd) {
                trie = trie.tries[word[nextIdx] - 'a'];
                nextIdx++;
            }
            return trie.calInputCnt(word, nextIdx, inputCnt + 1);
        }
    }
}
