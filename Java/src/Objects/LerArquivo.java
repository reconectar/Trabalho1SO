package Objects;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class LerArquivo {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();

		while (s != null) {
			String[] splitStr = s.split(";");
			if (splitStr.length == 4) {
				String nome = splitStr[0];
				char categoria = s.charAt(0);
				Cliente cliente = new Cliente(nome, categoria);
				int quantidadeDePaginas = Integer.parseInt(splitStr[2]);
				String prazo =  splitStr[3];
				Documento documento = new Documento(cliente, quantidadeDePaginas, prazo);
			}
			s = br.readLine();
		}

		br.close();
	}
}
