201710_CSOF5101_01 - CONCEP. AVAN. DE INGENI. SOFTW
Tarea No. 3 Personal Software Process for Engineers Program 2
Ian Sarasty Medina
03/05/17
Ejecute el programa desde el directorio src utilizando el comando: 

java -cp target/PSP3Regression-1.0-SNAPSHOT.jar co.ism.controller.RegressionApp 

o

java -cp target/PSP3Regression-1.0-SNAPSHOT.jar co.ism.controller.RegressionApp /directorio/foo.txt

La aplicación soporta que ingrese la ruta completa del archivo. Si no se especifica el programa lee el archivo “numeros.txt” almacenado en la raíz del proyecto.

Nota: en el directorio src se encuentra un archivo llamado "numeros.txt". Este es el archivo que el programa lee para hacer los cálculos requeridos. Es necesario ingresar los datos con un formato especial: para separar el valor estimado de las listas se usa el caracter ‘&’,  para se parar los tests se usa ‘;’, para se parar las listas se usa ‘,’ y para separar los elementos de las listas se usa ‘ ’ (un espacio).

En el archivo “numeros.txt” se ve un ejemplo de como se debe ingresar la información, sin embargo se agrega un ejemplo (data de prueba dada en el enunciado):

386 & 130 650 99 150 128 302 95 945 368 961,186 699 132 272 291 331 199 1890 788 1601;
386 & 130 650 99 150 128 302 95 945 368 961,15 69.9 6.5 22.4 28.4 65.9 19.4 198.7 38.8 138.2;
386 & 163 765 141 166 137 355 136 1206 433 1130,186 699 132 272 291 331 199 1890 788 1601;
386 & 163 765 141 166 137 355 136 1206 433 1130,15 69.9 6.5 22.4 28.4 65.9 19.4 198.7 38.8 138.2;

Si se agrega texto que no tenga que ver o letras el sistema no tendrá en cuenta estos valores.
Si las listas solo tienen ceros se mostraran valores indeterminados en los resultados.
Si se especifica una ruta invalida el sistema mostrara un mensaje de error.

GIT REPOSITORY: 

git@github.com:darthianuniandes/PSP2.git
https://github.com/darthianuniandes/PSP2.git