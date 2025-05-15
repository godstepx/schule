import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // Gültiges KFZ
        ArrayList<String> kfzArgs = new ArrayList<>();
        kfzArgs.add("Auto1");
        kfzArgs.add("10.0"); // Längengrad
        kfzArgs.add("20.0"); // Breitengrad
        kfzArgs.add("150");  // PS
        kfzArgs.add("50.0"); // Tankinhalt

        // Fehler: Zu wenige Werte für Kfz
        ArrayList<String> fehlerKfz = new ArrayList<>();
        fehlerKfz.add("Auto2");
        fehlerKfz.add("11.0");
        fehlerKfz.add("21.0");

        // Fehler: Zu wenige Werte für Fahrrad
        ArrayList<String> fehlerRad = new ArrayList<>();
        fehlerRad.add("Bike1");
        fehlerRad.add("12.0");

        // Fehler: Unbekannter Typ
        FahrzeugTyp falscherTyp = null;

        try {
            Fahrzeug f1 = FahrzeugFactory.createFahrzeug(FahrzeugTyp.KFZ, kfzArgs);
            System.out.println("Fahrzeug erstellt: " + f1.name);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        try {
            Fahrzeug f2 = FahrzeugFactory.createFahrzeug(FahrzeugTyp.KFZ, fehlerKfz);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());  // "Damit kann man kein Kfz erzeugen."
        }

        try {
            Fahrzeug f3 = FahrzeugFactory.createFahrzeug(FahrzeugTyp.FAHRRAD, fehlerRad);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());  // "Damit kann man kein Fahrrad erzeugen."
        }

        try {
            Fahrzeug f4 = FahrzeugFactory.createFahrzeug(falscherTyp, kfzArgs);
        } catch (NoSuchElementException | NullPointerException e) {
            System.out.println("Das Fahrzeug gibt es noch nicht.");
        }
    }
}
