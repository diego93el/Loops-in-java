import java.util.Scanner;
import java.util.Random;

public class Principal {
	public static void limpiar_pantalla (){
		for (int i=0;i<=50;i++) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		Random aleatorio= new Random(System.currentTimeMillis());
		
		System.out.println("*****HOLA USUARIO !!***** \nEl siguiente programa le mostrara los 9 NUMEROS ganadores de la PRIMITVA.");
		//Empezamos con la aplicacion, dando una bienvenida y explicando la metodologia del mismo .
       
            System.out.println("Antes de verlos debe tener en cuenta que debe tener su boleto en mano.");
            System.out.println("Su boleto debe tener 9 NUMEROS, los NUMERO deben ser del 10 al 99, en el caso de que quiera salir PULSE 0.");
            System.out.println("Cuando tenga su boleto en mano indique SI lo tiene de lo contrario indique que NO lo tiene.");
            char res=sc.nextLine() .charAt(0);//Solicitamos la entrada de un caracter para saber si el usuario quiere entrar o no a la aplicacion.
            if (res=='s'||res=='S') {
            	limpiar_pantalla();
            	//3 Variables y un booleano para el ultimo bucle.
            	int bol;
            	int intentos=0;
            	int contador=0;
            	boolean juego=true;
            	// Una variable de tipo entero para generar los numero aleatorios.
                int aleatorios=0;
            	
            	//Usamos un ARRAY de tipo String para que sea mas versatil su uso mas adelante.
        		String[] vnum= new String [9];
        		
        		
            	System.out.println("Acontinuacion los 9 numero ganadores. ");
            	System.out.println("**********************************");
                System.out.println("*****NUMEROS DE LA PRIMITVIVA*****");
                System.out.println("**********************************");
                //Una vez dentro damos los 9 numeros de la primitiva generados aleatoriamente.Usando bucle for.
                for (int i=0;i<vnum.length;i++){
                	aleatorios=(int)(Math.random()*90+10);	
                	Integer posicion=null;
                	//Utilizamos un segundo bucle para eliminar aquellos valores repetidos en la variabale.
                	for (int j=0;j<i;j++) {
                		//Transformamos el valor de la variable int e Integer para que sea compatible con el tipo String del arreglo.
                		if(String.valueOf(aleatorios)==vnum[j]) {
                			posicion=Integer.valueOf(vnum[j]);
                		}
                	}
                	
                	if(posicion==null) {
                		vnum[i]=String.valueOf(aleatorios);
                	}else {
                		i--;
                	}
                }
                //Una vez se almacenan las variables repetidas . Podemos imprimir el Array y mostrarle al usuario los 9 numeros .
                for(int i=0;i<vnum.length;i++) {
                	System.out.print(vnum[i]+" ");
                }
                //Antes de entrar al ultimo bucle damos la ultima instruccion para no tener que repetirla dentro de el y que no se nos sature la pantalla.
                System.out.println("\nPulse INTRO para continuar...");
                sc.nextLine();
                limpiar_pantalla();
                System.out.println("\nUsuario por favor indique los 9 NUMEROS de su boleto.");
             	System.out.println("Por cada numero que indique se le cuenta como un INTENTO, tiene 15 en total.");
             	System.out.println("Recuerde presionar 0 para salir");
             	System.out.println("****BUENA SUERTE¡¡¡****");
                //Entramos al ultimo bucle de tipo while.
            	while(intentos<15&&juego&&contador<9) {
            		System.out.println(" ");
            		//Le solicitamos al usuario los numeros.
            		System.out.println("Usuario por favor indique un NUMERO de su boleto");
                 	bol=sc.nextInt();
                 	if(bol ==0) {
                 		//Usamos el booleano fuera del bucle para poder salir de la aplicacion
                 	    juego=false;
                 	}
                 	//Creamos otro booleano para confirmar si los numeros que escribe el usuario son iguales que los del array, usamos un ultimo bucle para recorrer todos los arrays.
                 	boolean existia = false;
                 	for (int i= 0; i< vnum.length ; i ++) {
                    	if (vnum[i].equals(String.valueOf(bol)) ) {
                    		System.out.println("¡¡ NUMERO CORRECTO !!");
                    		System.out.println("Llevas "+(intentos+1)+" INTENTO(S)...");
                    		//Indicamos si el numero corresponde con el del array imprimimos dos caracteres de tipo String.
                    		vnum[i] = "XX";
                    		//Usamos el booleano para indicar si es igual o no al siguiente condicional. Sumamos a las dos variables ya que hacen parte de la condicion para seguir usando la aplicacion.
                    		existia = true;
                    		contador++;
                    		intentos++;
                           	}
                         }
                 	     //El segundo condicional va por fuera del bucle for, para seguir su camino por el bucle while.
                         if (!existia) {
                 	    System.out.println("El NUMERO "+bol+" no existe.");
                 	    //Se le indica cuando intentos lleva , al igual que cuando cumple el booleano , y aca solo sumamos una variable ya que nos dara otro resultado.
                 	    System.out.println("Llevas "+(intentos+1)+" INTENTO(S)...");
                 	    intentos++;
                         }
                        
                       //Usamos este ultimo bucle, para imprimir los numeros que falta por cambiar su valor.
                 	    int aux=0;
                 	   System.out.println("**********************************");
                       System.out.println("*****NUMEROS DE LA PRIMITVIVA*****");
                 	   while(aux<vnum.length) {
             			System.out.print(vnum[aux]+" ");
             			aux++;
             		   }
                 	  
                    
            	}//Una vez salimos del primer bucle while, indicamos segun la condicion que cumplio le usuario si gano o no la primitiva.
            	limpiar_pantalla();
            	if(contador==9) {
            		System.out.println("!!!ENHORABUENA¡¡¡ \nTe ha tocado la primitiva, !!!ERES MILLONARIO¡¡¡ ");
            	}
            	if(intentos==15) {
            		System.out.println("Te has quedado sin intentos, buena suerte la proxima.");
            	}//Este ultimo condicional se usa si el usario decide salir con el 0 ya explicado anteriormente.
            	if(!juego) {
            		System.out.println("*****SALISTE DE LA APLICACION******");
            	}
            
            }//El ultimo condicional es en el caso de que el usuario no quisiera entrar al primer condicional con el caracter.
            else {
            	System.out.println("Veo que no ha conseguido su boleto para esta primitiva, intentelo la proxima vez.");
            }
        System.out.println("****El programa ha llegado hasta aqui. ADIOS !!****");

	}
}
