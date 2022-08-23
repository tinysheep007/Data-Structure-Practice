import java.util.*;
public class directed_graph{

    public static void main(String[] args){
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Person> members=new ArrayList<Person>();
        int up=5;
        //load the keys
        for(int i=0;i<=up;i++){
            addOne(members,i);
            map.put(i,i);
        }
        add(members, 0, 1);
        add(members, 0, 3);
        add(members, 1, 4);
        add(members, 2, 0);

        add(members, 3, 4);
        add(members, 4, 2);
        add(members, 4, 5);
        add(members, 5, 2);
        
        print(members);

        boolean[] visited=new boolean[members.size()];
        int[] edgeTo=new boolean[members.size()];
        System.out.println(foo(-1, 0, visited, members, edgeTo));
        
    }


    //functions
    public static void addOne(ArrayList<Person> members, int n1){
        //check if n1 exist if not add in
        boolean in=false;
        for(int i=0;i<members.size();i++){
            if(members.get(i).key==n1){
                in=true;
                break;
            }
        }
        if(in==false){
            Person add=new Person(n1);
            members.add(add);
        }
    }

    public static void print(ArrayList<Person> members){
        for(int i=0;i<members.size();i++){
            System.out.print(members.get(i).key+" -- ");

            for(Friend f=members.get(i).first;f!=null;f=f.next){
                System.out.print(f.key+" -- ");
            }
            System.out.println();
        }
    }

    //add edge from n1 to n2
    public static void add(ArrayList<Person> members, int n1, int n2){
        
        //check if n1 exist if not add in
        boolean in=false;
        for(int i=0;i<members.size();i++){
            if(members.get(i).key==n1){
                in=true;
                break;
            }
        }
        if(in==false){
            Person add=new Person(n1);
            members.add(add);
        }

        //add the edge in
        for(int i=0;i<members.size();i++){
            //null
            if(members.get(i)==null){
                System.out.println("null");
                break;
            }

            if(members.get(i).key==n1){
                //start adding neightbors in
                //create new instance with the new friends
                Friend temp=new Friend(n2, members.get(i).first);
                members.get(i).first=temp;
                break;
            }

        }

        //add the new n2 if doesn't exist in the main array
        boolean exist=true;
        for(int i=0;i<members.size();i++){
            if(members.get(i).key!=n2){
                exist=false;
            }
            else{
                exist=true;
                break;
            }
        }
        //create new Person
        if(exist==false){
            Person addin=new Person(n2);
            members.add(addin);
        }
        

    }

    public static ArrayList<Ineteger> foo(int u, int v, boolean[] visited,ArrayList<Person> members,int[] edgeTo){
        
        visited[v]=true;
        for(Friend w=members[v].first;w!=null;w=w.next){
            if(visited[w.key]==false){
                edgeTo[w]=v;
                return foo(v, w, visited, members, edgeTo);
            }
            else if(w != u){
                ArrayList<Integer> ans=new ArrayList<Integer>();
                ans.add(w);
                for(int x=v;x!=w;x=edgeTo[x] ){
                    ans.add(x);
                }
                ans.add(w);
                return ans;
            }
        }

    }   
}