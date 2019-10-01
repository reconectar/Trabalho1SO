package Objects;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LeitorDeArquivo {

	public LeitorDeArquivo() {
		this.numeroInicialDeDocumentos = 0;
	}

	private int numeroInicialDeDocumentos;

	public int getNumeroInicialDeDocumentos() {
		return this.numeroInicialDeDocumentos;
	}

	private void setNumeroInicialDeDocumentos(int numeroInicialDeDocumentos) {
		this.numeroInicialDeDocumentos = numeroInicialDeDocumentos;
	}

	public ArrayList<Documento> lerArquivo() throws IOException {
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("H:mm");
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();
		setNumeroInicialDeDocumentos(Integer.parseInt(s));

		ArrayList<Documento> documentos = new ArrayList<Documento>();

		while (s != null) {
			String[] splitStr = s.split(";");
			if (splitStr.length == 5) {
				Cliente cliente = new Cliente(splitStr[0], s.charAt(0));
				LocalTime prazo = null;
				if (!splitStr[3].equals("0")){
					prazo = LocalTime.parse((splitStr[3]), customFormatter);
				}
				Documento documento = new Documento(Integer.parseInt(splitStr[2]), cliente, prazo);
				documento.toString();
				documentos.add(documento);
			}
			s = br.readLine();
		}
		br.close();
		return documentos;
	}
}


