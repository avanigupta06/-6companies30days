import java.util.*;

/*
delete n nodes after m nodes
The input list will have at least one element
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/
class Solution {
    static void linkdelete(Node head, int n, int m) {
        Node temp = head, t; 
        int count = 0;       
        while (temp != null) 
        {
            for (count = 1; count < m && temp != null; count++) 
                temp = temp.next; 

            if (temp == null) 
                return;
            t = temp.next; 
            for (count = 1; count <= n && t != null; count++)
            {

                t = t.next; 
            }
            temp.next = t; 
            temp = t;      
        }
    }
}
//Time Complexity: O(size) 
//Space Complexity: O(1)