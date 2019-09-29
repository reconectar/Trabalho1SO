package Objects;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LerArquivo {
	public static void main(String[] args) throws IOException {
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("hh:mm");
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();
		int numeroInicialDeDocumentos = Integer.parseInt(s);
		Documento documento;
		
		while (s != null) {
			String[] splitStr = s.split(";");
			if (splitStr.length == 4) {
				s = br.readLine();
				 Cliente cliente = new Cliente(splitStr[0], s.charAt(0));
				 LocalDateTime prazo = LocalDateTime.parse(splitStr[3], customFormatter);
				 documento = new Documento(Integer.parseInt(splitStr[2]), cliente, prazo);
			}
			s = br.readLine();
		}

		br.close();
		
		System.out.println(numeroInicialDeDocumentos);

	}
}


