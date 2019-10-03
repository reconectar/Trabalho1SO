package Objects;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo {

	private int numeroDeDocumentos;

	private static LeitorDeArquivo singleton = new LeitorDeArquivo();

	private LeitorDeArquivo() {
		this.numeroDeDocumentos = 0;
	}

	public static LeitorDeArquivo getInstance() {
		return singleton;
	}

	public int getNumeroInicialDeDocumentos() {
		return this.numeroDeDocumentos;
	}

	private void setNumeroDeDocumentos(int numeroDeDocumentos) {
		this.numeroDeDocumentos = numeroDeDocumentos;
	}

	public List<Documento> lerArquivo() throws IOException {
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("H:mm");
		InputStream is = new FileInputStream("dadosImpressora20192.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();
		setNumeroDeDocumentos(Integer.parseInt(s));

		List<Documento> documentos = new ArrayList<Documento>();

		while (s != null) {
			String[] splitStr = s.split(";");
			if (splitStr.length == 5) {
				Cliente cliente = new Cliente(splitStr[0], splitStr[1].charAt(0));
				LocalTime prazo = null;
				if (!splitStr[3].equals("0")){
					prazo = LocalTime.parse((splitStr[3]), customFormatter);
				}
				Documento documento = new Documento(Integer.parseInt(splitStr[2]), cliente, prazo);
				documentos.add(documento);
			}
			s = br.readLine();
		}
		br.close();
		return documentos;
	}
}


