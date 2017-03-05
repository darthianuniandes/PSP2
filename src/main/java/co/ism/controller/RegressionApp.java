package co.ism.controller;

/**
 * @author ian
 * Clase principal del proyecto
 * Se captura el directorio del archivo a analizar y se orquesta el analisis de los datos
 */
public class RegressionApp {
	
	private static RegressionController regressionController = null; 
	
	/**
	 * @author ian
	 * Metodo principal y estatico que lee el directorio con la informacion a analizar
	 * Gestiona los posibles errores que se pueden presentar
	 * @param args es el arreglo de directorios que puede ingresar un usuario
	 * La validez del directorio es analizada mas adelante
	 */
    public static void main( String[] args ) {
    	regressionController = new RegressionController();
    	try {
			regressionController.leerArchivo(args);
			regressionController.obtenerListasDesdeArchivo();
		} catch (Exception e) {
			e.getMessage();
		}    	
    }
}
