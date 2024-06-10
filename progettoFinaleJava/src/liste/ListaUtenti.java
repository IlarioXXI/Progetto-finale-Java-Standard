package liste;

import entita.Utente;

import java.util.ArrayList;

public class ListaUtenti {
    public ArrayList<Utente> listaUtenti;

    public ListaUtenti() {
            listaUtenti = new ArrayList<>();
    }

    public void add(Utente utente) throws Exception{
        try {
            listaUtenti.add(utente);
        } catch (Exception e) {
            System.out.println("Errore durante l'aggiunta dell'utente alla lista: " + e.getMessage());
        }
    }

    public Utente modificaUtente(String nuovoNomeUtente, String nuovaPass, Utente utente) throws Exception {
        try {
            utente.setNomeUtente(nuovoNomeUtente);
            utente.setPass(nuovaPass);
            return utente;
        } catch (Exception e) {
            System.out.println("Errore durante la modifica dell'utente: " + e.getMessage());
        }
        return null;
    }

    public boolean utenteEsistente(String email) throws Exception {
        try {
            for (Utente utente : listaUtenti) {
                if (email.equals(utente.getEmail())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Errore durante la verifica dell'utente esistente: " + e.getMessage());
        }
        return false;
    }

    public Utente loginUtente(String nomeUtente, String pass)throws Exception {
        try {
            for (Utente utente : listaUtenti) {
                if (nomeUtente.equals(utente.getNomeUtente()) && pass.equals(utente.getPass())) {
                    return utente;
                }
            }
        } catch (Exception e) {
            System.out.println("Errore durante il login dell'utente: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "ListaUtenti{" +
                "listaUtenti=" + listaUtenti +
                '}';
    }
}
