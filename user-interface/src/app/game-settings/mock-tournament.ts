import {TournamentSettingFull} from './tournament-setting-full';
import { TournamentSetting } from '../tournament-setting';

export const TOURNAMENTSETTING: TournamentSettingFull = new TournamentSettingFull();
TOURNAMENTSETTING.tournamentSet.name = "Main Event";
TOURNAMENTSETTING.tournamentSet.discription = "Main tournament of this Series";
TOURNAMENTSETTING.tournamentSet.buyIn.buyIn=10;
TOURNAMENTSETTING.tournamentSet.buyIn.rake=1;
TOURNAMENTSETTING.tournamentSet.buyIn.stack = 1000;
TOURNAMENTSETTING.tournamentSet.reBuy.buyIn=10;
TOURNAMENTSETTING.tournamentSet.reBuy.rake=1;
TOURNAMENTSETTING.tournamentSet.reBuy.stack = 1000;
TOURNAMENTSETTING.tournamentSet.addOn.buyIn=20;
TOURNAMENTSETTING.tournamentSet.addOn.rake=2;
TOURNAMENTSETTING.tournamentSet.addOn.stack = 10000;