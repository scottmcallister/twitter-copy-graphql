import React, { Component } from 'react';
import './styles/Login.css';

class Login extends Component {
    render() {
        return (
            <div className="login-page-container">
                <nav key="nav-0" className="navbar fixed-top">
                    <div className="nav-content">
                        <img className="loginpage-bird" src="/images/logo.png" />
                    </div>
                </nav>
                <div className="login-form-container">
                    <div className="login-form-content">
                        <h3>Log in to Twitter</h3>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;
