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
        Kostka kostka = new Kostka();
        Bojovnik bojovnik = new Bojovnik("Zalgoren", 100, 20, 10, kostka);
        
        System.out.printf("Bojovnik: %s\n", bojovnik); //test toString
        System.out.printf("Nazivu: %s\n", bojovnik.jeZivy()); //test jeZivy
        System.out.printf("Zivot: %s\n", bojovnik.grafickyZivot()); //test graficky zivot
        Bojovnik souper = new Bojovnik("Shadow", 60, 18, 15, kostka);
        souper.utoc(bojovnik); //test utoku
        System.out.printf("%s\n%s\n", souper.vratPosledniZpravu(), bojovnik.vratPosledniZpravu());
        System.out.printf("Zivot po utoku: %s\n", bojovnik.grafickyZivot());
    }
    
}
