public class Gauss implements Metodo{

	private int qtdLinhas, qtdColunas;

	public double[] aplicaMetodo(double a[][], double b[]) {
		int contadorComparacoes = 0;
		qtdLinhas = a.length;
		qtdColunas = a[0].length;

		// Determinar o elemento pivô para a coluna atual e reorganizar as
		// linhas

		Pivo pivo = new Pivo();
		pivo.pivoParcial(a, b);

		// Transforma a matriz a[][] em uma matriz diagonal superior pela
		// subtração de um multiplo da linha abaixo dela. Faz o mesmo com a
		// matriz b[][].

		for (int i = 0; i < qtdLinhas; ++i) {
			b[i] /= a[i][i];
			for (int j = qtdColunas - 1; j >= i; --j) {
				a[i][j] /= a[i][i];
				contadorComparacoes++;
			}

			for (int k = i + 1; k < qtdLinhas; ++k) {
				b[k] -= a[k][i] * b[i];
				for (int m = i + 1; m < qtdColunas; ++m) {
					a[k][m] -= a[k][i] * a[i][m];
					contadorComparacoes++;
				}
				contadorComparacoes++;
			}
			 contadorComparacoes++;
		}
		System.out.println("Gauss comparou: " + contadorComparacoes + " vezes\n");

		// Resolve a matriz b[] com substituição backward. Os elementos da
		// matriz a[][] foram previamente normalizados para 1.

		for (int i = qtdLinhas - 2; i >= 0; --i) {
			for (int j = i + 1; j < qtdLinhas; ++j) {
				b[i] -= a[i][j] * b[j];
			}
		}
		
		return b;
	}
}
