import { InfoPayment } from './infoPayment';
import {Round} from './round';

export class TournamentSetting{
    constructor(){
        this.name = "";
        this.discription ="";
        this.buyIn = new InfoPayment();
        this.addOn = new InfoPayment();
        this.reBuy = new InfoPayment();
    }
    rounds: Round[];
    name: string;
    discription: string;
    buyIn : InfoPayment;
    reBuy : InfoPayment;
    addOn : InfoPayment;
}