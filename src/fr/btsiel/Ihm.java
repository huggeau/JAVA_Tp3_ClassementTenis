package fr.btsiel;
import clavier.In;

public class Ihm {
    public static void main(String[] args) {
        int saisieClassement;
        int saisieVictoire;
        int saisieVictoireAdevrsaire;
        int capitalPointDepart = 0;
        int nombreVictoireMax = 0;
        int nombrevictoireTotal = 0;
        int nombreDefaiteEchelonEgale = 0;
        int nombreDefaiteEchelonInferieur = 0;
        int nombreDefaiteEchelon2 = 0;
        int pointGagner = 0;
        int pointMin = 0;
        int pointMax = 0;
        int ecart;
        int bonusVictory;
        final int NC = 1, _40 = 2, _30_5 = 3, _30_4 = 4, _30_3 = 5;
        final int _30_2 = 6, _30_1 = 7, _30 = 8, _15_5 = 9, _15_4 = 10;
        boolean flag = true;

        System.out.println("""
                    veuillez donner votre classement parmis les choix suivant :
                    1| Non-Classé                   6| 30/2
                    2| 40                           7| 30/1
                    3| 30/5                         8| 30
                    4| 30/4                         9| 15/5
                    5| 30/3                        10| 15/4
                    """);
        saisieClassement = In.readInteger();

        do{

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

            if (saisieVictoire > nombreVictoireMax) {
                nombrevictoireTotal = nombreVictoireMax;
                System.out.println("malgré vos nombreuse victoire nous devons réduire ce nombre à " + nombreVictoireMax);
            } else {
                nombrevictoireTotal = saisieVictoire;
                System.out.println("votre nombre de victoire et de " + nombrevictoireTotal);
            }

//            calcul des points gagner grace a ses victoires et a ses victoire bonus
            if (nombrevictoireTotal == nombreVictoireMax){
                System.out.println("nous allons calculer votre bonus de victoire");
                System.out.println("veuillez donner votre nombre de defaite a echelon égale ");
                nombreDefaiteEchelonEgale = In.readInteger();

                System.out.println("veuillez donner votre nombre de défaite a echelon inférieur ");
                nombreDefaiteEchelonInferieur = In.readInteger();

                System.out.println("veuillez donner votre nombre de defaite a echelon inferieur 2");
                nombreDefaiteEchelon2 = In.readInteger();

                bonusVictory = nombrevictoireTotal - nombreDefaiteEchelonEgale - (2 * nombreDefaiteEchelonInferieur) - ( 5* nombreDefaiteEchelon2);

                switch(bonusVictory){
                    case 0,1,2,3,4:
                        nombrevictoireTotal += 1;
                        break;
                    case 5,6,7,8,9:
                        nombrevictoireTotal += 2;
                        break;
                    case 10,11,12,13,14:
                        nombrevictoireTotal += 3;
                        break;
                    case 15,16,17,18,19:
                        nombrevictoireTotal += 4;
                        break;
                    case 20,21,22,23,24:
                        nombrevictoireTotal += 5;
                        break;
                    default:
                        nombrevictoireTotal += 6;
                        break;
                }
            }
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
//            affichage du rang
            System.out.println("votre nombre de point totale est de " + capitalPointDepart);
            if (capitalPointDepart >= pointMax) {
                saisieClassement++;
                System.out.println("vous avez augmenter de 1 rang au niveau du classement");
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


