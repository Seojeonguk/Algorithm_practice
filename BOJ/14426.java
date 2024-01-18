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
        st = new StringTokenizer(br.readLine());
        int totalExistWord = Integer.parseInt(st.nextToken());
        int totalExamineWord = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for (int i = 0; i < totalExistWord; i++) {
            char[] word = br.readLine().toCharArray();
            trie.addWord(word, 0);
        }

        int prefixWordCnt = 0;
        for (int i = 0; i < totalExamineWord; i++) {
            char[] examineWord = br.readLine().toCharArray();
            if (trie.isPrefixWord(examineWord, 0)) {
                prefixWordCnt++;
            }
        }

        sb.append(prefixWordCnt);

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

        public boolean isPrefixWord(char[] word, int idx) {
            if (word.length == idx) {
                return true;
            }
            int nextTrieIdx = word[idx] - 'a';
            if (this.tries[nextTrieIdx] == null) {
                return false;
            }
            return this.tries[nextTrieIdx].isPrefixWord(word, idx + 1);
        }
    }
}
