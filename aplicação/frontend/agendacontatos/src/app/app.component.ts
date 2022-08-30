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

  public onOpenModal(mode: string, contato?: Contato): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addContatoModal');
    }
    if (mode === 'edit') {
      button.setAttribute('data-target', '#updateContatoModal');
    }
    if (mode === 'delete') {
      button.setAttribute('data-target', '#deleteContatoModal');
    }
    container?.appendChild(button);
    button.click();
  }

}
