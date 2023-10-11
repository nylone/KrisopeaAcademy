package eu.tasgroup.collections.code;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> pila = new Stack<>();
		pila.push("a");
		pila.push("b");
		pila.push("c");
		pila.push("e");
		pila.push("g");
		pila.push("q");
		pila.push("a");
		pila.push("4");
		pila.push("2");
		pila.push("1");
		System.out.println(pila);
		pila.pop();
		pila.pop();
		pila.pop();
		pila.pop();
		System.out.println(pila);
	}

}
