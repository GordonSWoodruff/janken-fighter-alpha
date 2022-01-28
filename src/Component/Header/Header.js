// https://getbootstrap.com/docs/5.0/examples/sticky-footer-navbar/
import axios from 'axios';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import { useHistory } from 'react-router-dom';
import jFALogo from '../../assets/JFALogo.png';

const Header = () => {
    const history = useHistory();
    const [signInUser, setSignInUser] = useState({
        email: '',
        password: ''
    });
    const changeHandler = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        const tempSignIn = {...signInUser};
        tempSignIn[name] = value;
        setSignInUser(tempSignIn);
    };
    const signInSubmitHandler = () => {
        axios.post('http://localhost:8080/loginUser',signInUser).then(response => {
            localStorage.setItem('loggedInUser',(response.data.userId));
            localStorage.setItem('loggedInName',(response.data.userName));
            history.push('/home-logged');
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        })
    }
    let params = {
        userId: 900
    };
    const callOpponent = () => {
        axios.get('http://localhost:8080/findUserById',{params}).then(response => {
            localStorage.setItem('arenaOpponent',(response.data.userId));
            console.log("Summoning opponent, ", response.data.userName, ", now!");
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        })
    }
    const signOut = () => {
        localStorage.clear();
    }
    const toggleDisplay = () => {
        if(localStorage.getItem('loggedInUser')) {
            return (
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav me-auto mb-2 mb-md-0">
                        <li className="nav-item">
                            <Link className="nav-link active" aria-current="page" to="/settings">Settings</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link active" to="/dojo">Dojo</Link>
                        </li>
                        <li className="nav-item">
                            <button className="btn btn-outline-success" type="button" onClick={callOpponent}><Link className="nav-link active" to="/arena">Arena</Link></button>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link active" to="/about-us" >About Us</Link>
                        </li>
                    </ul>
                    <form className="d-flex">
                        <button className="btn btn-outline-success" type="button" onClick={signOut}><Link className="no-decoration" to="/">Sign Out</Link></button>
                    </form>
                </div>
            );
        } else {
            return (
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav me-auto mb-2 mb-md-0">
                        <li className="nav-item">
                            <Link className="nav-link active" aria-current="page" to="/sign-up">Sign Up</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link active" to="/about-us" >About Us</Link>
                        </li>
                    </ul>
                    <form className="d-flex">
                        <input name="email" value={signInUser.email} className="form-control me-2" type="text" placeholder="email" onChange={changeHandler} aria-label="email" />
                        <input name="password" value={signInUser.password} className="form-control me-2" type="password" placeholder="password" onChange={changeHandler} aria-label="password" />
                        <button className="btn btn-outline-success" type="button" onClick={signInSubmitHandler}>Sign In</button>
                    </form>
                </div>
                );
            }
        }
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <div className="container-fluid mb-5">
                    <Link className="navbar-brand" to="/">Janken Fighter Alpha</Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle Navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <img src={jFALogo} className='main-logo' />
                </div>
                {toggleDisplay()}
            </nav>
        </header>
    );
}
export default Header;