export interface Match {
    metadata: Metadata;
    info: MatchInfo;
}

export interface Metadata {
    dataVersion: string;
    matchId: string;
    participants: string[];
}

export interface MatchInfo {
    gameId: string;
    gameMode: string;
    platformId: string;
    gameStartTimestamp: number;
    participants: MatchParticipant[];
    teams: Team[];
}

export interface MatchParticipant {
    championId: number;
    championName: string;
    participantId: number;
    teamId: number;
    kills: number;
    deaths: number;
    assists: number;
    goldSpent: number;
}

export interface Team {
    teamId: number;
    win: boolean;
}
