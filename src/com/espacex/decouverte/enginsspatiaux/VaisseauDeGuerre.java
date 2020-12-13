package com.espacex.decouverte.enginsspatiaux;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CHASSEUR;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.FREGATE;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CROISEUR;

/**
 * 
 */


public class VaisseauDeGuerre extends Vaisseau{
    private boolean armesDesactivees = false;

    public VaisseauDeGuerre(TypeVaisseau type){
        super(type);
        if (type==CHASSEUR){
            tonnageMax = 0;
        }else if(type==FREGATE){
            tonnageMax=50;
        }else if(type==CROISEUR){
            tonnageMax = 100;
        }
    }

    public void desactiverArmes(){
        System.out.println("Desactivation des armes d'un vaisseau de type "+this.type);
        armesDesactivees= true;
    }

    public void activerArmes(){
        System.out.println("Activation des armes d'un vaisseau de type "+this.type);
        armesDesactivees= false;
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

    @Override
    public void  activerBouclier (){
        this.desactiverArmes();
        super.activerBouclier();
    }

    @Override
    public void emporterCargaison(int cargaison) throws DepassementTonnageException {
        if (this.type.equals(CHASSEUR)){
            throw new DepassementTonnageException(cargaison);
        }else if(nbPassagers<12){
            throw new DepassementTonnageException(cargaison);

        }else {
            int tonnagePassagers = 2 * nbPassagers;
            int tonnageRestant = tonnageMax - tonnageActuel;
            int tonnageAConsiderer = (Math.min(tonnagePassagers, tonnageRestant));
            if (cargaison > tonnageAConsiderer) {
                int tonnageEnExces = cargaison - tonnageAConsiderer;
                throw new DepassementTonnageException(tonnageEnExces);
            } else {
                tonnageActuel = tonnageActuel + cargaison;
            }
        }
    }
}