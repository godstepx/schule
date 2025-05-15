import java.util.*;

public class Parkplatz {

    // Schnelles Einfügen/Löschen an jeder Position + Sortierbarkeit -> LinkedList
    private LinkedList<Fahrzeug> geparkteFahrzeuge = new LinkedList<>();

    // Keine Duplikate, schnelle Suche -> HashSet
    private Set<Fahrzeug> bekannteFahrzeuge = new HashSet<>();

    // Eindeutige Zuordnung + Sortierung nach Parkplatznummer -> TreeMap
    private TreeMap<Integer, Fahrzeug> nummeriertePlaetze = new TreeMap<>();

    // Methoden zum Einfügen und Entfernen (optional)
    public void fahrzeugParken(Fahrzeug fz, int platznummer) {
        geparkteFahrzeuge.add(fz);
        bekannteFahrzeuge.add(fz);
        nummeriertePlaetze.put(platznummer, fz);
    }

    public void fahrzeugEntfernen(Fahrzeug fz) {
        geparkteFahrzeuge.remove(fz);
        nummeriertePlaetze.values().remove(fz);
    }

    public Fahrzeug getFahrzeugAmPlatz(int nummer) {
        return nummeriertePlaetze.get(nummer);
    }

    public List<Fahrzeug> getGeparkteFahrzeugeSortiert(Comparator<Fahrzeug> comparator) {
        List<Fahrzeug> sortedList = new ArrayList<>(geparkteFahrzeuge);
        sortedList.sort(comparator);
        return sortedList;
    }

    public boolean istFahrzeugBekannt(Fahrzeug fz) {
        return bekannteFahrzeuge.contains(fz);
    }
}



public static class ParkplatzUtil {
    public static void fuegeHinzu(Collection<Fahrzeug> sammlung, Fahrzeug fz) {
        sammlung.add(fz);
    }
}
