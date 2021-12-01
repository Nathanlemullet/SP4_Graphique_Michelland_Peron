/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_michelland_peron;

/**
 *
 * @author miche
 */
public class Cellule {

    Jeton jetonCourant;

    boolean trouNoir;

    boolean desintegrateur;

 

public Cellule(){

    jetonCourant=null;

    trouNoir=false;

    desintegrateur=false;

}

   

public boolean affecterJeton (Jeton jeton1){

    if (jetonCourant==null){

        jetonCourant=jeton1;

        return true;

    }

    else {

        return false;

    }

}

public String lireCouleurDuJeton (){

    if (jetonCourant==null){

        return "vide";

    }

    else{

        return jetonCourant.couleur;

    }

}

 

public boolean supprimerJeton (){

    if (jetonCourant==null){

        return false;

    }

    else {

    jetonCourant=null;

    return true;

    }

}

 

public Jeton recupererJeton (){

    return jetonCourant;

}

 

public boolean presenceTrouNoir (){

    if (trouNoir){

        return trouNoir;

    }

    return false;

}

 

public boolean activerTrouNoir(){

    if (trouNoir){

        jetonCourant=null;

        trouNoir=false;

        return true;

    }

    return false;

}

 

public boolean presenceDesintegrateur (){

    if (desintegrateur){

        return desintegrateur;

    }

    return false;

}

 

public boolean placerTrouNoir(){

    if (trouNoir){

        return false;

    }

 

    trouNoir=true;

    return true;

}

 

public boolean recupererDesintegrateur(){

    if(desintegrateur){

        desintegrateur=false;

        return true;

    }

    return false;

}      

 

public boolean placerDesintegrateur (){

    if (desintegrateur){

        return false;

    }

   

    desintegrateur=true;

    return true;

}

}
    


