import { AfterViewInit, Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { MatDrawer } from '@angular/material/sidenav';

@Component({
  selector: 'app-admin-header',
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
