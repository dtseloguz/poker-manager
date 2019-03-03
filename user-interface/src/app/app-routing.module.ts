import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlayerListComponent }      from './player-list/player-list.component';
import {GameSettingsComponent} from './game-settings/game-settings.component';
const routes: Routes = [
  { path: '', redirectTo: '/data-base', pathMatch: 'full' },
  { path: 'data-base', component: PlayerListComponent },
  {path: "game-settings", component:GameSettingsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
