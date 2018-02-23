import React from 'react'
import PropTypes from 'prop-types'
import { Link } from 'react-router-dom'
import './styles/Nav.css'

const Nav = props => {
    const { user } = props;
    return (
        <nav className="navbar fixed-top">
            <div className="container">
                <Link to="/">Home</Link>
                <div className="my-2">
                    <img alt={user.handle} className="rounded-circle" src={`/images/${user.handle}.jpg`}/>
                </div>
            </div>
        </nav>
    )
}

Nav.propTypes = {
    user: PropTypes.object
}

export default Nav;
