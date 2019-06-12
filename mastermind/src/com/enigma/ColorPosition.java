package com.enigma;

import java.util.Random;
import java.util.Scanner;

public class ColorPosition {
    private static String OK = "OK";
    private static String FAUX = "FAUX";

    public static void ColorGuess() {
        Scanner sc = new Scanner(System.in);

        int nbChiffres = 4;
        int max = 4;
        int nbEssaiMax = 10;
        int[] solution = new int[nbChiffres];
        int count = 0;
        int chiffres[] = new int[nbChiffres];
        boolean victory = false;
        Random r = new Random();


        for (int i = 0; i < nbChiffres; i++) {
            solution[i] = r.nextInt(max + 1);
        }
        System.out.println("trouves les 4 bons chiffres de 0 a 4");
        do {
            System.out.println("\nEssai n° " + (count + 1));
            int nombreSaisi = sc.nextInt();
            for (int i = 0; i < nbChiffres; i++)
                chiffres[i] = (int) (nombreSaisi / (Math.pow(10, (nbChiffres - i - 1)))) % 10; //je cherchais un moyen de stocker dans un tableau les valeurs saisies et je n'ai trouvé que ca, je comprend ce que mathpow fait a peut près


            for (int i = 0; i < nbChiffres; i++)
                System.out.print(chiffres[i] + " ");

            victory = true;
            for (int i = 0; i < nbChiffres; i++) {
                boolean bonChiffre = chiffres[i] == solution[i];
                System.out.print((bonChiffre ? OK : FAUX) + " ");

                victory = victory && bonChiffre;
            }
            System.out.println();

            count++;

            if (count == nbEssaiMax) {
                System.out.println("perdu");
            }

        }

        while (!victory && count < nbEssaiMax);
        System.out.println("gagné");
        sc.close();
    }
}