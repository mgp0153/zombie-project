public class RandomUbication {
    public static String ubicationName(){
        String[] names = {"Paris", "Florencia", "Milán", "Orlando", "Denver", "Brooklyn", "Sidney", "Phoenix", "Israel", "Tokio",
                            "Los Ángeles", "Ámsterdam", "Manchester", "Montreal", "Praga", "Tel Aviv", "Oporto", "Chicago", "Londres", "Barcelona",
                            "Shanghái", "Madrid", "México", "Hong Kong", "Lisboa", "Miami", "Dubai", "Medellín", "Bogotá", "Cali",
                            "Budapest", "Sao Paulo", "Johannesburgo", "Roma", "Moscú", "Buenso Aires", "Estambul", "Bangkok", "Lima", "Oslo"};
        int random = (int)(Math.random()*40);
        return names[random];
    }

    public static Double distance(){
        double randomMts = Math.round((Math.random()*95000)*100.0) / 100.0;
        /*double MtstoKm = Math.round((randomMts / 1000) * 100.0) / 100.0;
        double KmtoM = Math.round((MtstoKm / 1609) * 100.0) / 100.0;
        if (MtstoKm > 1608) return KmtoM+ " Mi";
        else if (randomMts > 999) return MtstoKm+ " Km";
        return randomMts+ " Mts";*/
        return randomMts;
    }

    public static int zombieCount(){
        int zombies = (int)(Math.random()*14950000)+50000;
        return zombies;
    }
}
