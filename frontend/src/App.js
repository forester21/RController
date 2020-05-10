import React, {Component} from 'react';
import './App.css';
import FilmList from "./components/FilmList";
import Actions from "./components/Actions";
import NavBar from "./components/NavBar";
import Utils from "./components/Utils";

class App extends Component {

    render() {
        return (
            <div>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
                      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
                      crossOrigin="anonymous"/>
                <NavBar/>
                <div id='films' className='my-page'>
                    <main style={{'padding-bottom': '200px'}}>
                        <FilmList/>
                    </main>
                    <div className="fixed-bottom" style={{'background-color': 'white'}}>
                        <Actions/>
                    </div>
                    <div className="overlay">
                        <div className="spinner-border text-warning" role="status"
                             style={{width: '8rem', height: '8rem'}}>
                            <span className="sr-only">Loading...</span>
                        </div>
                    </div>
                </div>
                <div id='utils' style={{display: 'none'}} className='my-page'>
                    <Utils/>
                </div>
            </div>
        );
    }
}

export default App;
