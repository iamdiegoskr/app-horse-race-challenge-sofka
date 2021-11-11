import './App.css';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import HorseRacePage from './pages/HorseRacePage';
import FormCreateGame from './components/FormCreateGame';

import {
  BrowserRouter,
  Routes,
  Route,
  Link
} from "react-router-dom";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/createGame" element={<FormCreateGame/>} />
        <Route path="/horseRace" element={<HorseRacePage />} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
