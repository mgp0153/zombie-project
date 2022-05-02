import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Zombie> zombieList = new ArrayList<Zombie>();
    private ArrayList<Ubicacion> ubiList = new ArrayList<Ubicacion>();

    public void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        double op = -1;
        while (op != 0){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            System.out.println("\n---------------------------------------------------------");
            System.out.println("\t°°Alcaldía de Alexadria°°" +
                    "\n - Dijite 0 para detener el programa" +
                    "\n - Dijite 1 para ingresar los datos de un zombie x" +
                    "\n - Dijite 2 para mostrar todos los zombies ingresados en la base de datos" +
                    "\n - Dijite 3 para mostrar la cantidad de zombies creados" +
                    "\n - Dijite 4 para mostrar por pantalla los zombies con tipo de sangre 'O+' o 'AB+'" +
                    "\n - Dijite 5 para mostrar por pantalla los zombies nacidos después del 2000" +
                    "\n - Dijite 6 para lanzar la °¡K6_BOOM!° (Reducir la vida de los zombies a la mitad)" +
                    "\n - Dijite 7 para ingresar nombre, distancia y cantidad de zombies de una ubicación" +
                    "\n - Dijite 8 para mostrar todas las ubicaciones registradas" +
                    "\n - Dijite 9 para mostrar la info de la ubicación con menor número de zombies" +
                    "\n - Dijite 10 para mostrar todas las ubicaciones ordenadas por distancia" +
                    "\n - Dijite 11 para mostrar tip sobre los zombies" +
                    "\n - Dijite 12 para ingresar zombies aleatorios" +
                    "\n - Dijite 13 para ingresar ubicaciones aleatorias");
            System.out.println("---------------------------------------------------------");
            System.out.print("Dijite el número de la opción que desea: ");
            op = sc.nextDouble();
            switch ((int)op){
                case 1:
                    addZombie(datosZombie());
                    break;
                case 2:
                    mostrarZombies();
                    break;
                case 3:
                    zombiesCreados();
                    break;
                case 4:
                    zombiesOplusABplus();
                    break;
                case 5:
                    zombies2000();
                    break;
                case 6:
                    K6();
                    break;
                case 7:
                    addUbi(datosUbi());
                    break;
                case 8:
                    mostrarUbicaciones();
                    break;
                case 9:
                    lessZombies(ubiList);
                    break;
                case 10:
                    closestUbications(ubiList);
                    break;
                case 11:
                    showTip();
                    break;
                case 12:
                    zombieRandom();
                    break;
                case 13:
                    randomUbication();
                    break;
                default:
                    System.out.println("°° Esa opción no existe revisa el menú de nuevo °°");
                    break;
            }
        }
        System.out.println("\n¡Tenga un zombificante día!");
    }
    
    //Case 1
    public Zombie datosZombie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t°|| Ingresar Zombie ||°\n");
        
        //Nombre
        System.out.print("Ingrese el nombre del zombie: ");
        String zName = sc.nextLine();
        
        //Salud
        System.out.print("Ingrese la salud actual de tal zombie: ");
        double zHealth = sc.nextDouble();
        
        //Naciminto
        String zBirth = "";
        System.out.println("Ingrese fecha de nacimiento de tal zombie");
        System.out.print("\tDía: ");
        int day = sc.nextInt();
        System.out.print("\tMes: "+day+"/");
        int month = sc.nextInt();
        System.out.print("\tAño: "+day+"/"+month+"/");
        int year = sc.nextInt();
        
        //Naciminto proceso de embellecimiento
        if (day <= 9 && month <= 9) zBirth = "0"+day+"/0"+month+"/"+year;
        else if (day <= 9) zBirth = "0"+day+"/"+month+"/"+year;
        else if (month <= 9) zBirth = +day+"/0"+month+"/"+year;
        else zBirth = day+"/"+month+"/"+year;
        
        sc.nextLine();
        
        //Tipo de sangre
        System.out.print("Ingrese tipo de sangre de tal zombie: ");
        String zBlood = sc.nextLine().toUpperCase();
        
        System.out.println("Zombie ingresado con éxito");
        
        //Creación y retorno
        Zombie zombie = new Zombie(zName, zHealth, zBirth, zBlood);
        return zombie;
    }
    //Case 1 pero 12
    public Zombie zombieR(){
        Zombie zombie = new Zombie(RandomZombies.zombieName(), RandomZombies.health(), RandomZombies.birth(), RandomZombies.bloodType());
        return zombie;
    }

    public void zombieRandom(){
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos zombies desea crear?: ");
        int n = sc.nextInt();
        if (n < 1) System.out.println("Ingrese una cantidad válidad");
        if (n == 1) {
            System.out.println("\t°|| Ingresando Zombie ||°");
            addZombie(zombieR());
            System.out.println("Zombie ingresado con éxito");
        }
        if (n > 1) {
            System.out.println("\t°|| Ingresando Zombies ||°");
            for (int i = 0; i < n; i++){
                addZombie(zombieR());
            }
            System.out.println("Zombies ingresados con éxito");
        }
    }
    //Case 1 pero 12

    public void addZombie(Zombie item){
        this.zombieList.add(item);
    }
    //Case 1
    
    //Case 2
    public void mostrarZombies(){
        System.out.println("\n\t°|| Zombies en la base de datos ||°\n");
        for (int i = 0; i < zombieList.size(); i++){
            System.out.println(1+i+ ". " +zombieList.get(i));
        }
    }
    //Case 2

    //Case 3
    public void zombiesCreados(){
        System.out.println("\t°|| Zombies Creados ||°");
        System.out.println("Hay un total de " +zombieList.size()+ " zombies creados.\n");
    }
    // Case 3

    //Case 4
    public void zombiesOplusABplus(){
        int count = 0;
        System.out.println("\n\t°|| Zombies con tipo de sangre 'O+' o 'AB+' ||°");
        for (int i = 0; i < zombieList.size(); i++){
            if (zombieList.get(i).getSangre().contains("O+") || zombieList.get(i).getSangre().contains("AB+")){
                count++;
                System.out.println(count+ ". " +zombieList.get(i));
            }
        }
    }
    //Case 4
    
    //Case 5
    public void zombies2000(){
        int count = 0;
        System.out.println("\n\t°|| Zombies nacidos después del 2000 ||°");
        for (int i = 0; i < zombieList.size(); i++){
            int year = Integer.parseInt(zombieList.get(i).getNacimiento().substring(6));
            if (year > 2000){
                count++;
                System.out.println(count+ ". " +zombieList.get(i));
            }
        }
    }
    //Case 5

    //Case 6
    public void K6() {
        if (zombieList.size() > 0){
            Scanner sc = new Scanner(System.in);
            System.out.println("\t°¡K6_BOOM!°");
            System.out.println("¿Está seguro que desea lanzar la bomba?");
            System.out.println(" - 1 para continuar\n - 0 para abortar");
            System.out.print("Decision final: ");
            int dc = sc.nextInt();
            if (dc == 1){
                System.out.println("La bomba será lanzada en...");
                try {
                    Thread.sleep(1000);
                    System.out.println("5...");
                    Thread.sleep(1000);
                    System.out.println("4...");
                    Thread.sleep(1000);
                    System.out.println("3...");
                    Thread.sleep(1000);
                    System.out.println("2...");
                    Thread.sleep(1000);
                    System.out.println("1...");
                    Thread.sleep(1000);
                    System.out.println("!°KBOOOOOOOOOOOOOOOOOOOOOOOOM°!");
                } catch (InterruptedException e) {
                    System.out.println("Haz logrado abortar a tiempo...");
                }
            }
            for (int i = 0; i < zombieList.size(); i++){
                zombieList.get(i).setSalud(Math.round((zombieList.get(i).getSalud() / 2)*100.0)/100.0);
            }
            System.out.println("Haz reducido la vida de todos los zombies a la mitad ¡genial!");
        }else{
            System.out.println("No puedes petar la ciudad si no hay zombies en ella.");
        }
    }
    //Case 6

    //Case 7
    public Ubicacion datosUbi(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\t°| Ingresar ubicación |°");

        System.out.print("Ingrese nombre de la ubicación: ");
        String ubiName = sc.nextLine();

        System.out.print("Ingrese la distacia hasta la ubicación (Metros): ");
        double ubiDistanceMts = Math.round(sc.nextDouble() * 100.0) / 100.0;
        /*double MtstoKm = Math.round((ubiDistanceMts / 1000) * 100.0) / 100.0;
        double KmtoM = Math.round((MtstoKm / 1609) * 100.0) / 100.0;

        String finalDistance = "";
        if (ubiDistanceMts < 999) finalDistance = ubiDistanceMts+ " Mts";
        if (ubiDistanceMts > 999) finalDistance = MtstoKm+ " Km";
        if (MtstoKm > 1608) finalDistance = KmtoM+ " Mi";*/

        System.out.print("Ingrese la cantidad de zombies de esa ubicación: ");
        int zombieCount = sc.nextInt();

        System.out.println("¡Ubicación agregada con éxito!");
        Ubicacion ubication = new Ubicacion(ubiName, ubiDistanceMts, zombieCount);
        return ubication;
    }

    public void randomUbication(){
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántas ubicaciones desea generar?: ");
        int ubis = sc.nextInt();

        if (ubis < 1) System.out.println("Ingrese una cantidad válida");
        if (ubis == 1){
            System.out.println("\t°| Generando Ubicación |°");
            addUbi(ubicationR());
            System.out.println("¡Ubicación agregada con exito!");
        }

        if (ubis > 1){
            System.out.println("\t°| Generando Ubicaciones |°");
            for (int i = 0; i < ubis; i++) addUbi(ubicationR());
            System.out.println("¡Ubicaciones agregadas con exito!");
        }
    }

    public Ubicacion ubicationR(){
        Ubicacion ubication = new Ubicacion(RandomUbication.ubicationName(), RandomUbication.distance(), RandomUbication.zombieCount());
        return ubication;
    }
    //Case 7 pero 13

    public void addUbi(Ubicacion item){
        this.ubiList.add(item);
    }
    //Case 7

    //Case 8
    public void mostrarUbicaciones(){
        System.out.println("\t°|| Ubiaciones en la base de datos ||°");
        for (int i = 0; i < ubiList.size(); i++){
            System.out.println(1+i+ ". " +ubiList.get(i));
        }
    }
    //Case 8

    //Case 9
    public void lessZombies(ArrayList<Ubicacion> ubi){
        Ubicacion temp;
        ArrayList <Ubicacion> listTemp = new ArrayList<Ubicacion>();
        listTemp = ubiList;
        for (int i = 0; i < ubiList.size() - 1; i++){
            for (int j = i + 1; j < ubiList.size(); j++){
                if (ubiList.get(i).compareTo(ubiList.get(j)) > 0){
                    temp = listTemp.get(j);
                    listTemp.set(j, listTemp.get(i));
                    listTemp.set(i, temp);
                }
            }
        }
        System.out.println("\t°| Mostrando la ubicación más segura |°");
        System.out.println(listTemp.get(0));
    }
    //Case 9
    
    //Case 10
    public void closestUbications(ArrayList<Ubicacion> ubi){
        Ubicacion temp;
        ArrayList <Ubicacion> listTemp = ubiList;
        for (int i = 0; i < ubiList.size() - 1; i++){
            for (int j = i + 1; j< ubiList.size(); j++){
                if (ubiList.get(i).compareToDistance(ubiList.get(j)) > 0){
                    temp = listTemp.get(j);
                    listTemp.set(j, listTemp.get(i));
                    listTemp.set(i, temp);
                }
            }
        }
        System.out.println("°| Mostrando ubicaciones más cercanas |°");
        for (int i = 0; i < ubiList.size(); i++){
            System.out.println(1+i+ ". " +listTemp.get(i));
        }
    }
    //Case 10

    //Case 11
    public void showTip(){
        System.out.println("\t°| Ahora un zombie-tip |°\n" +
                "'" +RandomZombies.tip()+ "'");
    }
    //Case 11
}