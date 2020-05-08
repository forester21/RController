import React, {Component} from "react";
import BASE_URL from "../Const";

class Reboot extends Component {

    reboot = () => {
        if (window.confirm('REBOOT device?')){
            fetch(BASE_URL + "/reboot")
        }
    };

    render() {
        return (
            <div>
                <h2 onClick={() => this.reboot()}>
                    RController21
                </h2>
            </div>
        )
    }
}

export default Reboot