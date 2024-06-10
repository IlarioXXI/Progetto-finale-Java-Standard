package entita;

import entitaprimaria.Persona;
import entitasecondarie.Prestito;
import liste.ListaPrestiti;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Utente extends Persona {
    String nomeUtente;
    public Float penalita;
    public ListaPrestiti listaPrestiti;

    public Utente(ListaPrestiti listaPrestiti, String nomeUtente, Float penalita, String nome, String cognome, String email) {
        super(nome, cognome, email);
        this.listaPrestiti = listaPrestiti;
        this.nomeUtente = nomeUtente;
        this.penalita = penalita;
    }

    public Utente(String nome, String cognome, String email) {
        super(nome, cognome, email);
        listaPrestiti = new ListaPrestiti();
    }


    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }


    public Float getPenalita() {
        return penalita;
    }

    public boolean registrazioneUtente(String nome, String cognome) {
        if (nome.matches(".*\\d.*") && cognome.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }

    public void aggiungiPenalita(Prestito prestito, Utente utente) {
        try {
            if (!prestito.statoPrestito) {
                utente.penalita += 5;
            }
        } catch (NullPointerException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public void controllaLoStatoDeiTuoiPrestiti(Utente utente) {
        System.out.println(utente.listaPrestiti);
    }

    public void controllaDataDiScadenzaPrestito(LocalDate oggi, Prestito prestito) {
        try {
            LocalDate dataFine = prestito.finePrestito(prestito);
            if (dataFine.isAfter(oggi)) {
                System.out.println("Il libro: " + prestito.getLibro().titolo + " deve essere restituito tra: " + ChronoUnit.DAYS.between(oggi, prestito.dataFinePrestito) + "giorni.");
                prestito.statoPrestito = true;
            } else {
                System.out.println("Il libro: " + prestito.getLibro().titolo + "doveva essere consegnato " + ChronoUnit.DAYS.between(oggi, prestito.dataFinePrestito) + " giorni fa.");
                prestito.statoPrestito = false;
            }
        } catch (NullPointerException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public void restituisciLibro(Prestito prestito) {
        try {
            prestito.getLibro().disponibilita = true;
            prestito.statoPrestito = null;
        } catch (NullPointerException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Utente{" +
                "nomeUtente='" + nomeUtente + '\'' +
                ", penalita=" + penalita +
                ", listaPrestiti=" + listaPrestiti +
                "} " + super.toString();
    }
}
