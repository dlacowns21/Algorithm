public class PGS_JadenCase문자열만들기 {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        s = s.toLowerCase();
        boolean isFirstChar = true;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == ' ') {
                isFirstChar = true;
                answer.append(cur);
            } else if (isFirstChar) {
                answer.append(Character.toUpperCase(cur));
                isFirstChar = false;
            } else {
                answer.append(cur);
            }
        }

        return answer.toString();
    }

}
