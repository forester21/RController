import React, {Component} from 'react'
import Film from "./Film";
import BASE_URL from "../Const";

class FilmList extends Component {

    state = {
        films: [],
    };

    componentDidMount() {
        fetch(BASE_URL + "/films", {method: 'GET'})
            .then(response => response.json())
            .then(films => this.setState(state => state.films = films))
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