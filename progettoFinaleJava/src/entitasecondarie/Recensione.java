package entitasecondarie;

import entita.Utente;

public class Recensione {
    String recensione;
    Utente utente;

    public String getRecensione() {
        return recensione;
    }

    public void setRecensione(String recensione) {
        this.recensione = recensione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Recensione{" +
                "recensione='" + recensione + '\'' +
                '}';
    }
}
