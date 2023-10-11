package eu.tasgroup.esempiooop.trycatch;

public class TestFinally {
	public static void main(String[] args) {
		System.out.println(test(true));
		System.out.println(test(false));
	}

	private static boolean test(boolean t) {
		try {
			return true;
		} finally {
			if (t)
				return false;
		}
	}
}