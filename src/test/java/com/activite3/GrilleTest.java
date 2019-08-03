package com.activite3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests unitaires pour la classe Grille.
 * @author KENNE
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
            this.grille.setValue(50, 2, 'p'); //caractere non autorise
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void setValue2() {
        this.grille.setValue(1, 2, '1'); //good value
    }

    @Test
    public void setValue3() {
        try {
            this.grille.setValue(1, 2, '1');
            this.grille.setValue(2, 3, '1'); //cette valeur utilisé 2 fois dans un carre
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void setValue4() {
        try {
            this.grille.setValue(1, 2, '1');
            this.grille.setValue(2, 2, '1'); //cette valeur utilisé 2 fois dans une colonne
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void setValue5() {
        try {
            this.grille.setValue(1, 2, '1');
            this.grille.setValue(1, 4, '1'); //cette valeur utilisé 2 fois dans une ligne
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
    public void getValue2() {
        //Grille grille = new GrilleImpl();
        try {
            Assert.assertEquals('@', this.grille.getValue(1, 20)); //invalid position
            Assert.fail();
        } catch (IllegalArgumentException e) {

        }
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

    @Test
    public void possible2() {
        try {
            this.grille.setValue(1, 2, '1');
            this.grille.possible(2, 3, '1'); //cette valeur utilisé 2 fois dans un carre
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void possible3() {
        try {
            this.grille.setValue(1, 2, '1');
            this.grille.possible(2, 2, '1'); //cette valeur utilisé 2 fois dans une colonne
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void possible4() {
        try {
            this.grille.setValue(2, 2, '1');
            this.grille.possible(2, 3, '1'); //cette valeur utilisé 2 fois dans une colonne
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void possible5() {
        try {
            this.grille.setValue(2, 2, '1');
            this.grille.possible(2, 2, '1'); //Valeur identique
            Assert.fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void affiche() {
    }
}
