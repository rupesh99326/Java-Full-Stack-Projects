import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;

  constructor(private formBuilder:FormBuilder,private userService:UserServiceService) { }

  ngOnInit() {
  


  this.signUpForm = this.formBuilder.group({
    username : ['',[
      Validators.required,
      this.isUsernameTaken
    ]],
    firstname:['',[
      Validators.required
    ]],
    lastname:['',[
      Validators.required
    ]],
    password:['',[
      Validators.required,Validators.minLength(5)
    ]],
    confirmPassword:['',[
      Validators.required,
      this.matchConfirmPassword.bind(this)
    ]]
  })
}

get username() {
  return this.signUpForm.get('username');
}
get firstname() {
  return this.signUpForm.get('firstname');
}
get lastname() {
  return this.signUpForm.get('lastname');
}
get password() {
  return this.signUpForm.get('password');
}
get confirmPassword() {
  return this.signUpForm.get('confirmPassword');
}
matchConfirmPassword(formControl: FormControl): { [s: string]: boolean } {
  if (this.signUpForm) {
    if (formControl.value && formControl.value.length > 0 && formControl.value !== this.signUpForm.get('password').value) {
      return { 'nomatch': true };
    }
  }
  return null;
}
isUsernameTaken(formControl: FormControl): { [s: string]: boolean } {
    if (formControl.value === 'admin') {
        return { 'userNameTaken': true };
      } else {
        return null;
      }
    }



  
}
