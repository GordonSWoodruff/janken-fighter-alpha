// https://getbootstrap.com/docs/5.0/examples/sticky-footer-navbar/
import axios from 'axios';
import { useState } from 'react';
import { useHistory } from 'react-router-dom';

function LogIn() {
    const history = useHistory();
    const [signInUser, setSignInUser] = useState({email: '', password: ''});
    const changeHandler = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        const tempSignIn = {...signInUser};
        tempSignIn[name] = value;
        setSignInUser(tempSignIn);
    };
    const signInSubmitHandler = () => {
        axios.post('http://localhost:8080/loginUser',signInUser).then(response => {
            localStorage.removeItem('signUpStepTwo');
            localStorage.setItem('loggedInUser',(response.data.userId));
            history.push('/sign-up2');
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        })
    }
    return (
        <form className="login-form">
            <input name="email" value={signInUser.email} className="form-input" type="text" placeholder="email" onChange={changeHandler} aria-label="email" />
            <input name="password" value={signInUser.password} className="form-input" type="password" placeholder="password" onChange={changeHandler} aria-label="password" />
            <button className="btn btn-outline-success" type="button" onClick={signInSubmitHandler}>Sign In to Continue...</button>
        </form>
    );
}
export default LogIn;