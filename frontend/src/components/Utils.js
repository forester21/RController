import React, {Component} from "react";
import BASE_URL from "../Const";

class Utils extends Component {

    reboot = () => {
        if (window.confirm('REBOOT device?')){
            fetch(BASE_URL + "/reboot")
        }
    };

    render() {
        return (
            <div>
                <br/>
                <div className="row">
                    <div className="col">
                        <div className="d-flex justify-content-center">
                            <h1>RAM:</h1>
                        </div>
                        <div className="d-flex justify-content-center">
                            <h1>25%</h1>
                        </div>
                    </div>
                    <div className="col">
                        <div className="d-flex justify-content-center">
                            <h1>DISK:</h1>
                        </div>
                        <div className="d-flex justify-content-center">
                            <h1>50%</h1>
                        </div>
                    </div>
                </div>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <div className="row">
                    <div className="col">

                    </div>
                    <div className="col">
                        <div className="d-flex justify-content-center">
                            <img src="https://image.flaticon.com/icons/svg/157/157100.svg" alt="reboot"
                                 style={{width: '100px', height: '100px'}} onClick={() => this.reboot()}/>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Utils