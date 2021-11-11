import React from 'react'
import {Link} from "react-router-dom";

const Navbar = () => {
    return (
        <nav className="navbar">
            <Link to="/">
                <img src="/assets/horseback.png" alt="horse race"/>
            </Link>
            <p className="title-app">Juego de carreras</p>
        </nav>
    )
}

export default Navbar;

