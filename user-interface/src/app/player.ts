export class Player{
    constructor(){
        this.name= "";
        this.surname= "";
        this.midname= "";
        this. age= 0;
        this.payment = false;
        this.paymentData="";
        this.paymentOffData= "";
        this.selected= false;
        this.changed=true; 
    }
    name: string;
    surname: string;
    midname: string;
    age: number;
    payment : boolean;
    paymentData: string;
    paymentOffData: string;
    selected: boolean;
    changed: boolean;
}