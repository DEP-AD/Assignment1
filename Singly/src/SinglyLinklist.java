import linklist.Node;

public class SinglyLinklist {

    private Node head=null;
    private int size;

    public void add(int number){

        if(empty()){
            head = new Node(number,null);
        }else{
                Node temp=head;

                while (temp.getNext()!=null){
                    temp=temp.getNext();
                }
                temp.setNext(new Node(number,null));
        }
    }
    //**************************************************************************************
    public void add(int index,int number){
        Node newNode=new Node(number,null);
        Node temp=head;

       if(empty()){
            newNode.setNext(head);
            head=newNode;
            return;
        }

       size=0;
       while (size<index-1){
           temp=temp.getNext();
           size++;
       }
       newNode.setNext(temp.getNext());
       temp.setNext(newNode);
       return;
    }
//*********************************************************************************************
    public void remove(int index){
        Node temp=head;
        if(empty()){
            System.err.println("The list is empty");
            return;
        }
        while (temp!=null && size<index-1){
            temp= temp.getNext();
            size++;
        }
        Node next=temp.getNext().getNext();
        temp.setNext(next);
    }

//***********************************************************************************************
    public int get(int index){
        if(index>size() || index<0){
            throw new RuntimeException("Invalid index");
        }
        Node current =head;
        for (int i = 0; i < index; i++) {
            current= current.getNext();
        }
        return current.getData();
    }
    //********************************************************************************************

    public void print(){
            System.out.print("[");
            Node tempHead=head;

            while (tempHead!=null){
                System.out.print(tempHead.getData() +", ");
                tempHead= tempHead.getNext();
            }

            System.out.println(empty() ? "]" : "\b\b]");
    }

    public void clear(){
        head=null;
        size=0;
    }

    public int size(){
        if(head==null){
            return 0;
        }else {
            int count=0;
            Node tempHead = head;
            while (tempHead!=null){
                count++;
                tempHead= tempHead.getNext();
            }
            return count;
        }

    }

    public boolean contains(int number){
        if(empty()){return false;}

        Node temp;
        for (temp = head; temp != null ; temp= temp.getNext()) {
            if(temp.getData() ==number){
                return true;
            }
        }
        return false;
    }

    public boolean empty(){
        return (head==null);
    }

    public static void main(String[] args) {
        SinglyLinklist sl = new SinglyLinklist();
        sl.add(10);
        sl.add(20);
        sl.add(30);
        sl.add(40);
        sl.add(50);
        sl.print();
        System.out.println("Size of Linked list : "+sl.size());
        sl.add(1,15);
        sl.print();
        sl.add(4,35);
        sl.print();
        sl.remove(4);
        sl.print();
        System.out.println(sl.contains(30));
        System.out.println("Get data using index : "+sl.get(2));
        sl.print();
        System.out.println("Size of Linked list : "+sl.size());
        sl.clear();
        sl.print();
    }

}
