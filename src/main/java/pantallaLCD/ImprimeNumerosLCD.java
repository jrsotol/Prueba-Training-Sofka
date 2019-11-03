package pantallaLCD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Candado on 03/11/2019.
 */
public class ImprimeNumerosLCD {


        /** Puntos fijos, e inicializacion de los mismos, matriz
         *  variables e inicializacion de las mismas
         */

        private final int[] pf1 = new int[2];
        private final int[] pf2 = new int[2];
        private final int[] pf3 = new int[2];
        private final int[] pf4 = new int[2];
        private final int[] pf5 = new int[2];
        private String[][] matrizDeImpresion;

        static final String SIMBOLO_HORIZONTAL = "-";
        static final String SIMBOLO_VERTICAL = "|";

        private int size;


        private int columDigito;
        private int filasDigito;
        private int totalColumnas;
        private int totalFilas;


        /**
         * METODO QUE AÑADE UNA LINEA A LA MATRIZ DE IMPRESION
         * @param punto,simbolo
         */

        private void agregarLinea(int[] punto, String simbolo){

            if (simbolo.equalsIgnoreCase(SIMBOLO_HORIZONTAL)){

                for (int a= 1; a <= this.size; a++){

                    int valor = punto[1] + a;
                    this.matrizDeImpresion[punto[0]][valor]= simbolo;
                }
            }
            else {

                for (int b= 1; b<= this.size; b++){

                    int valor= punto[0] + b;
                    this.matrizDeImpresion[valor][punto[1]]= simbolo;
                }
            }
        }

        /**
         * METODO DEL SEGMENTO A AGREGAR
         * @param segmento
         */

        private void agregarSegmento(int segmento){

            switch (segmento){

                case 1:
                    agregarLinea(this.pf1, SIMBOLO_VERTICAL);
                    break;
                case 2:
                    agregarLinea(this.pf2, SIMBOLO_VERTICAL);
                    break;
                case 3:
                    agregarLinea(this.pf5, SIMBOLO_VERTICAL);
                    break;
                case 4:
                    agregarLinea(this.pf4, SIMBOLO_VERTICAL);
                    break;
                case 5:
                    agregarLinea(this.pf1, SIMBOLO_HORIZONTAL);
                    break;
                case 6:
                    agregarLinea(this.pf2, SIMBOLO_HORIZONTAL);
                    break;
                case 7:
                    agregarLinea(this.pf3, SIMBOLO_HORIZONTAL);
                    break;

            }
        }

        /**
         * METODO QUE DEFINE LOS SEGMENTOS QUE HACEN PARTE DE UN DIGITO
         * PARA DESPUES ADICIONAR A LA MATRIZ EL DIGITO REQUERIDO
         * @param numero DIGITO
         */

        private void agregarDigito(int numero){

            //Establece los segmentos de cada numero
            List<Integer> segmentoNumero = new ArrayList<>();

            switch (numero){

                case 1:
                    segmentoNumero.add(3);
                    segmentoNumero.add(4);
                    break;
                case 2:
                    segmentoNumero.add(5);
                    segmentoNumero.add(3);
                    segmentoNumero.add(6);
                    segmentoNumero.add(2);
                    segmentoNumero.add(7);
                    break;
                case 3:
                    segmentoNumero.add(5);
                    segmentoNumero.add(3);
                    segmentoNumero.add(6);
                    segmentoNumero.add(4);
                    segmentoNumero.add(7);
                    break;
                case 4:
                    segmentoNumero.add(1);
                    segmentoNumero.add(6);
                    segmentoNumero.add(3);
                    segmentoNumero.add(4);
                    break;
                case 5:
                    segmentoNumero.add(5);
                    segmentoNumero.add(1);
                    segmentoNumero.add(6);
                    segmentoNumero.add(4);
                    segmentoNumero.add(7);
                    break;
                case 6:
                    segmentoNumero.add(5);
                    segmentoNumero.add(1);
                    segmentoNumero.add(6);
                    segmentoNumero.add(2);
                    segmentoNumero.add(7);
                    segmentoNumero.add(4);
                    break;
                case 7:
                    segmentoNumero.add(5);
                    segmentoNumero.add(3);
                    segmentoNumero.add(4);
                    break;
                case 8:
                    segmentoNumero.add(1);
                    segmentoNumero.add(2);
                    segmentoNumero.add(3);
                    segmentoNumero.add(4);
                    segmentoNumero.add(5);
                    segmentoNumero.add(6);
                    segmentoNumero.add(7);
                    break;
                case 9:
                    segmentoNumero.add(1);
                    segmentoNumero.add(3);
                    segmentoNumero.add(4);
                    segmentoNumero.add(5);
                    segmentoNumero.add(6);
                    segmentoNumero.add(7);
                    break;
                case 0:
                    segmentoNumero.add(1);
                    segmentoNumero.add(2);
                    segmentoNumero.add(3);
                    segmentoNumero.add(4);
                    segmentoNumero.add(5);
                    segmentoNumero.add(7);
                    break;

            }

            Iterator<Integer> iterator = segmentoNumero.iterator();

            while (iterator.hasNext()){

                agregarSegmento(iterator.next());
            }
        }

