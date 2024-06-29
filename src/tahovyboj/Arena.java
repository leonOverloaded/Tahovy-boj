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
        System.out.printf("Zdravi bojovniku: \n");
        System.out.printf("%s %s\n", bojovnikA, bojovnikA.grafickyZivot());
        System.out.printf("%s %s\n", bojovnikB, bojovnikB.grafickyZivot());
    }
    private void vypisZpravu(String zprava){
        System.out.printf("%s\n", zprava);
        try{
            Thread.sleep(1);
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
                vypisZpravu(bojovnikA.vratPosledniZpravu());
                vypisZpravu(bojovnikB.vratPosledniZpravu());
            }
            System.out.printf("\n");
        }
    }
}
