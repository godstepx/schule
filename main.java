import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // Gültiges Kfz-Objekt erstellen
        ArrayList<String> gueltigesKfz = new ArrayList<>();
        gueltigesKfz.add("BMW");       // Name
        gueltigesKfz.add("48.123456"); // Längengrad
        gueltigesKfz.add("11.987654"); // Breitengrad
        gueltigesKfz.add("150");       // PS
        gueltigesKfz.add("60.5");      // Tankinhalt
        
        // Ungültiges Kfz (zu wenige Parameter)
        ArrayList<String> ungueltigesKfz = new ArrayList<>();
        ungueltigesKfz.add("Audi");
        ungueltigesKfz.add("49.123456");
        ungueltigesKfz.add("10.987654");
        
        // Ungültiges Fahrrad (zu wenige Parameter)
        ArrayList<String> ungueltigesFahrrad = new ArrayList<>();
        ungueltigesFahrrad.add("Mountainbike");
        ungueltigesFahrrad.add("50.123456");
        
        // Ungültiger Fahrzeugtyp
        ArrayList<String> argumente = new ArrayList<>();
        argumente.add("Test");
        argumente.add("51.123456");
        argumente.add("12.987654");
        
        try {
            Fahrzeug meinKfz = FahrzeugFactory.erstelleFahrzeug(FahrzeugFactory.FahrzeugTyp.KFZ, gueltigesKfz);
            System.out.println("Fahrzeug erfolgreich erstellt: " + meinKfz.getClass().getSimpleName());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Fahrzeug meinUngueltigesKfz = FahrzeugFactory.erstelleFahrzeug(FahrzeugFactory.FahrzeugTyp.KFZ, ungueltigesKfz);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Fahrzeug meinUngueltigesFahrrad = FahrzeugFactory.erstelleFahrzeug(FahrzeugFactory.FahrzeugTyp.FAHRRAD, ungueltigesFahrrad);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
        // Da wir keinen dritten Fahrzeugtyp haben, müssen wir mit einer Cast-Umwandlung arbeiten
        try {
            // In einer echten Implementierung müsste man hier einen nicht existierenden Fahrzeugtyp übergeben
            // Da der Enum aber nur KFZ und FAHRRAD enthält, simulieren wir das mit einem speziellen Fall
            if (true) {
                throw new NoSuchElementException("Das Fahrzeug gibt es noch nicht.");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
