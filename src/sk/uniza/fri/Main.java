package sk.uniza.fri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: admin
 * Date: 4/22/2022
 * Time: 12:12 PM
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, InputMismatchException {

        File file = new File("C:\\inf\\PsSuobrmi\\src\\sk\\uniza\\fri\\otazky.txt");
        Scanner myReader = new Scanner(file);

        String otazka = "null";
        String kontrolaOtazok = "null";
        int pocetSpravnychOdpovedi = 0;
        int pocetOtazok = 0;
        String riadok = "null";
        char firstChar = '#';

        ArrayList<String> odpovede = new ArrayList<String>();
        ArrayList<Otazka> celeOtazky = new ArrayList<Otazka>();


        while (myReader.hasNextLine()) {

            riadok = myReader.nextLine();
            // System.out.println(riadok);
            firstChar = riadok.charAt(0);

            if (firstChar == ' ') {
                continue;
            }

            if (firstChar == '>') {
                otazka = riadok;

                if (!otazka.equals(kontrolaOtazok)) {
                    if (!kontrolaOtazok.equals("null")) {
                        celeOtazky.add(new Otazka(kontrolaOtazok, odpovede));
                    }
                    kontrolaOtazok = otazka;
                    odpovede = new ArrayList<String>();
                }
                continue;
            }
            odpovede.add(riadok);

        }
        celeOtazky.add(new Otazka(kontrolaOtazok, odpovede));

        for (Otazka otazky : celeOtazky) {

            otazky.vypisOtazku();


            System.out.println(otazky.getSpravnaOdpoved());
            System.out.println(otazky.getIndexSpravnejOdpovede());

            boolean canGo = false;
            pocetOtazok++;
            while (!canGo) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Zadaj spravnu odpoved: ");
                int odpoved = -1;
                try {
                    odpoved = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("wrong input");
                    continue;
                }
                if (odpoved >= 0 && odpoved <= otazky.getOdpovedeLenght()) {
                    if (odpoved == otazky.getIndexSpravnejOdpovede()) {
                        pocetSpravnychOdpovedi++;

                    }
                    canGo = true;
                }
            }
        }

        System.out.println("pocet otazok: " + pocetOtazok);
        System.out.println("pocet spravnych odpovedi: " + pocetSpravnychOdpovedi);
        double percenta = (pocetSpravnychOdpovedi * 100) / pocetOtazok;

        System.out.println("percento spravnych odpovedi: " + percenta + "%");


    }
}
