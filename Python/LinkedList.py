class Node :
    def __init__(self, data, next = None) :
        self.data = data
        self.next = next
            
class LinkedList :

    def __init__(self) :
        self.head = Node(None)

    def __str__(self) :
        s = "Linked List :"
        itr = self.head.next
        while itr :
            s += ' ' + str(itr.data)
            itr = itr.next
        return s

    def append(self, data) :
        itr = self.head
        while itr.next :
            itr = itr.next
        itr.next = Node(data)

    def have(self, data) :
        itr = self.head
        while itr :
            if itr.data == data :
                return True
            itr = itr.next
        return False

    def removeDup(self) :
        temp = LinkedList()
        itr = self.head.next
        while itr :
            if not temp.have(itr.data) :
                temp.append(itr.data)
            itr = itr.next
        self.head = temp.head

        
l = LinkedList()
l.append(2)
l.append(5)
l.append(4)
l.append(4)
print(l)
l.removeDup()
print(l)