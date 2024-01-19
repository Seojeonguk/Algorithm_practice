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
        int totalInterceptedMessage = Integer.parseInt(st.nextToken());
        int totalCodeword = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for (int i = 0; i < totalInterceptedMessage; i++) {
            st = new StringTokenizer(br.readLine());
            int bitSize = Integer.parseInt(st.nextToken());
            int[] bits = new int[bitSize];
            for (int j = 0; j < bitSize; j++) {
                bits[j] = Integer.parseInt(st.nextToken());
            }

            trie.addBit(bits, 0);
        }

        for (int i = 0; i < totalCodeword; i++) {
            st = new StringTokenizer(br.readLine());
            int bitSize = Integer.parseInt(st.nextToken());
            int[] bits = new int[bitSize];
            for (int j = 0; j < bitSize; j++) {
                bits[j] = Integer.parseInt(st.nextToken());
            }

            int matchCodewordCnt = trie.calMatchCodeword(bits, 0);
            sb.append(matchCodewordCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Trie {
        int childSize;
        int isEnd;

        Trie[] tries;

        Trie() {
            this.childSize = 0;
            this.isEnd = 0;
            tries = new Trie[2];
        }

        public void addBit(int[] bits, int idx) {
            if (bits.length == idx) {
                this.isEnd++;
                return;
            }

            this.childSize++;
            if (this.tries[bits[idx]] == null) {
                this.tries[bits[idx]] = new Trie();
            }

            this.tries[bits[idx]].addBit(bits, idx + 1);
        }

        public int calMatchCodeword(int[] bits, int idx) {
            int matchCodewordCnt = this.isEnd;
            if (bits.length == idx) {
                matchCodewordCnt += this.childSize;
                return matchCodewordCnt;
            }


            if (this.tries[bits[idx]] != null) {
                matchCodewordCnt += this.tries[bits[idx]].calMatchCodeword(bits, idx + 1);
            }
            return matchCodewordCnt;
        }
    }
}
