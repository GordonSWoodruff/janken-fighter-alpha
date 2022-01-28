import { useHistory } from 'react-router-dom';

import React, { Component, useState } from 'react';
import axios from 'axios';

function Winner() {
    let loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));
    let winner = localStorage.getItem("winner");
    return(
        <div className="main-content">
            <div className='middle'>
                <p>{winner}</p>
            </div>
        </div>
    );
}
export default Winner;