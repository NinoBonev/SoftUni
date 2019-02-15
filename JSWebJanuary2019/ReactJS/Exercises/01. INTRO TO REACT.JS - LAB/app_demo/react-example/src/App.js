import React, {Component} from 'react';
import './App.css';
import Welcome from './components/Welcome'

class App extends Component {
    render() {
        return (
            <div>
                <Welcome name1='Nino' name2='Vesy'/>
            </div>
        );
    }
}

export default App;
