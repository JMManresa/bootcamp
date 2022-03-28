import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { environment } from 'src/environments/environment';
import { ERROR_LEVEL, LoggerService, MyCoreModule } from 'src/lib/my-core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainModule } from './main';
import { SecurityModule } from './security';
import { DemosComponent } from './demos/demos.component';
import { CommonServicesModule } from './common-services';
import { DinamicoComponent } from './dinamico/dinamico.component';
import { CalculadoraComponent } from './calculadora/calculadora.component';
import { ContactosModule } from './contactos';
import { FormularioComponent } from './formulario/formulario.component';
import { CommonComponentModule } from './common-component';

@NgModule({
  declarations: [
    AppComponent,
    DemosComponent,
    DinamicoComponent,
    CalculadoraComponent,
    FormularioComponent,
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule,
    AppRoutingModule, MainModule, SecurityModule, MyCoreModule, CommonServicesModule,
    ContactosModule, CommonComponentModule
  ],
  providers: [
    LoggerService,
    { provide: ERROR_LEVEL, useValue: environment.ERROR_LEVEL },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
