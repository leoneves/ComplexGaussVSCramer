public class Main {

	private static StringBuffer exibeTexto = new StringBuffer();

	public static void main(String[] args) {
		double a[][] = {
				{0, -1, 1 },
				{-1, 3, 0  },
				{2, 0, 6 },
		};
		// Matriz solução
		double b[] = { 2, 5, 20};
		
		
		CriaJanela frame = new CriaJanela();
		Metodo metodo = new Gauss();
		imprimirResultados(metodo.aplicaMetodo(a,b));
		CriaJanela.getJt().setText(exibeTexto.toString());
		CriaJanela.getFrame().setVisible(true);	
	}//fim mail
	
	public static void imprimirResultados(double x[]) {
		exibeTexto.append("Incógnitas:" + "\r\n");
		for (int i = 0; i < x.length; ++i) {
			exibeTexto.append("\n Incógnita "+ (i+1) +" valor: " + x[i]);
		}
	}
    
}//fim class Main
