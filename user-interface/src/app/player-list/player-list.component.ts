import { Component, OnInit } from '@angular/core';
import { Player } from '../player';
import { PlayerService } from '../player.service';
import { List} from './list';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {

  players: Player[];
  lists: List[];
  selectedPlayer: Player;
  checkSelectedPlayer: boolean = false;
  constructor(private playerService:  PlayerService) { }

  ngOnInit() {
    this.getPlayers();
    this.selectedPlayer = new Player;
  }
  getPlayers(): void {
    this.playerService.getPlayers()
        .subscribe(players => this.players = players);
    
  }
    onSelect(player){
      if(player.selected === false && player.changed===false){        
        player.selected = true;
      }
      else{
        player.selected = false;
      }
    }
    onChange(player){
      if(player.changed === false &&  (this.checkSelectedPlayer === false)){
       player.changed = true;
       this.copyProperty(this.selectedPlayer,player);
       console.log(this.selectedPlayer);
       
       this.checkSelectedPlayer = true;
      }
      else if(player.changed === true) {
        player.changed = false;
        player.selected = false;
        this.checkSelectedPlayer = false;
      }
    }
    Cancel(player){
      console.log( this.checkSelectedPlayer);
      console.log(this.selectedPlayer);
      player = this.selectedPlayer;
      player.changed = false;
      this.checkSelectedPlayer = false;
    }
    copyProperty(player,secondPlayer): void {
      player.name = secondPlayer.name;
      player.midname =secondPlayer.midname;
      player.surname = secondPlayer.midname;
      player.age =secondPlayer.age;
      player.paymentData =secondPlayer.paymentData;
      player.paymentOffData =secondPlayer.paymentOffData;
      player.selected =secondPlayer.selected;
      player.changed =secondPlayer.changed;
      player.payment =secondPlayer.payment;
    }
}
