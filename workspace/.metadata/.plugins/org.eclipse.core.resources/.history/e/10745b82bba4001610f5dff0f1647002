package test2048;
import java.util.ArrayList;
import java.util.Scanner;

public class TabTuile 
{
	private
		int dimention;
		int TabJeu[][];
		
	public TabTuile(int dim)
	{
		try
		{
			dimention = dim;
			int Tab[][] = new int[dim][dim];
			for(int i=0; i<dim;i++)
			{
				for(int j=0; j<dim;j++)
				{
					Tab[i][j]=0;
				}
			}
			TabJeu = Tab;
			popTuiles();
			popTuiles();
		}
		catch(Exception MauvaiseDimention)
		{
			System.out.println("Erreur la dimention de votre 2048 doit être positif non nul");
		}
	}
	
	public void reset()
	{
		for(int i=0;i<dimention;i++)
		{
			for(int j=0; j<dimention;j++)
			{
				TabJeu[i][j]=0;
			}
		}
	}
	
	public int getDim()
	{
		return dimention;
	}
	
	public int getElemTab(int i, int j)
	{
		return TabJeu[i][j];
	}

	public int[][] getTab()
	{
		return TabJeu;
	}
	
	public void setTab(TabTuile Tab)
	{
		for(int i=0; i<dimention;i++)
		{
			for(int j=0;j<dimention;j++)
			{
				TabJeu[i][j]=Tab.getElemTab(i,j);
			}
		}
	}
	
 	public void affichTab()
	{
		for(int i=0; i<dimention;i++)
		{
			System.out.print("| ");
			for(int j=0;j<dimention;j++)
			{
				if(TabJeu[i][j]==0)
				{
					System.out.print("  | ");
				}
				else
					System.out.print(TabJeu[i][j]+" | ");
			}
			System.out.print("\n");
		}
	}
	
