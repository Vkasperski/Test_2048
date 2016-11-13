// KASPERSKI VICTOR : TEST 2048
// 07/11/2016

package test2048;
import java.util.ArrayList;

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
		for(int i=0;i<getDim();i++)
		{
			for(int j=0; j<getDim();j++)
			{
				setElemTab(i,j,0);
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
	
	public void setElemTab(int i, int j, int elem)
	{
		TabJeu[i][j] = elem;
	}

	public void setTab(TabTuile Tab)
	{
		for(int i=0; i<getDim();i++)
		{
			for(int j=0;j<getDim();j++)
			{
				TabJeu[i][j]=Tab.getElemTab(i,j);
			}
		}
	}
	
	public void TurnTable()
	{
		int[][] newArray = new int[getDim()][getDim()];
	    for(int i = 0; i < getDim();i++) 
	    {
	       for(int j = 0; j < getDim(); j++) 
	       {
	          newArray[i][j] = TabJeu[getDim() - j - 1][i];
	       }
	    }
	    TabJeu = newArray;
	}
	
 	public void affichTab()
	{
		for(int i=0; i<getDim();i++)
		{
			System.out.print("| ");
			for(int j=0;j<getDim();j++)
			{
				if(getElemTab(i,j)==0)
				{
					System.out.print("  | ");
				}
				else
					System.out.print(getElemTab(i,j)+" | ");
			}
			System.out.print("\n");
		}
	}
	
	public boolean MovePossible()
	{
		for(int i=0;i<getDim();i++)
		{
			for(int j=0;j<getDim();j++)
			{
				if(getElemTab(i,j)==0)
				{
					return true;
				}
				if(j<getDim()-1 && i<getDim()-1)
				{
					if(getElemTab(i,j)==getElemTab(i,j+1) || getElemTab(i,j)==getElemTab(i+1,j))
					{
						return true;
					}
				}
				if(j==getDim()-1 && i<getDim()-1)
				{
					if(getElemTab(i,j)==getElemTab(i+1,j))
					{
						return true;
					}
				}
				if(i==getDim()-1 && j<getDim()-1)
				{
					if(getElemTab(i,j)==getElemTab(i,j+1))
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
		for(int i=0; i<getDim();i++)
		{
			for(int j=0; j<getDim();j++)
			{
				if(getElemTab(i,j)==0)
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
			setElemTab(ligne.get(index), colone.get(index), nbPop);
		}
	}
	
	public void DecalerDown()
	{
		int k,l=0;
		for(int j=getDim()-1;j>=0;j--)
		{
			for(int i=getDim()-1;i>=0;i--)
			{
				if(getElemTab(i,j)==0)
				{
					k=i;
					l=i;
					while(k>=0)
					{
						if(getElemTab(k,j)!=0 && getElemTab(l,j)==0)
						{
							setElemTab(l,j,getElemTab(k,j));
							setElemTab(k,j,0);
							while(getElemTab(l,i)!=0 && l>0)
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
		for(int j=getDim()-1;j>=0;j--)
		{
			for(int i=getDim()-1;i>0;i--)
			{
				if(i>0)
				{
					if(getElemTab(i,j)==getElemTab(i-1,j) && getElemTab(i,j)!=0)
					{
						setElemTab(i,j,getElemTab(i-1,j)*2);
						setElemTab(i-1,j,0);
					}
				}
			}
		}
		DecalerDown();
	}	

	public boolean CheckMove(TabTuile Tab)
	{
		for(int i=0;i<getDim();i++)
		{
			for(int j=0; j<getDim();j++)
			{
				if(getElemTab(i,j)!=Tab.getElemTab(i,j))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean is2048()
	{
		for(int i=0; i<getDim()-1;i++)
		{
			for(int j=0;j<getDim()-1;j++)
			{
				if(getElemTab(i,j)==2048)
				{
					System.out.println("Vous avez gagner");
					return true;
				}
			}
		}
		return false;
	}
}