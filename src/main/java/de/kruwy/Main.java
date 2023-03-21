package de.kruwy;

import de.kruwy.eval.Formula;
import de.kruwy.objects.Cell;

public class Main {
    public static void main(String[] args) {

        Formula formula = new Formula("abc(def(ghi)jkl)mno(pqr)stu");

        formula.fullSplit();


    }
}