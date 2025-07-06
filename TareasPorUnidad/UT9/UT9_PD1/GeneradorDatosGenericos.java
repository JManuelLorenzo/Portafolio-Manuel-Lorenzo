package UT9;

import java.util.Random;

public class GeneradorDatosGenericos {
	private static int TAMANIO_MAX = 5;
	
        public int[] generarDatosAleatorios(int tamañoMaximo) {
		Random rnd = new Random();
		int[] datosGenerados = new int[tamañoMaximo];
		boolean[] datosUtilizados = new boolean[tamañoMaximo];
		for (int i = 0; i < datosGenerados.length; i++) {
			int j = rnd.nextInt(tamañoMaximo);
			while(datosUtilizados[j]){
				j = (j + 1) % tamañoMaximo;
			}
			datosGenerados[j] = i;
			datosUtilizados[j] = true;
		}
		return datosGenerados;
	}
	
	public int[] generarDatosAscendentes(int tamañoMaximo) {
		int [] copiaAscendente = new int[tamañoMaximo];
		for (int i = 0; i < tamañoMaximo; i++) {
			copiaAscendente[i] = i;
		}
		return copiaAscendente;
	}
	
	public int[] generarDatosDescendentes(int tamañoMaximo) {
		int [] copiaDescendente = new int[tamañoMaximo];
		for (int i = 0; i < tamañoMaximo; i++) {
			copiaDescendente[i] = tamañoMaximo - (i+1);
		}
		return copiaDescendente;
	}
	
}
