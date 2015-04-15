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
public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;
    
    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int m = Integer.parseInt(syotekentta.getText());
        this.edellinen = m;
        sovellus.miinus(m);
        tuloskentta.setText("" + sovellus.tulos()); 
    }

    @Override
    public void peru() {
        sovellus.plus(edellinen);
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
