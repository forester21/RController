import React, {Component} from "react";
import BASE_URL from "../Const";

class Film extends Component {

    runFilm = () => {
        // alert("Run film: " + this.props.name)
        fetch(BASE_URL + "/run-film", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name: this.props.name}),

        })
    };

    render() {
        return (
            <div>
                <li className="list-group-item">
                    <p onClick={this.runFilm}>
                        {this.props.name}
                    </p>
                </li>
            </div>
        )
    }

}

export default Film