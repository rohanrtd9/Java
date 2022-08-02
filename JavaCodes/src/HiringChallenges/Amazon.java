package HiringChallenges;

import java.io.*;
import java.util.*;


public class Amazon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer> > adj= new ArrayList<ArrayList<Integer> >(N+1);
            for (int i = 0; i <= N; i++)
                adj.add(new ArrayList<Integer>());
            String[] edges = new String[N-1];
            int m=0,n=0;
            for(int i_edges = 0; i_edges < N-1; i_edges++)
            {
            	
                String[] s=br.readLine().split(" ");
                m=Integer.parseInt(s[0]);
                n=Integer.parseInt(s[1]);
                addEdge(adj, m, n);
                edges[i_edges]=(m)+" "+(n);
            	
            }

            int out_ = solve(N, edges,adj);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static int solve(int N, String[] edges,ArrayList<ArrayList<Integer> > adj){
       // Write your code here
        int result = Integer.MAX_VALUE;
        String s[],s1[];
        Integer m=0,n=0,m1=0,n1=0,min=0,max=0;
        int x1=0,x2=0,x3=0;
        
        for (int i=0; i<(edges.length-1) ; i++)
        {
            int visited[]=new int[N+1];
            //remove from adjaceny current edge
            s=edges[i].split(" ");
            m=Integer.parseInt(s[0]);
            n=Integer.parseInt(s[1]);
            adj.get(m).remove(n);
            adj.get(n).remove(m);
            //System.out.print("\ncut 1: "+m+" "+n);
            for(int j=i+1;j<edges.length;j++)
            {
            	visited=new int[N+1];
                s1=edges[j].split(" ");
                m1=Integer.parseInt(s1[0]);
                n1=Integer.parseInt(s1[1]);
                adj.get(m1).remove(n1);
                adj.get(n1).remove(m1);
                //now we take three xor variables
                x1=0;x2=0;x3=0;
                //System.out.println("\n cut 2: "+m1+" "+n1);
                LinkedList<Integer> nodesToVist=new LinkedList<>();
                nodesToVist.add(m);
                //System.out.print(" Component 1: ");
                while(!nodesToVist.isEmpty())
                {

                    int t=(int)nodesToVist.pop();
                    
                    if(visited[t]==1)
                        continue;
                    visited[t]=1;
                    //System.out.print(" "+t);
                    x1=x1^(t);
                    for (Integer ii : adj.get(t))
                    {
                        if(visited[ii]==0)
                        	nodesToVist.add(ii);
                    }
                    
                }
                nodesToVist.add(n);
                //System.out.print(" Component 2: ");
                while(!nodesToVist.isEmpty())
                {

                    int t=nodesToVist.pop();
                    
                    if(visited[t]==1)
                        continue;
                    visited[t]=1;
                   // System.out.print(" "+t);
                    x2=x2^(t);
                    for (Integer ii : adj.get(t))
                    {
                        if(visited[i]==0)
                        	nodesToVist.add(ii);
                    }
                    
                }
                if(visited[m1]==1)
                	nodesToVist.add(n1);
                else
                	nodesToVist.add(m1);
                //System.out.print(" Component 3:");
                while(!nodesToVist.isEmpty())
                {

                    int t=nodesToVist.pop();
                   
                    if(visited[t]==1)
                        continue;
                    visited[t]=1;
                    //System.out.print(" "+t);
                    x3=x3^(t);
                    for (Integer ii : adj.get(t))
                    {
                        if(visited[ii]==0)
                        	nodesToVist.add(ii);
                    }
                   
                }
                
                adj.get(m1).add(n1);
                adj.get(n1).add(m1);
                if(x1>=x2)
                    if(x1>=x3)
                        max=x1;
                    else
                        max=x3;
                else
                    if(x2>=x3)
                        max=x2;
                    else
                        max=x3;
                if(x1<=x2)
                    if(x1<=x3)
                        min=x1;
                    else
                        min=x3;
                else
                    if(x2<=x3)
                        min=x2;
                    else
                        min=x3;
                result=Math.min((max-min),result);
               
            }
            adj.get(m).add(n);
            adj.get(n).add(m);
            
            
        }

        return result;
    
    }
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
			int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
		
		
	}
}