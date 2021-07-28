import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListeVoitureComponent } from './components/liste-voiture/liste-voiture.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path: '', redirectTo: 'voiture', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path:'logout',component:ListeVoitureComponent},
  {path:'liste-voiture',component:ListeVoitureComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