	public boolean MovePossible()
	{
		for(int i=0;i<dimention;i++)
		{
			for(int j=0;j<dimention;j++)
			{
				if(TabJeu[i][j]==0)
				{
					return true;
				}
				if(j<dimention-1 && i<dimention-1)
				{
					if(TabJeu[i][j]==TabJeu[i][j+1] || TabJeu[i][j]==TabJeu[i+1][j])
					{
						return true;
					}
				}
				if(j==dimention-1 && i<dimention-1)
				{
					if(TabJeu[i][j]==TabJeu[i+1][j])
					{
						return true;
					}
				}
				if(i==dimention-1 && j<dimention-1)
				{
					if(TabJeu[i][j]==TabJeu[i][j+1])
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void popTuiles()
	{
		int checkPlace=0;
		ArrayList<Integer> ligne = new ArrayList<Integer>();
		ArrayList<Integer> colone = new ArrayList<Integer>();
		int index=0;
		for(int i=0; i<dimention;i++)
		{
			for(int j=0; j<dimention;j++)
			{
				if(TabJeu[i][j]==0)
				{
					ligne.add(i);
					colone.add(j);
					index=+1;
					checkPlace=1;
				}
			}
		}
		if(checkPlace!=0)
		{
			index = (int) (Math.random() * ligne.size() );
			int nbPop = (int)(Math.random() * 4);
			if(nbPop==3)
			{
				nbPop = 4;
			}
			else
			{
				nbPop = 2;
			}
			TabJeu[ligne.get(index)][colone.get(index)]= nbPop;
		}
	}
	
	public void DecalerLeft()
	{
		int k,l=0;
		for(int i=0;i<dimention;i++)
		{
			for(int j=0;j<dimention;j++)
			{
				if(TabJeu[i][j]==0)
				{
					k=j;
					l=j;
					while(k<dimention)
					{
						if(TabJeu[i][k]!=0 && TabJeu[i][l]==0)
						{
							TabJeu[i][l]=TabJeu[i][k];
							TabJeu[i][k]=0;
							while(TabJeu[i][l]!=0 && l<dimention)
							{
								l=l+1;
							}
						}
						k=k+1;
					}
				}
			}
		}	
	}
	
	public void MoveLeft()
	{
		DecalerLeft();
		for(int i=0;i<dimention;i++)
		{
			for(int j=0;j<dimention;j++)
			{
				if(j<dimention-1)
				{
					if(TabJeu[i][j]==TabJeu[i][j+1] && TabJeu[i][j]!=0)
					{
						TabJeu[i][j]=TabJeu[i][j+1]*2;
						TabJeu[i][j+1]=0;
					}
				}
			}
		}
		DecalerLeft();
	}
	
	public void DecalerRight()
	{
		int k,l=0;
		for(int i=dimention-1;i>=0;i--)
		{
			for(int j=dimention-1;j>=0;j--)
			{
				if(TabJeu[i][j]==0)
				{
					k=j;
					l=j;
					while(k>=0)
					{
						if(TabJeu[i][k]!=0 && TabJeu[i][l]==0)
						{
							TabJeu[i][l]=TabJeu[i][k];
							TabJeu[i][k]=0;
							while(TabJeu[i][l]!=0 && l<dimention)
							{
								l=l-1;
							}
						}
						k=k-1;
					}
				}
			}
		}	
	}
	
	public void MoveRight()
	{
		DecalerRight();
		for(int i=dimention-1;i>=0;i--)
		{
			for(int j=dimention-1;j>=0;j--)
			{
				if(j>0)
				{
					if(TabJeu[i][j]==TabJeu[i][j-1] && TabJeu[i][j]!=0)
					{
						TabJeu[i][j]=TabJeu[i][j-1]*2;
						TabJeu[i][j-1]=0;
					}
				}
			}
		}
		DecalerRight();
	}
	
	public void DecalerUp()
	{
		int k,l=0;
		for(int j=0;j<dimention;j++)
		{
			for(int i=0;i<dimention;i++)
			{
				if(TabJeu[i][j]==0)
				{
					k=i;
					l=i;
					while(k<dimention)
					{
						if(TabJeu[k][j]!=0 && TabJeu[l][j]==0)
						{
							TabJeu[l][j]=TabJeu[k][j];
							TabJeu[k][j]=0;
							while(TabJeu[l][i]!=0 && l<dimention-1)
							{
								l=l+1;
							}
						}
						k=k+1;
					}
				}
			}
		}	
	}
	
	public void MoveUp()
	{
		DecalerUp();
		for(int j=0;j<dimention;j++)
		{
			for(int i=0;i<dimention;i++)
			{
				if(i<dimention-1)
				{
					if(TabJeu[i][j]==TabJeu[i+1][j] && TabJeu[i][j]!=0)
					{
						TabJeu[i][j]=TabJeu[i+1][j]*2;
						TabJeu[i+1][j]=0;
					}
				}
			}
		}
		DecalerUp();
	}

	public void DecalerDown()
	{
		int k,l=0;
		for(int j=dimention-1;j>=0;j--)
		{
			for(int i=dimention-1;i>=0;i--)
			{
				if(TabJeu[i][j]==0)
				{
					k=i;
					l=i;
					while(k>=0)
					{
						if(TabJeu[k][j]!=0 && TabJeu[l][j]==0)
						{
							TabJeu[l][j]=TabJeu[k][j];
							TabJeu[k][j]=0;
							while(TabJeu[l][i]!=0 && l>0)
							{
								l=l-1;
							}
						}
						k=k-1;
					}
				}
			}
		}	
	}
	
	public void MoveDown()
	{
		DecalerDown();
		for(int j=dimention-1;j>=0;j--)
		{
			for(int i=dimention-1;i>0;i--)
			{
				if(i>0)
				{
					if(TabJeu[i][j]==TabJeu[i-1][j] && TabJeu[i][j]!=0)
					{
						TabJeu[i][j]=TabJeu[i-1][j]*2;
						TabJeu[i-1][j]=0;
					}
				}
			}
		}
		DecalerDown();
	}	

	public boolean CheckMove(TabTuile Tab)
	{
		for(int i=0;i<dimention;i++)
		{
			for(int j=0; j<dimention;j++)
			{
				if(TabJeu[i][j]!=Tab.getElemTab(i,j))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static void Partie()
	{
		Scanner dim = new Scanner(System.in);
		Scanner choix = new Scanner(System.in);
		int dimention;
		char chx = '1';
		do
		{
			System.out.print("Dimention du 2048 : ");
			try
			{
				dimention = dim.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Dimention incorect dimention 4 cases sur 4 utilisé par défaut!!!");
				dimention = 4;
			}
			TabTuile Game = new TabTuile(dimention);
			TabTuile Save = new TabTuile(dimention);
			Save.setTab(Game);
				do
				{
					if(chx=='1'||chx=='2'||chx=='g'||chx=='G'||chx=='d'||chx=='D'||chx=='b'||chx=='B'||chx=='h'||chx=='H')
					{
						if(Game.CheckMove(Save))
						{
							Game.popTuiles();
							Game.popTuiles();
						}
					}
					Game.affichTab();
					Save.setTab(Game);
					if(Game.MovePossible())
					{
						System.out.println(" 'g'->Gauche \n 'd'->Droite \n 'b'->Bas \n 'h'->Haut");
						System.out.println(" '1'->reset \n '2'->Nouvelle Partie \n '3'->Quitter \n" );
						chx = choix.next().charAt(0);
						switch (chx)
						{
							case '1' :
								Game.reset();
								break;
							case '2' :
								System.out.println("\n\n\n\n");
								break;
							case '3' :
								break;
							case 'g' | 'G' :
								Game.MoveLeft();
								break;
							case 'd' | 'D' :
								Game.MoveRight();
								break;
							case 'h' | 'H' :
								Game.MoveUp();
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
						System.out.println("Plus de mouvelent disponible");
					}
				}while(chx!='2' && chx !='3');
		}while(chx!='3');
		dim.close();
		choix.close();
	}
}