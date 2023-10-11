package eu.tasgroup.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
	public static void main(String[] args) {
		String stringa = new String("Hello world!");
		Class<? extends String> classe1 = stringa.getClass();

		Class<?> classe2;
		try {
			classe2 = Class.forName("eu.tasgroup.reflection.Elemento");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		Constructor<?> elencoCostruttori1[] = classe1.getConstructors();
		Constructor<?> elencoCostruttori2[] = classe2.getConstructors();

		System.out.println("Costruttori:");
		for (int i = 0; i < elencoCostruttori2.length; i++) {
			Constructor<?> constructor = elencoCostruttori2[i];
			String descrizione = constructor.toString();
			System.out.println(descrizione);
			Class<?> tipologiaParametri[] = constructor.getParameterTypes();
			if (tipologiaParametri.length == 0) {
				System.out.println("Costruttore di default!");
				continue;
			}
			System.out.println("Parametri:");
			for (int j = 0; j < tipologiaParametri.length; j++) {
				Class<?> param = tipologiaParametri[j];
				System.out.println(param.getName());
			}

			Field campiDiIstanza[] = classe2.getDeclaredFields();
			for (Field campo : campiDiIstanza) {
				System.out.println("Nome campo: " + campo.getName());
				System.out.println("Modificatore di accesso: " + Modifier.toString(campo.getModifiers()));
			}

			Method metodi[] = classe2.getDeclaredMethods();
			for (Method metodo : metodi) {
				System.out.println("Nome metodo: " + metodo.getName());
				System.out.println("Modificatore di accesso: " + Modifier.toString(metodo.getModifiers()));
				System.out.println("Descrizione: " + metodo);
				System.out.println("Output type: " + metodo.getReturnType().getName());

				Class<?> eccezioni[] = metodo.getExceptionTypes();
				if (eccezioni.length == 0) {
					System.out.println("Non sollevo eccezioni");
				} else {
					System.out.println("Sollevo le seguenti eccezioni:");
					for (Class<?> exc : eccezioni) {
						System.out.println(exc.getName());
					}
				}
			}

		}
	}
}
