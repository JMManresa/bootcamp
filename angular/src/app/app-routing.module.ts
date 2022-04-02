import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CalculadoraComponent } from './calculadora/calculadora.component';
import {
  ContactosAddComponent,
  ContactosEditComponent,
  ContactosListComponent,
  ContactosViewComponent,
} from './contactos/componente.component';
import { DemosComponent } from './demos/demos.component';
import { PageNotFoundComponent } from './main';
import { HomeComponent } from './main/home/home.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', component: HomeComponent },
  { path: 'inicio', component: HomeComponent },
  { path: 'demos', component: DemosComponent, data: { pageTitle: 'Demos' } },
  { path: 'calculadora', component: CalculadoraComponent },
  {
    path: 'contactos',
    children: [
      { path: '', component: ContactosListComponent },
      { path: 'add', component: ContactosAddComponent },
      { path: ':id/edit', component: ContactosEditComponent },
      { path: ':id', component: ContactosViewComponent },
      { path: ':id/:kk', component: ContactosViewComponent },
    ],
  },
  {
    path: 'libros',
    children: [
      { path: '', component: ContactosListComponent },
      { path: 'add', component: ContactosAddComponent },
      { path: ':id', component: ContactosViewComponent },
      { path: ':id/edit', component: ContactosEditComponent },
      { path: ':id/:kk', component: ContactosViewComponent },
    ],
  },
  { path: 'alisha/passion', redirectTo: '/contactos/9' },
  {
    path: 'config',
    loadChildren: () =>
      import('./config/config.module').then((mod) => mod.ConfigModule),
  },
  { path: '404.html', component: PageNotFoundComponent },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
