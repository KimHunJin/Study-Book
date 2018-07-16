package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 백준 온라인 저지 15904
 *
 * UCPC는 '전국 대학생 프로그래밍 대회 동아리 연합 여름 대회'의 줄임말로 알려져있다. 하지만 이 줄임말이 정확히 어떻게 구성되었는지는 아무도 모른다. UCPC 2018을 준비하던 ntopia는 여러 사람들에게 UCPC가 정확히 무엇의 줄임말인지 물어보았지만, 아무도 정확한 답을 제시해주지 못했다. ntopia가 들은 몇 가지 답을 아래에 적어보았다.
 *
 * Union of Computer Programming Contest club contest
 * Union of Computer Programming contest Club contest
 * Union of Computer Programming contest club Contest
 * Union of Collegiate Programming Contest club contest
 * Union of Collegiate Programming contest Club contest
 * Union of Collegiate Programming contest club Contest
 * University Computer Programming Contest
 * University Computer Programming Club contest
 * University Computer Programming club Contest
 * University Collegiate Programming Contest
 * University CPC
 * ...
 * ntopia는 이렇게 다양한 답을 듣고는 UCPC가 무엇의 약자인지는 아무도 모른다고 결론내렸다. 적당히 슥삭해서 UCPC를 남길 수 있으면 모두 UCPC의 약자인 것이다!
 *
 * 문자열이 주어지면 이 문자열을 적절히 축약해서 "UCPC"로 만들 수 있는지 확인하는 프로그램을 만들어보자.
 *
 * 축약이라는 것은 문자열에서 임의의 문자들을 제거하는 행동을 뜻한다. 예를 들면, "apple"에서 a와 e를 지워 "ppl"로 만들 수 있고, "University Computer Programming Contest"에서 공백과 소문자를 모두 지워 "UCPC"로 만들 수 있다.
 *
 * 문자열을 비교할 때는 대소문자를 구분해 정확히 비교한다. 예를 들어 "UCPC"와 "UCpC"는 다른 문자열이다. 따라서 "University Computer programming Contest"를 "UCPC"로 축약할 수 있는 방법은 없다.
 *
 * 그나저나 UCPC는 정말 무엇의 약자였을까? 정확히 아시는 분은 제보 부탁드립니다.
 *
 * ex)
 * input
 * Union of Computer Programming Contest club contest
 *
 * output
 * I love UCPC
 *
 * input
 * University Computer Programming
 *
 * output
 * I hate UCPC
 */
public class BJ_15904 {

    private static final String OK = "I love UCPC";
    private static final String NO = "I hate UCPC";

    private char[] UCPC = {'U', 'C', 'P', 'C'};

    public static void main(String[] args) {
        new BJ_15904().solve();
    }

    private void solve() {
        String s = input();
        int size = s.length();

        int count = 0;
        boolean isUCPC = false;

        for(int i=0;i<size;i++) {
            char c = s.charAt(i);
            if(c == UCPC[count]) {
                count++;
            }

            if(count > 3) {
                isUCPC = true;
                break;
            }
        }

        if(isUCPC) {
            System.out.println(OK);
        } else {
            System.out.println(NO);
        }
    }

    private String input() {
        String result = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            result = br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return result;
    }
}
