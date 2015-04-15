/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author pihla
 */
public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;
    
    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int plussattava = Integer.parseInt(syotekentta.getText());
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        edellinen = plussattava;
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinen);
        tuloskentta.setText("" + sovellus.tulos());
    }
}
