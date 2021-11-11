import { createContext } from 'react';
import {initialState} from './InitialState'

export const Store = createContext(initialState);