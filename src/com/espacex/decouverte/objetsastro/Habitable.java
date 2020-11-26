package com.espacex.decouverte.objetsastro;

import com.espacex.decouverte.enginsspatiaux.Vaisseau;

public interface Habitable {

    void accueillirVaisseau(int nouveauVisiteur);
    void accueillirVaisseau(String typeVaisseau);
    void accueillirVaisseaux(Vaisseau... nouveauVaisseau);

}
