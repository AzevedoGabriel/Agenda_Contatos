import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contato } from './contato';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ContatoService {
  private url = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getContatos(): Observable<Contato[]> {
    return this.http.get<Contato[]>(`${this.url}/contato/all`);
  }

  public addContato(contato: Contato): Observable<Contato> {
    return this.http.post<Contato>(`${this.url}/contato/add`, contato);
  }

  public updateContato(contato: Contato): Observable<Contato> {
    return this.http.put<Contato>(`${this.url}/contato/update`, contato);
  }

  public deleteContato(contatoId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/contato/delete/${contatoId}`);
  }

}
