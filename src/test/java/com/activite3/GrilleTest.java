package com.emiage.sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests unitaires pour la classe Grille.
 */
public class GrilleTest {
    private Grille grille;

    @Before
    public void init() {
        grille = new GrilleImpl();
    }
    @Test
    public void testConstructeur() {
        new GrilleImpl();
    }

    @Test
    public void getDimension() {
        Grille grille = new GrilleImpl();
        Assert.assertEquals(9, grille.getDimension());
    }

    @Test
    public void setValue() {
        try {
            this.grille.possible(50, 2, 'p');
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void getValue() {
        Grille grille = new GrilleImpl();
        Assert.assertEquals('@', grille.getValue(1,2));
    }

    @Test
    public void complete() {
        Grille grille = new GrilleImpl();
        Assert.assertFalse(grille.complete());
    }

    @Test
    public void possible() {
        Grille grille = new GrilleImpl();
        Assert.assertTrue(grille.possible(1, 2, '5'));

        try {
            grille.possible(20, 7, 'd');
            Assert.fail("Les parametres de position sont invalides");
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }
}
