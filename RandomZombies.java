public class RandomZombies {
    public static String zombieName(){
        String[] names = {"Hugo" , "Martín" , "Lucas" , "Mateo" , "Leo" , "Daniel" , "Alejandro" , "Pablo" , "Manuel" , "Álvaro" , "Adrián" , "David" , "Mario" , "Enzo" , "Diego" ,
                "Marcos" , "Izan" , "Javier" , "Marco" , "Álex" , "Bruno" , "Oliver" , "Miguel" , "Thiago" , "Antonio" , "Marc" , "Carlos" , "Ángel" , "Juan" , "Gonzalo" ,
                "Gael" , "Sergio" , "Nicolás" , "Dylan" , "Gabriel" , "Jorge" , "José" , "Adam" , "Liam" , "Eric" , "Samuel" , "Darío" , "Héctor" , "Luca" , "Iker" , "Amir" ,
                "Rodrigo" , "Saúl" , "Víctor" , "Francisco", "Lucía" , "Sofía" , "Martina" , "María" , "Julia" , "Paula" , "Valeria" , "Emma" , "Daniela" , "Carla" , "Alba" , "Noa" , "Alma" , "Sara" , "Carmen" , "Vega" ,
                "Lara" , "Mia" , "Valentina" , "Olivia" , "Claudia" , "Jimena" , "Lola" , "Chlóe" , "Aitana" , "Abril" , "Ana" , "Laia" , "Triana" , "Alejandra" , "Elena" ,
                "Vera" , "Manuela" , "Adriana" , "Inés" , "Marta" , "Carlota" , "Irene" , "Victoria" , "Blanca" , "Marina" , "Laura" , "Rocío" , "Alicia" , "Clara" , "Nora" ,
                "Lía" , "Ariadna" , "Zoe" , "Amira"};
        int random = (int)(Math.random()*100);
        return names[random];
    }

    public static double health(){
        double randomHealth = Math.random()*100;
        return Math.round(randomHealth * 100.0) / 100.0;
    }

    public static String birth(){
        int day = (int)(Math.random()*30)+1;
        int month = (int)(Math.random()*11)+1;
        int year = (int)(Math.random()*35)+1980;

        if (day <= 9 && month <= 9) return "0"+day+"/0"+month+"/"+year;
        if (day <= 9) return "0"+day+"/"+month+"/"+year;
        if (month <= 9) return +day+"/0"+month+"/"+year;

        return day+"/"+month+"/"+year;
    }

    public static String bloodType(){
        String[] blood = {"O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"};
        int random = (int)(Math.random()*8);
        return blood[random];
    }

    public static String tip(){
        String[] tips = {"Si disparas a los zombies a la cabeza te asegurarás de una ¡kill instantánea!",
                        "Ten en cuenta que si eres mordido por un zombie con tu mismo tipo de sangre tendrás\n" +
                                "5 horas extra antes de volverte uno de ellos",
                        "¡Los zombies son amantes al rock, por lo que si necesitas unos minutos de distracción lleva\n" +
                                "unos buenos clásicos del rock!",
                        "Los zombies con tipo de sangre 'AB-' son alergicos a los rayos UV",
                        "Es bien sabido que los zombies no atacan a personas con enfermedades terminales"};
        int random = (int)(Math.random()*5);
        return tips[random];
    }
}
