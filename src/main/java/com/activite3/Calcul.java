package com.activite3;

/**
 * Définition de la classe Calcul.
 * @author KENNE
 **/
public class Calcul {
    /**Définition de la constante NBR.
     **/
    private final int nBR = 10;
    /** Calcule la somme de deux nombres.
     * @param a premier entier
     * @param b deuxième entier
     * @return retourne la somme de a et b
     **/
    public int somme(final int a, final int b) {
        return a + b;
    }
    /** Effectue la division entre deux nombres a et b.
     * @param a premier opérande (numérateur)
     * @param b deuxième opérande (dénominateur)
     * @return retourne la résultat de a par b ou b selon une condition
     **/
    public int maFonction(final int a, final int b) {
        if (b >= nBR) {
            return a / b;
        }
        return b;
    }
    /**
     * Effectue la division entre deux nombres a et b.
     * @param a premier opérande (numérateur)
     * @param b deuxième opérande (dénominateur)
     * @return a / b si b != 0
     * @throws IllegalArgumentException si b == 0
     */
    public int division(final int a, final int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b ne doit pas etre 0");
        }
        return a / b;
    }
}
