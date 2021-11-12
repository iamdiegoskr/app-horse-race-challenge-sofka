import React,{useState,useContext}from 'react'
import '../styles/FormCreateGame.css'
import uuid from 'react-uuid'
import { Store } from '../services/store/Store';
import {useNavigate} from 'react-router-dom';
//import { Redirect } from 'react-router'

const FormCreateGame = () => {

    const navigate = useNavigate();

    const { game, dispatch } = useContext(Store);

    const [data, setData] = useState({
        kilometers:'100',
        numberOfLanes:3
    })


    const handleInputChange = e => {
        setData({
            ...data,
            [e.target.name] : e.target.value
        })
    }

    const onSubmit = e => {


        console.log("holaa");

        e.preventDefault();

        const body = {
            type: "sofkau.game.creategame",
            gameId:uuid(),
            kilometers:data.kilometers,
            numberOfLanes:data.numberOfLanes
        };

        fetch("http://localhost:8080/api/createGame", {
        method: "POST",
        body: JSON.stringify(body),
        headers: {
            'Content-Type': 'application/json'
        }
        })
        .then(response => {
            dispatch({
                type: 'create-game',
                payload: {
                    data: {
                        gameId: uuid(),
                        kilometers:data.kilometers,
                        numberOfLanes:data.numberOfLanes
                    },
                }
            });
            console.log(response);
            if(response.status === 200){
                navigate('/addPlayer');
            }
        })

    }

    return (
        <section className="section-create-game">
            <h1>NUEVO JUEGO</h1>

            <form className="formCreateGame" onSubmit={onSubmit}>
                <div>
                    <label htmlFor="kilometers">Seleccione la cantidad de kilometros que tiene la carrera : </label>
                    <select name="kilometers" id="kilometers" onChange={handleInputChange}>
                        <option value="100">100 METROS</option>
                        <option value="200">200  METROS</option>
                        <option value="300">300 METROS</option>
                        <option value="500">500 METROS</option>
                        <option value="1000">1000 METROS</option>
                    </select>
                </div>
                <div>
                    <label htmlFor="numberoflines">Numero de carriles : </label>
                    <input
                        name="numberOfLanes"
                        type="number"
                        id="numberoflines"
                        min="3"
                        max="8"
                        value={data.numberOfLanes}
                        onChange={handleInputChange}
                    />
                </div>
                <button type="submit" className="btn-create-game">Crear juego</button>
            </form>
        </section>
    )
}

export default FormCreateGame;
