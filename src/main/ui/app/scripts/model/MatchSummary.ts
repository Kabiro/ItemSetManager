export interface MatchSummary {
    gameId: string ;
    gameMode: string ;
    platformId: string ;
    gameStartTimestamp: number ;
    teamA: Team ;
    teamB: Team ;
}

export interface Team {
    players: TeamPlayer[];
}

export interface TeamPlayer {
    championId: number;
    championName: string;
}
