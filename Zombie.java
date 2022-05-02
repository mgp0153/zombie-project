public class Zombie {
    private String nombre;
    private double salud;
    private String nacimiento;
    private String sangre;

    public Zombie(String nombre, double salud,String nacimiento, String sangre){
        this.nombre = nombre;
        this.salud = salud;
        this.nacimiento = nacimiento;
        this.sangre = sangre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalud() {
        return salud;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    @Override
    public String toString(){
        return "Nombre (" +nombre+ ") - Salud (" +salud+ " HP) - Nacimiento (" +nacimiento+ ") - G.S. (" +sangre+ ")";
    }
}
