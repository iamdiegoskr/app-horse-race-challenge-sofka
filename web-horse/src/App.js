import './App.css';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import HorseRacePage from './pages/HorseRacePage';
import FormCreateGame from './components/FormCreateGame';
import StoreProvider from './services/store/StoreProvider';
import { FormAddPlayers } from './components/FormAddPlayers';

import {
  BrowserRouter,
  Routes,
  Route,
  Link
} from "react-router-dom";

function App() {
  return (
    <StoreProvider>
      <BrowserRouter>
          <Navbar/>
          <Routes>
              <Route path="/" element={<HomePage />} />
              <Route path="/createGame" element={<FormCreateGame/>} />
              <Route path="/addPlayer" element={<FormAddPlayers/>}/>
              <Route path="/horseRace" element={<HorseRacePage />} />
          </Routes>
      </BrowserRouter>
    </StoreProvider>
  );
}

export default App;
