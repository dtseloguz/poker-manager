import { TournamentSetting } from '../tournament-setting';

export class TournamentSettingFull{
    constructor(){
        this.tournamentSet = new TournamentSetting();
    }
    tournamentSet : TournamentSetting;
}