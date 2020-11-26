package com.espacex.decouverte.enginsspatiaux;


public abstract class Vaisseau {
    public TypeVaisseau type;
    public int nbPassagers;
    int blindage = 0;
    int resistanceDuBouclier = 0;
    int tonnageMax;
    int tonnageActuel;


    public abstract int emporterCargaison(int cargaison);

    void  activerBouclier (){
        System.out.println("Activation du bouclier d'un vaisseau de type "+this.type);
    }

    void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+this.type);
    }

}