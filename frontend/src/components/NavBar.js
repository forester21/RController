import React, {Component} from "react";
import BASE_URL from "../Const";

class NavBar extends Component {

    state = {
        activeNav: 'films'
    };

    choosePage(pageId) {
        Array.prototype.forEach.call(document.getElementsByClassName("my-page"),
            function(el) {
                el.style.display = "none";
            });
        document.getElementById(pageId).style.display = 'block';
        this.setState(state => state.activeNav = pageId);
    };

    render() {
        return (
            <div>
                <nav className="navbar navbar-light bg-light justify-content-between flex-nowrap flex-row">
                    <div className="container">
                        <ul className="nav navbar-nav flex-row float-left">
                            <li id='filmsNav' className={this.state.activeNav === "films" ? "nav-item active" : "nav-item "}>
                                <a className="nav-link pr-3" onClick={() => this.choosePage('films')}>Films</a>
                            </li>
                            <li id='utilsNav' className={this.state.activeNav === 'utils' ? 'nav-item active' : 'nav-item '}>
                                <a className="nav-link" onClick={() => this.choosePage('utils')}>Utils</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        )
    }

}

export default NavBar