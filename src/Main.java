public class Main {

	private static StringBuffer exibeTexto = new StringBuffer();

	public static void main(String[] args) {
		double a[][] = {
				{1,8,2,8,9,8,2,8,9,2,8,9},
				{0,1,0,4,4,8,2,8,9,2,8,9},
				{0,0,1,0,6,8,2,8,9,2,8,9},
				{0,0,0,1,7,8,2,8,9,2,8,9},
				{0,0,0,0,1,8,2,8,9,2,8,9},
				{0,0,0,0,0,1,2,8,9,2,8,9},
				{0,0,0,0,0,0,1,8,9,2,8,9},
				{0,0,0,0,0,0,0,1,9,2,8,9},
				{0,0,0,0,0,0,0,0,1,2,8,9},
				{0,0,0,0,0,0,0,0,0,1,8,9},
				{0,0,0,0,0,0,0,0,0,0,1,9},
				{0,0,0,0,0,0,0,0,0,0,0,1}
		};
		// Matriz solução
		double b[] = {1,1,1,1,1,1,1,1,1,1,1,1};
			
		CriaJanela frame = new CriaJanela();
		exibeTexto.append("Método Cramer:" + "\r\n");
		Metodo cramer = new Cramer();
		imprimirResultados(cramer.aplicaMetodo(a,b));
		CriaJanela.getJt().setText(exibeTexto.toString());
		
		exibeTexto.append("\n\nMétodo Gauss:" + "\r\n");
		Metodo gauss = new Gauss();
		imprimirResultados(gauss.aplicaMetodo(a,b));
		CriaJanela.getJt().setText(exibeTexto.toString());
		
		CriaJanela.getFrame().setVisible(true);	
	}//fim mail
	
	public static void imprimirResultados(double x[]) {
		exibeTexto.append("Incógnitas:" + "\r\n");
		for (int i = 0; i < x.length; i++) {
			exibeTexto.append("\n Incógnita "+ (i+1) +" valor: " + x[i]);
		}
	}
    
}//fim class Main
