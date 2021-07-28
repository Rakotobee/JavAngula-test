import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { VoitureService } from 'src/app/services/voiture.service';

@Component({
  selector: 'app-liste-voiture',
  templateUrl: './liste-voiture.component.html',
  styleUrls: ['./liste-voiture.component.css']
})
export class ListeVoitureComponent implements OnInit {

    voitures: any;
    userConnecter:any;
    addCommentForm: any;
  constructor(private voitureService:VoitureService,private route: Router,public fb: FormBuilder,
    public loginservice: LoginService) {
     this.addCommentForm = new FormGroup({
         idClient:  new FormControl(window.sessionStorage.getItem('id')),
         idVoiture: new FormControl(),
         commentaire: new FormControl()
     })
   }
    
  ngOnInit(): void {
    this.findCommentaireVoiture();
    this.checkUser();
  }
  findCommentaireVoiture(): void{
     this.voitureService.findCommentaireVoiture().subscribe(
          data =>{
            this.voitures = data;
          },
          error =>{
            console.log(error);
          }
     );
  }
  saveCommentaire(id_voiture: number): void{
     const idVoiture = this.voitures[id_voiture-1]['voiture']['id'];
     this.addCommentForm.patchValue({
          idVoiture:idVoiture
     });
    this.voitureService.commenter(this.addCommentForm.value).subscribe(
        (res) =>{
          console.log(" test result "+JSON.stringify(res));
          this.findCommentaireVoiture();
        },
        (error) =>{
          console.log(error);
        }
    );
  }
  public checkUser() {
    const user = window.sessionStorage.getItem('id');
    if (user != null) {
      this.userConnecter = true;
    } else {
      this.userConnecter = false;
    }
  }
}

