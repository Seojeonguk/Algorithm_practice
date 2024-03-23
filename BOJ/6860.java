import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int PARENT_CNT = 2;
    static final int GENE_CNT = 5;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] genes = new String[PARENT_CNT];
        for (int i = 0; i < PARENT_CNT; i++) {
            genes[i] = br.readLine();
        }

        boolean[][] canShowGenes = new boolean[2][5];
        for (int idx = 0; idx < GENE_CNT * 2; idx += 2) {
            String upperC = String.valueOf((char) ('A' + idx / 2));
            String lowerC = String.valueOf((char) ('a' + idx / 2));

            if (genes[0].contains(upperC) || genes[1].contains(upperC)) {
                canShowGenes[0][idx / 2] = true;
            }
            if (genes[0].contains(lowerC) && genes[1].contains(lowerC)) {
                canShowGenes[1][idx / 2] = true;
            }
        }

        int babyCnt = Integer.parseInt(br.readLine());
        for (int babyNum = 1; babyNum <= babyCnt; babyNum++) {
            char[] babyGenes = br.readLine().toCharArray();
            boolean canShowBaby = true;
            for (int idx = 0; idx < babyGenes.length; idx++) {
                int isUpper = (Character.isUpperCase(babyGenes[idx]) ? 0 : 1);
                if (!canShowGenes[isUpper][idx]) {
                    canShowBaby = false;
                    break;
                }
            }

            sb.append(canShowBaby ? "Possible baby.\n" : "Not their baby!\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
