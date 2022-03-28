import { Component, OnInit } from '@angular/core';
import { CalculadoraComponent } from '../calculadora/calculadora.component';
import { HomeComponent } from '../main/home/home.component';
import { DemosComponent } from '../demos/demos.component';
import { FormularioComponent } from '../formulario/formulario.component';
import { ContactosComponent } from '../contactos/componente.component';

@Component({
  selector: 'app-dinamico',
  templateUrl: './dinamico.component.html',
  styleUrls: ['./dinamico.component.css']
})
export class DinamicoComponent implements OnInit {
  menu = [
    { texto: 'contactor', icono: 'fa-solid fa-chalkboard-user', componente: ContactosComponent},
    { texto: 'formulario', icono: 'fa-solid fa-chalkboard-user', componente: FormularioComponent},
    { texto: 'inicio', icono: 'fa-solid fa-house', componente: HomeComponent},
    { texto: 'demos', icono: 'fa-solid fa-chalkboard-user', componente: DemosComponent},
    { texto: 'calculadora', icono: 'fa-solid fa-calculator', componente: CalculadoraComponent },
  ]
  actual = this.menu[0].componente

  constructor() { }

  ngOnInit(): void {
  }

  seleccionar(indice: number): void {
    this.actual  = this.menu[indice].componente
  }
}
