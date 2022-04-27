package daa;
import java.util.*;
class project {
	void dijkstra(int[][] bmuMap,int source,HashMap<Integer,String> map)
	{
		int numOfV = bmuMap[0].length;
		int[] distance = new int[numOfV];
		boolean[] visited = new boolean[numOfV];
		for (int i = 0; i < numOfV;i++)
		{
			distance[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		distance[source] = 0;
		int[] path = new int[numOfV];
		path[source] = -1;
		for (int i = 1; i < numOfV; i++)
		{

			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int v = 0;v < numOfV;v++)
			{
				if (!visited[v] && distance[v] < shortestDistance)
				{
					nearestVertex = v;
					shortestDistance = distance[v];
				}
			}

			visited[nearestVertex] = true;

			for (int v = 0;v < numOfV;v++)
			{
				int edgeDistance = bmuMap[nearestVertex][v];
				
				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < distance[v]))
				{
					path[v] = nearestVertex;
					distance[v] = shortestDistance +edgeDistance;
				}
			}
		}

		printSolution(source, distance, path,map);
	}
	private static void printSolution(int source, int[] distances, int[] path,HashMap<Integer,String> map)
	{
		int numOfV = distances.length;
		System.out.print("Vertex\t\tPath");
		
		for (int v = 0;v < numOfV;v++)
		{
			if (v != source)
			{
				System.out.print("\n" + source + " ->\t");
				System.out.print(v + "\t");
				p=0;
				printPath(v, path,map);
			}
		}
	}
	static int p=0;
	static int z=0;
	private static void printPath(int curr,int[] path,HashMap<Integer,String> map)
	{
		if(p==0) {
			z=curr;
			p++;
		}
 		if (curr == -1)
 		{
 			return;
 		}
 		printPath(path[curr], path,map);
 		if(curr==z)
 		{
 			System.out.print(map.get(curr));
 		}
 		else
 		{
 			System.out.print(map.get(curr) + " -> ");
 		}
 		
	}

	public static void main(String[] args)
	{
		int[][] bmuMap = {
				{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2,0,0},
				{0,2,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0,3,0},
				{0,0,0,0,2,0,1,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,0,2,5,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,2,0,1,0,0,0,0,0,0,0,3},
				{0,0,0,0,0,0,0,5,1,0,3,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,3,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,2,0,1,3,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,3,1,0,4,2,0},
				{0,0,2,0,0,0,0,0,0,0,0,0,0,0,4,0,6,0},
				{0,0,0,0,3,0,0,0,0,0,0,0,0,0,2,6,0,7},
				{0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,7,0}
		};
		HashMap<Integer,String> map=new HashMap<>();
		map.put(0,"Gate");
		map.put(1,"Ground");
		map.put(2,"Gateway Building");
		map.put(3,"Dhaba");
		map.put(4,"New Building");
		map.put(5,"Faculty Housing");
		map.put(6,"T2");
		map.put(7,"D Cafe (Mess)");
		map.put(8,"Appt C");
		map.put(9,"Appt B");
		map.put(10,"Appt A");
		map.put(11,"Laundry");
		map.put(12,"Old Tower");
		map.put(13,"Falhar");
		map.put(14,"Workshop");
		map.put(15,"Library/Area 51");
		map.put(16,"Volleyball Court");
		map.put(17,"Pond Area");
		for(int i=0;i<18;i++)
		{
			System.out.println(i+" - "+map.get(i));
		}
		Scanner sc=new Scanner(System.in);		
		System.out.println("Enter your location at the moment:");
		int src=sc.nextInt();
		project obj=new project();
		obj.dijkstra(bmuMap, src,map);
		
	}
}