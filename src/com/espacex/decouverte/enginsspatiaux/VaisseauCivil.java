package com.espacex.decouverte.enginsspatiaux;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CARGO;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.VAISSEAUMONDE;

public class VaisseauCivil extends Vaisseau {
    int tonnageActuel=0;
    int tonnageMax;

    public VaisseauCivil(TypeVaisseau type) {
        this.type=type;
        if (type==CARGO)  {
            tonnageMax = 500;
        } else if(type==VAISSEAUMONDE) {
            tonnageMax = 2000;
        }
    }


    @Override
    public int emporterCargaison(int cargaison) {

        int tonnageRestant = tonnageMax - tonnageActuel;
        if (cargaison > tonnageRestant) {
            tonnageActuel = tonnageMax;
            return cargaison - tonnageRestant;
        } else {
            tonnageActuel = tonnageActuel + cargaison;
            return 0;
        }

    }

}
