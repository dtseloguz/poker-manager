import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlayerListComponent }      from './player-list/player-list.component';

const routes: Routes = [
  { path: '', redirectTo: '/data-base', pathMatch: 'full' },
  { path: 'data-base', component: PlayerListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
