package com.espacex.decouverte.enginsspatiaux;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CHASSEUR;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.FREGATE;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CROISEUR;

public class VaisseauDeGuerre extends Vaisseau{
    boolean armesDesactivees = false;

    public VaisseauDeGuerre(TypeVaisseau type){
        this.type=type;
        if (type==CHASSEUR){
            tonnageMax = 0;
        }else if(type==FREGATE){
            tonnageMax=50;
        }else if(type==CROISEUR){
            tonnageMax = 100;
        }
    }

    @Override
    public int emporterCargaison(int cargaison) {
        if (this.type.equals(CHASSEUR)){
            return cargaison;
        }else if(nbPassagers<12){
            return cargaison;
        }else {
            int tonnagePassagers = 2 * nbPassagers;
            int tonnageRestant = tonnageMax - tonnageActuel;
            int tonnageAConsiderer = (tonnagePassagers<tonnageRestant ? tonnagePassagers : tonnageRestant);
            if (cargaison > tonnageAConsiderer) {
                tonnageActuel = tonnageMax;
                return cargaison - tonnageAConsiderer;
            } else {
                tonnageActuel = tonnageActuel + cargaison;
                return 0;
            }
        }
    }

    public void desactiverArmes(){
        System.out.println("Desactivation des armes d'un vaisseau de type "+this.type);
        armesDesactivees= true;
    }

    @Override
    void  activerBouclier (){
        this.desactiverArmes();
        super.activerBouclier();
    }

    void attaque(Vaisseau cible,String arme, int dureeAttaque){

        if (armesDesactivees){
            System.out.println("Attaque impossible, l'armement est désactivé.");
        }
        else {
            System.out.println("Le vaisseau de type " + this.type + " attaque un vaisseau de type " + cible.type + " en utilisant l'arme " + arme + " pendant " + dureeAttaque + " minutes.");
            cible.resistanceDuBouclier = 0;
            cible.blindage = cible.blindage / 2;
        }
    }
}