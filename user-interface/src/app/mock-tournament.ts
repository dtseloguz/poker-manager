import {TournamentSettingFull} from './tournament-setting-full';
import {ROUNDS} from './mock-rounds';

export const TOURNAMENTSETTING: TournamentSettingFull = {
    tournamentSet:{
        rounds:ROUNDS,
        name:"Main Event",
        discription:"Main tournament of this Series",
        buyIn:{rake:10, buyIn:1,stack:1000},
        reBuy:{rake:10, buyIn:1,stack:1000},
        addOn:{rake:20, buyIn:2,stack:10000},
    },
    rebuyBut: false,
    AddOnBut:false,
}