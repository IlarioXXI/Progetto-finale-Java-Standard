package entitasecondarie;

import entita.Libro;
import entita.Utente;

import java.time.LocalDate;


public class Prestito {
    Libro libro;
    Utente utente;
    LocalDate dataInizioPrestito;
    public LocalDate dataFinePrestito;
    Integer scelta;
    public Boolean statoPrestito;

    public Prestito(LocalDate dataInizioPrestito, Utente utente, Integer scelta, Libro libro) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.utente = utente;
        this.scelta = scelta;
        this.libro = libro;
    }


    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getScelta() {
        return scelta;
    }

    public void setScelta(Integer scelta) {
        this.scelta = scelta;
    }

    public LocalDate finePrestito(Prestito prestito) {
        LocalDate dataInizio = prestito.getDataInizioPrestito();
        try {
            switch (prestito.getScelta()) {
                case 1:
                    dataFinePrestito = dataInizio.plusMonths(1);
                    break;
                case 2:
                    dataFinePrestito = dataInizio.plusMonths(2);
                    break;
                case 3:
                    dataFinePrestito = dataInizio.plusMonths(3);
                    break;
                default:
                    throw new IllegalArgumentException("Non puoi tenere un libro per più di tre mesi.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
        return dataFinePrestito;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "dataFinePrestito=" + dataFinePrestito +
                ", libro=" + libro +
                ", dataInizioPrestito=" + dataInizioPrestito +
                '}';
    }
}
