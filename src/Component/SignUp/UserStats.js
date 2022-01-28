import React from "react";

class UserStats extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            chisei: 1,
            ken: 1,
            seishin: 1,
            attack: 1,
            defense: 1,
            hit: 1,
            pwr: 1
        };
    }
    render() {
        return(
            <div>
                <table>
                    <thead>
                        <tr>
                            <th className="stat">Chisei</th>
                            <th className="stat">Ken</th>
                            <th className="stat">Seishin</th>
                            <th className="stat">Hit Points</th>
                            <th className="stat">Power Level</th>
                            <th className="stat">Attack</th>
                            <th className="stat">Defense</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        
                        </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}