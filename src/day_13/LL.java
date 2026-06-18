package day_13;

    public class LL {
        private int size = 0;
       public node head;
        private node tail;

        public void addFirst(int value) {
            node newnode = new node(value);
            if (head == null) {
                head = newnode;
                tail = newnode;
                size++;
                return;
            }
            newnode.next = head;
            head = newnode;
            size++;
        }

        public void addLast(int value) {
            node newnode = new node(value);
            size++;
            if (head == null) {
                head = newnode;
                tail = newnode;
                return;
            }
            tail.next = newnode;
            tail = newnode;
        }

        public void deleteFirst() {
            if (head == null) {
                System.out.println("list is empty");
                return;
            }
            if (head.next == null) {
                head = null;
                tail = null;
                size--;
                return;
            }
            size--;
            head = head.next;

        }

        public void deleteLast() {
            if (head == null) {
                System.out.println("list is empty");
                return;
            }
            size--;
            if (head.next == null) {
                head = null;
                tail = null;
                return;
            }
            node currNode = head;
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            currNode.next = null;
            tail = currNode;
        }

        public void printList() {
            if (head == null) {
                System.out.println("list is empty");
                return;
            }
            node currNode = head;
            while (currNode != null) {
                System.out.print(currNode.data + " -> ");
                currNode = currNode.next;
            }
            System.out.println("null");
        }

        public int getSize() {
            return size;
        }

        public boolean search(int data) {
            if (head == null) {
                return false;
            }
            node currNode = head;
            while (currNode != null) {
                if (currNode.data == data) {
                    return true;
                }
                currNode = currNode.next;
            }
            return false;
        }

        public int searchIndex(int data) {
            if (head == null) {
                return -1;
            }
            int index = -1;
            node currNode = head;
            while (currNode != null) {
                index++;
                if (currNode.data == data) {
                    return index;
                }
                currNode = currNode.next;
            }
            return -1;
        }

        public void insertAtIndex(int data, int index) {
            node newNode = new node(data);
            if (head == null) {
                System.out.println("list is empty");
                return;
            }
            if (index > size) {
                System.out.println("invalid index...");
                return;
            }
            if (index == 0) {
                addFirst(data);
                return;
            }
            if (index == size) {
                addLast(data);
                return;
            }
            int i = 1;
            node currNode = head;
            while (i < index) {
                i++;
                currNode = currNode.next;
            }
            node temp = currNode.next;
            currNode.next = newNode;
            newNode.next = temp;

        }
    }
