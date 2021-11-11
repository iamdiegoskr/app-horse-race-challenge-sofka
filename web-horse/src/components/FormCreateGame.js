import React,{useState}from 'react'
import '../styles/FormCreateGame.css'
import uuid from 'react-uuid'

const FormCreateGame = () => {

    const [data, setData] = useState({
        kilometers:'',
        numberOfLanes:0
    })


    const handleInputChange = e => {
        setData({
            ...data,
            [e.target.name] : e.target.value
        })
    }

    const onSubmit = e => {
        e.preventDefault();

        const body = {
            gameId: uuid(),
            kilometers:data.kilometers,
            numberOfLanes:data.numberOfLanes
        }
        // validateInput(data) && dispatch(postQuestion(data));
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
                    </select>
                </div>
                <div>
                    <label htmlFor="numberoflines">Numero de carriles : </label>
                    <input
                        name="numberOfLanes"
                        type="number"
                        id="numberoflines"
                        min="2"
                        max="8"
                        onChange={handleInputChange}
                    />
                </div>
                <button type="submit" className="btn-create-game">Crear juego</button>
            </form>
        </section>
    )
}

export default FormCreateGame;
