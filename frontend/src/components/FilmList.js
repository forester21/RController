import React, {Component} from 'react'
import Film from "./Film";
import BASE_URL from "../Const";

class FilmList extends Component {

    state = {
        films: [],
    };

    componentDidMount() {
        document.getElementsByClassName("overlay")[0].style.display = "block";
        fetch(BASE_URL + "/films", {method: 'GET'})
            .then(response => response.json())
            .then(films => this.setState(state => state.films = films))
            .then(() => document.getElementsByClassName("overlay")[0].style.display = "none");
    }

    getFilms() {
        return this.state.films.map(it => <Film key={it} name={it}/>)
    }

    render() {
        return (
            <div>
                <ul className="list-group">
                    {this.getFilms()}
                </ul>
            </div>
        )
    }
}

export default FilmList