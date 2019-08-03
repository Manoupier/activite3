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
        checkLigne(x, value);
        checkColonne(y, value);
        checkCarre(trouveCarre(x,y), value);

        //valeur interdite si la cellule de la grille contient déjà la valeur qu'on veut lui assigner
        return this.grille[x][y] != value;

    }

    /**
     * Affiche la grille au joueur.
     */
    public void affiche() {
        System.out.println(stringOfChar('-', 4 * this.taille));
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                System.out.print(Console.FOREGROUNDS[trouveCarre(i+1,j+1)]+ "| "+this.grille[i][j]+ " ");
                System.out.print(Console.ANSI_RESET);
            }
            System.out.println("|");
            System.out.println(stringOfChar('-', 4 * this.taille));
        }
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

    private void checkLigne(int ligne, char value) throws IllegalArgumentException {
        if (Arrays.toString(ligne(ligne)).indexOf(value) != -1) {
            throw new IllegalArgumentException("Cette valeur a déjà été utilisée sur cette ligne");
        }
    }

    private void checkColonne(int col, char value) throws IllegalArgumentException {
        if (Arrays.toString(colonne(col)).indexOf(value) != -1) {
            throw new IllegalArgumentException("Cette valeur a déjà été utilisée sur cette colonne");
        }
    }

    private void checkCarre(int num, char value) throws IllegalArgumentException {
        char[][] carre = carree(num);
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            tab.append(Arrays.toString(carre[i]));
        }

        if (tab.toString().indexOf(value) != -1) {
            throw new IllegalArgumentException("Cette valeur a déjà été utilisée dans ce carré");
        }
    }

    private String stringOfChar(char c, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(c);
        }

        return result.toString();
    }

    /**
     * Trouve le numéro du grand carre auquel appartient une case.
     * @param x numero de ligne de la case
     * @param y numero de colonne de la case
     * @return numero du grand carre
     */
    private int trouveCarre(int x, int y) {
        int abs; //coordonnées de la ligne dans le repere du grand carre
        int ord; //coordonnées de la colonne dans le repere du grand carre
        abs = x % 3 == 0 ? x / 3 : x/3 +1;
        ord = y % 3 == 0 ? y / 3 : y/3 +1;
        //abs = abs == 0 ? 1 : abs;
        //ord = ord == 0 ? 1 : ord;

        if (ord == 2) {
            return abs + 3;
        } else if (ord == 3) {
            return abs + 6;
        }

        return abs;
    }

    /**
     * Les éléments d'une ligne de la grille.
     * @param ligne numero de la ligne
     * @return Ligne
     */
    private char[] ligne(int ligne) {
        char[] result = new char[this.taille];
        System.arraycopy(this.grille[ligne], 0, result, 0, this.taille);
        return result;
    }

    /**
     * Les éléments d'une colonne de la grille.
     * @param ligne numero de la colonne
     * @return Elements de la colonne
     */
    private char[] colonne(int col) {
        char[] result = new char[this.taille];
        for (int i = 0; i < this.taille; i++) {
            result[i] = this.grille[i][col];
        }
        return result;
    }

    /**
     * Les éléments d'un grand carre.
     * @param num numéro du carré
     * @return Eléments du carre
     */
    private char[][] carree(int num) {
        int x = 0, y = 0;
        switch (num) {
            case 1:
                x = 0;
                y = 0;
                break;
            case 2:
                x = 3;
                y = 0;
                break;
            case 3:
                x = 6;
                y = 0;
                break;
            case 4:
                x = 0;
                y = 3;
                break;
            case 5:
                x = 3;
                y = 3;
                break;
            case 6:
                x = 6;
                y = 3;
                break;
            case 7:
                x = 0;
                y = 6;
                break;
            case 8:
                x = 3;
                y = 6;
                break;
            case 9:
                x = 6;
                y = 6;
                break;
        }

        char[][] result = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.grille[x + i][y + j];
            }
        }

        return result;
    }
}
