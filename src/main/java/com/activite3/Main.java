package com.emiage.sudoku;

import java.util.Scanner;

/**
 * @author Jirez Tchinda <jireztchinda@epstechgroup.com>
 * copyright eps-technologies
 * Date 02/08/19
 * Time 13:31
 **/
public class Main {
    public static void main(String[] args) {
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
                grille.setValue(x-1, y-1, value.charAt(0));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            //Reaffichage de la grille
            grille.affiche();
        }
    }
}
