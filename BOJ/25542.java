import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final String NOT_SATISFY_RESULT = "CALL FRIEND";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int nameCandidateCnt = Integer.parseInt(st.nextToken());
            int nameLength = Integer.parseInt(st.nextToken());

            String[] names = new String[nameCandidateCnt];
            for (int i = 0; i < nameCandidateCnt; i++) {
                names[i] = br.readLine();
            }

            sb.append(getSatisfyingNames(nameLength, names));

            bw.write(sb.toString());
        }
    }

    public static String getSatisfyingNames(int nameLength, String[] names) {
        char[][] namesChars = new char[names.length][];
        for (int i = 0; i < names.length; i++) {
            namesChars[i] = names[i].toCharArray();
        }

        char[] candidates = new char[nameLength];

        for (int changedIdx = 0; changedIdx < nameLength; changedIdx++) {
            System.arraycopy(namesChars[0], 0, candidates, 0, nameLength);
            for (char c = 'A'; c <= 'Z'; c++) {
                candidates[changedIdx] = c;

                int satisfyingNameCnt = 0;
                for (int i = 0; i < names.length; i++) {
                    int diffCnt = 0;
                    for (int idx = 0; idx < nameLength; idx++) {
                        if (namesChars[i][idx] != candidates[idx]) {
                            diffCnt++;
                        }
                    }

                    if (diffCnt <= 1) {
                        satisfyingNameCnt++;
                    }
                }

                if (satisfyingNameCnt == names.length) {
                    return String.valueOf(candidates);
                }
            }
        }

        return NOT_SATISFY_RESULT;
    }
}
