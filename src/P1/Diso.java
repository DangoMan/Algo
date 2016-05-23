package P1;

import java.io.*;
import java.util.*;;

class Dvertex{
	
	public int distance[] = new int[200];
	public boolean isexplore = false;
	public int greedy_score = Integer.MAX_VALUE;
	int index;

	Dvertex(int index){
		Arrays.fill(distance, Integer.MAX_VALUE);
		this.index = index;
	}

	void addedge(int vertex, int dis){
		distance[vertex] = dis;
	} 
}

class Dedge{
	int endedge;
	int greety_score;
	
	Dedge(int ee, int gs){
		endedge = ee;
		greety_score =gs;
	}
}


public class Diso {
	public static Dvertex ver[] = new Dvertex[200];
	public static ArrayList ischeck = new ArrayList<Integer>();
	
	public static void process(){
		
		if(ischeck.size() != 200){
			
			ArrayList<Dedge> edg  = new ArrayList<Dedge>();
			
			for(int i = 0; i < ischeck.size(); i++){
				for(int j = 0; j<200; j++){
					if (ver[(int) ischeck.get(i)].distance[j] != Integer.MAX_VALUE){
						if(ver[j].isexplore == false){
							edg.add(new Dedge(j, ver[(int) ischeck.get(i)].distance[j]+ ver[(int) ischeck.get(i)].greedy_score));
						}
					}
				}			
			}
			
			
			int lowscore = Integer.MAX_VALUE;
			int lowedge = 99999;
			
			for(int i = 0; i < edg.size();i++){
				if(lowscore > edg.get(i).greety_score){
					lowedge = edg.get(i).endedge;
					lowscore = edg.get(i).greety_score;
				}
			}
			
			ischeck.add(lowedge);
			ver[lowedge].greedy_score = lowscore;
			ver[lowedge].isexplore = true;
			
			process();
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("src/dijkstraData.txt"));
		
		//init the ver 
		for (int i = 0; i < ver.length; i++){
			ver[i] = new Dvertex(i);
		}
		
		String read;
		
		//input size
		while((read = br.readLine()) != null){
			Scanner sc = new Scanner(read);
			
			//the vertex that is referring to
			int start = sc.nextInt()-1;
			
			while(sc.hasNext()){
				int connect = sc.nextInt() - 1;
				int distance = sc.nextInt();
				
				//System.out.println(connect + " " + distance);
				
				ver[start].addedge(connect, distance);
			}
		}
		
		ischeck.add(0);
		ver[0].greedy_score = 0;
		ver[0].isexplore = true;
		
		process();
		
		System.out.println(ver[6].greedy_score);
		System.out.println(ver[36].greedy_score);
		System.out.println(ver[58].greedy_score);
		System.out.println(ver[81].greedy_score);
		System.out.println(ver[98].greedy_score);
		System.out.println(ver[114].greedy_score);
		System.out.println(ver[132].greedy_score);
		System.out.println(ver[164].greedy_score);
		System.out.println(ver[187].greedy_score);
		System.out.println(ver[196].greedy_score);
	}
}

