package eu.tasgroup.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest2 {
public static void main(String[] args) {
	Elemento e1 = new Elemento("Persona", "Impiegato");
	Elemento e2 = new Elemento("Persona", "Studente");
	Elemento e3 = new Elemento("Persona", "Deficente");
	
	Class<?> classe = e1.getClass();
	
	Method metodo;
	try {
		metodo = classe.getMethod("equals", new Class<?>[] { new Object().getClass() });
	} catch (NoSuchMethodException | SecurityException e) {
		e.printStackTrace();
		return;
	}

	Object c1;
	try {
		c1 = metodo.invoke(e1, e2);
	} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		e.printStackTrace();
		return;
	}
	System.out.println("Confronto: " + c1);

	Object c2;
	try {
		Field campo = classe.getField("descrizione");
		campo.set(e3, "Impiegato");
		c2 = metodo.invoke(e1, e3);
	} catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
		e.printStackTrace();
		return;
	}
	System.out.println("Confronto: " + c2);
}
}
