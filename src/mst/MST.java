/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mst;

import java.util.ArrayList;
import java.util.Scanner;

public class MST {
	public static ArrayList<String>  Vertices = new ArrayList<>();
	public static ArrayList<String>  Source_Vertix = new ArrayList<>();
	public static ArrayList<String>  Destination_Vertix = new ArrayList<>();
	public static ArrayList<Integer> weights = new ArrayList<>();
        
	public static ArrayList<String> visited = new ArrayList<>();
	public static ArrayList<String> Output_Source_Vertix = new ArrayList<>();
	public static ArrayList<String> Output_Destination_Vertix = new ArrayList<>();
	public static ArrayList<Integer> Output_Weights = new ArrayList<>();
	
        // Loop to get minimum egde
	public static void getMinimumWeight() 
	{
		int minVal = Integer.MAX_VALUE  , minIndex = 0 ;
		for( int i = 0 ; i < Source_Vertix.size(); i++ )
		{
                    if ( visited.contains(Source_Vertix.get(i)) && !(visited.contains(Destination_Vertix.get(i))) )
			{
				if(weights.get(i) < minVal )
				{
					minVal = weights.get(i);
					minIndex = i;
				}
			}
		}
		visited.add(Destination_Vertix.get(minIndex));
		Output_Source_Vertix.add(Source_Vertix.get(minIndex));
		Output_Destination_Vertix.add(Destination_Vertix.get(minIndex));
		Output_Weights.add(weights.get(minIndex));
		Source_Vertix.remove(minIndex);
		Destination_Vertix.remove(minIndex);
		weights.remove(minIndex);
		
	}
        
        // ensure that tree span  all vertix
	public static void MST()
	{

		int minWeight ;
		visited.add(Vertices.get(0));
		while(visited.size() < Vertices.size())
		{
                    getMinimumWeight();
		}
		printMST();
	}
	
        // To Print Output
	public static void printMST() {
            
                System.out.println();
                System.out.println(" Minimum Spanning Tree Output is : ");
                System.out.println("=======================");
		for ( int i = 0 ; i < Output_Source_Vertix.size() ; i++ )
		{
                System.out.println("Source_Vertix: "+Output_Source_Vertix.get(i)+" ---> Destination_Vertix: "+Output_Destination_Vertix.get(i)+ "    Weight is: ("+Output_Weights.get(i)+")");
		}
                System.out.println();
                
                int Output_Weight =0;
                for(int i=0; i<Output_Weights.size();i++)
                    Output_Weight+=Output_Weights.get(i);
                
                System.out.println("MST Weight is : "+Output_Weight);
	}
	
	


	/////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Destination_VertixDO AuDestination_Vertix-generated method stub
		int numberOfNodes;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Number of Nodes: ");
		numberOfNodes = sc.nextInt();
                
		System.out.println("Please Enter Nodes' Name one by one: ");
		for(int i = 0 ; i < numberOfNodes ; i++)
		{
			System.out.println("Enter Node "+(i+1)+" Name : ");
                        String Vertex_Name = sc.next();
			Vertices.add(Vertex_Name);
		}
                
		int numberOfNeighbors;
		for(int i = 0 ; i < numberOfNodes ; i++)
		{
                    String Source = Vertices.get(i);
			System.out.println("Please Enter Node "+ Source +"'s Number Of Neighbors");
			numberOfNeighbors = sc.nextInt();
			for(int j = 0 ; j < numberOfNeighbors ; j++)
			{
				Source_Vertix.add(Source);
				System.out.println("Please Enter Neighbor Vertix Name : ");
                                String Destination = sc.next();
				Destination_Vertix.add(Destination);
				System.out.println("Please Enter Weight of Edge "+Source+"-"+Destination+" : ");
                                int edge_weight =sc.nextInt();
				weights.add(edge_weight);
			}
		}
                
                System.out.println(" Original Graph is : ");
                System.out.println("=======================");
		for(int i = 0 ; i < Source_Vertix.size() ; i++)
		{
			System.out.println("Source_Vertix Node "+Source_Vertix.get(i)+"  ---> "
                                + " Destination_Vertix Node "+Destination_Vertix.get(i)+"   Weight is ("+weights.get(i)+")");
		}
		System.out.println();
                
		MST();		

	}

}
