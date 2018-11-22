public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int i = s.length() - 1, j = i;
        for (i = s.length() - 1, j = i; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (!flag) {
                    continue;
                } else {
                    sb.append(s.substring(i + 1, j + 1)).append(" ");
                    flag = false;
                }
            } else {
                if (!flag) {
                    j = i;
                    flag = true;
                }
            }
        }
        if (j > i) {
            sb.append(s.substring(i + 1, j + 1));
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
