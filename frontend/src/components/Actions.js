import React, {Component} from "react";
import BASE_URL from "../Const";
import Reboot from "./Reboot";

class Actions extends Component {

    sendAction = (action) => {
        console.log(action);
        fetch(BASE_URL + "/action", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({value: action}),
        })
    };

    render() {
        return (
            <div className="container">
                <br/>
                <div className="row">
                    <div className="col">
                        <h1 className="d-flex justify-content-center">
                            <img src="https://image.flaticon.com/icons/svg/157/157101.svg" alt="qq"
                                 style={{width: '50px', height: '50px'}}
                                 onClick={() => this.sendAction('seek-600')}
                            />
                        </h1>
                    </div>
                    <div className="col">
                        <h1 className="d-flex justify-content-center">
                            <img src="https://image.flaticon.com/icons/svg/157/157078.svg" alt="qq"
                                 style={{width: '50px', height: '50px'}}
                                 onClick={() => this.sendAction('seek-30')}
                            />
                        </h1>
                    </div>
                    <div className="col">
                        <h1 className="d-flex justify-content-center">
                            ️<img src="https://image.flaticon.com/icons/svg/157/157093.svg" alt="qq"
                                  style={{width: '50px', height: '50px'}}
                                  onClick={() => this.sendAction('pause')}
                        />
                        </h1>
                    </div>
                    <div className="col">
                        <h1 className="d-flex justify-content-center">
                            <img src="https://image.flaticon.com/icons/svg/157/157103.svg" alt="qq"
                                 style={{width: '50px', height: '50px'}}
                            onClick={() => this.sendAction('seek+30')}/>
                        </h1>
                    </div>
                    <div className="col">
                        <h1 className="d-flex justify-content-center">
                            ️<img src="https://image.flaticon.com/icons/svg/157/157102.svg" alt="qq"
                                  style={{width: '50px', height: '50px'}}
                            onClick={() => this.sendAction('seek+600')}/>
                        </h1>
                    </div>
                </div>
                <div className="row">
                    <div className="col">
                        <h1 className="d-flex justify-content-start">
                            <img src="https://image.flaticon.com/icons/svg/157/157088.svg" alt="qq"
                                 style={{width: '50px', height: '50px'}}
                            onClick={() => this.sendAction('volumeDown')}/>
                        </h1>
                    </div>
                    <div className="col-6 d-flex justify-content-center">
                        <Reboot/>
                    </div>
                    <div className="col">
                        <h1 className="d-flex justify-content-end">
                            <img src="https://image.flaticon.com/icons/svg/157/157094.svg" alt="qq"
                                 style={{width: '50px', height: '50px'}}
                            onClick={() => this.sendAction('volumeUp')}/>
                        </h1>
                    </div>
                </div>
            </div>
        )
    }
}

export default Actions