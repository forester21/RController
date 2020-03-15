import React, {Component} from 'react';
import './App.css';
import FilmList from "./components/FilmList";
import Actions from "./components/Actions";

class App extends Component {

    render() {
        return (
            <div>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
                      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
                      crossOrigin="anonymous"/>
                <FilmList/>
                <Actions/>
            </div>
        );
    }
}

export default App;
