package com.espacex.decouverte.objetsastro;

import com.espacex.decouverte.enginsspatiaux.Vaisseau;
import com.espacex.decouverte.enginsspatiaux.VaisseauDeGuerre;

public class PlaneteTellurique extends Planete implements Habitable{

    public int totalVisiteurs =0;
    public Vaisseau[][] vaisseauxAccostes = new Vaisseau[1][1];


    PlaneteTellurique(){
        super();
    }

    public PlaneteTellurique(String nom, int tailleBaie){
        super( nom);
        this.vaisseauxAccostes = new Vaisseau[2][tailleBaie];
    }


    public boolean restePlaceDisponible(Vaisseau vaisseau){


        int indexZone = 0 ;

        switch (vaisseau.type){
            case CARGO:
            case VAISSEAUMONDE:
                indexZone = 1 ;
        }


        for (int index = 0; index < vaisseauxAccostes[indexZone].length; index++){
            if(vaisseauxAccostes[indexZone][index]==null){
                return true;
            }
        }

        return false;
    }

    @Override
    public void accueillirVaisseau(int nouveauVisiteur) {
        totalVisiteurs = totalVisiteurs+nouveauVisiteur;
    }

    @Override
    public void accueillirVaisseau(String typeVaisseau) {
        switch (typeVaisseau) {
            case "CHASSEUR":
                totalVisiteurs = totalVisiteurs + 3;
                break;
            case "FREGATE":
                totalVisiteurs = totalVisiteurs + 12;
                break;
            case "CROISEUR":
                totalVisiteurs = totalVisiteurs + 50;
                break;
        }

    }

    @Override
    public void accueillirVaisseaux(Vaisseau... vaisseaux) {

        for (Vaisseau vaisseau : vaisseaux) {


            int indexZone = 0;

            switch (vaisseau.type) {
                case CARGO:
                case VAISSEAUMONDE:
                    indexZone = 1;
            }


            if (vaisseau instanceof VaisseauDeGuerre) {

                ((VaisseauDeGuerre) vaisseau).desactiverArmes();
            }

            for (int index = 0; index < vaisseauxAccostes[indexZone].length; index++) {

                if (vaisseauxAccostes[indexZone][index] == null) {

                    vaisseauxAccostes[indexZone][index] = vaisseau;
                    break;
                }
            }

            totalVisiteurs = totalVisiteurs + vaisseau.nbPassagers;
        }
    }
}
