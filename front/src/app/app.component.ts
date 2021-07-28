import { Component, OnInit } from '@angular/core';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'voiture-front-end';
  currentHeader: any;
  userConnecter:any;
  constructor(private loginService:LoginService){}
  ngOnInit(): void {
    this.checkUserExist();
  }
  
  public seLogin():void{
     this.currentHeader = true;
  }
  public seLogOut():void{
    this.loginService.doLogout();
  }
  public checkUserExist():void{
    if(sessionStorage.getItem("id")!=null){
       this.userConnecter = true;
    }else{
       this.userConnecter = false;
    }
  }
}
