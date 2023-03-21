package de.kruwy.eval;

import java.util.HashMap;

public class VariableReplacement {

    public static HashMap<String, String> variables = new HashMap<String, String>();


    public static int[] getBraces(String string) {
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

    public static String evalVariables(String string) {


        while (string.indexOf('$') == string.indexOf('{') - 1) {
            int pos[] = getBraces(string);
            if (!(pos[0] >= 1 && string.charAt(pos[0] - 1) == '$')) return string;
            string = string.substring(0, pos[0] - 1) + variables.get(string.substring(pos[0] + 1, pos[1])) + string.substring(pos[1] + 1);
        }
        return string;
    }
}
