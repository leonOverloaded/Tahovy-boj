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
        Bojovnik gandalf = new Mag("Gandalf", 60, 15, 12, kostka, 30, 45);
        Arena arena = new Arena(zalgoren, gandalf, kostka);
        arena.zapas();
    }
    
}
