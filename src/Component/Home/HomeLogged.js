import React from "react";

const HomeLogged = () => {
    let loggedInUser = localStorage.getItem("loggedInUser");
    let loggedInName = localStorage.getItem("loggedInName");
    loggedInUser = Number.parseInt(loggedInUser,10);
    return (
        <div className="playableScreen">
            <h1 className="headers">Welcome to Janken Fighter, {loggedInName}!</h1>
            <h4 className="headers">You are currently logged in as User #{loggedInUser}.</h4>
        </div>
    );
}
export default HomeLogged;