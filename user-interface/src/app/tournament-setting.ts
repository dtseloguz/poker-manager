import { InfoPayment } from './infoPayment';

export class TournamentSetting{
    constructor(){
        this.name = "";
        this.discription ="";
        this.buyIn = new InfoPayment();
        this.addOn = new InfoPayment();
        this.reBuy = new InfoPayment();
    }
    name: string;
    discription: string;
    buyIn : InfoPayment;
    reBuy : InfoPayment;
    addOn : InfoPayment;
}