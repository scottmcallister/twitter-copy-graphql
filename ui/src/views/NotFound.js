import React from 'react';
import { Link } from 'react-router-dom';
import './styles/NotFound.css'

const NotFound = () => (
    <div>
        <nav key="nav-0" className="navbar fixed-top">
            <div className="container">
                <Link to="/"><img className="errorpage-bird" src="/images/logo.png" /></Link>
                <div className="my-2">
                    <Link to="/">Home →</Link>
                </div>
            </div>
        </nav>
        <div className="errorpage-content">
            <h1>Sorry, that page doesn't exist!</h1>
        </div>
    </div>
);

export default NotFound;