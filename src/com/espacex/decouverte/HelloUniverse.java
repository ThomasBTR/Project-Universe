package com.espacex.decouverte;

import com.espacex.decouverte.enginsspatiaux.*;

import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CHASSEUR;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CARGO;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.FREGATE;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.CROISEUR;
import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.VAISSEAUMONDE;

import com.espacex.decouverte.objetsastro.*;

import java.util.*;

public class HelloUniverse {

    public static void main(String[] args) {

        Galaxie systemeSolaire = new Galaxie();
        systemeSolaire.nom = "Système Solaire";

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.distanceEtoile = 1427.0f;
        systemeSolaire.planetes.add(saturne);

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.distanceEtoile = 2877.38f;
        uranus.atmosphere = new Atmosphere();
        systemeSolaire.planetes.add(uranus);

        PlaneteTellurique terre = new PlaneteTellurique("Terre", 10);
        terre.diametre = 12756;
        terre.distanceEtoile = 149.6f;
        systemeSolaire.planetes.add(terre);


        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        jupiter.distanceEtoile = 778.3f;
        systemeSolaire.planetes.add(jupiter);

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        mercure.distanceEtoile = 57.9f;
        systemeSolaire.planetes.add(mercure);

        PlaneteTellurique mars = new PlaneteTellurique("Mars", 3);
        mars.diametre = 6792;
        mars.distanceEtoile = 227.9f;
        systemeSolaire.planetes.add(mars);

        Atmosphere atmosphereMars = new Atmosphere();
        atmosphereMars.constituants.put("CO2", 95.0f);
        atmosphereMars.constituants.put("N2", 3.0f);
        atmosphereMars.constituants.put("AR", 1.5f);
        atmosphereMars.constituants.put("NO", 0.013f);

        System.out.println("L'atmosphère de Mars est constituée de  : /n");
        for (Map.Entry<String, Float> entry : atmosphereMars.constituants.entrySet()) {
            System.out.println(entry.getValue() + "% de " + entry.getKey());
        }

        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        venus.distanceEtoile = 108.2f;
        systemeSolaire.planetes.add(venus);


        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.distanceEtoile = 4497.07f;
        systemeSolaire.planetes.add(neptune);

        Atmosphere atmosphereUranus = new Atmosphere();
        atmosphereUranus.tauxHydrogene = 83f;
        atmosphereUranus.tauxHelium = 15f;
        atmosphereUranus.tauxMethane = 2.5f;
        atmosphereUranus.tauxAzote = 0.0f;
        uranus.atmosphere = atmosphereUranus;

        System.out.println("Les planètes du système Solaire dans l'ordre croissant de distance avec le Soleil sont : \n");
        for (Planete planete : systemeSolaire.planetes) {
            System.out.println(planete.nom + "\n");
        }

        System.out.println("la composition de l'atmosphère d'Uranus est de : ");
        if (uranus.atmosphere.tauxHydrogene != null) {
            System.out.println("A " + uranus.atmosphere.tauxHydrogene + " % d'Hydrogène,");
        }
        if (uranus.atmosphere.tauxArgon != null) {
            System.out.println("A " + uranus.atmosphere.tauxArgon + " % d'Argon,");
        }
        if (uranus.atmosphere.tauxDioxydeDeCarbone != null) {
            System.out.println("A " + uranus.atmosphere.tauxDioxydeDeCarbone + " % de Dioxyde de carbone,");
        }
        if (uranus.atmosphere.tauxAzote != null) {
            System.out.println("A " + uranus.atmosphere.tauxAzote + " % d'Azote,");
        }
        if (uranus.atmosphere.tauxHelium != null) {
            System.out.println("A " + uranus.atmosphere.tauxHelium + " % d'Helium,");
        }
        if (uranus.atmosphere.tauxSodium != null) {
            System.out.println("A " + uranus.atmosphere.tauxSodium + " % de Sodium,");
        }
        if (uranus.atmosphere.tauxMethane != null) {
            System.out.println("A " + uranus.atmosphere.tauxMethane + " % de Méthane,");
        }


        Vaisseau chasseur = new VaisseauDeGuerre(CHASSEUR);
        chasseur.nbPassagers = 5;
        Vaisseau fregate = new VaisseauDeGuerre(FREGATE);
        fregate.nbPassagers = 40;
        Vaisseau croiseur = new VaisseauDeGuerre(CROISEUR);
        croiseur.nbPassagers = 150;
        Vaisseau cargo = new VaisseauCivil(CARGO);
        cargo.nbPassagers = 150;
        Vaisseau vm = new VaisseauCivil(VAISSEAUMONDE);
        vm.nbPassagers = 500;

        Vaisseau cargoTerre1 = new VaisseauCivil(CARGO);
        cargo.nbPassagers = 150;
        Vaisseau chasseurTerre1 = new VaisseauDeGuerre(CHASSEUR);
        chasseur.nbPassagers = 5;
        Vaisseau chasseurTerre2 = new VaisseauDeGuerre(CHASSEUR);
        chasseur.nbPassagers = 5;

        terre.accueillirVaisseaux(cargoTerre1, chasseurTerre1, chasseurTerre2);

        Scanner scanner = new Scanner(System.in);

        boolean recommencer = true;
        while (recommencer) {

            System.out.println("Quel vaisseau souhaitez vous manipuler​ : " + CHASSEUR.name() + ", " + FREGATE.name() + ", " + CROISEUR.name() + ", " + CARGO.name() + " ou " + VAISSEAUMONDE.name() + " ?");
            String vaisseauSelectionne = scanner.nextLine();


            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(vaisseauSelectionne);
            Vaisseau vaisseau = null;

            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseau = new VaisseauDeGuerre(CHASSEUR);
                    break;
                case FREGATE:
                    vaisseau = fregate;
                    break;
                case CROISEUR:
                    vaisseau = croiseur;
                    break;
                case CARGO:
                    vaisseau = cargo;
                    break;
                case VAISSEAUMONDE:
                    vaisseau = vm;
                    break;
            }

            System.out.println("2) Sur quel planète tellurique souhaitez-vous vous poser : Mercure, Venus, la Terre ou Mars ?");
            String nomPlanete = scanner.nextLine();

            Planete planeteSelectionnee = null;

            for (Planete p : systemeSolaire.planetes
            ) {
                if (p.nom.equalsIgnoreCase(nomPlanete)) {
                    planeteSelectionnee = p;
                    break;
                }
            }

            if (planeteSelectionnee instanceof PlaneteGazeuse) {
                System.out.println("La planète selectionnée n'est pas une planète Tellurique.");
                continue;
            }

            PlaneteTellurique planete = (PlaneteTellurique) planeteSelectionnee;


            System.out.println("3) Quel tonnage voulez-vous embarquer? ");
            int tonnage = scanner.nextInt();
            scanner.nextLine();


            planete.accueillirVaisseaux(vaisseau);
            try {
                vaisseau.emporterCargaison(tonnage);
            } catch (DepassementTonnageException e) {
                System.out.println("Le vaisseau à rejeté "+e+" tonnes");
                System.out.println("Voulez-vous emporter un tonnage partiel de la cargaison à hauteur de " + (tonnage - e.tonnageEnExces) + " tonnes (oui/non) ?");
                String reponse = scanner.nextLine();
                if (reponse.equals("oui")) {
                    try {
                        vaisseau.emporterCargaison(tonnage - e.tonnageEnExces);
                    } catch (DepassementTonnageException exception) {
                        System.out.println("Une erreur inattendue est survenue");
                    }
                } else {
                    System.out.println("La demande à été annulée.");

                }
            }


            if (!planete.restePlaceDisponible(vaisseau)) {
                System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie.");
            } else {
                planete.accueillirVaisseaux(vaisseau);
            }
            System.out.println("Voulez-vous recommencer ?");
            recommencer = scanner.nextLine().equals("oui");

        }


        mars.accueillirVaisseau(8);
        mars.accueillirVaisseau("FREGATE");
        System.out.println("Le nombre d'humains ayant déjà séjourné sur Mars est actuellement de " + mars.totalVisiteurs);


        uranus.atmosphere.tauxHydrogene = 83f;
        uranus.atmosphere.tauxHelium = 15f;
        uranus.atmosphere.tauxMethane = 2.5f;


        System.out.println("Le nombre d'humains ayant déjà séjourné sur " + mars.nom + " est actuellement de " + mars.totalVisiteurs);

        System.out.println("La forme d'une planète est : " + Planete.forme);
        System.out.println("La forme de la planète" + mars.nom + " est : " + Planete.forme);

        System.out.println(Planete.expansion(10.5));
        System.out.println(Planete.expansion(14.2));

        System.out.println("Le nombre de planètes découverte par l'Homme est de : " + Planete.nbPlanetesDecouvertes);


    }


}
