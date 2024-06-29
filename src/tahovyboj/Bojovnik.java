/**
 * uci se:
 * Leon Belligerrator
 */
package tahovyboj;

/**
 * Vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class Bojovnik {

    /**
     * Konstruktor objektu bojovnika
     * @param jmeno
     * @param zivot
     * @param utok
     * @param obrana
     * @param kostka
     */
    public Bojovnik(String jmeno, int zivot, int utok, int obrana, Kostka kostka){
        this.jmeno = jmeno;
        this.zivot = zivot;
        this.maximalniZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kostka = kostka;
    }
    /**
     * Jmeno bojovnika
     */
    protected String jmeno;
    /**
     * Zivot v HP
     */
    private int zivot;
    /**
     * Maximalni zdravi
     */
    private int maximalniZivot;
    /**
     * Utok v HP
     */
    protected int utok;
    /**
     * Obrana v HP
     */
    private int obrana;
    /**
     * instance hraci kostky
     */
    protected Kostka kostka;
    /**
     * Posledni zprava
     */
    private String zprava;
    
    @Override
    public String toString(){
        return jmeno;
    }

    /**
     * Pokud je bojovnik zivy, vraci true
     * @return true/false
     */
    public boolean jeZivy(){
        return (zivot > 0);
    }

    /**
     * Vraci retezec s grafickym zobrayenim zivota
     * @param aktualni
     * @param maximalni
     * @return String graficky zivot
     */
    public String grafickyUkazatel(int aktualni, int maximalni){
        String grafickyZivot = "[";
        int celkem = 20;
        double pocetDilku = Math.round(((double) aktualni / maximalni) * celkem);
        if((pocetDilku == 0) && (jeZivy())){
            pocetDilku = 1;
        }
        for(int i=0; i<pocetDilku; i++){
            grafickyZivot += "#";
        }
        for(int i=0; i<celkem-pocetDilku; i++){
            grafickyZivot += " ";
        }
        grafickyZivot += "]";
        return grafickyZivot;
    }
    
    /**
     *
     * @return 
     */
    public String grafickyZivot(){
        return grafickyUkazatel(zivot, maximalniZivot);
    }

    /**
     * Obrana proti utoku
     * @param uder
     */
    public void branSe(int uder){
        int zraneni = uder - (obrana + kostka.hod());
        if(zraneni > 0 ){
            zivot -= zraneni;
            zprava = String.format("%s utrpel poskozeni %s hp", jmeno, zraneni);
            if(zivot <= 0){
                zivot = 0;
                zprava += " a zemrel";
            }
        }
        else{
            zprava = String.format("%s odrazil utok", jmeno);
        }
        nastavZpravu(zprava);
    }

    /**
     * Utok na protivnika
     * @param souper
     */
    public void utoc(Bojovnik souper){
        int uder = utok + kostka.hod();
        nastavZpravu(String.format("%s utoci s uderem za %s hp", jmeno, uder));
        souper.branSe(uder);
    }
    protected void nastavZpravu(String zprava){
        this.zprava = zprava;
    }

    /**
     * Vraci vypis prubehu boje
     * @return zprava
     */
    public String vratPosledniZpravu(){
        return zprava;
    }
}
