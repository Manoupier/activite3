package com.activite3;

import java.util.Arrays;

/**
 * Implementation d'une grille.
 * @author KENNE
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

    /**
     * Taille d'un grand carre.
     */
    private final int squareLength = 3;

    /**
     * Constructeur de grille.
     */
    public GrilleImpl() {
        this.taille = POSSIBLE.length; //La taille de la grille est egale au
        // nombre de caracteres possibles

        //On initialise toutes les case a la valeur vide
        this.grille = new char[this.taille][this.taille];
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                this.grille[i][j] = EMPTY;
            }
        }
    }

    /**
     *
     * @return largeur/hauteur de la grille.
     */
    public int getDimension() {
        return this.taille;
    }

    /**
     * Affecte une valeur dans la grille.
     * @param x    position x dans la grille
     * @param y    position y dans la grille
     * @param value    valeur a mettre dans la case
     * @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
     * @throws IllegalArgumentException si la valeur est interdite aux vues des
     * autres valeurs de la grille
     * @throws IllegalArgumentException si valeur n'est pas un caractere
     * autorise ('1',...'9')
     */
    public void setValue(final int x, final int y, final char value)
            throws IllegalArgumentException {
        if (possible(x, y, value)) {
            this.grille[x][y] = value;
        }
    }

    /**
     * Recupere une valeur de la grille.
     * @param x    position x dans la grille
     * @param y    position y dans la grille
     * @return valeur dans la case x,y
     * @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
     */
    public char getValue(final int x, final int y)
            throws IllegalArgumentException {
        checkPositions(x, y);
        return this.grille[x][y];
    }

    /**
     * Test si une grille est terminee.
     * @return true si la grille est complete
     */
    public boolean complete() {
        //La grille est complete quand elle ne contient plus de caractere vide
        return Arrays.toString(this.grille).indexOf(EMPTY) == -1;
    }

    /**
     * test si une valeur est possible dans la grille par rapport
     * a ce qu'elle contient deja.
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @param value valeur de la case x,y
     * @return vraie si valeur peut etre assignee a la case x,y
     * @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
     */
    public boolean possible(final int x, final int y, final char value)
            throws IllegalArgumentException {
        checkPositions(x, y);
        checkValue(value);
        checkLigne(x, value);
        checkColonne(y, value);
        checkCarre(trouveCarre(x, y), value);

        //valeur interdite si la cellule de la grille
        // contient déjà la valeur qu'on veut lui assigner
        return this.grille[x][y] != value;

    }

    /**
     * Affiche la grille au joueur.
     */
    public void affiche() {
        final int factor = 4;
        System.out.println(stringOfChar('-', factor * this.taille));
        for (int i = 0; i < this.taille; i++) {
            for (int j = 0; j < this.taille; j++) {
                System.out.print(Console.FOREGROUNDS[trouveCarre(i + 1,
                        j + 1)] + "| " + this.grille[i][j] + " ");
                System.out.print(Console.ANSI_RESET);
            }
            System.out.println("|");
            System.out.println(stringOfChar('-', factor * this.taille));
        }
    }

    /**
     * Vérifie si les coordonnées auxquels ont veut positionner
     * une lettre sont valides.
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
     */
    private void checkPositions(final int x, final int y)
            throws IllegalArgumentException {
        if (x < 0 || x >= this.taille || y < 0 || y >= this.taille) {
            throw new IllegalArgumentException("Les parametres de position "
                   + "sont invalides");
        }
    }

    /**
     * Vérifie si la valeur qu'on veut positionner est correcte.
     * @param value valeur a positionner
     * @throws IllegalArgumentException si valeur n'est pas un
     * caractere autorise
     */
    private void checkValue(final char value) throws IllegalArgumentException {
        if (Arrays.toString(POSSIBLE).indexOf(value) == -1) {
            throw new IllegalArgumentException("Le parametre valeur "
                   + "est incorrect");
        }
    }

    /**
     * Vérifie si la valeur qu'on veut positionner n'est pas
     * encore présente sur la ligne.
     * @param ligne ligne de la grille
     * @param value valeur a positionner
     * @throws IllegalArgumentException si valeur est deja
     * presente sur la ligne
     */
    private void checkLigne(final int ligne, final char value)
            throws IllegalArgumentException {
        if (Arrays.toString(ligne(ligne)).indexOf(value) != -1) {
            throw new IllegalArgumentException("Cette valeur a "
                   + "déjà été utilisée sur cette ligne");
        }
    }

    /**
     * Vérifie si la valeur qu'on veut positionner n'est pas
     * encore présente sur la colonne.
     * @param col colonne de la grille
     * @param value valeur a affecter a la case
     * @throws IllegalArgumentException si valeur est deja
     * presente sur le colonne
     */
    private void checkColonne(final int col, final char value)
            throws IllegalArgumentException {
        if (Arrays.toString(colonne(col)).indexOf(value) != -1) {
            throw new IllegalArgumentException("Cette valeur a déjà été "
                    + "utilisée sur cette colonne");
        }
    }

    /**
     * Vérifie sur la valeur qu'on veut positionner n'est pas encore
     * presente dans le grand carre.
     * @param num numero du grand carre
     * @param value valeur a positionner
     * @throws IllegalArgumentException si valeur est deja
     * presente dans le carre
     */
    private void checkCarre(final int num, final char value)
            throws IllegalArgumentException {
        char[][] carre = carree(num);
        StringBuilder tab = new StringBuilder();
        for (int i = 0; i < this.squareLength; i++) {
            tab.append(Arrays.toString(carre[i]));
        }

        if (tab.toString().indexOf(value) != -1) {
            throw new IllegalArgumentException("Cette valeur a déjà "
                  + "été utilisée dans ce carré");
        }
    }

    /**
     * Construit une chaine de caractere a partir d'un motif.
     * @param c motif
     * @param length longueur de la chaine
     * @return chaine
     */
    private String stringOfChar(final char c, final int length) {
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
    private int trouveCarre(final int x, final int y) {
        if (x == 0 || y == 0) {
            return 1;
        }

        int abs; //coordonnées de la ligne dans le repere du grand carre
        int ord; //coordonnées de la colonne dans le repere du grand carre
        abs = x % this.squareLength == 0
                ? x / this.squareLength : x / this.squareLength + 1;

        ord = y % this.squareLength == 0
                ? y / this.squareLength : y / this.squareLength + 1;

        if (ord == 2) {
            return abs + this.squareLength;
        } else if (ord == this.squareLength) {
            return abs + this.squareLength * 2;
        }

        return abs;
    }

    /**
     * Les éléments d'une ligne de la grille.
     * @param ligne numero de la ligne
     * @return Elements de la ligne
     */
    private char[] ligne(final int ligne) {
        char[] result = new char[this.taille];
        System.arraycopy(this.grille[ligne], 0, result, 0, this.taille);
        return result;
    }

    /**
     * Les éléments d'une colonne de la grille.
     * @param col numero de la colonne
     * @return Elements de la colonne
     */
    private char[] colonne(final int col) {
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
    private char[][] carree(final int num) {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int seven = 7;
        final int eight = 8;
        final int nine = 9;

        int x = 0, y = 0;
        switch (num) {
            case one:
                x = 0;
                y = 0;
                break;
            case two:
                x = this.squareLength;
                y = 0;
                break;
            case three:
                x = this.squareLength * 2;
                y = 0;
                break;
            case four:
                x = 0;
                y = this.squareLength;
                break;
            case five:
                x = this.squareLength;
                y = this.squareLength;
                break;
            case six:
                x = this.squareLength * 2;
                y = this.squareLength;
                break;
            case seven:
                x = 0;
                y = this.squareLength * 2;
                break;
            case eight:
                x = this.squareLength;
                y = this.squareLength * 2;
                break;
            case nine:
                x = this.squareLength * 2;
                y = this.squareLength * 2;
                break;
                default:
                    x = -1;
                    y = -1;
                    break;
        }

        char[][] result = new char[this.squareLength][this.squareLength];
        for (int i = 0; i < this.squareLength; i++) {
            for (int j = 0; j < this.squareLength; j++) {
                result[i][j] = this.grille[x + i][y + j];
            }
        }

        return result;
    }
}
