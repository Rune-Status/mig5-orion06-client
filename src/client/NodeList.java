package client;


final class NodeList {

   private final Node head = new Node();
   private Node current;


   public NodeList() {
      this.head.prev = this.head;
      this.head.next = this.head;
   }

   public void insertHead(Node node) {
      if(node.next != null) {
         node.unlink();
      }

      node.next = this.head.next;
      node.prev = this.head;
      node.next.prev = node;
      node.prev.next = node;
   }

   public void insertTail(Node node) {
      if(node.next != null) {
         node.unlink();
      }

      node.next = this.head;
      node.prev = this.head.prev;
      node.next.prev = node;
      node.prev.next = node;
   }

   public Node popHead() {
      Node node = this.head.prev;
      if(node == this.head) {
         return null;
      } else {
         node.unlink();
         return node;
      }
   }

   public Node reverseGetFirst() {
      Node node = this.head.prev;
      if(node == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = node.prev;
         return node;
      }
   }

   public Node getFirst() {
      Node node = this.head.next;
      if(node == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = node.next;
         return node;
      }
   }

   public Node reverseGetNext() {
      Node node = this.current;
      if(node == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = node.prev;
         return node;
      }
   }

   public Node getNext() {
      Node node = this.current;
      if(node == this.head) {
         this.current = null;
         return null;
      } else {
         this.current = node.next;
         return node;
      }
   }

   public void removeAll() {
      if(this.head.prev != this.head) {
         while(true) {
            Node node = this.head.prev;
            if(node == this.head) {
               return;
            }

            node.unlink();
         }
      }
   }
}
