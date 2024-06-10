package liste;

import entita.Libro;

import java.util.ArrayList;

public class ListaLibri {
    public ArrayList<Libro> listaLibri;

    public ListaLibri() {
        try {
            listaLibri = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Errore durante l'inizializzazione della lista dei libri: " + e.getMessage());
        }
    }

    public void add(Libro libro) {
        try {
            listaLibri.add(libro);
        } catch (Exception e) {
            System.out.println("Errore durante l'aggiunta del libro alla lista: " + e.getMessage());
        }
    }

    public ListaLibri cercaLibroPerTitolo(String titolo) {
        try {
            ListaLibri listaLibriTrovati = new ListaLibri();
            for (Libro libro : listaLibri) {
                if (libro.titolo.equals(titolo)) {
                    listaLibriTrovati.add(libro);
                }
            }
            if (listaLibriTrovati.listaLibri.isEmpty()) {
                System.out.println("Nessun libro trovato con il titolo: " + titolo);
            } else {
                return listaLibriTrovati;
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca del libro per titolo: " + e.getMessage());
        }
        return null;
    }

    public ListaLibri cercaLibroPerAutore(String autore) {
        try {
            ListaLibri listaLibriTrovati = new ListaLibri();
            for (Libro libro : listaLibri) {
                if (libro.autore.equals(autore)) {
                    listaLibriTrovati.add(libro);
                }
            }
            if (listaLibriTrovati.listaLibri.isEmpty()) {
                System.out.println("Nessun libro trovato dell'autore: " + autore);
            } else {
                return listaLibriTrovati;
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca del libro per autore: " + e.getMessage());
        }
        return null;
    }

    public ListaLibri cercaLibroPerGenere(String genere) {
        try {
            ListaLibri listaLibriTrovati = new ListaLibri();
            for (Libro libro : listaLibri) {
                if (libro.genere.equals(genere)) {
                    listaLibriTrovati.add(libro);
                }
            }
            if (listaLibriTrovati.listaLibri.isEmpty()) {
                System.out.println("Nessun libro trovato del genere: " + genere);
            } else {
                return listaLibriTrovati;
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca del libro per genere: " + e.getMessage());
        }
        return null;
    }

    public ListaLibri cercaLibriDisponibili() {
        try {
            ListaLibri listaLibriDisponibili = new ListaLibri();
            for (Libro libro : listaLibri) {
                if (libro.disponibilita) {
                    listaLibriDisponibili.add(libro);
                    return listaLibriDisponibili;
                }
            }
        } catch (Exception e) {
            System.out.println("Errore durante la ricerca dei libri disponibili: " + e.getMessage());
        }
        return null;
    }

    public Libro scegliLibroPerPrestito(String titolo, String autore) {
        try {
            for (Libro libro : listaLibri) {
                if (libro.autore.equals(autore) && libro.titolo.equals(titolo)) {
                    return libro;
                }
            }
        } catch (Exception e) {
            System.out.println("Errore durante la selezione del libro per il prestito: " + e.getMessage());
        }
        return null;
    }
    public static void cambiaDisponibilita(Libro libro) {
        libro.disponibilita = !libro.disponibilita;
    }

    @Override
    public String toString() {
        return "ListaLibri{" +
                "listaLibri=" + listaLibri +
                '}';
    }
}
