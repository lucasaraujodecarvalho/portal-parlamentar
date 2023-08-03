import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeputadosComponent } from './deputados.component';

describe('DeputadosComponent', () => {
  let component: DeputadosComponent;
  let fixture: ComponentFixture<DeputadosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DeputadosComponent]
    });
    fixture = TestBed.createComponent(DeputadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
