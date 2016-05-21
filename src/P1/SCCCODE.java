package P1;

import java.io.*;
import java.util.*;
/*
class vertex{

	ArrayList<String> c_list = new ArrayList<String>();
	public boolean isexplore = false;
	public int index = 999999;

	vertex(){

	}

	void addedge(String str){
		c_list.add(str);
	}



}


public class SCCCODE {

	static vertex reverse[] = new vertex[875714];
	static vertex forward[] = new vertex[875714];
	static int order[] = new int[875714];
	static int counter = 0;

	static void DFSRev(int edgenum){

		reverse[edgenum].isexplore = true;

		for(int i = 0; i < reverse[edgenum].c_list.size();i++){

			if(reverse[Integer.parseInt(reverse[edgenum].c_list.get(i))].isexplore == false){
				//System.out.println(edgenum);
					DFSRev( Integer.parseInt(reverse[edgenum].c_list.get(i)));
				
			}

		}

		reverse[edgenum].index = counter;
		counter++;
	}


	
	static int DFSFor(int edgenum,int currentedge){

		forward[edgenum].isexplore = true;


		for(int i = 0; i < forward[edgenum].c_list.size();i++){
			if(forward[Integer.parseInt(forward[edgenum].c_list.get(i))].isexplore == false){
				//System.out.println(edgenum);
				currentedge = DFSFor(Integer.parseInt(forward[edgenum].c_list.get(i)),currentedge);
				
			}
		}

		currentedge++;
		return currentedge;
	}

	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/SCC.txt"));

		//init the reverse array
		for(int i = 0; i<reverse.length; i++){
			reverse[i] = new vertex();
		}

		String str;

		//loading the info into the array
		while((str = br.readLine()) != null){
			String st[] = str.split(" ");

			if(Integer.parseInt(st[0]) > 875714 ||Integer.parseInt(st[0]) > 875714){
				System.out.println(st[0] + " "+ st[1]);
			}

			reverse[Integer.parseInt(st[1])-1].addedge(Integer.toString(Integer.parseInt(st[0])-1));
		}



		for(int i =reverse.length-1; i>0;i--){
			if(reverse[i].isexplore == false){
				DFSRev(i);
				//System.out.println("Hello");
			}
		}


		//System.out.println(counter);

		for(int i = 0; i<reverse.length;i++){
			order[reverse[i].index] = i;
		}

		//System.out.println(counter);
		
		//init the forward array 
		for(int i = 0; i<forward.length; i++){
			forward[i] = new vertex();
		}

		br = new BufferedReader(new FileReader("src/SCC.txt"));

		//loading the info into the forward array
		while((str = br.readLine()) != null){
			String st[] = str.split(" ");
			forward[Integer.parseInt(st[0])-1].addedge(Integer.toString(Integer.parseInt(st[1])-1));
		}

		ArrayList result = new ArrayList<Integer>();

		for(int i = forward.length-1; i>=0;i--){
			if(forward[order[i]].isexplore == false){
				 result.add(DFSFor(order[i], 0));
				 //System.out.println("Hello");
			}
		}

		int acc = 0;



		for(int i = 0; i<result.size();i++){ 
			acc += (int) result.get(i);
			if((int)result.get(i)>200){
				System.out.println(result.get(i));
			}
		}

		//System.out.println(acc);

		 
	}

}
*/
