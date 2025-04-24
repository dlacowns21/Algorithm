public class PGS_이진변환반복하기 {

    public int[] solution(String s) {

        int count = 0;
        int znum = 0;

        while(!s.equals("1")) {
            int len1 = s.length();
            s = s.replace("0", "");
            int len2 = s.length();

            znum += (len1 - len2);
            s = Integer.toBinaryString(len2);
            count++;
        }
        int[] answer = {count, znum};
        return answer;
    }

}
