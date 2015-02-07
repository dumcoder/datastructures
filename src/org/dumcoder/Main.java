package org.dumcoder;


import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<Integer> integerSll = new SingleLinkedList<Integer>();
        integerSll.addHead(1);
        integerSll.addHead(2);
        integerSll.addHead(3);
        integerSll.addHead(4);
        integerSll.addHead(5);
        integerSll.addHead(6);
        integerSll.addHead(7);
        integerSll.addHead(8);

        final Iterator<Integer> integerIterator = integerSll.iterator();
        while (integerIterator.hasNext()){
            final Integer data = integerIterator.next();
            System.out.println(data  + "->");
        }



        //Brents Cycle detection Algorithm
/*		Node turtle = head;
		Node bunny = head;
		int steps_taken = 0;
		int step_limit = 2;

		while (true){
			if (bunny == null){
				System.out.println("\nNo Cycle Found");
				break;
			}
			bunny = bunny.next;
			++steps_taken;

			if (bunny == turtle){
				System.out.println("\nCycle Found");
				break;
			}

			if(steps_taken == step_limit){
				steps_taken = 0;
				step_limit *= 2;
				//teleport turtle
				turtle = bunny;
			}
		}*/
    }
}