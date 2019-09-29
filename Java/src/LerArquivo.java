package trabalhoSO;

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
				String cargo = splitStr[1];
				int quantidadeDePaginas = Integer.parseInt(splitStr[2]);
				String prazo = splitStr[3];
				System.out.println(nome);
				System.out.println(cargo);
				System.out.println(quantidadeDePaginas);
				System.out.println(prazo);
			}
			s = br.readLine();
		}

		br.close();
	}
}