/* Crear una función que devuelva un numero aleatorio (Math.random()) dentro del rango dado. */
function numeroAleatorioEntre(min, max) {
    return Math.trunc(Math.random() * (max - min) + min);
  }
  
  /*Adivina el Número, generar un número entre el 0 y el 100, introducir un número e informar
  si es igual, mayor o menor. Hay un máximo de 10 intentos para encontrar el número que sea igual.*/
  function AdivinaElNumero() {
    let random = numeroAleatorioEntre(0, 100);
    let intentos = 10;
  
    let cad, num;
  
    do {
      cad = prompt("Dame un numerito porfa:");
      num = parseInt(cad);
  
      intentos--;
  
      if (num < random)
        console.log("Mi numero es mayor, tienes " + intentos + " intentos");
      else if (num > random)
        console.log("Mi numero es menor, tienes " + intentos + " intentos");
      else {
        console.log("Correcto!");
        break;
      }
    } while (intentos > 0);
  
    console.log("Fin del juego");
  }
  
  /* Crear una función que devuelva un array con el numero de elementos indicado, inicializados
  al valor suministrado.*/
  function devolverArray(rango, inicial = 0) {
    let array = [];
  
    for (let i = 0; i < rango; i++) {
      array[i] = inicial;
    }
  
    return array;
  }
  
  /*Crear una función que devuelva un determinado número de números primos.*/
  function numerosPrimos(cantidad) {
    let numerosPrimos = [];
    let limite = 100;
    let contador = 0;
  
    for (let i = 2; i < limite; i++) {
      if (esPrimo(i)) {
        numerosPrimos.push(i);
        contador++;
        if (contador === cantidad) break;
      }
    }
    return numerosPrimos;
  }
  
  function esPrimo(number) {
    for (let i = 2; i < number; i++) {
      if (number % i === 0) {
        return false;
      }
    }
    return number !== 1;
  }
  
  /*Crear una función que valide un NIF*/
  
  function NifValidator() {
    if (value == null) return true;
    value = value.toUpperCase();
    if (!value.matches("^\\d{1,8}[A-Z]$")) return false;
    return (
      "TRWAGMYFPDXBNJZSQVHLCKE".charAt(
        Integer.parseInt(value.substring(0, value.length() - 1)) % 23
      ) == value.charAt(value.length() - 1)
    );
  }
  
  /*Definir una función que determine si la cadena de texto que se le pasa como parámetro
  es un palíndromo, es decir, si se lee de la misma forma desde la izquierda y desde la derecha.
  Ejemplo de palíndromo complejo: "La ruta nos aporto otro paso natural".*/
  
  function esPalindromo(cadena) {
    let volteada = cadena.split("").reverse().join("");
  
    return volteada === cadena;
  }
  
  /*Crear la función constructora del juego Adivina el Número.*/
  function JuegoDelNumero() {
    this.intentos = 10;
    this.ultimaJugada = -1;
    this.random = numeroAleatorioEntre(0, 100);
  
    this.jugada = function (num) {
      if (this.intentos <= 0 || num < 0 || num > 100) return "INVALIDA";
  
      this.intentos--;
      this.ultimaJugada = num;
      if (num < this.random) return "MAYOR";
      else if (num > this.random) return "MENOR";
      else return "IGUAL";
    };
  
    this.getIntentos = function () {
      return this.intentos;
    };
  
    this.getUltimaJugada = function () {
      return this.ultimaJugada;
    };
  
    this.getSolucion = function () {
      return this.random;
    };
  }
  
  /*Crear la clase del juego Adivina el Número.*/
  class JuegoDelNumeroConClase {
    constructor() {
      this.inicializar();
    }
  
    inicializar() {
      this.intentos = 10;
      this.ultimaJugada = -1;
      this.random = numeroAleatorioEntre(0, 100);
    }
  
    jugada(num) {
      if (this.intentos <= 0 || num < 0 || num > 100) return "INVALIDA";
  
      this.intentos--;
      this.ultimaJugada = num;
      if (num < this.random) return "MAYOR";
      else if (num > this.random) return "MENOR";
      else return "IGUAL";
    }
  
    getIntentos() {
      return this.intentos;
    }
  
    getUltimaJugada() {
      return this.ultimaJugada;
    }
  
    getSolucion() {
      return this.random;
    }
  }
  