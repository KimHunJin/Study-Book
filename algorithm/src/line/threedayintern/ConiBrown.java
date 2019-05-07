package line.threedayintern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConiBrown {
    public static void main(String[] args) {
        new ConiBrown().solve();
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tmp = br.readLine().split(" ");
            int cony = Integer.parseInt(tmp[0], 10);
            int brown = Integer.parseInt(tmp[1], 10);

            int index = 0;
            boolean isCatch = false;
            while (cony <= 200000) {
                cony += index;

                if(cony < brown) {
                    break;
                }
                if (dp(index, cony, brown)) {
                    isCatch = true;
                    break;
                }
                index++;
            }

            if (isCatch) {
                System.out.println(index);
            } else {
                System.out.println(-1);
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private boolean dp(int index, int cony, int brown) {
        if (index == 0 && cony == brown) {
            return true;
        } else {
            if (index == 0) {
                return false;
            } else {
                index--;
                if (cony % 2 == 0) {
                    return dp(index, cony / 2, brown);
                } else {
                    return dp(index, cony - 1, brown);
                }
            }
        }
    }
}
