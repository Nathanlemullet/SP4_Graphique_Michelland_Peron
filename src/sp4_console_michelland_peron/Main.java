/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_michelland_peron;

import java.util.Scanner;

/**
 *
 * @author miche
 */
public class SP4_console_MICHELLAND_PERON {

    /**
     * Jeton
     */
    public static void main(String[] args) { 
        Scanner r = new Scanner(System.in) ;
        String J1 ; 
        String J2 ;
        
        System.out.print("Bienvenue au jeu du puissance 4 !");
        System.out.print("\nEntrer le nom du joueur 1 :") ;
        J1 = r.next() ;
        Joueur Joueur1 = new Joueur(J1)  ;
        System.out.print("Entrer le nom du joueur 2 :") ;
        J2 = r.next() ;
        Joueur Joueur2 = new Joueur(J2)  ;//on prend le nom des joueurs
        
        Partie laPartie = new Partie(Joueur1,Joueur2);// On créer la partie intitulé laPartie
        laPartie.grilleDeJeu.afficherGrilleSurConsole();
        laPartie.initialiserPartie();// On appelle la méthode qui initialise la partie
        laPartie.debuterPartie();// On appelle la méthode qui lance la partie
        laPartie.attribuerCouleursAuxJoueurs();// On appelle la méthode qui attribuer aux joueurs couleur

        
         
        
        
        
    }
    
}
