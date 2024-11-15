// import java.util.*;
public class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int d){  //here node is a constructor
            data = d;
            next = null;
        }
    }
    public static Node head;
    public static void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void countNodes(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }
    
    public static void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public static void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void deleteFirst(){
        head = head.next; 
    }

    public static void deleteLast(){
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next=null;
    }

    public static boolean search(int data){
        Node temp = head;
        while(temp!=null){
            if(temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    public static void addAtGivenPos(int data, int target){
        if(target<0){
            System.out.println("the given target is below 0");
            return;
        }
        if(target == 0 ){
            addFirst(data);
        }
        else{
            int count = 0;
            Node temp = head;
            while(count!=target-1){
                count++;
                temp = temp.next;
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public static void deleteAtGivenPos(int target){
        if(target<0){
            System.out.println("the given target is below 0");
            return;
        }
        if(target == 0 ){
            deleteFirst();
            return;
        }
            int count = 0;
            Node temp = head;
            while(count!=target-1){
                count++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
    }
    
    public static void DeleteKFromLast(int k)
    {
        Node fast = head;
        while(k!=0 && fast.next!=null)
        {
            fast = fast.next;
            k--;
        }
        if(k!=0)
        {
            System.out.println("Can't do because k value should be in btwn o to length of LL");
            return;
        }
        if(fast == null)
        {
            head = head.next;
            return;
        }
        Node slow = head;
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
    }

    public static int MiddleNode(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static boolean HasLoop(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static void RemoveLoop()
    {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        if(slow!=fast) return;
        slow = head;
        if(slow==head)
        {
            prev.next = null;
            return;
        }
        while(slow!=fast)
        {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
    }

    public static void ReverseLL()
    {
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        prev = head;
    }

    public static boolean isPalindrome()
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow;
        Node next;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node temp = head;
        while(temp!=null && prev!=null)
        {
            if(temp.data!=prev.data) return false;
            temp = temp.next;
            prev = prev.next;
        }
        return true;
    }

    public static Node RotateKtimes(int k)
    {
        if(head == null || k==0) return head;
        Node temp = head;
        int count = 0;
        while(temp!=null && temp.next!=null)
        {
            count++;
            temp = temp.next;
        }
        count++;
        if(k % count == 0) return head;
        k = k % count;
        temp.next = head;  //Loop created to starting from last becoz temp will be at last node in previous loop
        Node prev = null;
        for(int i=0;i<count-k+1;i++)
        {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        head = temp;
        return head;
    }

    public static Node rotateRight(Node head,int k)
   {
        if(head == null || k == 0) return head;
        Node temp = head;
        int count = 0;
        while(temp.next!=null)
        {
            count++;
            temp = temp.next;
        }
        count++;
        if(k%count==0) return head;
        k = k % count;
        temp.next = head;
        Node prev = null;
        for(int i=0;i<count-k+1;i++)
        {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        head = temp;
        return head;
   }

    public static Node head2;
    public static int IntersectionOfLL()
    {
        Node temp1 = head;
        Node temp2 = head2;
        int count1 = 0;
        int count2 = 0;
        while(temp1!=temp2)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(temp1!=null)
            {
                if(count1==1) return -1;
                temp1 = head2;
                count1++;
            }
            if(temp2==null)
            {
                if(count2==1) return -1;
                temp2 = head;
                count2++;
            }
        }
        if(temp1 == null || temp2 == null) return -1;
        return temp1.data;
    }

    public static Node EvenOddIndex()
    {
        Node oddHead=new Node (-1);
        Node evenHead=new Node (-1);
        Node even=evenHead;
        Node odd=oddHead;
        Node temp=head;
        int index=0;
        while(temp!=null){
            if(index%2==0){
                even.next=temp;
                even=even.next;
            }
            else{
                odd.next=temp;
                odd=odd.next;
            }
            index++;
            temp=temp.next;
            even.next=oddHead.next;
        }
        odd.next=null;
        return evenHead.next;
    }

    public static Node OnesZerosTwos()
    {
        Node zeroHead=new Node(-1);
        Node oneHead=new Node(-1);
        Node twoHead=new Node(-1);
        Node zero=zeroHead;
        Node one=oneHead;
        Node two=twoHead;
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data==0)
            {
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.data==1)
            {
                one.next=temp;
                one=one.next;
            }
            else if(temp.data==2)
            {
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
            two.next=null;
            if(oneHead.next==null) zero.next=twoHead.next;
            else zero.next=oneHead.next;
            one.next=twoHead.next;
        }
        return zeroHead.next;
    }


    public static void main(String[] args) {
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next=head.next;
        // printLL();
        // addFirst(100);
        // addLast(100);
        // printLL();
        // System.out.println(head.data );

        

    }
}