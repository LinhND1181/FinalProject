import { AfterViewInit, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-header',
  standalone: false,
  templateUrl: './admin-header.component.html',
  styleUrl: './admin-header.component.scss'
})
export class AdminHeaderComponent implements OnInit, AfterViewInit {

  
  constructor() { }

  ngAfterViewInit(): void {

  }

  ngOnInit(): void {
  }

  isBadgeVisible: boolean = false;

  badgeVisibility() {
    this.isBadgeVisible = true;
  }

}
