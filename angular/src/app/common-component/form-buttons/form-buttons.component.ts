import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-form-buttons',
  templateUrl: './form-buttons.component.html',
  styleUrls: ['./form-buttons.component.css']
})
export class FormButtonsComponent implements OnInit {

@Output() send = new EventEmitter<any>();
@Output() cancel = new EventEmitter<any>();

@Input('send-disabled') disabled: boolean | null = false;
  constructor() { }

  ngOnInit(): void {
  }

}
