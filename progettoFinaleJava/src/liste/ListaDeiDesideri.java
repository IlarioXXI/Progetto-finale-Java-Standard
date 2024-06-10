package liste;

import entita.Libro;

import java.util.ArrayList;
import java.util.List;

public class ListaDeiDesideri {
    List<Libro>listaDeiDesideri;

    public ListaDeiDesideri() {
        listaDeiDesideri = new ArrayList<>();
    }

    public void addListaDeiDesideri(Libro libro) {
        try {
            listaDeiDesideri.add(libro);
        } catch (Exception e) {
            System.out.println("Errore durante l'aggiunta del libro alla lista dei desideri: " + e.getMessage());
        }
    }
}
