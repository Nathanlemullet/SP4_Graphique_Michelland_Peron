/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_michelland_peron;

/**
 *
 * @author miche
 */
public class Grille {

    Cellule  [][]CellulesJeu = new Cellule [6][7];

 

public void grille (){

    for (int i=0;i<=5;i++){

        for (int j=0;j<=6;j++){

            CellulesJeu[i][j]=new Cellule();

        }

    }

}

 

public boolean ajouterJetonDansColonne(Jeton Jeton, int nC){

   

    for (int i=0; i<7;i++){

        if (CellulesJeu[i][nC].jetonCourant==null){
            
            return true;

        }

    }

    return false;

   

}

 

public boolean etreRemplie(){

    int i;

    int j;

    for (i=0; i<7;i++){

        for (j=0; j<6;j++){

            if (CellulesJeu[j][i].jetonCourant==null){

                return false;

            }

        }

    }

    return true;

}

 
public void viderGrille(){ //vide les jetons de la grille
    for (int j=0;j<7;j++){ 
        for (int i=0;i<6;i++){
            CellulesJeu[i][j].trouNoir=false;
            CellulesJeu[i][j].desintegrateur=false;
            CellulesJeu[i][j].jetonCourant=null;
        }
    }
}


public void afficherGrilleSurConsole(){
    int i;
    int j; 
    for (i=5; i>=0;i--){
        for (j=6; j>=0;j--){
            if (celluleOccupee(i,j)==true){  
                if (lireCouleurDuJeton(i,j)=="rouge"){
                    System.out.println("\033[31m O");
                }
                else {
                    System.out.println("\033[33m O");
                }
            }  
                if(CellulesJeu[i][j].presenceDesintegrateur()==true){ 
                    if(CellulesJeu[i][j].presenceTrouNoir()==true){   
                        System.out.print("\033[30m O  ");  
                    }
                    else{
                        System.out.print("\033[36m 0  ");  
                        }
                }   
                if(CellulesJeu[i][j].presenceTrouNoir()==true){
                    System.out.print("\033[30m O  ");               
                }
                else{
                    System.out.print("\033[37m O  ");  
                }
        }
    }
}

 

public String lireCouleurDuJeton(int nL,int nC ){

    return CellulesJeu[nC][nL].jetonCourant.couleur;

 

}

 

public boolean celluleOccupee(int nL,int nC){
    if (CellulesJeu[nL][nC].jetonCourant!=null){
        return true;
    }
    else {
        return false;        
    }



}

 

public boolean etreGagnantePourJoueur(Joueur Joueur1){

    for (int i=0; i<6;i++){

        for (int j=0; j<4;j++){ // le if en dessous verifie si il y a une ligne de quatre jetons de la meme couleur.

            if (CellulesJeu[i][j].lireCouleurDuJeton()!=null && CellulesJeu[i][j].lireCouleurDuJeton().equals(Joueur1.couleur)){

                if (CellulesJeu[i][j+1].lireCouleurDuJeton().equals(Joueur1.couleur) &&CellulesJeu[i][j+2].lireCouleurDuJeton().equals(Joueur1.couleur) &&CellulesJeu[i][j+3].lireCouleurDuJeton().equals(Joueur1.couleur)){

                    return true;

                }

   

            }

               

        }

    }

    for (int i=0;i<3;i++){

       for (int j=0; j<4;j++){// ICI C'est pour verifier diagonale vers la droite motante

            if (CellulesJeu[i][j].lireCouleurDuJeton()!=null && CellulesJeu[i][j].lireCouleurDuJeton().equals(Joueur1.couleur)){

                if (CellulesJeu[i+1][j+1].lireCouleurDuJeton().equals(Joueur1.couleur) &&CellulesJeu[i+2][j+2].lireCouleurDuJeton().equals(Joueur1.couleur) &&CellulesJeu[i+3][j+3].lireCouleurDuJeton().equals(Joueur1.couleur)){

                    return true;

                }

            }

        }

    }

    for (int i=0;i<2;i++){ // Verifie la colonne

       for (int j=0; j<6;j++){

            if (CellulesJeu[i][j].lireCouleurDuJeton()!=null && CellulesJeu[i][j].lireCouleurDuJeton().equals(Joueur1.couleur)){

                if (CellulesJeu[i+1][j].lireCouleurDuJeton().equals(Joueur1.couleur) &&CellulesJeu[i+2][j].lireCouleurDuJeton().equals(Joueur1.couleur) &&CellulesJeu[i+3][j].lireCouleurDuJeton().equals(Joueur1.couleur)){

                    return true;

                }

            }

        }

    }

    for (int i=0;i<3;i++){

       for (int j=0; j<4;j++){// ICI C'est pour verifier diagonale vers la droite descendante.

            if (CellulesJeu[i][j].lireCouleurDuJeton()!=null && CellulesJeu[i][j].lireCouleurDuJeton().equals(Joueur1.couleur)){

                if (CellulesJeu[i-1][j+1].lireCouleurDuJeton().equals(Joueur1.couleur) &&CellulesJeu[i-2][j+2].lireCouleurDuJeton().equals(Joueur1.couleur) &&CellulesJeu[i-3][j+3].lireCouleurDuJeton().equals(Joueur1.couleur)){

                    return true;

                }

            }

        }

    }

    return false;

  

}

 

public boolean placerDesintegrateur(int nL,int nC){

    if (CellulesJeu[nL][nC].desintegrateur==false){

        CellulesJeu[nL][nC].desintegrateur=true;

        return true; 

    }

    return true;

}

 

public boolean placerTrouNoir(int nL,int nC){

    if (CellulesJeu[nL][nC].presenceTrouNoir()==false){

        CellulesJeu[nL][nC].placerTrouNoir();

        return true; 

    }

    return true;

}

 

 

public void tasserGrille(int Col){

    for(int i=0; i<6;i++){

        if( i==5){

            CellulesJeu[i][Col].jetonCourant=null;

        } 

        if (CellulesJeu[i][Col].jetonCourant==null){  /* Pour bien vérifier que la cellule soit bien celle à qui on a supprimer le jeton.*/

            CellulesJeu[i][Col].jetonCourant=CellulesJeu[i][Col+1].jetonCourant ;

            CellulesJeu[i][Col+1].jetonCourant=null;

        }

    }

     

}

public void tasserGrille(){

    for (int j=0; j<7;j++){

        tasserGrille(j);

    }

}

 

public boolean supprimerJeton (int x, int y){

    if (CellulesJeu[x][y].jetonCourant==null){

        return false;

    }

    else {

    CellulesJeu[x][y].jetonCourant=null;

    return true;

    }

}

 

public Jeton recupererJeton (int x,int y){

    Jeton jetonenlevé =CellulesJeu[x][y].recupererJeton(); /*on met le jeton enlevé dans une variable pour pouvoir le retourné quand il sera supprimé dans sa cellule.*/

    CellulesJeu[x][y].supprimerJeton();

    return jetonenlevé;

}

 

public boolean colonneRemplie(int Col){

    if (CellulesJeu[5][Col].jetonCourant!=null){

            return true;

        }

    return false;

}

}


