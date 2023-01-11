import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { User, UsersService } from '../Services/users.service';

@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent {

  user?: User;

  registerForm = this.formBuilder.group({
    username: [''],
    password: [''],
    email: [''],
    firstName: [''],
    lastName: [''],
    bio: ['']
  });

  constructor(
    private formBuilder: FormBuilder,
    private usersService : UsersService
  ){}

  onSubmit(): void{
    this.usersService.createUser(this.registerForm.value.username!, this.registerForm.value.password!, this.registerForm.value.email!, this.registerForm.value.firstName!, this.registerForm.value.lastName!, this.registerForm.value.bio!).subscribe(user =>{
      console.log("posted user: "+ JSON.stringify(user));
    })
    this.registerForm.reset();
  }
}
