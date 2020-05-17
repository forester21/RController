import React, {Component} from "react";
import BASE_URL from "../Const";

class Utils extends Component {

    state = {
        monitoringInfo : {
            usedMemory : null,
            cpu : null,
            freeDiskMemory: null,
            usedDiskMemory : null
        }
    };

    reboot = () => {
        if (window.confirm('REBOOT device?')){
            fetch(BASE_URL + "/reboot")
        }
    };

    getMonitoringInfo = () => {
            fetch(BASE_URL + "/" + "monitoring")
                .then(response => response.json())
                .then(info => this.setState(state => state.monitoringInfo = info))
    };

    getValueOrDefault(val){
      return val == null ? 'N/A' : val
    };

    componentDidMount() {
        this.getMonitoringInfo();
        setInterval(this.getMonitoringInfo, 3000);
    }

    render() {
        return (
            <div>
                <br/>
                <div className="row">
                    <div className="col">
                        <div className="d-flex justify-content-center">
                            <h2>RAM:</h2>
                        </div>
                        <div className="d-flex justify-content-center">
                            <h2>{this.getValueOrDefault(this.state.monitoringInfo.usedMemory)}</h2>
                        </div>
                    </div>
                    <div className="col">
                        <div className="d-flex justify-content-center">
                            <h2>DISK:</h2>
                        </div>
                        <div className="d-flex justify-content-center">
                            <h2>{this.getValueOrDefault(this.state.monitoringInfo.usedDiskMemory)}</h2>
                        </div>
                    </div>
                    <div className="col">
                        <div className="d-flex justify-content-center">
                            <h2>AVAIL:</h2>
                        </div>
                        <div className="d-flex justify-content-center">
                            <h2>{this.getValueOrDefault(this.state.monitoringInfo.freeDiskMemory)}</h2>
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