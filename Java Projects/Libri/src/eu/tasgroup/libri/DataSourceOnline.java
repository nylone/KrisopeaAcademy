package eu.tasgroup.libri;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataSourceOnline implements DataSource {
	private String path;

	public DataSourceOnline(String nome) {
		this.path = "C:\\libri\\" + nome + ".xml";
	}

	public String ottieniDati() {
		File file = new File(path);
		String out;
		try {
			FileInputStream in = new FileInputStream(file);
			byte[] data = in.readAllBytes();
			in.close();
			out = new String(data);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return out;
	}
}
