package com.espacex.decouverte.objetsastro;

public abstract class Planete implements Comparable<Object> {
    public String nom;
    public long diametre;
    public Atmosphere atmosphere;
    public static final String forme = "Sphérique";
    public static int nbPlanetesDecouvertes = 0 ;
    public float distanceEtoile ;

    Planete(){
        nbPlanetesDecouvertes++;
    }

    Planete(String nom1){
        this.nom = nom1;
        nbPlanetesDecouvertes++;
    }


    public static String expansion(double distance2Planetes){

        if (distance2Planetes<14){
            return "Oh la la mais c'est super rapide !";
        }
        else {
            return "Je rêve ou c'est plus rapide que la lumière ?";

        }
    }


    final void revolution(){
        System.out.println("Je suis la planète "+nom+" et je tourne autour de mon étoile.");
    }
    final void rotation(){
        System.out.println("Je suis la planète "+nom+"et je tourne sur moi-même.");
    }

    void revolution(int angleRev){
        int nbTour = angleRev/360;
        System.out.println(nom+" a effectué "+nbTour+" tours complets autour de son étoile.");
    }
    void rotation(int angleRot){
        int nombreTour = angleRot/360;
        System.out.println(nom+" a effectué "+nombreTour+" tours complets sur elle-même.");
    }

    @Override
    public int compareTo(Object o) {
        Planete autrePlanete = (Planete) o;
        return Float.compare(distanceEtoile,autrePlanete.distanceEtoile);
    }
}
