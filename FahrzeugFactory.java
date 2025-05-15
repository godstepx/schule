import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FahrzeugFactory {
    
    public enum FahrzeugTyp {
        KFZ,
        FAHRRAD
    }
    
    public static Fahrzeug erstelleFahrzeug(FahrzeugTyp typ, ArrayList<String> argumente) throws NoSuchElementException {
        switch (typ) {
            case KFZ:
                if (argumente.size() < 4) {
                    throw new NoSuchElementException("Damit kann man kein Kfz erzeugen.");
                }
                String kfzName = argumente.get(0);
                double laengengrad = Double.parseDouble(argumente.get(1));
                double breitengrad = Double.parseDouble(argumente.get(2));
                int ps = Integer.parseInt(argumente.get(3));
                double tankinhalt = Double.parseDouble(argumente.get(4));
                
                GPS kfzPosition = new GPS(laengengrad, breitengrad);
                return new Kfz(kfzName, kfzPosition, ps, tankinhalt);
                
            case FAHRRAD:
                if (argumente.size() < 3) {
                    throw new NoSuchElementException("Damit kann man kein Fahrrad erzeugen.");
                }
                String fahrradName = argumente.get(0);
                double fLaengengrad = Double.parseDouble(argumente.get(1));
                double fBreitengrad = Double.parseDouble(argumente.get(2));
                int zoll = Integer.parseInt(argumente.get(3));
                
                GPS fahrradPosition = new GPS(fLaengengrad, fBreitengrad);
                return new Fahrrad(fahrradName, fahrradPosition, zoll);
                
            default:
                throw new NoSuchElementException("Das Fahrzeug gibt es noch nicht.");
        }
    }
}
