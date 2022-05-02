import java.text.DecimalFormat;

public class Ubicacion {
    DecimalFormat formato = new DecimalFormat("###,###");
    private String name;
    private Double distance;
    private int zombieCount;

    public Ubicacion(String name, Double distance, int zombieCount) {
        this.name = name;
        this.distance = distance;
        this.zombieCount = zombieCount;
    }

    public String getName() {
        return name;
    }

    public Double getDistance() {
        return distance;
    }

    public int getZombieCount() {
        return zombieCount;
    }

    @Override
    public String toString(){
        double ubiDistanceMts = Math.round(this.distance * 100.0) / 100.0;
        double MtstoKm = Math.round((ubiDistanceMts / 1000) * 100.0) / 100.0;
        //double KmtoM = Math.round((MtstoKm / 1.609) * 100.0) / 100.0;
        //if (MtstoKm > 1.609) return "Nombre (" +this.name+ ") - Distancia (" +KmtoM+ " Mi) - Zombies(" +formato.format(this.zombieCount)+ ")";
        if (ubiDistanceMts > 999) return "Nombre (" +this.name+ ") - Distancia (" +MtstoKm+ " Km) - Zombies(" +formato.format(this.zombieCount)+ ")";
        if (ubiDistanceMts < 999) return "Nombre (" +this.name+ ") - Distancia (" +this.distance+ " Mts) - Zombies(" +formato.format(this.zombieCount)+ ")";
        return null;
    }

    public int compareTo(Ubicacion ubi){
        if (ubi.getZombieCount() < this.zombieCount) return 1;
        else if (ubi.getZombieCount() > this.zombieCount) return -1;
        return 0;
    }

    public int compareToDistance(Ubicacion ubi){
        if (ubi.getDistance() < this.distance) return 1;
        else if (ubi.getDistance() > this.distance) return -1;
        return 0;
    }
}