        /**
         * METODO QUE IMPRIME UN NUMERO
         * @param size Tamaño Segmento Digitos
         * @param numeroAImprimir Numero a Imprimir
         * @param espacio Espacio Entre digitos
         * 1)Calcula el numero de filas cada digito
         * 2)Calcula el numero de columna de cada digito
         * 3)Calcula el total de filas de la matriz en la que se almacenaran los digitos
         * 4)Calcula el total de columnas de la matriz en la que se almacenaran los digitos
         * 5)crea matriz para almacenar los numero a imprimir
         * 6)crea el arreglo de digitos
         */

        private void imprimirNumero(int size, String numeroAImprimir, int espacio){

            char[] digitos;
            this.size= size;
            //1)
            this.filasDigito = (2 * this.size) + 3;

            //2)
            this.columDigito = this.size + 2;

            //3)
            this.totalFilas = this.filasDigito;

            //4)
            this.totalColumnas = (this.columDigito * numeroAImprimir.length())
                    + (espacio * numeroAImprimir.length());

            //5)
            this.matrizDeImpresion = new String[this.totalFilas][this.totalColumnas];

            //6)
            digitos = numeroAImprimir.toCharArray();

            iniciaMatriz(); // Inicializa matriz
            validaDigito(digitos, espacio); //Valida que el caracter sea un digito
            imprimeMatriz(); // Imprime matriz
        }

        private void iniciaMatriz(){
            for (int i = 0; i < this.totalFilas; i++) {
                for (int j = 0; j < this.totalColumnas; j++) {
                    this.matrizDeImpresion[i][j] = " ";
                }
            }
        }

        private void validaDigito(char[] digitos, int espacio){
            int pivotX = 0;
            for (char digito : digitos) {


                if( ! Character.isDigit(digito))
                {
                    throw new IllegalArgumentException("Caracter " + digito
                            + " no es un digito");
                }

                int numero = Integer.parseInt(String.valueOf(digito));

                //Calcula puntos fijos
                this.pf1[0] = 0;
                this.pf1[1] = 0 + pivotX;

                this.pf2[0] = (this.filasDigito / 2);
                this.pf2[1] = 0 + pivotX;

                this.pf3[0] = (this.filasDigito- 1);
                this.pf3[1] = 0 + pivotX;

                this.pf4[0] = (this.columDigito - 1);
                this.pf4[1] = (this.filasDigito / 2) + pivotX;

                this.pf5[0] = 0;
                this.pf5[1] = (this.columDigito - 1) + pivotX;

                pivotX = pivotX + this.columDigito + espacio;

                agregarDigito(numero);
            }
        }
        private void imprimeMatriz() {
            for (int i = 0; i < this.totalFilas; i++) {
                for (int j = 0; j < this.totalColumnas; j++) {
                    System.out.print(this.matrizDeImpresion[i][j]);
                }
                System.out.println();
            }
        }

        /**
         * METODO QUE PROCESA LA ENTRADA QUE CONTIENE EL TAMAÑO (size) DEL SEGMENTO DE LOS DIGITOS
         * Y LOS DIGITOS QUE SE VAN A IMPRIMIR
         * Metodo encargado de procesar la entrada que contiene el size del segmento
         * de los digitos y los digitos a imprimir
         *
         * @param comando Entrada que contiene el size del segmento de los digito
         * y el numero a imprimir
         * @param espacioDig Espacio Entre digitos
         */
        public void procesar(String comando, int espacioDig) {

            String[] parametros;

            int tam;

            if (!comando.contains(",")) {
                throw new IllegalArgumentException("Cadena " + comando
                        + " no contiene caracter ,");
            }

            //Se hace el split de la cadena
            parametros = comando.split(",");

            //Valida la cantidad de parametros
            if(parametros.length > 2)
            {
                throw new IllegalArgumentException("Cadena " + comando
                        + " contiene mas caracter ,");
            }

            //Valida la cantidad de parametros
            if(parametros.length < 2)
            {
                throw new IllegalArgumentException("Cadena " + comando
                        + " no contiene los parametros requeridos");
            }

            //Valida que el parametro size sea un numerico
            if(isNumeric(parametros[0]))
            {
                tam = Integer.parseInt(parametros[0]);

                // se valida que el size este entre 1 y 10
                if(tam < 1 || tam >10)
                {
                    throw new IllegalArgumentException("El parametro size ["+tam
                            + "] debe estar entre 1 y 10");
                }
            }
            else
            {
                throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                        + "] no es un numero");
            }

            // Realiza la impresion del numero
            imprimirNumero(tam, parametros[1],espacioDig);

        }

        /**
         *
         * Metodo encargado de validar si una cadena es numerica
         *
         * @param cadena Cadena
         */
        public static boolean isNumeric(String cadena) {
            try {
                Integer.parseInt(cadena);
                return true;
            } catch (NumberFormatException ex) {
                return false;
            }
        }



    }

