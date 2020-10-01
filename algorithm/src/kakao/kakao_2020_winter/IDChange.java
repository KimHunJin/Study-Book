package kakao.kakao_2020_winter;

public class IDChange {
    public static void main(String[] args) {
        String s = new IDChange().solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(s);

        String s2 = new IDChange().solution("z-+.^.");
        System.out.println(s2);

        String s3 = new IDChange().solution("abcdefghijklmn.p");
        System.out.println(s3);

        String s4 = new IDChange().solution("=.=");
        System.out.println(s4);

        String s5 = new IDChange().solution("123_.def");
        System.out.println(s5);

        String s6 = new IDChange().solution("abcdefghijklmn.p");
        System.out.println(s6);

        System.out.println(new IDChange().solution("........."));
        System.out.println(new IDChange().solution("#######"));
        System.out.println(new IDChange().solution("cccccccc"));
        System.out.println(new IDChange().solution("12345678901234567890"));
        System.out.println(new IDChange().solution("a.a.a.a.a.a.a.a.a.a.a.a.a.a.a."));
        System.out.println(new IDChange().solution(""));
        System.out.println(new IDChange().solution("va"));
        System.out.println(new IDChange().solution(".va."));
        System.out.println(new IDChange().solution(".aac."));
        System.out.println(new IDChange().solution("a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a."));

    }

    public String solution(String new_id) {
        String answer = new_id;

        answer = firstChange(answer);
        answer = secondChange(answer);
        answer = thirdChange(answer);
        answer = fourthChange(answer);
        answer = fifthChange(answer);
        answer = sixthChange(answer);
        answer = seventhChange(answer);

        return answer;
    }

    private String firstChange(String id) {
        return id.toLowerCase();
    }

    private String secondChange(String id) {
        String regx = "[^a-z0-9_.-]";
        return id.replaceAll(regx, "");
    }

    private String thirdChange(String id) {
        String regx = "\\.+";
        return id.replaceAll(regx, "\\.");
    }

    private String fourthChange(String id) {
        String answer = id;
        if (answer.length() == 0) {
            return answer;
        }
        if (answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (answer.length() == 0) {
            return answer;
        }
        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        return answer;
    }

    private String fifthChange(String id) {
        if (id.length() == 0) {
            return "a";
        }

        return id;
    }

    private String sixthChange(String id) {
        String answer = id;
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        return fourthChange(answer);
    }

    private String seventhChange(String id) {
        String answer = id;
        char c = answer.charAt(answer.length() - 1);
        while (answer.length() < 3) {
            answer += c;
        }

        return answer;
    }
}
