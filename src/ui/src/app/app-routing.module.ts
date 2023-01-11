import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { RegisterComponent } from './register/register.component';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { ResetCredentialsComponent } from './reset-credentials/reset-credentials.component';
import { LoginComponent } from './login/login.component';

const routes : Routes = [
  {path: 'credentials', component: ResetCredentialsComponent},
  {path: 'login', component: LoginComponent},
 // {path: '', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
