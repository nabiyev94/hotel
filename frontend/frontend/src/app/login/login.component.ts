import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  constructor(){}

  ngOnInit(): void {
    
  }

  login(loginForm:NgForm){
    console.log("ok");
    console.log(loginForm.value);
  }
  

}
