import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DeputadosComponent } from './funcionalidades/components/deputados/deputados.component';

@NgModule({
  declarations: [
    AppComponent,
    DeputadosComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
