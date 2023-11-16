package fr.btsiel;
import clavier.In;

public class Ihm {
    public static void main(String[] args) {
        int saisieClassement;
        int saisieVictoire;
        int saisieVictoireAdevrsaire;
        int capitalPointDepart = 0;
        int nombreVictoireMax = 0;
        int nombrevictoireTotal ;
        int nombreDefaite;
        int echelonAdversaire;
        int nombreDefaiteEchelonEgale = 0;
        int nombreDefaiteEchelonInferieur = 0;
        int nombreDefaiteEchelon2 = 0;
        int pointGagner = 0;
        int pointMin = 0;
        int pointMax = 0;
        int ecart;
        int bonusVictory;
        int compteur_G = 0;
        int compteur_i = 0;
        int compteur_e = 0;
        final int NC = 1, _40 = 2, _30_5 = 3, _30_4 = 4, _30_3 = 5;
        final int _30_2 = 6, _30_1 = 7, _30 = 8, _15_5 = 9, _15_4 = 10;
        boolean flag = true;

//        demande le rang du joueur
        System.out.println("""
                    veuillez donner votre classement parmis les choix suivant :
                    1| Non-Classé                   6| 30/2
                    2| 40                           7| 30/1
                    3| 30/5                         8| 30
                    4| 30/4                         9| 15/5
                    5| 30/3                        10| 15/4
                    """);
        saisieClassement = In.readInteger();

//      on fait une boucle do-while car on fais au moins une fois le programme
        do{
            System.out.println("votre classement est de "+saisieClassement);
//            attribution de ses point de depart et de ses victoire max celon son rang
            switch (saisieClassement) {
                case NC:
                    nombreVictoireMax = 5;
                    pointMax = 50;
                    break;
                case _40:
                    capitalPointDepart = 2;
                    nombreVictoireMax = 5;
                    pointMin = 30;
                    pointMax = 80;
                    break;
                case _30_5:
                    capitalPointDepart = 5;
                    nombreVictoireMax = 5;
                    pointMin = 50;
                    pointMax = 150;
                    break;
                case _30_4:
                    capitalPointDepart = 10;
                    nombreVictoireMax = 5;
                    pointMin = 90;
                    pointMax = 260;
                    break;
                case _30_3:
                    capitalPointDepart = 20;
                    nombreVictoireMax = 6;
                    pointMin = 154;
                    pointMax = 340;
                    break;
                case _30_2:
                    capitalPointDepart = 30;
                    nombreVictoireMax = 6;
                    pointMin = 205;
                    pointMax = 410;
                    break;
                case _30_1:
                    capitalPointDepart = 50;
                    nombreVictoireMax = 6;
                    pointMin = 245;
                    pointMax = 480;
                    break;
                case _30:
                    capitalPointDepart = 80;
                    nombreVictoireMax = 6;
                    pointMin = 290;
                    pointMax = 510;
                    break;
                case _15_5:
                    capitalPointDepart = 120;
                    nombreVictoireMax = 6;
                    pointMin = 325;
                    pointMax = 580;
                    break;
                case _15_4:
                    capitalPointDepart = 160;
                    nombreVictoireMax = 6;
                    pointMin = 395;
                    pointMax = 660;
                    break;
            }
            System.out.println("votre nombre de victoire maximale est de " + nombreVictoireMax
                    + "\net votre capitale de point de départ est de " + capitalPointDepart + " points\n");

            System.out.println("veuillez donner votre nombre de victoire ");
            saisieVictoire = In.readInteger();

//            viens regarder si le nombre de victoire donner par le joueur est bien inferieur ou egale a la valeur de victoire max de son rang
            if (saisieVictoire > nombreVictoireMax) {
                nombrevictoireTotal = nombreVictoireMax;
                System.out.println("malgré vos nombreuse victoire nous devons réduire ce nombre à " + nombreVictoireMax);
            } else {
                nombrevictoireTotal = saisieVictoire;
                System.out.println("votre nombre de victoire et de " + nombrevictoireTotal);
            }

//            calcul des victoire bonus
            if (nombrevictoireTotal >= nombreVictoireMax){
                System.out.println("nous allons calculer votre bonus de victoire");
                System.out.println("veuillez donner votre nombre de défaite ");
                nombreDefaite = In.readInteger();
                for (int i = 0; i < nombreDefaite; i++) {
                    System.out.println("veuillez donner l'echelon de l'adversaire qui vous as battu ");
                    echelonAdversaire = In.readInteger();
                    if (echelonAdversaire == saisieClassement){
                        nombreDefaiteEchelonEgale++;
                        compteur_e++;
                        System.out.println("vous avez "+ compteur_e+" point dans le e ( qui équivaut a une defaite a echelon egale) ");
                    } else if (echelonAdversaire +1 == saisieClassement) {
                        nombreDefaiteEchelonInferieur++;
                        compteur_i++;
                        System.out.println("vous avez "+ compteur_i+" point dans le i (qui équivaut a une defaite a un echelon inféreiru)");
                    }else if (echelonAdversaire +2 == saisieClassement){
                        nombreDefaiteEchelon2++;
                        compteur_G++;
                        System.out.println("vous avez "+ compteur_G+ " point dans le G (qui équivaut a une defaite a deux echelon inferieur)");
                    }
                }
                bonusVictory = saisieVictoire - nombreDefaiteEchelonEgale - (2 * nombreDefaiteEchelonInferieur) - ( 5* nombreDefaiteEchelon2);
                System.out.println("vous avez le droit à "+ bonusVictory + " victoire bonus");

               if(bonusVictory >= 25){
                   nombrevictoireTotal += 6;
               }else if(bonusVictory >= 20){
                   nombrevictoireTotal += 5;
               }else if (bonusVictory >= 15){
                   nombrevictoireTotal += 4;
               }else if (bonusVictory >= 10){
                   nombrevictoireTotal += 3;
               } else if (bonusVictory >= 5){
                   nombrevictoireTotal += 2;
               }else{
                   nombrevictoireTotal += 1;
               }
            }

//            calcul des points gagner grâce a ses victoires
            for (int i = 0; i < nombrevictoireTotal; i++) {
                System.out.println("""
                        veuillez donner le classement de votre adversaire parmis les choix suivant :
                        1| Non-Classé                   6| 30/2
                        2| 40                           7| 30/1
                        3| 30/5                         8| 30
                        4| 30/4                         9| 15/5
                        5| 30/3                        10| 15/4
                        """);
                saisieVictoireAdevrsaire = In.readInteger();
                ecart = saisieClassement - saisieVictoireAdevrsaire;
                if (ecart <= -2) {
                    pointGagner = 150;
                } else if (ecart == -1) {
                    pointGagner = 100;
                } else if (ecart == 0) {
                    pointGagner = 50;
                } else if (ecart == 1) {
                    pointGagner = 30;
                } else if (ecart == 2) {
                    pointGagner = 20;
                } else if (ecart == 3) {
                    pointGagner = 15;
                }
                System.out.println("votre nombre de points grâce a cette victoire est de " + pointGagner);
                capitalPointDepart += pointGagner;
            }

//          affichage du changement de classe (s'il y en a un) et mis en arret du programme s'il descend ou ne change pas de classement
            System.out.println("votre nombre de point totale est de " + capitalPointDepart);
            if (capitalPointDepart >= pointMax) {
                saisieClassement++;
                System.out.println("vous avez augmenter de 1 rang au niveau du classement\n");
            } else if (capitalPointDepart <= pointMin) {
                saisieClassement--;
                System.out.println("vous avez diminué de 1 rang au niveau du classement");
                flag = false;
            } else {
                System.out.println("vous gardez le même rang");
                flag = false;
            }

        }while(flag);
    }
}


