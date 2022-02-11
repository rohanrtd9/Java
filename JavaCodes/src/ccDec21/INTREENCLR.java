package ccDec21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class INTREENCLR {
	//SOLUTION BEGIN
    void pre() throws Exception{}
    void solve(int TC) throws Exception{
        int N = ni(), Q = ni();
        int[] from = new int[N-1], to = new int[N-1];
        for(int i = 0; i< N-1; i++){
            from[i] = ni()-1;
            to[i] = ni()-1;
        }
        int[][] tree = tree(N, from, to);
        boolean[] same = new boolean[N];
        //same[i] denotes whether node i has same color as its parent or not
        query(0);
        dfs(tree, same, 0, -1);
        
        int[] col = new int[N];
        color(tree, col, same, 0, -1);
        int[] cnt = new int[2];
        for(int i = 0; i< N; i++)cnt[col[i]]++;
        int flip = cnt[0] < cnt[1]?0:1;
        for(int i = 0; i< N; i++)if(col[i] == flip)query(i);
        pni(0);
        hold(ni() == 1);
    }
    void color(int[][] tree, int[] col, boolean[] same, int u, int p){
        for(int v:tree[u]){
            if(v == p)continue;
            col[v] = same[v]?col[u]:(1-col[u]);
            color(tree, col, same, v, u);
        }
    }
    long prevQuery = -1, curQuery = -1;
    void dfs(int[][] tree, boolean[] sameColor, int u, int p) throws Exception{
        for(int v:tree[u])if(v != p)dfs(tree, sameColor, v, u);
        if(p == -1)return;
        query(u);
        int same = 0, diff = 0;
        for(int v:tree[u]){
            if(v == p)continue;
            sameColor[v] = !sameColor[v]; 
            // Since after query on u, color of u is flipped
            if(sameColor[v])same++;
            else diff++;
        }
        
        long w = (curQuery - prevQuery + same - diff +1)/2;
        sameColor[u] = w == 0;
    }
    void query(int u) throws Exception{
        pni(1+u);
        prevQuery = curQuery;
        curQuery = nl();
        hold(curQuery != -1);
    }
    //creates adjacency list representation using jagged arrays in java, faster than array of lists
    int[][] tree(int N, int[] from, int[] to){
        int[][] g = new int[N][];
        int[] c = new int[N];
        for(int x:from)c[x]++;
        for(int x:to)c[x]++;
        for(int i = 0; i< N; i++)g[i] = new int[c[i]];
        for(int i = 0; i< N-1; i++){
            g[from[i]][--c[from[i]]] = to[i];
            g[to[i]][--c[to[i]]] = from[i];
        }
        return g;
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    static boolean multipleTC = true;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        //Solution Credits: Taranpreet Singh
        int T = (multipleTC)?ni():1;
        pre();for(int t = 1; t<= T; t++)solve(t);
        out.flush();
        out.close();
    }
    public static void main(String[] args) throws Exception{
        new INTREENCLR().run();
    }
    int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}
    String n()throws Exception{return in.next();}
    String nln()throws Exception{return in.nextLine();}
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}

    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception{
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception{
            String str = "";
            try{   
                str = br.readLine();
            }catch (IOException e){
                throw new Exception(e.toString());
            }  
            return str;
        }
    }
}