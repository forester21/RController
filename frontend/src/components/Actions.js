import React, {Component} from "react";

class Actions extends Component {

    sendAction = (action) => {
        console.log(action);
        fetch("http://192.168.1.66:8080/action", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({value: action}),
        })
    };

    buttons = [
        {name: 'pause', display: 'PAUSE/PLAY'},
        {name: 'volumeUp', display: 'Громче'},
        {name: 'volumeDown', display: 'Тише'},
        {name: 'seek-30', display: '-30s'},
        {name: 'seek+30', display: '+30s'},
        {name: 'seek-600', display: '-10m'},
        {name: 'seek+600', display: '+10m'},
        {name: 'stop', display: 'STOP'},
    ]

    render() {
        return (
            <div>
                <footer>
                    {this.buttons.map(it =>
                        <button type="button" className="btn btn-lg btn-primary"
                                onClick={() => this.sendAction(it.name)}>
                            {it.display}
                        </button>)}
                </footer>
            </div>
        )
    }
}

export default Actions