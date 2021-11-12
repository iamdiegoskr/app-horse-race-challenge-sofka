import React,{useContext} from 'react'
import { Store } from '../services/store/Store';
import FormPlayer from './FormPlayer';
import '../styles/SectionPlayers.css';

export const FormAddPlayers = () => {

    const { dispatch, state } = useContext(Store);

    const players = [];
    const showPlayerToAdd = ()=>{
        for (let i = 0; i < state.numberOfLanes; i++) {
            players.push(<div className="container-player-register">
                <p className="title-player">Jugador {i+1}</p>   <FormPlayer key={i}/>
            </div>);
        }
        return players;
    }

    console.log(state.numberOfLanes);

    return (
        <div className="section-players">
            <h2>INGRESE LOS DATOS DE LOS JUGADORES</h2>
            {showPlayerToAdd()}
        </div>
    )
}
