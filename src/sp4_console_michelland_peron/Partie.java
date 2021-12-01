/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_michelland_peron;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class Partie {
    Joueur Listejoueurs[] = new Joueur[2];
    Joueur JoueurCourant;
    Grille grilleDeJeu = new Grille();
    int nombreJetonsRestants0=21 ;
    int nombreJetonsRestants1=21 ;
    Random r= new Random();
    
public Partie(Joueur Joueur1,Joueur Joueur2){
        Listejoueurs[0]=Joueur1;
        Listejoueurs[1]=Joueur2;
    }
public void attribuerCouleursAuxJoueurs() {
    
    int re = r.nextInt(2);
    if (re==0){
        Listejoueurs[0].couleur = "Rouge";
        Listejoueurs[1].couleur = "Jaune";
    } 
    else {
        Listejoueurs[0].couleur = "Jaune";
        Listejoueurs[1].couleur = "Rouge";
    }
}
  
public void initialiserPartie() {
    Grille grilleDeJeu = new Grille();
    grilleDeJeu.viderGrille();
    Scanner sc = new Scanner(System.in);
   
    System.out.print("Nom du joueur 1 :");
    Joueur Joueur1 = new Joueur(sc.nextLine());
   
    System.out.print("Nom du joueur 2 :");
    Joueur Joueur2 = new Joueur(sc.nextLine());
   
    Listejoueurs[1] = Joueur2;
    Listejoueurs[0] = Joueur1;
    //on donne noms aux joueurs et on les place dans la liste des joueurs
    attribuerCouleursAuxJoueurs();
   
    for (int i = 0; i < 21; i++) { //on donne les jetons aux joueurs
        Jeton J1 = new Jeton(Listejoueurs[0].couleur);
        Joueur1.ajouterjeton(J1);
        Jeton J2 = new Jeton(Listejoueurs[0].couleur);
        Joueur2.ajouterjeton(J2);
    }
    //on definit le permier joueur a jouer aléatoirement
    
    int preums = r.nextInt(2);
    if (preums==1){
        JoueurCourant= Listejoueurs[0];
    }
    else {
        JoueurCourant= Listejoueurs[1];
    }
    //on crée d'abord les trous noirs avec un compteur pour que lorsqu'on place les deux premiers trous noirs on place aussi deux intégrateurs
    int nbdes=0;
    for (int i =0; i<5 ; i++){ 
        int colonnetrounoir = r.nextInt(7);     
        int lignetrounoir = r.nextInt(6);
        if (grilleDeJeu.CellulesJeu[lignetrounoir][colonnetrounoir].presenceTrouNoir()==false){
            grilleDeJeu.placerTrouNoir(lignetrounoir,colonnetrounoir);
            nbdes+=1;
        }
        else{
            i-=1;
        }
        if (nbdes<3){
            grilleDeJeu.placerDesintegrateur(lignetrounoir,colonnetrounoir);
        }
    }
//reste trois integrateurs a placer de la meme maniere que les trous noirs
for (int i =0; i<3 ; i++){
        int colonnedes = r.nextInt(7);
        int lignedes = r.nextInt(6);
        if (grilleDeJeu.CellulesJeu[lignedes][colonnedes].presenceDesintegrateur()==false){
        grilleDeJeu.placerTrouNoir(lignedes,colonnedes);
        }
        if (grilleDeJeu.CellulesJeu[lignedes][colonnedes].presenceDesintegrateur()==true){
        i-=1;
        }
    }
grilleDeJeu.afficherGrilleSurConsole();
} 
public void debuterPartie() {
    while (grilleDeJeu.etreRemplie()==false & grilleDeJeu.etreGagnantePourJoueur(Listejoueurs[1])==false & grilleDeJeu.etreGagnantePourJoueur(Listejoueurs[0])==false){
        Scanner enter = new Scanner(System.in);
        int cible = enter.nextInt();
        System.out.println("Entrez la colonne de votre choix : ");
        int choixcollone = enter.nextInt();
        while (choixcollone<7 & choixcollone>1 & grilleDeJeu.colonneRemplie(choixcollone)==false){
            Jeton jetonenjeu;
            if (JoueurCourant== Listejoueurs[0]){
                jetonenjeu = JoueurCourant.listeJetons[nombreJetonsRestants0-1];
                grilleDeJeu.ajouterJetonDansColonne(jetonenjeu, choixcollone);
                nombreJetonsRestants0=nombreJetonsRestants0-1;
                JoueurCourant= Listejoueurs[1];
                grilleDeJeu.afficherGrilleSurConsole();
            }
            if (JoueurCourant== Listejoueurs[1]){
                jetonenjeu = JoueurCourant.listeJetons[nombreJetonsRestants1-1];
                grilleDeJeu.ajouterJetonDansColonne(jetonenjeu, choixcollone);
                nombreJetonsRestants1=nombreJetonsRestants1-1;
                JoueurCourant= Listejoueurs[0];
                grilleDeJeu.afficherGrilleSurConsole();
            }
            if(grilleDeJeu.etreRemplie()==true){
                break;
            }
        }      
        /*System.out.println("Erreur ! Entrez une autre colonne : "); */            
    }
}
        
}