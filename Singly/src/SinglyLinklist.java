import linklist.Node;

public class SinglyLinklist {
    private Node head=null;

    public void add(int number){
        Node newNode=new Node(number);

        if(head==null){
            head=newNode;
        }else {
            newNode.next=head;
            head=newNode;
        }

    }

    public void add(int index,int number){


    }

    public void remove(int index){

    }

    public int get(int index){
        return 0;
    }

    public void print(){

            System.out.print("[");
            Node tempHead=head;
            while (tempHead!=null){
                System.out.print(tempHead.data+", ");
                tempHead=tempHead.next;
            }
            System.out.println(empty() ? "List is Empty]" : "\b\b]");

    }

    public void clear(){
        head=null;
    }

    public int size(){
        if(head==null){
            return 0;
        }else {
            int count=0;
            Node tempHead = head;
            while (tempHead!=null){
                count++;
                tempHead= tempHead.next;
            }
            return count;
        }

    }

    public boolean contains(int index){
        return false;
    }

    public boolean empty(){
        return head==null;
    }

    public static void main(String[] args) {
        SinglyLinklist sl = new SinglyLinklist();
        sl.add(10);
        sl.add(20);
        sl.print();
        System.out.println(sl.size());

    }

}
