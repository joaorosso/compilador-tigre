package principal;

import java.util.Stack;

public class testepilha {

    public static void main(String Args[]) {
        Stack<Integer> pilha = new Stack();
        pilha.push(1);
        pilha.push(2);


        System.out.println(pilha.pop());
        System.out.println(pilha.peek());
        System.out.println(pilha.peek());
    }
}
