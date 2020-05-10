import React, {Component} from "react";
import BASE_URL from "../Const";

class Film extends Component {

    runFilm = () => {
        document.getElementsByClassName("overlay")[0].style.display = "block";
        fetch(BASE_URL + "/run-film", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name: this.props.name}),
        })
            .then(() => document.getElementsByClassName("overlay")[0].style.display = "none");

        Array.prototype.forEach.call(document.getElementsByClassName("myfilm"),
            function(el) {
            el.style.backgroundColor = "white";
        });
        document.getElementById(this.props.name).style.backgroundColor = "#FFFFCC";
    };

    render() {
        return (
            <div>
                <li id={this.props.name} className="list-group-item myfilm">
                    <p onClick={this.runFilm}>
                        {this.props.name.length > 35 ?
                            this.props.name.substr(0,35) + "..." :
                            this.props.name}
                    </p>
                </li>
            </div>
        )
    }

}

export default Film