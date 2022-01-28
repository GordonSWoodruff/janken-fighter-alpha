// Source code: https://getbootstrap.com/docs/5.0/forms/layout/
import Header from "../Header/Header";
import SignUp from "../SignUp/SignUp";
import SignUp2 from "../SignUp/SignUp2";
import SignUp3 from "../SignUp/SignUp3";
import Home from "../Home/Home";
import HomeLogged from '../Home/HomeLogged';
import Dojo from '../Dojo/Dojo';
import Arena from '../Arena/Arena';
import Settings from '../Settings/Settings';
import {Route, withRouter} from 'react-router-dom';
import Registered from '../Registered/Registered';
import AboutUs from "../AboutUs/AboutUs";
import LogIn from "../LogIn/LogIn.js";
import Winner from "../Arena/Winner.js";

function Layout() {
    const toggleRoutes = () => {
        if(localStorage.getItem('loggedInUser')) {
            return (
                <div className="main-content">
                    <Route exact path="/" component={HomeLogged} />
                    <Route path="/home-logged" component={HomeLogged} />
                    <Route path="/dojo" component={Dojo} />
                    <Route path="/arena" component={Arena} />
                    <Route path="/settings" component={Settings} />
                    <Route path="/sign-up2" component={SignUp2} />
                    <Route path="/sign-up3" component={SignUp3} />
                    <Route path="/registered" component={Registered} />
                    <Route path="/winner" component={Winner} />
                </div>
            );
        } else if(localStorage.getItem('signUpStepTwo')) {
            return (
                <div className="main-content">
                    <Route exact path="/" component={LogIn} />
                    <Route path="/login" component={LogIn} />
                </div>
            );
        } else {
            return (
                <div className="main-content">
                    <Route exact path="/" component={Home} />
                    <Route path="/home" component={Home} />
                    <Route path="/sign-up" component={SignUp} />
                </div>
            );
        }
    }
    if(localStorage.getItem('signUpStepTwo')) {
        return (
          <div>
              {toggleRoutes()}
          </div>  
        );
    } else {
        return(
            <div>
                <Header />
                <Route path="/about-us" component={AboutUs} />
                {toggleRoutes()}
            </div>
        );
    }
}
export default withRouter(Layout);