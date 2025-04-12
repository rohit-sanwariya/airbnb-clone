import { Component } from '@angular/core';
import {
  FaIconLibrary,
  FontAwesomeModule,
} from '@fortawesome/angular-fontawesome';
import { faGlobe} from '@fortawesome/free-solid-svg-icons';
 
@Component({
  selector: 'app-header',
  imports: [FontAwesomeModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  constructor(private library: FaIconLibrary){
      this.library.addIcons(
        faGlobe
      )
  }
}
