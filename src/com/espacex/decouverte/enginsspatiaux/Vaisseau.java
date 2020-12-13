package com.espacex.decouverte.enginsspatiaux;


public abstract class Vaisseau {
    public final TypeVaisseau type;
    public int nbPassagers;
    public int blindage = 0;
    public int resistanceDuBouclier = 0;
    protected int tonnageMax;
    protected int tonnageActuel;

    protected Vaisseau(TypeVaisseau type) {
        this.type = type;
    }


    public abstract void emporterCargaison(int cargaison) throws DepassementTonnageException;


    public void  activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+this.type);
    }


    void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+this.type);
    }

}