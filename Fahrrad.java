public class Fahrrad extends Fahrzeug {
    private int zoll;
    
    public Fahrrad(String name, GPS position, int zoll) {
        super(name, position);
        this.zoll = zoll;
    }
    
    @Override
    public void fahren(GPS zielposition) {
        // Implementation der Fahrmethode für Fahrrad
        this.position = zielposition;
    }
}
