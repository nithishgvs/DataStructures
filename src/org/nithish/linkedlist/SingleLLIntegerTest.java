package org.nithish.linkedlist;

public class SingleLLIntegerTest {
	public static void main(String[] main){
		SingleLLInteger list=new SingleLLInteger();
		SingleLLInteger list2=new SingleLLInteger();
		list.head = new Node(5);
		list.head.setNextNode(new Node(6));
        list.head.getNextNode().setNextNode(new Node(3));
        /*list.head.getNextNode().getNextNode().setNextNode(new Node(4));
        list.head.getNextNode().getNextNode().getNextNode().setNextNode(new Node(5));
        list.head.getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(list.head.getNextNode());*/
        
        list2.head = new Node(8);
        list2.head.setNextNode(new Node(4));
        list2.head.getNextNode().setNextNode(new Node(2));
        
        list.addNumbersofSLL(list.head, list2.head);
      
        //list.head.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new Node(3));
        //list.head.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new Node(8));
        //list.displayLinkedList();
        //list.evenOddSeggregationofLL();
        //Node headNodes=list.reverseLLIngivenSizeGroups(list.head,3);
        //list.displayLinkedList(headNodes);
        /*list2.head = new Node(1);
        list2.head.setNextNode(new Node(2));
        list2.head.getNextNode().setNextNode(new Node(10));
        list2.displayLinkedList();	
        boolean value=list.identicalLinkedListsRecursion(list.head, list2.head);
        System.out.println(value);*/
        //list.displayLinkedList(newNode);
       // boolean res=list.isPalindromeMethod2();
        //System.out.println("Palindrome ah :"+res);
       // list.reverseLinkedListRecursively(list.head, null);	
    
		/*list.insertNodeInSortedLinkedList(2);
		list.insertNodeInSortedLinkedList(4);
		list.insertNodeInSortedLinkedList(4);
		list.insertNodeInSortedLinkedList(6);
		list.insertNodeInSortedLinkedList(6);
		list.insertNodeInSortedLinkedList(10);
		list.insertNodeInSortedLinkedList(10);*/
			
		//list.pairwiseSwapIterativeApproach();
		//list.alternateSplitSLL();
        
        PolynomialLinkedListOperations op=new PolynomialLinkedListOperations();
		op.insertTwoVariablePolynomial(8, 3, 5);
		op.insertTwoVariablePolynomial(10, 6, 6);
		op.insertTwoVariablePolynomial(-9, 7, 15);
		op.displayTwoVariablePolynomial();
		PolynomialLinkedListOperations op2=new PolynomialLinkedListOperations();
        op2.insertOneVariablePolynomial(1, 3);
        op2.insertOneVariablePolynomial(11, 9);
		op2.displayOneVariablePolynomial();
	}

}
