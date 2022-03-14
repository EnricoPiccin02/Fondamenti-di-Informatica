/*
1. Scrivi un programma contenente una classe chiamata BasicDemo1 che nel metodomain richiama il metodo stampa() in essa contenuto. Il metodo stampa() deve mostrare a video la frase “sto testando l’istruzione System.out.print()” su un’unica riga, ma spezzando la stampa della frase in due istruzioni, poi saltando una riga deve stampareanche la frase “sto testando l’istruzione System.out.println()” usando un’unica istruzione.

2. Aggiungi alla classe BasicDemo1 il metodo “tipiDiDato” che dichiara una variabile perogni tipo di dato primitivo, gli assegni un valore e lo mostri a video.

3. Aggiungi alla classe BasicDemo1 un metodo “overflow” che mostri cosa succede aivalori di una variabile di tipo int quando viene raggiunto l’overflow.

4. Scrivi un algoritmo per calcolare il numero di bit utilizzati dalla tua macchinaper la variabile int e mostra tale numero a video

5. Scrivi un algoritmo algoritmo in cui una variabile intera raggiunge l’overflow e fanne il cast ad una variabile di tipo double. Mostra il valore iniziale della variabile intera, quellodopo l’overflow e quello della variabile double.

6. Scrivi l’algoritmo che converte in binario un numero naturale chiesto da tastiera e viceversa usando solo tipi di dato primitivi. Utilizza il tipo di dato più efficiente in terminidi memoria occupata.

7. Scrivi un algoritmo che calcola il fattoriale di un numero (naturale). L’algoritmo deve gestire anche lo zero. Inoltre verifica il comportamento della macchina nel caso di overfloating usando solo tipi di dato primitivi, stampa una frase che spiega cosa fa e realizza l’algoritmo che gestisce anche questo caso.

8. Definisci una griglia NxM con N ed M <=10000 e >=1000 dove registrare temperature>=-60 <=50 con la precisione di ½ grado definendo i tipi di dato che rendono l’algoritmo più efficiente possibile in termini di occupazione di memoria

9. Scrivi l’algoritmo del Crivello di Eratostene per calcolare i primi N numeri primi dove N>100000

10. Scrivi l’algoritmo che decodifica in binario e decimale il valore della seguente variabile: char lettera= ‘\u0043’

11. Calcolo della mantissa

*/
class Main {
  public static final char LETTERA = '\u0043';
  
  public static void main(String[] args) {
    stampa();
    tipiDiDato();
    overflow();
    numBit(8);
    casting();
    //indovinaNumero();
    convertiInBinario(37895);
    convertiInDecimale("1001010000000111");
    System.out.println(factorial(8));
    registroTemp();
    trovaNumPrimi();
    codificaLettera();
    mantissa(45.89778978);
  }

  public static void stampa() {
    System.out.print("sto testando ");
    System.out.println("l’istruzione System.out.print()\n");
    System.out.println("sto testando l’istruzione System.out.println()");
  }

  public static void tipiDiDato(){
    int a = 0;
    float b = 45.6f;
    double c = 67.9089d;
    char d = 'd';
    System.out.println("a = " + a);
    System.out.println("b = " + b);
    System.out.println("c = " + c);
    System.out.println("d = " + d);
    System.out.println("d = " + ((int) d));
    System.out.println("a = " + String.valueOf(a));
    System.out.println("a = " + Integer.toString(a));
  }

  public static void overflow(){
    int a = Integer.MAX_VALUE;
    System.out.println("a = " + a);
    System.out.println("a = " + (a+1));
  }

  public static void numBit(int a){
    System.out.println("Il numero di bit di a è " + (Integer.SIZE - Integer.numberOfLeadingZeros(a)));
  }

  public static void casting() {
    int a = Integer.MAX_VALUE;
    System.out.println("a = " + a);
    System.out.println("a = " + (a+1));
    System.out.println("a = " + ((double) a+1));
  }

  public static void indovinaNumero(){
    double tempNumeroIndovinare = 10000 * Math.random() * Math.pow(-1,Math.floor(Math.random() * 10));
    int numeroIndovinare = (int) tempNumeroIndovinare;
    System.out.println("Il numero da indovinare é " + numeroIndovinare);

    String numeroInserito = "99999";
    while(Integer.parseInt(numeroInserito) != numeroIndovinare) {
      System.out.println("Inserisci un numero tra -10000 e 10000:");
        numeroInserito = System.console().readLine();
        try {
          Integer.parseInt(numeroInserito);
          if(numeroIndovinare > Integer.parseInt(numeroInserito))
            System.out.println("Il numero da indovinare è più grande di " + numeroInserito);
          else if(numeroIndovinare < Integer.parseInt(numeroInserito))
            System.out.println("Il numero da indovinare è più piccolo di " + numeroInserito);
          else
            System.out.println("Hai indovinato il numero!");
        }catch(Exception e) {
          numeroInserito = "99999";
        }
    }
  }

  public static void convertiInBinario(int numeroDaConvertire){ 
    String numBin = "";
    while(numeroDaConvertire != 0) {
      numBin += numeroDaConvertire % 2;
      numeroDaConvertire /= 2;
    }
    for(int i = numBin.length() - 1; i >= 0; i--)
      System.out.print(numBin.charAt(i));
  }

  public static void convertiInDecimale(String numBin) {
    int numeroDecimale = 0; 
    System.out.println("\n");
    for(int i = 0; i < numBin.length(); i++) {
      numeroDecimale += Integer.parseInt(numBin.charAt(i) + "") * Math.pow(2,numBin.length()-1-i);
    }
    System.out.println("\nNumero decimale: " + numeroDecimale);
  }

  public static int factorial(int n){
    if(n != 0)
      return n * factorial(n-1);
    else
      return 1;
  }

  public static void registroTemp() {
    double m =  10000 * Math.random();
    double n =  1000 * Math.random();
    float[][] r = new float[(int) m][(int) n];

    for(int i = 0; i < (int)m; i++) {
      for(int j = 0; j < (int) n; j++) {
        double entry = Math.random() * 50 * Math.pow(-1,Math.floor(10 * Math.random())) - 10 * Math.random();
        entry = Math.floor(entry) + (Math.abs(entry - Math.floor(entry)) > 0.5 ? 1 : 0.5);
        r[i][j] = (float) entry;
        System.out.println(r[i][j] + "");
        
      }
    }
  }

  public static void trovaNumPrimi(){
    int n = 1;
    boolean flag = false;
    while(n < 57) {
      for(int i = 2; i < n & !flag; i++)
        flag = n % i != 0 ? false : true;
      if(!flag) System.out.println(n);
      n++; flag = false;
    }
  }

  public static void codificaLettera() {
    System.out.println(LETTERA);
    int intL = (int) LETTERA;
    System.out.println(intL + "");
    convertiInBinario(intL); 
  }

  public static void mantissa(double d) {
    System.out.println("La mantissa del numero " + d + " e': " + (d - Math.floor(d)));
  }
}