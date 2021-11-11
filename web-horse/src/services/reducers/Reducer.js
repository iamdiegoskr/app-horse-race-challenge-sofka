
export function reducer(state, action) {
    switch (action.type) {
        case 'create-game':
            return {
                ...action.payload.game,
                gameId: action.payload.data.gameId,
                kilometers: action.payload.data.kilometers,
                numberOfLanes: action.payload.data.numberOfLanes
            };
        default:
        return state;
    }
}