public abstract class Fahrzeug {
    protected String name;
    protected int speed;
    protected GPS position;
    
    public Fahrzeug(String name, GPS position) {
        this.name = name;
        this.position = position;
        this.speed = 0;
    }
    
    public abstract void fahren(GPS zielposition);
}
