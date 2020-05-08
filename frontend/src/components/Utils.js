import React, {Component} from "react";
import BASE_URL from "../Const";

class Utils extends Component {

    reboot = (action) => {
        fetch(BASE_URL + "/reboot")
    };

    render() {
        return (
            <div>
                <button type="button" className="btn btn-lg btn-primary"
                        onClick={() => this.reboot()}>
                    REBOOT!
                </button>
            </div>
        )
    }
}

export default Utils