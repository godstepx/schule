import java.util.*;

public class Parkplatz {
    private LinkedList<Fahrzeug> geparkteFahrzeuge;
    private HashSet<Fahrzeug> bekannteFahrzeuge;
    private TreeMap<Integer, Fahrzeug> nummeriertePlaetze;
    
    public Parkplatz() {
        geparkteFahrzeuge = new LinkedList<>();
        bekannteFahrzeuge = new HashSet<>();
        nummeriertePlaetze = new TreeMap<>();
    }
    

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
        
        for (Map.Entry<Integer, Fahrzeug> entry : nummeriertePlaetze.entrySet()) {
            if (entry.getValue().equals(fahrzeug)) {
                nummeriertePlaetze.remove(entry.getKey());
                break;
            }
        }
    }
    
    public static <T extends Collection<? super Fahrzeug>> void addFahrzeugToCollection(T collection, Fahrzeug fahrzeug) {
        collection.add(fahrzeug);
    }
}
