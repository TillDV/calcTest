package de.kruwy.eval;

public class Formula {


    private String formula;
    private Formula[] formulas = new Formula[3];

    public int[] getParentheses() {
        char[] chars = formula.toCharArray();
        boolean end = false;
        int parentheses = 0;
        int[] pos = new int[2];
        pos[0] = 0;
        pos[1] = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                if (end == false) pos[0] = i;
                parentheses++;
                end = true;
            }

            if (chars[i] == ')') {
                parentheses--;
            }

            if (parentheses == 0 && end == true) {
                pos[1] = i;
                break;

            }
        }
        return pos;
    }

    public boolean splitForm(int[] pos) {
        if (pos[0] == pos[1]) return false;
        this.formulas[0] = new Formula(formula.substring(0, pos[0]));
        this.formulas[1] = new Formula(formula.substring(pos[0] + 1, pos[1]));
        this.formulas[2] = new Formula(formula.substring(pos[1] + 1));
        return true;
    }


    public void fullSplit() {

        int[] pos = getParentheses();
        //Stop splitting if there are no parentheses
        if (pos[0] == pos[1]) {
            return;
        }

        //Stop splitting if nothing is in the parentheses
        if (!splitForm(pos)) return;

        formula = "";
        for (int i = 0; i < formulas.length; i++) {
            formulas[i].fullSplit();
            formula += formulas[i].getFormula();
        }


    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }


    public Formula(String formula) {
        this.formula = formula;
    }

    public void eval() {
        formula = VariableReplacement.evalVariables(formula);
        fullSplit();
        System.out.println(formula);
    }
}
