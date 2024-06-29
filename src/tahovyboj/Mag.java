/**
 * uci se:
 * Leon Belligerrator
 */
package tahovyboj;

/**
 * Vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class Mag extends Bojovnik{
    public Mag(String jmeno, int zivot, int utok, int obrana, Kostka kostka, int mana, int magickyUtok){
        super(jmeno, zivot, utok, obrana, kostka);
        this.mana = mana;
        this.maximalniMana = mana;
        this.magickyUtok = magickyUtok;
    }
    private int mana;
    private int maximalniMana;
    private int magickyUtok;
    
    @Override
    public void utoc(Bojovnik souper){
        //mana neni naplnena
        if(mana < maximalniMana){
            mana += 10;
            if(mana > maximalniMana){
                mana = maximalniMana;
            }
            super.utoc(souper);
        }
        else{
            int uder = magickyUtok + kostka.hod();
            nastavZpravu(String.format("%s pouzil magii za %s hp", jmeno, uder));
            souper.branSe(uder);
            mana = 0;
        }
    }
    public String grafickaMana(){
        return grafickyUkazatel(mana, maximalniMana);
    }
}
