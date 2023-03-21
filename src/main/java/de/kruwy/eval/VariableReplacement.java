package de.kruwy.eval;

public class VariableReplacement {
    public int[] getBraces(String string) {
        char[] chars = string.toCharArray();
        boolean end = false;
        int braces = 0;
        int[] pos = new int[2];
        pos[0] = 0;
        pos[1] = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{') {
                if (end == false) pos[0] = i;
                braces++;
                end = true;
            }

            if (chars[i] == '}') {
                braces--;
            }

            if (braces == 0 && end == true) {
                pos[1] = i;
                break;

            }
        }
        return pos;
    }

    public void getVariableCall() {

    }
}
