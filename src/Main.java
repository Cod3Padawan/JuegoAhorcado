import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String palabraSecreta = getPalabraSecreta();

        char[] palabraGuiones = getGuionesPalabra(palabraSecreta);
        boolean juegoTerminado = false;
        Scanner sc = new Scanner(System.in);
        int intentos = 5;
        System.out.println("Estamos buscando el nombre de un jugador de futbol");


        do {
            System.out.println("te quedan " + intentos + " intentos");
            System.out.println(palabraGuiones);
            System.out.println("Introduce una letra: ");
            char letra = sc.next().charAt(0);
            boolean algunaLetraAcertada = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraGuiones[i] = letra;
                    algunaLetraAcertada = true;
                }
            }
            if (!algunaLetraAcertada) {
                System.out.println("No has acertado ninguna letra");
                --intentos;
                if (intentos == 0) {
                    System.out.println("Has perdido, el jugador era " + palabraSecreta);
                    juegoTerminado = true;
                }
            } else {
                boolean juegoGanado = !hayGuiones(palabraGuiones);
                if (juegoGanado){
                    System.out.println("Has ganado");
                    juegoTerminado = true;
                }
            }
        } while (!juegoTerminado);
    }

    static String getPalabraSecreta() {
        String[] palabras = {"LionelMessi", "CristianoRonaldo", "Neymar", "KylianMbappe", "LukaModric",
                "SergioRamos", "RobertLewandowski", "ManuelNeuer", "MohamedSalah", "VirgilVanDijk",
                "SadioMane", "AlissonBecker", "TrentAlexanderArnold", "RobertoFirmino", "KevinDeBruyne",
                "RaheemSterling", "BernardoSilva", "Ederson", "Rodri", "FrenkieDeJong",
                "MarcTerStegen", "JordiAlba", "GerardPique", "LuisSuarez", "AntoineGriezmann",
                "JanOblak", "JoaoFelix", "DiegoCosta", "Koke", "SaulNiguez",
                "EdenHazard", "KarimBenzema", "SergioRamos", "ThibautCourtois", "ViniciusJunior",
                "LukaJovic", "Marcelo", "Casemiro", "Isco", "ToniKroos",
                "MarcoAsensio", "LeroySane", "IlkayGundogan", "PhilFoden", "GabrielJesus",
                "BrunoFernandes", "MarcusRashford", "PaulPogba", "EdinsonCavani", "HarryMaguire"};
        Random r = new Random();
        int n = r.nextInt(palabras.length);

        return palabras[n];
    }

    static char[] getGuionesPalabra(String palabra) {
        int nLetrasPalabraSecreta = palabra.length();

        char[] palabraGuion = new char[nLetrasPalabraSecreta];

        for (int i = 0; i < nLetrasPalabraSecreta; i++) {
            palabraGuion[i] = '_';
        }
        return palabraGuion;
    }

    static boolean hayGuiones(char[] array) {
        for (char l : array) {
            if (l == '_') return true;
        }return false;
    }
}


