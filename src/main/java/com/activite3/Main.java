package com.activite3;

import java.util.Scanner;

/**
 * Classe principale.
 * @author KENNE
 **/
public final class Main {

    /**
     * Point d'entre de l'application.
     * @param args arguments
     */
    public static void main(final String[] args) {
        Grille grille = new GrilleImpl();
        int x, y;
        String value;
        Scanner sc = new Scanner(System.in);
        grille.affiche();

        while (!grille.complete()) {
            System.out.print("Position x dans la grille : ");
            x = sc.nextInt();

            System.out.print("Position y dans la grille : ");
            y = sc.nextInt();

            System.out.print("Valeur à ajouter : ");
            sc.nextLine();
            value = sc.nextLine();

            try {
                grille.setValue(x - 1, y - 1, value.charAt(0));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            //Reaffichage de la grille
            grille.affiche();
        }
    }

    /**
     * Constructeur prive.
     */
    private Main() {

    }
}
