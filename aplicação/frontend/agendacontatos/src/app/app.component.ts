import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Contato } from './contato';
import { ContatoService } from './contato.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public contatos: Contato[] = [];
  public editContato: Contato | undefined;
  public deleteContato: Contato | undefined;

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

  public onAddContato(addForm: NgForm): void {
    document.getElementById('add-contato-form')?.click();
    this.contatoService.addContato(addForm.value).subscribe(
      (response: Contato) => {
        console.log(response);
        this.getContatos();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateContato(contato: Contato): void {
    this.contatoService.updateContato(contato).subscribe(
      (response: Contato) => {
        console.log(response);
        this.getContatos();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteContato(contatoId: number): void {
    this.contatoService.deleteContato(contatoId).subscribe(
      (response: void) => {
        console.log(response);
        this.getContatos();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchContatos(key: string): void {
    const results: Contato[] = [];
    for (const contato of this.contatos) {
      if (contato.name.toLowerCase().indexOf(key.toLowerCase()) !== -1){
        results.push(contato);
      }
    }
    this.contatos = results;
    if (results.length === 0 || !key) {
      this.getContatos();
    }
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
      this.editContato = contato;
      button.setAttribute('data-target', '#updateContatoModal');
    }
    if (mode === 'delete') {
      this.deleteContato = contato;
      button.setAttribute('data-target', '#deleteContatoModal');
    }
    container?.appendChild(button);
    button.click();
  }

}
