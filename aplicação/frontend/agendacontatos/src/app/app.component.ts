import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Contato } from './contato';
import { ContatoService } from './contato.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public contatos!: Contato[];

  constructor(private contatoService: ContatoService) {}

  ngOnInit() {
    this.getContatos();
  }

  public getContatos(): void {
    this.contatoService.getContatos().subscribe(
      (response: Contato[]) => {
        this.contatos = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
