package P1;

import java.io.*;
import java.util.*;


class vertex{
	
	public int distance[];
	public boolean isexplore = false;
	int index;

	vertex(int size, int index){
		distance = new int[size];
		Arrays.fill(distance, Integer.MAX_VALUE);
		this.index = index;
	}

	void addedge(int vertex, int dis){
		distance[vertex-1] = dis;
	} 
}

class edge{
	int outedge;
	int cost;
	
	edge(int ee, int cost){
		outedge = ee;
		this.cost = cost;
	}
}

public class Prim_Min_Tree {
	public static int size; 
	public static vertex ver[];
	public static ArrayList ischeck = new ArrayList<Integer>();
	public static int solution = 0;
	
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("src/edges.txt"));
		
		size = Integer.parseInt(br.readLine().split(" ")[0]);
		ver = new vertex[size];
		
		//init the ver 
		for (int i = 0; i < ver.length; i++){
			ver[i] = new vertex(size,i);
		}
		
		
		String read;
		
		//add edge
		while((read = br.readLine()) != null){
			String st[] = read.split(" ");
			ver[Integer.parseInt(st[0])-1].addedge(Integer.parseInt(st[1]), Integer.parseInt(st[2]));
			ver[Integer.parseInt(st[1])-1].addedge(Integer.parseInt(st[0]), Integer.parseInt(st[2]));
			

		}
		
		ischeck.add(0);
		ver[0].isexplore = true;
		
		
		process();
		
		System.out.println(solution);
	}

	public static void process(){
		
		if(ischeck.size() != size){
			
			ArrayList<edge> edg  = new ArrayList<edge>();
			
			for(int i = 0; i < ischeck.size(); i++){
				for(int j = 0; j<size; j++){
					if (ver[(int) ischeck.get(i)].distance[j] != Integer.MAX_VALUE){
						if(ver[j].isexplore == false){
							edg.add(new edge(j,ver[(int) ischeck.get(i)].distance[j]));
						}
					}
				}			
			}
			
			
			int lowscore = Integer.MAX_VALUE;
			int lowedge = 99999;
			
			for(int i = 0; i < edg.size();i++){
				if(lowscore > edg.get(i).cost){
					lowedge = edg.get(i).outedge;
					lowscore = edg.get(i).cost;
				}
			}
			
			ischeck.add(lowedge);
			solution += lowscore;
			System.out.println(ischeck.size());
			ver[lowedge].isexplore = true;
			
			process();
		}
	}
}
