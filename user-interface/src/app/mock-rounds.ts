import {Round} from './round'

export const ROUNDS: Round[] = [
    {   levelNumber: 1,levelType:true, gameName:"Texas Hold'Em", gameType: "No Limit", duration: 20,
        ante:200, smallBlind: 100, bigBlind: 200, startTime: "0:00", chipUp: false,
    },
    {   levelNumber: 2,levelType:true, gameName:"Texas Hold'Em", gameType: "No Limit", duration: 20,
        ante:300, smallBlind: 150, bigBlind: 300, startTime: "0:20", chipUp: false,
    },
    {   levelNumber: 3,levelType:true, gameName:"Texas Hold'Em", gameType: "No Limit", duration: 20,
        ante:400, smallBlind: 200, bigBlind: 400, startTime: "0:40", chipUp: false,
    },
    {   levelNumber: 1,levelType:false, gameName:"Texas Hold'Em", gameType: "No Limit", duration: 10,
        ante:0, smallBlind: 0, bigBlind: 0, startTime: "1:00", chipUp: false,
    },
    {   levelNumber: 4,levelType:true, gameName:"Texas Hold'Em", gameType: "No Limit", duration: 20,
        ante:500, smallBlind: 250, bigBlind: 500, startTime: "1:10", chipUp: true,
    },
]