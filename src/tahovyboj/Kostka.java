/**
 * uci se:
 * Leon Belligerrator
 */
package tahovyboj;

import java.util.Random;

/**
 * vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class Kostka {
    /**
     * Vytvori novou instanci hraci kostky
     */
    public Kostka(){
        pocetSten = 6;
        random = new Random();
    }
    public Kostka(int pocetSten){
        this.pocetSten = pocetSten;
        random = new Random();
    }
    /**
     * Generator nahodnych cisel
     */
    private Random random;
    /**
     * Pocet sten kostky
     */
    private int pocetSten;
    /**
     * Vrati pocet sten hraci kostky
     * @return Pocet sten hraci kostky
     */
    public int vratPocetSten(){
        return pocetSten;
    }
    /**
     * Vykona hod kostkou
     * @return Cislo od 1 do poctu sten
     */
    public int hod(){
        return random.nextInt(pocetSten) +1;
    }
    /**
     * Vraci textovou reprezentaci kostky
     * @return  Textova reprezentace kostky
     */
    @Override
    public String toString(){
        return String.format("Kostka s %s stenami", pocetSten);
    }
}
