// Source code: https://getbootstrap.com/docs/5.0/forms/layout/
import React from 'react';
import axios from 'axios';
import { useState } from 'react';
import { useHistory } from 'react-router-dom';
import chiseiIcon from '../../assets/ChiseiIcon.png';
import kenIcon from '../../assets/KenIcon.png';
import seishinIcon from '../../assets/SeishinIcon.png';
import hPIcon from '../../assets/HPIcon.png';
import pWIcon from '../../assets/PWIcon.png';
import attackIcon from '../../assets/AttackIcon.png';
import defenseIcon from '../../assets/DefenseIcon.png';


function SignUp() {
    const history = useHistory();
    const [signUpUser, setSignUpUser] = useState({email: '', userName: '', password: '', userStats: {
        chisei: 1, ken: 1, seishin: 1, hit: 10, pwr: 1, attack: 1, defense: 1
    }}
    );
    const changeHandler = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        const tempSignUp = {...signUpUser};
        tempSignUp[name] = value;
        setSignUpUser(tempSignUp);
    };
    const changeStatHandler = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        const tempSignUp = {...signUpUser};
        tempSignUp.userStats[name] = value;
        setSignUpUser(tempSignUp);
    }
    const signUpSubmitHandler = () => {
        axios.post("http://localhost:8080/saveUser",signUpUser).then(response => {
            localStorage.setItem("signUpStepTwo",true);
            history.push('/login');
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        })
    }
    return (
        <div className = "sign-up-container container">
            <form className="row g-3">
                <h2>Register for Battle</h2>
                <div className="col-md-6">
                    <label htmlFor="inputEmail" className="form-label">Email:</label>
                    <input name="email" value={signUpUser.email} type="email" className="form-control" id="inputEmail" onChange={changeHandler} />
                </div>
                <div className="col-12">
                    <label htmlFor="inputUserName" className="form-label">User Name:</label>
                    <input name="userName" value={signUpUser.userName} type="text" className="form-control" id="inputUserName" placeholder="Training Dummy" onChange={changeHandler} />
                </div>
                <div className="col-md-12">
                    <label htmlFor="inputPassword" className="form-label">Password</label>
                    <input name="password" value={signUpUser.password} type="password" className="form-control" id="inputPassword" onChange={changeHandler} />
                </div>
                <table>
                    <thead>
                        <tr>
                            <th className="stat">Chisei</th>
                            <th className="stat">Ken</th>
                            <th className="stat">Seishin</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td className="stat"><img className="icon" src={chiseiIcon} /></td>
                            <td className="stat"><img className="icon" src={kenIcon} /></td>
                            <td className="stat"><img className="icon" src={seishinIcon} /></td>
                        </tr>
                        <tr>
                            <td className="stat"><span className='center' onChange={changeStatHandler}>{signUpUser.userStats.chisei}</span></td>
                            <td className="stat"><span className='center' onChange={changeStatHandler}>{signUpUser.userStats.ken}</span></td>
                            <td className="stat"><span className='center' onChange={changeStatHandler}>{signUpUser.userStats.seishin}</span></td>
                        </tr>
                        <tr>
                            <th className="stat">Hit Points</th>
                            <th className="stat">Power Level</th>
                            <th className="stat">Attack</th>
                            <th className="stat">Defense</th>
                        </tr>
                        <tr>
                            <td className="stat"><img className="icon" src={hPIcon} /></td>
                            <td className="stat"><img className="icon" src={pWIcon} /></td>
                            <td className="stat"><img className="icon" src={attackIcon} /></td>
                            <td className="stat"><img className="icon" src={defenseIcon} /></td>
                        </tr>
                        <tr>
                            <td className="stat"><span className='center' onChange={changeStatHandler}>{signUpUser.userStats.hit}</span></td>
                            <td className="stat"><span className='center' onChange={changeStatHandler}>{signUpUser.userStats.pwr}</span></td>
                            <td className="stat"><span className='center' onChange={changeStatHandler}>{signUpUser.userStats.attack}</span></td>
                            <td className="stat"><span className='center' onChange={changeStatHandler}>{signUpUser.userStats.defense}</span></td>
                        </tr>
                    </tbody>
                </table>
                <div className="col-12">
                    <button type="button" className="btn btn-primary" onClick={signUpSubmitHandler}>Continue...</button>
                </div>
            </form>
        </div>
    );
}
export default SignUp;