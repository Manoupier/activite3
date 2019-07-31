package com.emiage.sudoku;

import java.util.Arrays;

/**
 * Implementation d'une grille.
 */
public class GrilleImpl implements Grille {
    /**
     * Representation de la grille.
     */
    private char[][] grille;

    /**
     * Taille de la grille.
     */
    private int taille;

    public GrilleImpl() {
        this.taille = possible.length; //La taille de la grille est egale au nombre de caracteres possibles

        //On initialise toutes les case a la valeur vide
        this.grille = new char[this.taille][this.taille];
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                this.grille[i][j] = EMPTY;
            }
        }
    }

    public int getDimension() {
        return this.taille;
    }

    public void setValue(int x, int y, char value) throws IllegalArgumentException {
        if (possible(x, y, value)) {
            this.grille[x][y] = value;
        }
    }

    public char getValue(int x, int y) throws IllegalArgumentException {
        checkPositions(x, y);
        return this.grille[x][y];
    }

    public boolean complete() {
        //La grille est complete quand elle ne contient plus de caractere vide
        return Arrays.toString(this.grille).indexOf(EMPTY) == -1;
    }

    public boolean possible(int x, int y, char value) throws IllegalArgumentException {
        checkPositions(x, y);
        checkValue(value);

        //valeur interdite si la cellule de la grille contient déjà la valeur qu'on veut lui assigner
        if (this.grille[x][y] == value) {
            return false;
        }

        return true;
    }

    private void checkPositions(int x, int y) throws IllegalArgumentException {
        if (x < 0 || x >= this.taille || y < 0 || y >= this.taille) {
            throw new IllegalArgumentException("Les parametres de position sont invalides");
        }
    }

    private void checkValue(char value) throws IllegalArgumentException {
        if (Arrays.toString(possible).indexOf(value) == -1) {
            throw new IllegalArgumentException("Le parametre valeur est incorrect");
        }
    }
}
