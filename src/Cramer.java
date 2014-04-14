public class Cramer implements Metodo{

	private int qtdLinhas, qtdColunas;
	private double D,Dx;
	private double Ax[][];
	private int contadorComparacoes = 0;

	public double[] aplicaMetodo(double a[][], double b[]) {
		qtdLinhas = a.length;
		qtdColunas = a[0].length;
		
		double result[] = new double[qtdColunas];

		//cálcular determinante da matriz incompleta
		D = laplace(a);
		
		for (int l = 0; l < qtdLinhas; l++) {
			Ax = copyArray(a);
			
			for(int c=0; c< qtdColunas; c++ ){
				Ax[c][l] = b[c];	
				contadorComparacoes++;
			}
			
			Dx = laplace(Ax);
									
			result[l] = Dx/D;
			contadorComparacoes++;
		}
		System.out.println("Cramer comparou:  " + contadorComparacoes + " vezes\n");		
		return result;		
	}
	
	public double[][] copyArray(double array[][]){
		double[][] arrayTemp = new double[qtdColunas][qtdLinhas];
		for (int i = 0; i < qtdColunas; i++) {
			for(int k=0; k< (qtdLinhas); k++ ){
				arrayTemp[i][k] = array[i][k];
			}
		}
		return arrayTemp;
	}
	
	public double laplace(double[][] matriz){
 
        validaMatriz(matriz);
        double determinante = 0;
        if(matriz.length == 1){
            determinante = matriz[0][0];
	    contadorComparacoes++;
        }else if(matriz.length == 2){
            determinante = matriz[0][0]*matriz[1][1] - matriz[0][1]*matriz[1][0];
	    contadorComparacoes++;
        }else if(matriz.length == 3){
		determinante = matriz[0][0]*matriz[1][1]*matriz[2][2]
                        +matriz[0][1]*matriz[1][2]*matriz[2][0]
                        +matriz[0][2]*matriz[1][0]*matriz[2][1]
                        -matriz[0][2]*matriz[1][1]*matriz[2][0]
                        -matriz[0][0]*matriz[1][2]*matriz[2][1]
                        -matriz[0][1]*matriz[1][0]*matriz[2][2];
		contadorComparacoes++;
        }else{
            double[][] aux;
            int i_aux, j_aux, linha, coluna, i;            
             
            for(i = 0; i < matriz.length; i++){
		contadorComparacoes++;
                if(matriz[0][i] != 0){
			aux = new double[matriz.length - 1][matriz.length - 1];
			i_aux = 0;
			j_aux = 0;
			contadorComparacoes++;
 
			for(linha = 1; linha < matriz.length; linha++){
				for(coluna = 0; coluna < matriz.length; coluna++){
					if(coluna != i){
						aux[i_aux][j_aux] = matriz[linha][coluna];
						j_aux++;
						contadorComparacoes++;
					}
				}
 
				i_aux++;
				j_aux = 0;
				contadorComparacoes++;
			}
 
                    determinante += Math.pow(-1, i)*matriz[0][i]*laplace(aux);
                }
                 
            }
	}
	return determinante;
    }
 
    public void validaMatriz(double[][] matriz){
        if(matriz == null)
            throw new NullPointerException("Matriz null");
        if(matriz.length == 0)
            throw new IllegalArgumentException("A matriz não possui linhas e colunas");
        if(matriz.length != matriz[0].length)
            throw new IllegalArgumentException("A matriz não é quadrada");        
    }
	
}
