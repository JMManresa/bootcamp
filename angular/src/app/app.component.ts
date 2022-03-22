import { Component } from '@angular/core';
import { LoggerService } from 'src/lib/my-core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'curso';

  constructor(private out: LoggerService) {
    out.error('Es un error');
    out.warning('Es un warning');
    out.info('Es un info');
    out.log('Es un log');
  }
}
