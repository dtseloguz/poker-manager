import { Component, OnInit } from '@angular/core';
import {TournamentSettingFull} from './tournament-setting-full';
import { TOURNAMENTSETTING } from './mock-tournament'
@Component({
  selector: 'app-game-settings',
  templateUrl: './game-settings.component.html',
  styleUrls: ['./game-settings.component.css']
})
export class GameSettingsComponent implements OnInit {
  tournamentInfo : TournamentSettingFull;

  constructor() { 
    this.tournamentInfo = new TournamentSettingFull();
  }

  ngOnInit() {
  }
  load(): void{
    this.tournamentInfo = TOURNAMENTSETTING ;
  }
}
