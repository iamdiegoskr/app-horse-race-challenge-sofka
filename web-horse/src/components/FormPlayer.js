import React from 'react'
import '../styles/FormPlayer.css'

const FormPlayer = () => {
    return (
        <form className="formPlayer">
            <input type="text" name="playerName" placeholder="Ingrese nombre del jugador..." required/>
            <input type="text" name="playerIdentity" placeholder="Ingrese cedula del jugador..." required/>
        </form>
    )
}

export default FormPlayer;