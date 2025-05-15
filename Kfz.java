public class Kfz extends Fahrzeug {
    private int ps;
    private double tankinhalt;
    
    public Kfz(String name, GPS position, int ps, double tankinhalt) {
        super(name, position);
        this.ps = ps;
        this.tankinhalt = tankinhalt;
    }
    
    public void tanken(double liter) {
        this.tankinhalt += liter;
    }
    
    @Override
    public void fahren(GPS zielposition) {
        this.position = zielposition;
        this.tankinhalt -= 0.1;
    }
}
