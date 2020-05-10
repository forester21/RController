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
                <img src="https://image.flaticon.com/icons/svg/157/157100.svg" alt="reboot"
                     style={{width: '50px', height: '50px'}} onClick={() => this.reboot()}/>
            </div>
        )
    }
}

export default Reboot