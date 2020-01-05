package com.wt.leetcode5303;

class Solution {

    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.freqAlphabets("10#11#12"));
        System.out.println(s.freqAlphabets("1326#"));
        System.out.println(s.freqAlphabets("25#"));
        System.out.println(s.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    public String freqAlphabets(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        char[] schar = s.toCharArray();
        int max = schar.length;

        StringBuffer sb = new StringBuffer();

        for (int min = 1; min <= max; ) {
            // 转换带#的字符
            if (min + 2 <= max && schar[min + 1] == '#') {
                int letterIndex = Integer.parseInt(String.valueOf(schar[min - 1]) + schar[min]);
                sb.append(letters[letterIndex - 1]);
                min = min + 3;
            } else {
                int letterIndex = Integer.parseInt(String.valueOf(schar[min - 1]));
                sb.append(letters[letterIndex - 1]);
                min = min + 1;
            }
        }

        return sb.toString();
    }
}
