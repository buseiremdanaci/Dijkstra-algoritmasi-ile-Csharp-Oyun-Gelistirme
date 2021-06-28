package prolab2.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {
		
	public ArrayList<ArrayList<Integer>> findPath(int start,int goal)
	{
		if(start == goal)
			return new ArrayList<ArrayList<Integer>>();
		return dijkstr(start,goal);
	}
	
	public int[][] getKoor()
	{
		int[][] harita = new int[11][13];
		
		try 
		{
			FileReader flRead = new FileReader("harita.txt");
			BufferedReader bfReader = new BufferedReader(flRead);
			String yaziString;
			int j = 0;
			
			while(true)
			{
				yaziString = bfReader.readLine();
				if(yaziString == null)
					break;
				else 
				{
					if(!yaziString.startsWith("Karakter"))
					{
						for(int i = 0; i < yaziString.split("\t").length; i++)
						{
							harita[j][i] = Integer.parseInt(yaziString.split("\t")[i]);
						}
						j++;
					}
				}
			}
			
			bfReader.close();
			flRead.close();
		} 
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			System.out.println("Hata dijkstra satir : 52");
		}
		return harita;
	}
	
	public int minDistance(int dist[],Boolean b[])
	{
		int min = Integer.MAX_VALUE;
		int index = -1;
		
		for(int i = 0; i < 78; i++)
		{
			if(b[i] == false && dist[i] <= min)
			{
				min = dist[i];
				index = i;					
			}
		}
		return index;
	}
	
	public ArrayList<ArrayList<Integer>> dijkstr(int start,int goal)
	{
		ArrayList<Integer> insidePath = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
		
		int[][] harita = getKoor();
		
		int distance[] = new int[78];
		Boolean b[] = new Boolean[78];
		
		int graph[][] = new int[78][78];
		int index = 0;
		
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				if(harita[i][j] == 1)
				{
					harita[i][j] = index;
					index++;
				}
				else
				{
					harita[i][j] = -1;
				}
			}
		}
		
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				int eklenecekler[] = new int[4];
				
				if(harita[i][j] != -1)
				{
					
					if(i > 0)
					{
						if(harita[i-1][j] != -1)
						{
							eklenecekler[0] = harita[i-1][j];
						}
					}
					if(i < 10)
					{
						if(harita[i+1][j] != -1)
						{
							eklenecekler[1] = harita[i+1][j];
						}
					}
					if(j > 0)
					{
						if(harita[i][j-1] != -1)
						{
							eklenecekler[2] = harita[i][j-1];
						}
					}
					if(j < 12)
					{
						if(harita[i][j+1] != -1)
						{
							eklenecekler[3] = harita[i][j+1];
						}
					}
					
					for (int k = 0; k < eklenecekler.length; k++) 
					{
						if(eklenecekler[k] != 0)
						graph[harita[i][j]][eklenecekler[k]] = 1;
					}
					
				}
			}
		}
		graph[4][0] = 1;
		
		for(int i = 0; i < 78; i++)
		{
			distance[i] = Integer.MAX_VALUE;
			b[i] = false;
		}
		
		distance[start] = 0;
		int lastDistance = 1;
		
		for(int i = 0; i < 78; i++)
		{
			int u = minDistance(distance,b);
			try {
				b[u] = true;
			} catch (Exception e) {
				u = i;
				System.out.println("-1   " + u);
			}
			
			for(int j = 0; j < 78; j++)
			{
				if(!b[j] && graph[u][j] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + 1 < distance[j])//graph[u][j] < distance[j])
				{
					distance[j] = distance[u] + 1;
					if(lastDistance != distance[j])
					{
						 
						path.add(new ArrayList<Integer>(insidePath));
						insidePath.clear();
						lastDistance = distance[j];
					}
					insidePath.add(j);
					//System.out.println("distance[j]: " + distance[j] + "\t distance[u]: " + distance[u] + "\tgraph[u][j]: " + graph[u][j] + "\t i: " + i + "  j: " + j);
				}
			}
		}
		
		return createPath(path,start,goal);
	}
	
	public ArrayList<ArrayList<Integer>> createPath(ArrayList<ArrayList<Integer>> path,int start,int goal)
	{
		ArrayList<Integer> realPath = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> pathKoordinatlari = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> gecIntegers = new ArrayList<Integer>();
		
		int[][] harita = getKoor();
		
		
		int hedef;
		int hedefY = 0;
		int hedefX = 0;
		int onceki = goal;
		int XIndex;
		int YIndex;
		int index = 0;
		
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				if(harita[i][j] == 1)
				{
					harita[i][j] = index;
					index++;
				}
				else
				{
					harita[i][j] = -1;
				}
			}
		}
		
		for (int i = 0; i < path.size(); i++) 
		{
			if(path.get(i).contains(goal))
			{
				for (int j = 0; j < path.get(i).size(); j++) 
				{
					if(path.get(i).get(j) == goal)
					{
						hedefY = i;
						hedefX = j;
					}
				}	
			}
		}
		
		realPath.add(path.get(hedefY).get(hedefX));
		
		for (int i = hedefY - 1; i >= 0; i--) 
		{
			YIndex = 0;
			boolean donguyuKir = false;
			
			for(XIndex = 0; XIndex < 11; XIndex++)
			{
				for(int l = 0; l < 13; l++)
				{
					if(harita[XIndex][l] == onceki)
					{
						YIndex = l;
						donguyuKir = true;
					}
					if(donguyuKir)
					{
						break;
					}
				}
				if(donguyuKir)
				{
					break;
				}
			}
			
			for (int j = 0; j < path.get(i).size(); j++) 
			{
				if(XIndex > 0)
				{
					if(harita[XIndex-1][YIndex] == path.get(i).get(j))
					{
						onceki = path.get(i).get(j);
						realPath.add(path.get(i).get(j));
						break;
					}
				}
				if(XIndex < 10)
				{
					if(harita[XIndex+1][YIndex] == path.get(i).get(j))
					{
						onceki = path.get(i).get(j);
						realPath.add(path.get(i).get(j));
						break;
					}
				}
				if(YIndex > 0)
				{
					if(harita[XIndex][YIndex-1] == path.get(i).get(j))
					{
						onceki = path.get(i).get(j);
						realPath.add(path.get(i).get(j));
						break;
					}
				}
				if(YIndex < 12)
				{
					if(harita[XIndex][YIndex+1] == path.get(i).get(j))
					{
						onceki = path.get(i).get(j);
						realPath.add(path.get(i).get(j));
						break;
					}
				}
			}
		}
		boolean donguyuKir = false;
		for (int j = 0; j < realPath.size(); j++)
		{
			hedef = realPath.get(j);
			for(int y = 0; y < 11; y++)
			{
				for(int x = 0; x < 13; x++)
				{
					if(harita[y][x] == hedef)
					{
						gecIntegers.clear();
						gecIntegers.add(y);
						gecIntegers.add(x);
						pathKoordinatlari.add(new ArrayList<Integer>(gecIntegers));
						donguyuKir = true;
					}
					if(donguyuKir)
					{
						break;
					}
				}
				if(donguyuKir)
				{
					break;
				}
			}
			donguyuKir = false;
		}
		Collections.reverse(pathKoordinatlari);
		return pathKoordinatlari;
	}
	
	public int indexToNumber(int x,int y)
	{
		int index = 0;
		int[][] harita = getKoor();
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				if(harita[i][j] == 1)
				{
					harita[i][j] = index;
					index++;
				}
				else
				{
					harita[i][j] = -1;
				}
			}
		}
		return harita[y][x];
	}
	
	public int[] numberToIndex(int number)
	{
		int index = 0;
		int koordinatlar[] = new int[2];
		int[][] harita = getKoor();
		
		for(int i = 0; i < 11; i++)
		{
			for(int j = 0; j < 13; j++)
			{
				if(harita[i][j] == 1)
				{
					harita[i][j] = index;
					if(index == number)
					{
						koordinatlar[0] = j;
						koordinatlar[1] = i;
						return koordinatlar;
					}
					index++;
				}
				else
				{
					harita[i][j] = -1;
				}
				
			}
		}
		return koordinatlar;
	}
}
