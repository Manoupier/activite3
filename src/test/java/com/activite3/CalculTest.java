package com.activite2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe contenant la batterie de tests pour Calcul
 * @author KENNE
 **/
public class CalculTest {
    @Test
    public void testConstructeur() {
        new Calcul();
    }
    @Test
    public void somme() {
        Calcul calcul = new Calcul();
        assertEquals(5, calcul.somme(2,3));
    }

    @Test
    public void maFonction() {
        Calcul calcul = new Calcul();
        assertEquals(4, calcul.maFonction(8,2));
 }

    @Test
    public void division() {
        Calcul calcul = new Calcul();
        assertEquals(2, calcul.division(20,5));
    }
}