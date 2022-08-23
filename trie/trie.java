public class trie{

    //pre-req classes
    class node{
        node[] child=new node[26];
        boolean isVal;
        node(){
            this.isVal=false;
            for(int i=0;i<child.length;i++){
                child[i]=null;
            }
        }
    }

    //instance variables
    node root;
    public trie(){
        this.root=new node();
    }

    public void insert(String word){
        node temp=root;
        for(int i=0;i<word.length();++i){
            
            if(temp.child[word.charAt(i)-'a']==null){
                temp.child[word.charAt(i)-'a']=new node();
            }
            temp=temp.child[word.charAt(i)-'a'];
        }
        temp.isVal=true;

    }

    public boolean search(String word){
        node temp=root;
        boolean ans=false;
        for(int i=0;i<word.length();++i){
            if(temp==null){
                break;
            }
            temp=temp.child[word.charAt(i)-'a'];
        }
        if(temp==null){
            return ans;
        }
        if(temp.isVal==true){
            ans=true;
        }
        return ans;
    }

    public boolean startWith(String prefix){
        node temp=root;
        boolean ans=false;
        for(int i=0;i<prefix.length();++i){
            if(temp==null){
                return ans;
            }
            temp=temp.child[prefix.charAt(i)-'a'];
        }
        if(temp!=null){
            ans=true;
        }
        return ans;

    }

    public static void main(String[] args){ 
        trie trie=new trie();
        trie.insert("apple");
        trie.insert("pear");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("par"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startWith("pe"));
        System.out.println(trie.startWith("a"));
        
    }
}