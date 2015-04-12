package ohtu.verkkokauppa;

import org.springframework.beans.factory.annotation.Autowired;

public class Pankki implements MaksuPaikka {
    
    private TapahtumaLista kirjanpito;

    @Autowired
    public Pankki(TapahtumaLista kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
