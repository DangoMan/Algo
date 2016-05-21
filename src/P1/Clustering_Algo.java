package P1;
import java.io.*;
import java.util.*;
/*
 * Note to self, make a Node template
 */
class CNode{
	public int distance[];
	int max; 
	int index;
	int parent;
	

	CNode(int index, int max){
		distance = new int[max];
		this.max = max;
		Arrays.fill(distance, Integer.MAX_VALUE);
		this.index = index;
		parent = index;
		
	}
	
	static int getparent(int index, CNode[] node){
		
		if(node[index].parent == index){
			return index;
		}
		
		else{
			return getparent(node[index].parent,node);
		}
	}

	void addedge(int vertex, int dis){
		distance[vertex] = dis;
	}
}


class CEdge{
	int node1;
	int node2;
	int cost; 
	
	CEdge(int node1, int node2, int cost){
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
}



 class Clustering_Algo {
	public static CNode[] node;
	public static CEdge[] edge = new CEdge[2000000];
	
	public static void swap(int a, int b){
		CEdge temp = edge[a];
		edge[a] = edge[b];
		edge[b] = temp;
	}
	
	public static void QS(int up, int low){

		if(low-up >= 1){
			
			//System.out.println();


			//reset variable
			int pivot = up;
			int i = up+1;

			swap(up,pivot);

			//the run through loop
			for (int j = i; j < low; j++){
				if(edge[j].cost < edge[up].cost){
					swap(i,j);
					i++;

					//System.out.println("s");
				}
			}

			swap(i-1,up);

			QS(up,i-1);
			QS(i,low);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader ("src/clustering1.txt"));
		int size;
		int edges = 0; 
		
		size = Integer.parseInt(br.readLine());
		node = new CNode[size];
		
		
		String read;
		for(int i = 0; i<size;i++){
			node[i] = new CNode(i,size);
		}
		
		while((read = br.readLine()) != null){
			String st[] = read.split(" ");
			edge[edges] = new CEdge(Integer.parseInt(st[0])-1, Integer.parseInt(st[1])-1,Integer.parseInt(st[2]));
			edges++;
		}
		
		
		QS(0,edges);
		//System.out.println(edge[0].cost + " "  + edge[0].node1 + " " + edge[0].node2);
		
		int counter = 0;
		
		while (size != 4){
			CEdge edg = edge[counter];
			
			if(CNode.getparent(edg.node1,node) != CNode.getparent(edg.node2,node)){
				
				node[CNode.getparent(edg.node2,node)].parent = CNode.getparent(edg.node1, node);
				//System.out.println(edg.cost);
				//System.out.println(CNode.getparent(edg.node1,node) + " " +  CNode.getparent(edg.node2, node));
				
				//System.out.println(size);
				
				int solution[] = new int[500];
				
				for(int i = 0; i < node.length; i ++){
					solution[CNode.getparent(i, node)]++;
				}
				
				for(int i = 0; i < node.length; i ++){
					if (solution[i] != 0){
						System.out.println(solution[i]);
					}
				}
				
				System.out.println();
				
				size --;
			}
			
			else{
				//System.out.println(edg.cost);
				//System.out.println(CNode.getparent(edg.node1,node) + " " + CNode.getparent(edg.node2,node));
			}
			
			//System.out.println(edg.cost);
			
			counter++;
		}
		
		
		while (size != 3){
			CEdge edg = edge[counter];
			
			if(CNode.getparent(edg.node1,node) != CNode.getparent(edg.node2,node)){
				
				//node[CNode.getparent(edg.node2,node)].parent = CNode.getparent(edg.node1, node);
				System.out.println(edg.cost);
				//System.out.println(CNode.getparent(edg.node1,node) + " " +  CNode.getparent(edg.node2, node));
				
				//System.out.println(size);
				
				System.out.println();
				
				size --;
			}
			
			else{
				//System.out.println(edg.cost);
				//System.out.println(CNode.getparent(edg.node1,node) + " " + CNode.getparent(edg.node2,node));
			}
			
			//System.out.println(edg.cost);
			
			counter++;
		}
		
		

		/*
		for(int i = 0; i < node.length; i ++){
			System.out.println(CNode.getparent(i, node));
		}
		*/
		
	}
}
