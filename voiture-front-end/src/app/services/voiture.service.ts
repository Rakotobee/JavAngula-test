import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { CommentaireVoiture } from '../models/commentaire-voiture.model';
import { Commentaire } from '../models/commentaire.model';
import { Voiture } from '../models/voiture.model';
import { LoginService } from './login.service';

const baseUrl = 'http://localhost:8080/api';

@Injectable({
  providedIn: 'root'
})
export class VoitureService {

  constructor(private http: HttpClient, public loginservice: LoginService) { }
  getAll(): Observable<Voiture[]> {
    return this.http.get<Voiture[]>(`${baseUrl}/voiture`);
  }
  findCommentaireVoiture():Observable<CommentaireVoiture[]>{
     return this.http.get<CommentaireVoiture[]>(`${baseUrl}/commentaireVoiture`);
  }
  commenter(data: any):Observable<any>{
      return this.http.post<any>(`${baseUrl}/commentaire`, data);
  }
}
