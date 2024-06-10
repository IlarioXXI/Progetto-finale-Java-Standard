import entita.Gestore;
import entita.Libro;
import entita.Utente;
import entitasecondarie.Prestito;
import entitasecondarie.Recensione;
import liste.ListaDeiDesideri;
import liste.ListaLibri;
import liste.ListaPrestiti;
import liste.ListaUtenti;

import java.time.LocalDate;
import java.util.Scanner;

import static liste.ListaLibri.cambiaDisponibilita;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDate oggi = LocalDate.now();
        Gestore gestore = new Gestore();
        Scanner in = new Scanner(System.in);

        ListaUtenti listaUtenti = new ListaUtenti();
        ListaLibri listaLibri = new ListaLibri();
        ListaPrestiti listaPrestiti = new ListaPrestiti();


        Libro libro1 = new Libro("Il signore degli anelli", "J.R.R. Tolkien", "Fantasy", 1954, true);
        listaLibri.add(libro1);

        Libro libro2 = new Libro("Harry Potter e la pietra filosofale", "J.K. Rowling", "Fantasy", 1997, true);
        listaLibri.add(libro2);

        Libro libro3 = new Libro("Cronache del ghiaccio e del fuoco", "George R.R. Martin", "Fantasy", 1996, true);
        listaLibri.add(libro3);

        Libro libro4 = new Libro("1984", "George Orwell", "Romanzo distopico", 1949, true);
        listaLibri.add(libro4);

        Libro libro5 = new Libro("Il giovane Holden", "J.D. Salinger", "Romanzo", 1951, true);
        listaLibri.add(libro5);

        Libro libro6 = new Libro("La colonna di fuoco", "Ken Follett", "Romanzo storico", 2017, true);
        listaLibri.add(libro6);

        Libro libro7 = new Libro("Cime tempestose", "Emily Brontë", "Romanzo", 1847, true);
        listaLibri.add(libro7);

        Libro libro8 = new Libro("Orgoglio e pregiudizio", "Jane Austen", "Romanzo", 1813, true);
        listaLibri.add(libro8);

        Libro libro9 = new Libro("Moby Dick", "Herman Melville", "Romanzo", 1851, true);
        listaLibri.add(libro9);

        Libro libro10 = new Libro("Il vecchio e il mare", "Ernest Hemingway", "Romanzo", 1952, true);
        listaLibri.add(libro10);

        Libro libro11 = new Libro("Cent'anni di solitudine", "Gabriel García Márquez", "Romanzo", 1967, true);
        listaLibri.add(libro11);

        Libro libro12 = new Libro("Il processo", "Franz Kafka", "Romanzo", 1925, true);
        listaLibri.add(libro12);

        Libro libro13 = new Libro("Don Chisciotte della Mancia", "Miguel de Cervantes", "Romanzo", 1605, true);
        listaLibri.add(libro13);

        Libro libro14 = new Libro("Cinquanta sfumature di grigio", "E.L. James", "Romanzo erotico", 2011, true);
        listaLibri.add(libro14);

        Libro libro15 = new Libro("L'ombra del vento", "Carlos Ruiz Zafón", "Romanzo", 2001, true);
        listaLibri.add(libro15);

        Utente utenteEsistente1 = new Utente("nomeUtenteEsistente1", "cognomeUtenteEsistente1", "emailStudenteEsistente1");
        Utente utenteEsistente2 = new Utente("nomeUtenteEsistente2", "cognomeUtenteEsistente2", "emailStudenteEsistente2");

        Prestito prestito1 = new Prestito(oggi, utenteEsistente1, 1, libro2);
        Prestito prestito2 = new Prestito(oggi, utenteEsistente2, 3, libro3);
        listaPrestiti.aggiungiPrestito(prestito1);
        listaPrestiti.aggiungiPrestito(prestito2);
        listaUtenti.add(utenteEsistente1);
        listaUtenti.add(utenteEsistente2);

        System.out.println("Entrare nel gestionale da amministratore o da utente?" +
                "Premi 1 se sei un amministratore o premi 2 se sei un utente.");
        int amministratoreUtente = in.nextInt();
        while (amministratoreUtente != 1 && amministratoreUtente != 2) {
            System.out.println("Inserire un numero tra 1 e 2: ");
            amministratoreUtente = in.nextInt();
        }
        while (amministratoreUtente == 1 || amministratoreUtente == 2) {
            boolean accessoConcesso = false;
            switch (amministratoreUtente) {
                case 1:
                    System.out.println("(Per testare l'area gestore inserire email : " + gestore.getEmail() + " ,e inserire password: " + gestore.getPass() + ")");
                    System.out.print("Inserire email: ");
                    String emailAdmin = in.next();
                    System.out.print("Inserire password: ");
                    String passAdmin = in.next();
                    if (emailAdmin.equals(gestore.getEmail()) && passAdmin.equals(gestore.getPass())) {
                        accessoConcesso = true;
                        System.out.println("Per vedere tutti i libri premi 1 per vedere tutti i prestiti premi 2.");
                        int inAdmin = in.nextInt();
                        while (inAdmin != 1 && inAdmin != 2) {
                            System.out.println("Inserire un numero tra 1 e 2.");
                            inAdmin = in.nextInt();
                        }
                        while (inAdmin == 1 || inAdmin == 2) {
                            switch (inAdmin) {
                                case 1:
                                    System.out.println(listaLibri);
                                    System.out.println("Se vuoi vedere tutti i prestiti premi 2 altrimenti qualsiasi altro numero.");
                                    inAdmin = in.nextInt();
                                    break;
                                case 2:
                                    System.out.println(listaPrestiti);
                                    System.out.println("Se vuoi vedere la lista di tutti i libri premi 1 altrimenti qualsiasi altro numero.");
                                    inAdmin = in.nextInt();
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Password o email non valida. Riprova.");
                    }

                    System.out.println("Per accedere come utente premi 2 altrimenti premi 1.");
                    amministratoreUtente = in.nextInt();


                case 2:
                    System.out.println("Premere 0 per inserire un nuovo utente o un qualsiasi altro numero per accedere.");
                    int scelta;
                    scelta = in.nextInt();
                    in.nextLine();
                    while (scelta == 0) {
                        System.out.println("Registra nuovo utente o accedi.");
                        System.out.println("Inserire nome: ");
                        String nome = in.nextLine();
                        System.out.println("Inserire cognome: ");
                        String cognome = in.nextLine();
                        System.out.println("Inserire nome utente: ");
                        String nomeUtente = in.next();
                        System.out.println("Inserire email: ");
                        String email = in.next();
                        System.out.println("Inserire password: ");
                        String passUtente = in.next();
                        Utente nuovoUtente = new Utente(nome, cognome, email);
                        nuovoUtente.setPass(passUtente);
                        nuovoUtente.setNomeUtente(nomeUtente);

                        if (!nuovoUtente.registrazioneUtente(nuovoUtente.getNome(), nuovoUtente.getCognome())) {
                            System.out.println("Controllare che i dati inseriti siano giusti.");
                            continue;
                        }

                        if (listaUtenti.utenteEsistente(email)) {
                            System.out.println("Utente già registrato.");
                        } else {
                            listaUtenti.add(nuovoUtente);
                        }

                        System.out.println("Per inserire un nuovo utente premi 0 altrimenti qualsiasi altro numero per accedere.");
                        scelta = in.nextInt();
                        in.nextLine();
                    }
                    System.out.println("Inserire nome utente: ");
                    String nomeUtente = in.nextLine();
                    System.out.println("Inserire password: ");
                    String passUtente = in.next();
                    Utente utenteLogin = listaUtenti.loginUtente(nomeUtente, passUtente);
                    System.out.println("Dati utente: " + utenteLogin);
                    System.out.println("Nel caso in cui tu volessi cambiare nome utente o password premi 1. Altrimenti qualsiasi altro numero per continuare.");
                    int cambioDati = in.nextInt();
                    in.nextLine();
                    if (cambioDati == 1) {
                        System.out.print("Inserire il nuovo nome utente: ");
                        String nuovoNome = in.nextLine();
                        System.out.print("Inserire la nuova password: ");
                        String nuovaPass = in.next();
                        System.out.println(listaUtenti.modificaUtente(nuovoNome, nuovaPass, utenteLogin));
                    }
                    System.out.println("Filtra il libro in base alle tue preferenze.");
                    System.out.println("Inserisci titolo, inserisci genere o inserisci nome dell'autore.Premi 1 per scegliere il libro tramite il titolo, 2 per il genere e 3 per l'autore.");
                    int filtraLibro = in.nextInt();
                    in.nextLine();
                    while (filtraLibro != 1 && filtraLibro != 2 && filtraLibro != 3) {
                        System.out.println("Inserire un numero tra 1 , 2 e 3: ");
                        filtraLibro = in.nextInt();
                        in.nextLine();
                    }
                    while (filtraLibro == 1 || filtraLibro == 2 || filtraLibro == 3) {
                        switch (filtraLibro) {
                            case 1:
                                System.out.print("Inserire il titolo del libro: ");
                                String titolo = in.nextLine();
                                System.out.println(listaLibri.cercaLibroPerTitolo(titolo));
                                break;
                            case 2:
                                System.out.print("Inserire genere del libro: ");
                                String genere = in.nextLine();
                                System.out.println(listaLibri.cercaLibroPerGenere(genere));
                                break;
                            case 3:
                                System.out.print("Inserire il nome dell'autore del libro: ");
                                String autore = in.nextLine();
                                System.out.println(listaLibri.cercaLibroPerAutore(autore));
                                break;
                        }
                        System.out.println("Se vuoi cercare altri libri premi gli stessi numeri con gli stessi criteri.Altrimenti presi un altro numero.");
                        filtraLibro = in.nextInt();
                        in.nextLine();
                    }
                    System.out.println("Vuoi inserire un libro in una lista desideri? Premi 1 per aggiungere un numero altrimenti qualsiasi altro numero.");
                    int inListaDesideri = in.nextInt();
                    in.nextLine();
                    while (inListaDesideri == 1) {
                        System.out.println("Inserisci titolo del libro");
                        String titoloLibro = in.nextLine();
                        System.out.println("Inserire nome dell'autore");
                        String nomeAutore = in.nextLine();
                        ListaDeiDesideri listaDeiDesideri = new ListaDeiDesideri();
                        if (listaLibri.scegliLibroPerPrestito(titoloLibro, nomeAutore) == null) {
                            System.out.println("Libro non trovato");
                        } else {
                            listaDeiDesideri.addListaDeiDesideri(listaLibri.scegliLibroPerPrestito(titoloLibro, nomeAutore));
                        }
                        System.out.println("Vuoi aggiungere un altro libro? Se si premi 1.");
                        inListaDesideri = in.nextInt();
                        in.nextLine();
                    }
                    System.out.println("Vuoi prendere in prestito un libro? Premi 1 per richiedere un libro in prestito altrimenti qualsiasi altro numero.");
                    int sceltaPrestito = in.nextInt();
                    in.nextLine();
                    while (sceltaPrestito == 1) {
                        System.out.println("Inserisci titolo del libro:");
                        String titoloLibro = in.nextLine();
                        System.out.println("Inserire nome dell'autore:");
                        String nomeAutore = in.nextLine();
                        Libro libroPrestito = listaLibri.scegliLibroPerPrestito(titoloLibro, nomeAutore);
                        if (!listaLibri.scegliLibroPerPrestito(titoloLibro, nomeAutore).disponibilita) {
                            System.out.println("Libro non disponibile.");
                            System.out.println("Se vuoi prendere un libro in prestito premi 1.");
                            sceltaPrestito = in.nextInt();
                            in.nextLine();
                        }

                        cambiaDisponibilita(libroPrestito);
                        System.out.println("Per quanti mesi vuoi tenere il libro? Inserire un numero da uno a tre.");
                        int sceltaMesi = in.nextInt();
                        in.nextLine();
                        while (sceltaMesi != 1 && sceltaMesi != 2 && sceltaMesi != 3) {
                            if (sceltaMesi > 3) {
                                System.out.println("Non puoi tenere il libro per più di tre mesi.Scegli un numero tra 1 e 3.");
                                sceltaMesi = in.nextInt();
                                in.nextLine();
                            } else {
                                System.out.println("Non puoi avere il libro per meno di un mese. Scegli un numero tra 1 e 3.");
                                sceltaMesi = in.nextInt();
                                in.nextLine();
                            }
                        }

                        Prestito prestito = new Prestito(oggi, utenteLogin, sceltaMesi, libroPrestito);
                        prestito.finePrestito(prestito);
                        prestito.finePrestito(prestito);
                        utenteLogin.listaPrestiti.aggiungiPrestito(prestito);
                        System.out.println("Se vui prendere in prestito un altro libro premi 1.Altrimenti qualsiasi altro numero.");
                        sceltaPrestito = in.nextInt();
                        in.nextLine();
                    }
                    System.out.println("Per controllare la lista dei tuoi prestiti premi 1, per restituire un libro premi 2, per controllare la scadenza di un prestito premi 3.");
                    int inStatoLibro = in.nextInt();
                    in.nextLine();
                    while (inStatoLibro != 1 && inStatoLibro != 2 && inStatoLibro != 3) {
                        System.out.print("Inserire un numero tra 1 e 2.");
                        inStatoLibro = in.nextInt();
                        in.nextLine();
                    }
                    while (inStatoLibro == 1 || inStatoLibro == 2 || inStatoLibro == 3) {
                        switch (inStatoLibro) {
                            case 1:
                                utenteLogin.controllaLoStatoDeiTuoiPrestiti(utenteLogin);
                                System.out.println("Per controllare la lista dei tuoi prestiti premi 1, per restituire un libro premi 2, per controllare la scadenza di un prestito premi 3 o qualsiasi altro numero per uscire.");
                                inStatoLibro = in.nextInt();
                                in.nextLine();
                                break;

                            case 2:
                                System.out.println("Inserire titolo del libro da restituire.");
                                String titoloDaRestituire = in.nextLine();
                                System.out.println("Inserire nome dell'autore.");
                                String autoreDaRestituire = in.nextLine();
                                Libro libroDaRestituire = utenteLogin.listaPrestiti.sceglibroDaRestituire(titoloDaRestituire, autoreDaRestituire);
                                utenteLogin.listaPrestiti.cancellaLibro(libroDaRestituire);
                                System.out.println("Vuoi inserire una recensione? Premi 1 per inserire una recensione.");
                                int inRecensione = in.nextInt();
                                in.nextLine();
                                if (inRecensione == 1) {
                                    Recensione recensione = new Recensione();
                                    System.out.println("Inserire la recensione.");
                                    String recensioneString = in.nextLine();
                                    recensione.setRecensione(recensioneString);
                                    recensione.setUtente(utenteLogin);
                                    libroDaRestituire.addRecensione(recensione);
                                }
                                System.out.println("Per controllare la lista dei tuoi prestiti premi 1, per restituire un libro premi 2, per controllare la scadenza di un prestito premi 3 o qualsiasi altro numero per uscire.");
                                inStatoLibro = in.nextInt();
                                in.nextLine();
                                break;

                            case 3:
                                System.out.println("Controlla lo stato dei tuoi libri presi in prestito.");
                                utenteLogin.controllaLoStatoDeiTuoiPrestiti(utenteLogin);
                                System.out.println("Controlla le date di scadenza.");
                                for (Prestito prestito : utenteLogin.listaPrestiti.listaPrestiti) {
                                    utenteLogin.controllaDataDiScadenzaPrestito(oggi, prestito);
                                    if (oggi.isAfter(prestito.dataFinePrestito)) {
                                        utenteLogin.aggiungiPenalita(prestito, utenteLogin);
                                    }
                                }
                                System.out.println("Per controllare la lista dei tuoi prestiti premi 1, per restituire un libro premi 2, per controllare la scadenza di un prestito premi 3 o qualsiasi altro numero per uscire.");
                                inStatoLibro = in.nextInt();
                                in.nextLine();
                                break;
                        }
                    }
                    System.out.println("Per accedere come gestore premi 1, se vuoi accedere come utente premi 2.");
                    amministratoreUtente = in.nextInt();
                    in.nextLine();
            }
        }
    }
}