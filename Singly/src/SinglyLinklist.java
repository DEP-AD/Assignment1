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
        Node newNode=new Node(number);

        Node temp=head, prev=head;

        if(index==1){
            newNode.next=head;
            head=newNode;
            return;
        }

        while (temp.next!=null && index>0){
            prev=temp;
            temp=temp.next;

        }

        prev.next=newNode;
        newNode=temp;

    }

    public void remove(int index){
        Node prev=head, temp=head;
        if(empty()){
            System.err.println("The list is empty");
            return;
        }
        while (temp.next!=null && index>0){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
    }

//*******************************************************
    public int get(int index){
        if(index>size() || index<=0){
            throw new RuntimeException("Invalid index");
        }
        Node current =head;
        for (int i = 1; i < index; i++) {
            current=current.next;
        }
        return current.data;
    }
    //****************************************************

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

    public boolean contains(int number){
        if(empty()){return false;}

        Node temp;
        for (temp = head; temp != null ; temp=temp.next) {
            if(temp.data==number){
                return true;
            }
        }
        return false;
    }

    public boolean empty(){
        return head==null;
    }

    public static void main(String[] args) {
        SinglyLinklist sl = new SinglyLinklist();
        sl.add(10);
        sl.add(20);
        sl.add(30);
        sl.add(40);
        sl.add(50);
        sl.print();
        System.out.println(sl.size());
        sl.add(2,15);
        sl.print();
        sl.add(4,35);
        sl.print();
        sl.remove(2);
        sl.print();
        System.out.println(sl.contains(60));
        System.out.println(sl.get(1));
        sl.print();
        System.out.println(sl.size());
        sl.clear();
        sl.print();

    }

}
