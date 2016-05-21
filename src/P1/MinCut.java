package P1;
/*
import java.io.*;
import java.util.*;

class edge{
	
	//the two vertex connect to the edges
	public int n1;
	public int n2;
	
	boolean ismer = false;
	
	edge(int n1, int n2){
		this.n1 = n1;
		this.n2 = n2;
	}
	
	
	
}

class vertex{
	
	public int [] hasedges = new int[200];
	
	vertex(){
		
		for(int i = 0; i < hasedges.length;i++){
			hasedges[i] = 0;
		}
		
	}
	
	public static void adde(int startpoint, int endpoint, vertex n[]){
		
		//denote that they are connected
		n[startpoint-1].hasedges[endpoint-1] ++;
		n[endpoint-1].hasedges[startpoint-1] ++;
	}
	
	public void merge(int startpoint, int endpoint, vertex n[]){
		
	}
	
	
	
}

public  class MinCut {
	
	public static vertex[] n = new vertex[200];
	public static edge[] m = new edge[3000];
	public static Random r = new Random();
	
	public static int mincut(vertex n[], edge[] m, int counter){
		
		//base case when there is two element left
		if(n.length == 2){
			return counter + 1;
		}
		else{
			int m_num = r.nextInt(counter);
			
			
			
			
		}
	}
	
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("src/kargerMinCut.txt"));
		
		//keep track of # of edge
		int counter = 0;
		
		for(int i = 0 ;i<n.length;i++){
			n[i] = new vertex();
		}

		String read;
		while((read = br.readLine()) != null){
			Scanner sc = new Scanner(read);
			int start = sc.nextInt();
			
			while(sc.hasNext()){
				int end = sc.nextInt();
				//ensure no parallel edge 
				if (start < end){
					//add an edge
					m[counter] = new edge(start,end);
					
					//System.out.println(start);
					
					//add an vertex into the main list
					vertex.adde(start,end,n);
					
					counter++;
				}
			}
		}
		
		System.out.println(counter);
	
		
		
		
	}
}
*/