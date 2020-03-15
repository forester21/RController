import React, {Component} from "react";

class Film extends Component {

    runFilm = () => {
        // alert("Run film: " + this.props.name)
        fetch("http://192.168.1.66:8080/run-film", {
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