package com.example.parentheses;


import java.util.ArrayDeque;
import java.util.Stack;

/**
 * This class provides the method to get the number of semantic errors from an input of parentheses.
 */
public class Parentheses {

    /**
     * This function gets an input of parentheses, and returns the number of semantic errors found.
     *
     * @param inputArr An array of single parentheses in String
     * @return returns an integer, the number of semantic errors found  in the input
     */
	public static int findMistakes(String[] inputArr) {
		ArrayDeque<String> qInput = new ArrayDeque<String>();
		Stack<String> parenthesesStack = new Stack<String>();
		int numOfMistakes = 0;

		for(int i = 0; i < inputArr.length; i++) {
			qInput.add(inputArr[i]);
		}

		if(!qInput.isEmpty()) {
			parenthesesStack.push(qInput.pop());
		}

		// if ) is the thing that in the stack... Then it is already wrong
				// if the next thing in q is ), then they it is good, because they can become the pair + 1
				// if the next thing in q is (,
					// if that is the last thing on the q, then there are two changes + 2
					// if that is NOT the last thing on the q, then just let it be, until it finds its match

		// if ( is the thing that is in the stack...
			// and if the next thing is in the q is ), then pop it
			// else, if ( is the last thing in the q, then mistake + 1, and pop.
            // else, just add it

		// else, the stack is empty, and just simply add.

		while(!qInput.isEmpty()){
			String tempQueueVal = qInput.poll();
			if(parenthesesStack.empty()) {
				parenthesesStack.push(tempQueueVal);
			} else if(parenthesesStack.peek().equals(")")) {
				if(tempQueueVal.equals("(") && qInput.isEmpty()) {
					numOfMistakes += 2;
					parenthesesStack.pop();
				} else if(tempQueueVal.equals("(") && !qInput.isEmpty()) {
					parenthesesStack.push(tempQueueVal);
				} else {
					numOfMistakes++;
					parenthesesStack.pop();
				}
			} else {
				if(tempQueueVal.equals(")")) {
					parenthesesStack.pop();
				} else {
				    // else ,it will "("
				    if(qInput.isEmpty()) {
				        parenthesesStack.pop();
				        numOfMistakes++;
                    } else {
                        parenthesesStack.push(tempQueueVal);
                    }
				}

			}
		}

		return numOfMistakes;
	}

}
