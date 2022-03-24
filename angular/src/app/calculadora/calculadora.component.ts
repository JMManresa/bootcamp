import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {

  public principal: string = "0";
  public secundaria: string = "";
  public acumulado: number = 0;
  public operando: string = "0";
  public operadorPendiente: string = "+";

  calcula(nuevoOperador: string) {

    switch (this.operadorPendiente) {
      case "+":
        this.acumulado += parseFloat(this.operando);
        break;
      case "-":
        this.acumulado -= parseFloat(this.operando);
        break;
      case "*":
        this.acumulado *= parseFloat(this.operando);
        break;
      case "/":
        this.acumulado /= parseFloat(this.operando);
        break;
      case "=":
        break;
    }
    this.imprimirEnSecundaria(nuevoOperador);
    if(this.principal != this.acumulado.toString()) {
        this.limpiar();
        this.imprimirEnPrincipal(this.acumulado.toString());
    }
    this.operadorPendiente = nuevoOperador;
    this.operando = "0";
  }

  imprimirEnPrincipal(value: string) {
    if (this.principal == "0" || this.principal  == this.acumulado.toString()) {
      this.principal = value;
    } else {
      this.principal += value;
    }
    //Guardamos el numero en formato string
    this.operando += value;

  }

  imprimirEnSecundaria(operador: string) {
    this.secundaria = this.acumulado + " " + operador;
  }

  limpiar() {
    this.principal = "0";
  }

  resetear() {
    this.principal = "0";
    this.secundaria = "";
    this.acumulado = 0;
    this.operando = "0";
    this.operadorPendiente = "+";
  }

  ngOnInit(): void {
  }

}
