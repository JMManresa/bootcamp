class Calculadora {
  constructor(pantallaPrincipal, pantallaSecundaria) {
    this.acumulado = 0;
    this.operando = 0;
    this.operadorPendiente = "+";
    this.pantallaPrincipal = pantallaPrincipal;
    this.pantallaSecundaria = pantallaSecundaria;
  }

  getAcumulado() {
    return this.acumulado;
  }

  calcula(nuevoOperador) {
    
    this.acumulado = parseFloat(this.acumulado);
    this.operando = parseFloat(this.operando);
    switch (this.operadorPendiente) {
      case "+":
        this.acumulado += this.operando;
        break;
      case "-":
        this.acumulado -= this.operando;
        break;
      case "*":
        this.acumulado *= this.operando;
        break;
      case "/":
        this.acumulado /= this.operando;
        break;
      case "=":
        break;
    }
    this.imprimirEnSecundaria(nuevoOperador);
    if(parseFloat(this.pantallaPrincipal.textContent) != this.acumulado) {
        this.limpiar();
        this.imprimirEnPrincipal(this.acumulado);
    } else {
        
    }
    
    this.operadorPendiente = nuevoOperador;
    this.operando = 0;
  }

  imprimirEnPrincipal(value) {
    
    if (this.pantallaPrincipal.textContent == 0 || this.pantallaPrincipal.textContent == this.acumulado) {
      this.pantallaPrincipal.textContent = value;
    } else {
      this.pantallaPrincipal.textContent += value;
    }
    //Guardamos el numero en formato string
    this.operando += value;
  }

  imprimirEnSecundaria(operador) {
    this.pantallaSecundaria.textContent = this.acumulado + " " + operador;
  }

  limpiar() {
    this.pantallaPrincipal.textContent = "";
  }

  resetear() {
    this.pantallaPrincipal.textContent = 0;
    this.pantallaSecundaria.textContent = "";
    this.acumulado = 0;
    this.operando = 0;
    this.operadorPendiente = "+";
  }
}