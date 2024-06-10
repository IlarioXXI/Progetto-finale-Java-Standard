package entita;

import entitasecondarie.Recensione;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    public String titolo;
    public String autore;
    public String genere;
    public int annoDiPubblicazione;
    public boolean disponibilita;
    List<Recensione> listaRecensioni;

    public Libro(String titolo, String autore, String genere, int annoDiPubblicazione, Boolean disponibilita) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.annoDiPubblicazione = annoDiPubblicazione;
        this.disponibilita = disponibilita;
        listaRecensioni = new ArrayList<>();
    }

    public void addRecensione(Recensione recensione) {
        listaRecensioni.add(recensione);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", listaRecensioni=" + listaRecensioni +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", disponibilita=" + disponibilita +
                '}';
    }
}
