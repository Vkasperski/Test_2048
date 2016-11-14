// KASPERSKI VICTOR : TEST 2048
// 07/11/2016
// https://github.com/Vkasperski/Test_2048.git

package test2048;

import java.util.Scanner;


public class Test2048 
{ 
	public static void main(String[]args)
	{
		Scanner dim = new Scanner(System.in);
		Scanner choix = new Scanner(System.in); 
		int dimension;
		char chx = '1';
		do
		{
			System.out.print("Dimension du 2048 : ");
			try
			{
				dimension = dim.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Dimension incorect dimention 4 cases sur 4 utilisé par défaut!!!");
				dimension = 4;
			}
			TabTuile Game = new TabTuile(dimension);
			TabTuile Save = new TabTuile(dimension);
			Save.setTab(Game);
				do
				{
					if(chx=='r'||chx=='2'||chx=='g'||chx=='G'||chx=='d'||chx=='D'||chx=='b'||chx=='B'||chx=='h'||chx=='H')
					{
						if(Game.CheckMove(Save))
						{
							Game.popTuiles();
							Game.popTuiles();
						}
					}
					Game.affichTab();
					Save.setTab(Game); 
					if(Game.MovePossible() || chx=='r' ||chx=='2')
					{
						System.out.println(" 'g'->Gauche \n 'd'->Droite \n 'b'->Bas \n 'h'->Haut");
						System.out.println(" 'r'->reset \n '2'->Nouvelle Partie \n '3'->Quitter \n" );
						chx = choix.next().charAt(0);
						switch (chx)
						{
							case 'r' :
								Game.reset();
								break;
							case '2' :
								System.out.println("\n\n\n\n");
								break;
							case '3' :
								break;
							case 'g' | 'G' :
								Game.TurnTable();
								Game.TurnTable();
								Game.TurnTable();
								Game.MoveDown();
								Game.TurnTable();
								break;
							case 'd' | 'D' :
								Game.TurnTable();
								Game.MoveDown();
								Game.TurnTable();
								Game.TurnTable();
								Game.TurnTable();
								break;
							case 'h' | 'H' :
								Game.TurnTable();
								Game.TurnTable();
								Game.MoveDown();
								Game.TurnTable();
								Game.TurnTable();
								break;
							case 'b' | 'B' :
								Game.MoveDown();
								break;
							default :
								System.out.println("\n Choix non disponible");
								break;
						}
					}
					else
					{
						System.out.println("Plus de mouvelent disponible :\n 1->reset \n 2->Nouvelle Partie \n 3->Quitter");
						chx = choix.next().charAt(0);
						if(chx!='r' && chx!='2' && chx!='3')
						{
							System.out.println("Choix non disponible");
						}
					}
					Game.is2048();
				}while(chx!='2' && chx !='3');
		}while(chx!='3');
		dim.close();
		choix.close();
	}
}