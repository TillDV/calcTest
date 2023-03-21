package de.kruwy;

import de.kruwy.eval.Formula;

import static de.kruwy.eval.VariableReplacement.evalVariables;
import static de.kruwy.eval.VariableReplacement.variables;

public class Main {
    public static void main(String[] args) {

        variables.put("name", "Mensch");
        variables.put("name2", "Bob");

        Formula formula = new Formula("Hallo ${name}! Ich bin (${name2}!)");

        formula.eval();


    }
}