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
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            int totalCollection = Integer.parseInt(br.readLine());
            String[] collections = new String[totalCollection];
            for (int i = 0; i < totalCollection; i++) {
                collections[i] = br.readLine().toUpperCase();
            }

            sb.append(String.format("Case #%d:\n", testCase));
            for (int i = 0; i < totalCollection; i++) {
                String uniqueStr = calUniqueString(collections, i);
                if (uniqueStr.equals(":(")) {
                    sb.append(uniqueStr).append("\n");
                } else {
                    sb.append(String.format("\"%s\"\n", uniqueStr));
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String calUniqueString(String[] collections, int cur) {
        if (collections.length == 1) {
            return "";
        }
        String ret = "";
        for (int intervalSize = 1; intervalSize <= collections[cur].length(); intervalSize++) {
            for (int startIdx = 0; intervalSize + startIdx <= collections[cur].length(); startIdx++) {
                String subStr = collections[cur].substring(startIdx, startIdx + intervalSize);

                boolean isContain = false;
                for (int i = 0; i < collections.length; i++) {
                    if (i == cur) {
                        continue;
                    }
                    if (collections[i].contains(subStr)) {
                        isContain = true;
                        break;
                    }
                }

                if (!isContain) {
                    ret = lexicographicallyStr(ret, subStr);
                }
            }
            if (!"".equals(ret)) {
                break;
            }
        }

        return "".equals(ret) ? ":(" : ret;
    }

    public static String lexicographicallyStr(String a, String b) {
        if ("".equals(a)) {
            return b;
        }
        return a.compareTo(b) < 0 ? a : b;
    }
}
