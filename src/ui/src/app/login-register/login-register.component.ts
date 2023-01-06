import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { User } from '../user';

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent {

  user?: User;

  registerForm = this.formBuilder.group({
    username: '',
    password: '',
    email: '',
    firstName: '',
    lastName: ''
  });

  constructor(
    private formBuilder: FormBuilder
  ){}

  onSubmit(): void{
    console.log(this.registerForm.value);
    this.registerForm.reset();
  }
}
