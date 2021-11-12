import React from 'react'
import '../styles/FormPlayer.css'

const FormPlayer = () => {
    return (
        <form className="formPlayer">
            <input type="text" name="playerName" placeholder="Ingrese nombre del jugador..."/>
            <input type="text" name="playerIdentity" placeholder="Ingrese cedula del jugador..."/>
        </form>
    )
}

export default FormPlayer;