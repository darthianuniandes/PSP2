package co.ism.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import co.ism.services.RegressionService;

/**
 * @author ian
 * Clase que se encarga de leer los datos ingresados por el usuario y orquestar la optencion de los resultados de las regresiones 
 */
public class RegressionController {

	private RegressionService regressionService;
	private List<String> listaX;
	private List<String> listaY;
	private String numeros;
	private Boolean cabecera;

	/**
	 * @author ian
	 * El constructor de la clase inicializa los atributos, sin obtenerlos de manera externa
	 */
	public RegressionController() {
		super();
		this.regressionService = new RegressionService();
		this.listaX = new LinkedList<String>();
		this.listaY = new LinkedList<String>();
		cabecera = true;
	}
	
	/**
	 * @author ian
	 * Se obtiene la informacion del archivo dado
	 * Si no se tiene un archivo dado por el usuario se usa el archivo por defecto 
	 */
	public void leerArchivo(String[] archivo) {
		if(archivo != null && archivo.length > 0){
			leerArchivo(archivo[0]);
		} else {
			leerArchivo("./numeros.txt");			
		}
	}

	/**
	 * @author ian
	 * Metodo que separa la informacion almacenada en el archivo dado para analizar
	 * Se hace la separacion de la informacion segun un formato especifico
	 */
	public void obtenerListasDesdeArchivo() {
		List<String> tests = Arrays.asList(numeros.split(";"));
		int testNumber = 0;
		for (String testIterator : tests) {
			List<String> arrayXk = Arrays.asList(testIterator.split("&"));
			List<String> arrayNs = Arrays.asList(arrayXk.get(1).split(","));
			listaX = Arrays.asList(arrayNs.get(0).split(" "));
			listaY = Arrays.asList(arrayNs.get(1).split(" "));
			regressionService = new RegressionService();
			regressionService.crearListas(arrayXk.get(0), listaX, listaY);
			calcularDatos();
			testNumber++;
			imprimirResultados(testNumber);
		}
	}

	/**
	 * @author ian
	 * Metodo que orquesta el calculo de los datos de la regresion
	 */
	public void calcularDatos() {
		regressionService.calcularCoeficientes();
		regressionService.calcularYk();
	}
	
	/**
	 * @author ian
	 * Metodo que imprime los resultados de las diferentes regresiones que se vayan calculando segun como se ingresen estas en el archivo dado
	 * Imprime la cabecera una vez y procede a hacer la impresion de cada uno de los resultados de cada test
	 * @param testNumber es el contador de los tests dados en el documento de entrada
	 */
	public void imprimirResultados(int testNumber) {
		StringBuilder reporte = new StringBuilder();
		if(cabecera){
			reporte.append("______________________________________________\n");
			reporte.append("|Test  |    Expected Values                   |\n");
			reporte.append("______________________________________________\n");
			reporte.append("|      |   B0   |  B1  |   r  |  r^2 |   Yk   |\n");
			reporte.append("______________________________________________\n");
			cabecera = false;
			System.out.println(reporte.toString());
		}		
		regressionService.imprimirData(testNumber);
	}

	/**
	 * @author ian
	 * Metodo que hace la lectura del archivo dado por el usuario
	 * @param archivo es el directorio del archivo que va a ser analizado
	 */
	private void leerArchivo(String archivo) {
		BufferedReader in = null;
		FileInputStream fis = null;
		StringBuilder lectura;

		try {
			fis = new FileInputStream(archivo);
			in = new BufferedReader(new InputStreamReader(fis));

			lectura = new StringBuilder();
			String sCurrentLine;

			while ((sCurrentLine = in.readLine()) != null) {
				lectura.append(sCurrentLine);
			}
			numeros = lectura.toString();
		} catch (IOException e) {
			System.out.println("El directorio ingresado es invalido");
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				System.out.println("Hubo un error al intentar cerrar los recursos abiertos");
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @author ian
	 * Metodo que devuelve la primer lista de datos fisicos
	 */
	public List<String> getListaX() {
		return listaX;
	}
	
	/**
	 * @author ian
	 * Metodo que devuelve la segunda lista de datos fisicos
	 */
	public List<String> getListaY() {
		return listaY;
	}

}
