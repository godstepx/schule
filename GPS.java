public class GPS {
    private double laengengrad;
    private double breitengrad;
    
    public GPS(double laengengrad, double breitengrad) {
        this.laengengrad = laengengrad;
        this.breitengrad = breitengrad;
    }
    
    public double getLaengengrad() {
        return laengengrad;
    }
    
    public double getBreitengrad() {
        return breitengrad;
    }
}
