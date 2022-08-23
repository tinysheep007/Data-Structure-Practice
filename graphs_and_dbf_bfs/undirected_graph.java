import java.util.*;


class Friend {
	int key;
	Friend next;
	Friend(int key, Friend next) {
		this.key = key;
		this.next = next;
	}
}

class Person {
    String name;
	int key;
	Friend first;
    Person(int key){
        this.key=key;
    }
}

public class undirected_graph {
    
    public static void main(String[] args){
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Person> members=new ArrayList<Person>();
        int up=6;
        //load the keys
        for(int i=0;i<=up;i++){
            addOne(members,i);
            map.put(i,i);
        }
    
        add(members, 0, 1);
        add(members, 1, 2);
        add(members, 1, 3);
        add(members, 2, 3);
        add(members, 3, 4);
        add(members, 3, 5);
        add(members, 3, 6);
        add(members, 5, 6);
        
        

        print(members);
        ArrayList<Integer> ok=shortestPathBFS(members, 2, 6);
        System.out.println("the shortest path is "+ok);

        shortestpathV1(members, 0, 6);

        // ArrayList<Integer> bfs=bfs(members);
        // System.out.println("bfs is "+bfs);
        
        // ArrayList<Integer> dfs=dfs(members, map);
        // System.out.println("dfs is "+dfs);

        // int[] topo=topologicalSort(members);
        // System.out.println("topo sort: ");
        // for(int i=0;i<topo.length;i++){
        //     System.out.print(topo[i]+" ");
        // }
        
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
        boolean exist=false;
        for(int i=0;i<members.size();i++){
            if(members.get(i).key!=n2){
                exist=false;
            }else{
                //if n2 exist
                //add n1 as friend
                exist=true;
                Friend n2add=new Friend(n1,members.get(i).first);
                members.get(i).first=n2add;
                break;
            }

        }
        //create new Person
        if(exist==false){
            Person addin=new Person(n2);
            addin.first=new Friend(n1,null);
            members.add(addin);
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

    public static ArrayList<Integer> shortestPathBFS(ArrayList<Person> members, int key1, int key2){
        //make queue to store 
        Queue<Integer> q=new LinkedList<>();
        Queue<Queue<Integer>> path=new LinkedList<>();
        Queue<Integer> temp=new LinkedList<>();
        //ans
        ArrayList<Integer> ans=new ArrayList<>();
        //visited array
        boolean[] visited=new boolean[members.size()];
    
        //prepartion
        //began enqueue
        q.add(key1);
        visited[key1]=true;
        temp.add(key1);
        path.add(temp);
        while(q.isEmpty()==false){
            Queue<Integer> q2=path.remove();
            
            for(Friend f=members.get(q.remove()).first;f!=null;f=f.next){
                //if unvisited
                if(visited[f.key]==false){
                    visited[f.key]=true;
                    temp=new LinkedList<>();
                    //transfer the current path to temp
                    for(int i=q2.size();i>0;i--){
                        int a=q2.remove();
                        temp.add(a);
                        q2.add(a);
                    }
                    q.add(f.key);
                    temp.add(f.key);
                    path.add(temp);
                    if(f.key==key2){
                        while(temp.isEmpty()==false){
                            ans.add(temp.remove());
                        }
                        return ans;
                    }
                }
            }
        }
        
        return ans;

    }

    public static void shortestpathV1(ArrayList<Person> members,int key1, int key2){
        Queue<Integer> q=new LinkedList<>();
        //Ex: edgeTo[1]=2 means from 2(upper level), you can go access 1(lower level)
        int[] edgeTo=new int[members.size()];
        for(int i=0;i<edgeTo.length;i++){
            edgeTo[i]=-5;
        }
        boolean[] visited=new boolean[members.size()];
        edgeTo[members.get(key1).key]=members.get(key1).key;
        visited[members.get(key1).key]=true;
        q.add(members.get(key1).key);
        while(q.isEmpty()==false){
            int person=q.remove();
            for(Friend f=members.get(person).first;f!=null;f=f.next){
                if(visited[f.key]!=true){
                    visited[f.key]=true;
                    q.add(f.key);
                    //correct
                    edgeTo[f.key]=person;
                    if(f.key==key2){

                        for(int i=f.key;i!=-5;i=edgeTo[i]){
                            if(i!=key1){
                                System.out.print(i+" <- ");
                            }
                            else{
                                System.out.print(i);
                                break;
                            }
                            
                            
                        }

                        //function ends
                        return;
                    }
                }
            }
        }
        System.out.println("no such route");
        return;

    }

    public static ArrayList<Integer> bfs(ArrayList<Person> members){
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        boolean[] visited=new boolean[members.size()];
        //enqueue first item

        q.add(members.get(0).key);
        ans.add(members.get(0).key);
        visited[members.get(0).key]=true;

        //driver
        for(int i=0;i<members.size();i++){
            if(visited[i]==false){
                visited[i]=true;
                q.add(i);
                ans.add(i);
                //until nothing in queue
                while(q.isEmpty()==false){
                    for(Friend f=members.get(q.remove()).first;f!=null;f=f.next){
                        if(visited[f.key]==false){
                            visited[f.key]=true;
                            ans.add(f.key);
                            q.add(f.key);
                        }
                    }
                }

            }
        }

        

        return ans;
    }

    public static ArrayList<Integer> dfs(ArrayList<Person> members,HashMap<Integer,Integer> map){
        boolean[] visited=new boolean[members.size()];
        ArrayList<Integer> ans=new ArrayList<>();
        visited[members.get(0).key]=true;
        ans.add(members.get(0).key);

        for(int i=1;i<members.size();i++){
            if(visited[members.get(i).key]==false){
                
                visited[members.get(i).key]=true;
                ans.add(members.get(i).key);
               dfsRecursive(members, visited, members.get(i).key,ans);
            }
        }
        return ans;
    }

    private static void dfsRecursive(ArrayList<Person> members,boolean[] visited, int key,ArrayList<Integer> ans){
        visited[key]=true;
        for(Friend f=members.get(key).first;f!=null;f=f.next){
            //System.out.println("hit");
            if(visited[f.key]==false){
                ans.add(f.key);
                dfsRecursive(members, visited, f.key, ans);
            }
        }
    }

    public static int[] topologicalSort(ArrayList<Person> members){
        boolean[] visited=new boolean[members.size()];
        int[] topo=new int[members.size()];
        int num=members.size()-1;
        for(int i=0;i<members.size();i++){
            if(visited[i]==false){
                num=topoDFS(i,visited,num,topo,members);
            }
        }
        return topo;
    }

    private static int topoDFS(int v, boolean[] visited, int num, int[] topo,ArrayList<Person> members){
        visited[v]=true;
        for(Friend f=members.get(v).first;f!=null;f=f.next){
            if(visited[f.key]==false){
                num=topoDFS(f.key, visited, num, topo, members);
            }
        }
        //System.out.println("v: "+v+" num: "+num);
        topo[num]=v;
        return num-1;
    }

}