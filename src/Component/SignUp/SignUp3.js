// Source code: https://getbootstrap.com/docs/5.0/forms/layout/
import axios from 'axios';
import { useState } from 'react';
import {useHistory} from 'react-router-dom';

function SignUp3() {
    let loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));
    const history = useHistory();
    const [chooseMoveset, setMoveset] = useState({chiMove: '', kenMove: '', seiMove: '', surpriseMove: ''});
    const changeHandler = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        const tempMoveset = {...chooseMoveset};
        tempMoveset[name] = value;
        setMoveset(tempMoveset);
    };
    const signUpSubmitHandler = () => {
        axios.post('http://localhost:8080/chooseMoveset',chooseMoveset).then(response => {
            history.push('/registered');
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        })
    }
    return (
        <div>
            <form className="moveset-select">
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th>Moveset</th>
                            </tr>
                        </thead>
                    <tbody>
                        <tr>
                            <td>Chisei Move</td>
                            <td>{loggedInUser.moveset.chiMove.moveName}</td>
                            <td>{loggedInUser.moveset.chiMove.moveDesc}</td>
                        </tr>
                        <tr>
                            <td>Ken Move</td>
                            <td>{loggedInUser.moveset.kenMove.moveName}</td
                            ><td>{loggedInUser.moveset.kenMove.moveDesc}</td>
                        </tr>
                        <tr>
                            <td>Seishin Move</td>
                            <td>{loggedInUser.moveset.seiMove.moveName}</td>
                            <td>{loggedInUser.moveset.seiMove.moveDesc}</td>
                        </tr>
                        <tr>
                            <td>Surprise Move</td>
                            <td>{loggedInUser.moveset.surpriseMove.moveName}</td>
                            <td>{loggedInUser.moveset.surpriseMove.moveDesc}</td>
                        </tr>
                    </tbody>
                    </table>
                    <div className="button">
                        <button type="submit" className="btn btn-primary" onClick={signUpSubmitHandler}>Continue...</button>
                    </div>
                </div>
            </form>
        </div>
    );
}
export default SignUp3;