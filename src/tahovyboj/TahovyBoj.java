/**
 * uci se:
 * Leon Belligerrator
 */
package tahovyboj;

/**
 * Vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class TahovyBoj {

    public static void main(String[] args) {
        Kostka kostka = new Kostka(10);
        Bojovnik zalgoren = new Bojovnik("Zalgoren", 100, 20, 10, kostka);
        Bojovnik shadow = new Bojovnik("Shadow", 60, 18, 15, kostka);
        Arena arena = new Arena(zalgoren, shadow, kostka);
        arena.zapas();
    }
    
}
