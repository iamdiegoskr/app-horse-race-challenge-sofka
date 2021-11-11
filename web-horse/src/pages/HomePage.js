import React from 'react'
import {Link} from "react-router-dom";


const HomePage = () => {
    return (
        <div className="welcome-container">
            <div className="welcome">
                <img src="/assets/horsebackground2.svg" alt="horse race" className="horse-image-main"/>
                <div className="info">
                    <h2 className="welcome-title">BIENVENIDO</h2>
                    <img src="/assets/winner.png" alt="flag"/>
                    <p className="welcome-text">Bienvenido a este increible juego de carreras</p>
                    <Link to="/horseRace" className="btn-welcome">COMENZAR</Link>
                </div>
            </div>
        </div>
    )
}

export default HomePage;
