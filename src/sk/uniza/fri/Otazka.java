package sk.uniza.fri;

import java.util.ArrayList;

/**
 * 4/22/2022 - 12:12 PM
 *
 * @author admin
 */
public class Otazka {
    private String otazka;
    private String spravnaOdpoved;
    private int indexSpravnejOdpovede;
    private ArrayList<String> odpovede;


    public Otazka(String otazka, ArrayList<String> odpovede) {
        this.odpovede = odpovede;
        this.otazka = otazka;
        int i = 0;


        for (String odpoved : odpovede
        ) {

            char firstChar = odpoved.charAt(0);
            if (firstChar == '*') {
                this.odpovede.remove(odpoved);
                this.spravnaOdpoved = odpoved.substring(1);
                this.odpovede.add(this.spravnaOdpoved);

                break;
            }


        }


    }

    public int getOdpovedeLenght() {
        return this.odpovede.size();
    }

    public void vypisOtazku() {
        System.out.println(otazka.substring(1));
        int i = 1;
        for (String odpoved : odpovede
        ) {
            System.out.println(i + " " + odpoved);
            i++;
            if (odpoved.equals(this.spravnaOdpoved)) {
                this.indexSpravnejOdpovede = i - 1;
            }


        }
        System.out.println();

    }

    public String getSpravnaOdpoved() {
        return this.spravnaOdpoved;
    }

    public int getIndexSpravnejOdpovede() {
        return this.indexSpravnejOdpovede;
    }
}
