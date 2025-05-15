public enum FahrzeugTyp {
    KFZ,
    FAHRRAD
}

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FahrzeugFactory {
    public static Fahrzeug createFahrzeug(FahrzeugTyp typ, ArrayList<String> args) {
        try {
            switch (typ) {
                case KFZ:
                    if (args.size() < 5)
                        throw new NoSuchElementException("Damit kann man kein Kfz erzeugen.");
                    String nameKfz = args.get(0);
                    double laengeKfz = Double.parseDouble(args.get(1));
                    double breiteKfz = Double.parseDouble(args.get(2));
                    int ps = Integer.parseInt(args.get(3));
                    double tankinhalt = Double.parseDouble(args.get(4));
                    GPS gpsKfz = new GPS(laengeKfz, breiteKfz);
                    return new Kfz(nameKfz, gpsKfz, ps, tankinhalt);

                case FAHRRAD:
                    if (args.size() < 4)
                        throw new NoSuchElementException("Damit kann man kein Fahrrad erzeugen.");
                    String nameRad = args.get(0);
                    double laengeRad = Double.parseDouble(args.get(1));
                    double breiteRad = Double.parseDouble(args.get(2));
                    int zoll = Integer.parseInt(args.get(3));
                    GPS gpsRad = new GPS(laengeRad, breiteRad);
                    return new Dreirad(nameRad, gpsRad, zoll);

                default:
                    throw new NoSuchElementException("Das Fahrzeug gibt es noch nicht.");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException("Fehlende Argumente.");
        }
    }
}
