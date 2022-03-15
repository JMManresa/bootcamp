/* Crear una función que devuelva un numero aleatorio (Math.random()) dentro del rango dado. */
function numeroAleatorioEntre(min, max) {
    return Math.trunc(Math.random() * (max-min)+min)
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
function devolverArray(rango, inicial) {
    let array = [];

    for(let i = 0; i < rango; i++) {
        array[i] = inicial;
    }

    return array;
}

/*Crear una función que devuelva un determinado número de números primos.*/
function numerosPrimos(cantidad) {

    let numerosPrimos = [];
    let limite = 100;
    let contador = 0;

    for(let i = 2; i < limite; i++) {
        if(esPrimo(i)) {
            numerosPrimos.push(i);
            contador++;
            if(contador === cantidad)
                break;
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
function validaNIF(nif) {

    nif = nif.toUpperCase();

    return "TRWAGMYFPDXBNJZSQVHLCKE".charAt(parseInt(nif.substring(0, nif.length() - 1)) % 23) 
            == nif.charAt(nif.length() - 1);
}


/*Definir una función que determine si la cadena de texto que se le pasa como parámetro
es un palíndromo, es decir, si se lee de la misma forma desde la izquierda y desde la derecha.
Ejemplo de palíndromo complejo: "La ruta nos aporto otro paso natural".*/

function esPalindromo(cadena) {
    let volteada = cadena.split("").reverse().join("");
  
    return volteada === cadena;
  }
