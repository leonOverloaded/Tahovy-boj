/**
 * uci se:
 * Leon Belligerrator
 */
package tahovyboj;

/**
 * Vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class Arena {
    private Bojovnik bojovnikA;
    private Bojovnik bojovnikB;
    private Kostka kostka;
    
    public Arena(Bojovnik bojovnikA, Bojovnik bojovnikB, Kostka kostka){
        this.bojovnikA = bojovnikA;
        this.bojovnikB = bojovnikB;
        this.kostka = kostka;
    }
    private void vykresli(){
        System.out.printf("----------------Arena------------\n\n");
        System.out.printf("Bojovnici: \n");
        vypisBojovnika(bojovnikA);
        System.out.println();
        vypisBojovnika(bojovnikB);
        System.out.println();
    }
    private void vypisZpravu(String zprava){
        System.out.printf("%s\n", zprava);
        try{
            Thread.sleep(0);
        }
        catch(InterruptedException ex){
            System.err.printf("Chyba, nepodarilo se uspat vlakno!\n");
        }
    }
    public void zapas(){
        Bojovnik bojovnikA = this.bojovnikA;
        Bojovnik bojovnikB = this.bojovnikB;
        
        System.out.printf("Vitejte v arene!\n");
        System.out.printf("Dnes se utkaji%s a %s!\n", bojovnikA, bojovnikB);
        
        boolean zacinaBojovnikB = (kostka.hod() <= kostka.vratPocetSten() / 2);
        if(zacinaBojovnikB){
            bojovnikA = this.bojovnikB;
            bojovnikB = this.bojovnikA;
        }
        System.out.printf("Zacinat bude bojovnik %s!\nZapas muze zacit...\n", bojovnikA);
        
        while(bojovnikA.jeZivy() && bojovnikB.jeZivy()){
            bojovnikA.utoc(bojovnikB);
            vykresli();
            vypisZpravu(bojovnikA.vratPosledniZpravu());
            vypisZpravu(bojovnikB.vratPosledniZpravu());
            if(bojovnikB.jeZivy()){
                bojovnikB.utoc(bojovnikA);
                vypisZpravu(bojovnikB.vratPosledniZpravu());
                vypisZpravu(bojovnikA.vratPosledniZpravu());
            }
            System.out.printf("\n");
        }
    }
    private void vypisBojovnika(Bojovnik bojovnik){
        System.out.println(bojovnik);
        System.out.print("Zivot: ");
        System.out.println(bojovnik.grafickyZivot());
        if(bojovnik instanceof Mag){
            System.out.print("Mana: ");
            System.out.println(((Mag) bojovnik).grafickaMana());
        }
    }
}
