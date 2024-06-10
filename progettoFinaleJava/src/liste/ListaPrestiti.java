package liste;

import entita.Libro;
import entitasecondarie.Prestito;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPrestiti {
    public ArrayList<Prestito> listaPrestiti;

    public ListaPrestiti() {
            listaPrestiti = new ArrayList<>();
    }


    public void aggiungiPrestito( Prestito prestito){
        listaPrestiti.add(prestito);
    }
    public Libro sceglibroDaRestituire(String titolo, String autore) {
        try {
            for (Prestito prestito : listaPrestiti) {
                if (prestito.getLibro().autore.equals(autore) && prestito.getLibro().titolo.equals(titolo)) {
                    return prestito.getLibro();
                }
            }
        } catch (Exception e) {
            System.out.println("Errore durante la selezione del libro per il prestito: " + e.getMessage());
        }
        return null;
    }

    public void cancellaLibro(Libro libro) {
        boolean libroTrovato = false;
        try {
            Iterator<Prestito> iterator = listaPrestiti.iterator();
            while (iterator.hasNext()) {
                Prestito prestito = iterator.next();
                if (prestito.getLibro().equals(libro)) {
                    iterator.remove();
                    libroTrovato = true;
                    System.out.println("Libro restituito.");
                    break;
                }
            }
            if (!libroTrovato) {
                System.out.println("Libro non trovato nella lista dei prestiti.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "ListaPrestiti{" +
                "listaPrestiti=" + listaPrestiti +
                '}';
    }
}
