package com.activite3;

/**
 * Définition de la classe Console.
 * @author KENNE
 **/
public final class Console {
    /**
     * Retour a la valeur par defaut.
     */
    public static final String ANSI_RESET  = "\u001B[0m";

    /**
     * Couleur noire.
     */
    public static final String ANSI_BLACK  = "\u001B[30m";

    /**
     * Couleur rouge.
     */
    public static final String ANSI_RED    = "\u001B[31m";

    /**
     * Couleur verte.
     */
    public static final String ANSI_GREEN  = "\u001B[32m";

    /**
     * Couleur jaune.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Couleur bleue.
     */
    public static final String ANSI_BLUE   = "\u001B[34m";

    /**
     * Couleur pourpre.
     */
    public static final String ANSI_PURPLE = "\u001B[35m";

    /**
     * Couleur Cyan.
     */
    public static final String ANSI_CYAN   = "\u001B[36m";

    /**
     * Couleur blanche.
     */
    public static final String ANSI_WHITE  = "\u001B[37m";

    /**
     * Couleur console noire claire.
     */
    public static final String ANSI_BRIGHT_BLACK  = "\u001B[90m";

    /**
     * Couleur console rouge claire.
     */
    public static final String ANSI_BRIGHT_RED    = "\u001B[91m";

    /**
     * Couleur console vert claire.
     */
    public static final String ANSI_BRIGHT_GREEN  = "\u001B[92m";

    /**
     * Couleur console jaune claire.
     */
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";

    /**
     * Couleur console bleue claire.
     */
    public static final String ANSI_BRIGHT_BLUE   = "\u001B[94m";

    /**
     * Couleur console pourpre claire.
     */
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";

    /**
     * Couleur console cyan claire.
     */
    public static final String ANSI_BRIGHT_CYAN   = "\u001B[96m";

    /**
     * Couleur console blanc claire.
     */
    public static final String ANSI_BRIGHT_WHITE  = "\u001B[97m";

    /**
     * Tableau de coleurs.
     */
    public static final String[] FOREGROUNDS = {
            ANSI_BLACK, ANSI_RED, ANSI_GREEN, ANSI_YELLOW,
            ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE,
            ANSI_BRIGHT_BLACK, ANSI_BRIGHT_RED, ANSI_BRIGHT_GREEN,
            ANSI_BRIGHT_YELLOW, ANSI_BRIGHT_BLUE, ANSI_BRIGHT_PURPLE,
            ANSI_BRIGHT_CYAN, ANSI_BRIGHT_WHITE
    };

    /**
     * Constructeur privé.
     */
    private Console() {

    }

    /*public static final String ANSI_BG_BLACK  = "\u001B[40m";
    public static final String ANSI_BG_RED    = "\u001B[41m";
    public static final String ANSI_BG_GREEN  = "\u001B[42m";
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public static final String ANSI_BG_BLUE   = "\u001B[44m";
    public static final String ANSI_BG_PURPLE = "\u001B[45m";
    public static final String ANSI_BG_CYAN   = "\u001B[46m";
    public static final String ANSI_BG_WHITE  = "\u001B[47m";

    public static final String ANSI_BRIGHT_BG_BLACK  = "\u001B[100m";
    public static final String ANSI_BRIGHT_BG_RED    = "\u001B[101m";
    public static final String ANSI_BRIGHT_BG_GREEN  = "\u001B[102m";
    public static final String ANSI_BRIGHT_BG_YELLOW = "\u001B[103m";
    public static final String ANSI_BRIGHT_BG_BLUE   = "\u001B[104m";
    public static final String ANSI_BRIGHT_BG_PURPLE = "\u001B[105m";
    public static final String ANSI_BRIGHT_BG_CYAN   = "\u001B[106m";
    public static final String ANSI_BRIGHT_BG_WHITE  = "\u001B[107m";

    public static final String[] BACKGROUNDS = {
            ANSI_BG_BLACK, ANSI_BG_RED, ANSI_BG_GREEN, ANSI_BG_YELLOW,
            ANSI_BG_BLUE, ANSI_BG_PURPLE, ANSI_BG_CYAN, ANSI_BG_WHITE,
            ANSI_BRIGHT_BG_BLACK, ANSI_BRIGHT_BG_RED, ANSI_BRIGHT_BG_GREEN,
            ANSI_BRIGHT_BG_YELLOW,
            ANSI_BRIGHT_BG_BLUE, ANSI_BRIGHT_BG_PURPLE, ANSI_BRIGHT_BG_CYAN,
            ANSI_BRIGHT_BG_WHITE };*/

}
