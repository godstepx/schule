import java.util.*;

public class Parkplatz {
    // Datenstruktur für geparkte Fahrzeuge: LinkedList für schnelles Einfügen/Löschen an jeder Position
    private LinkedList<Fahrzeug> geparkteFahrzeuge;
    
    // Datenstruktur für bekannte Fahrzeuge: HashSet für schnelle Suche und keine Duplikate
    private HashSet<Fahrzeug> bekannteFahrzeuge;
    
    // Datenstruktur für nummerierte Plätze: TreeMap für automatische Sortierung nach Schlüssel (Parkplatznummer)
    private TreeMap<Integer, Fahrzeug> nummeriertePlaetze;
    
    public Parkplatz() {
        geparkteFahrzeuge = new LinkedList<>();
        bekannteFahrzeuge = new HashSet<>();
        nummeriertePlaetze = new TreeMap<>();
    }
    
    // Hilfsmethoden (nicht gefordert, aber sinnvoll)
    public void parkeFahrzeug(Fahrzeug fahrzeug) {
        geparkteFahrzeuge.add(fahrzeug);
        bekannteFahrzeuge.add(fahrzeug);
    }
    
    public void parkeFahrzeugAufPlatz(int platznummer, Fahrzeug fahrzeug) {
        nummeriertePlaetze.put(platznummer, fahrzeug);
        bekannteFahrzeuge.add(fahrzeug);
    }
    
    public Fahrzeug getFahrzeugVonPlatz(int platznummer) {
        return nummeriertePlaetze.get(platznummer);
    }
    
    public void entferneFahrzeug(Fahrzeug fahrzeug) {
        geparkteFahrzeuge.remove(fahrzeug);
        
        // Entfernen des Fahrzeugs aus nummeriertePlaetze, falls vorhanden
        for (Map.Entry<Integer, Fahrzeug> entry : nummeriertePlaetze.entrySet()) {
            if (entry.getValue().equals(fahrzeug)) {
                nummeriertePlaetze.remove(entry.getKey());
                break;
            }
        }
    }
    
    // Statische Methode zum Hinzufügen eines beliebigen Fahrzeugs zu einer beliebigen Collection
    public static <T extends Collection<? super Fahrzeug>> void addFahrzeugToCollection(T collection, Fahrzeug fahrzeug) {
        collection.add(fahrzeug);
    }
}
