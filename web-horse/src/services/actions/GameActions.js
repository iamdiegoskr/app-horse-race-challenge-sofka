const BASE_URL = "http://localhost:8080/api";

export const createGameAction = async (dataGame) => {

    console.log("entrando al game action");
    const { gameId, kilometers, numberOfLanes } = dataGame;

    const body = {
        type: "sofkau.game.creategame",
        gameId,
        kilometers,
        numberOfLanes
    };
    try {
        const res = await fetch(`${BASE_URL}/createGame`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(body),
    });

    const status = res.status;
    const statusText = res.statusText;

    const values = { status, statusText };
    console.log(values);
    return values;
    } catch (err) {
        console.log(err);
    }
};