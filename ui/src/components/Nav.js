import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { Link } from 'react-router-dom'
import './styles/Nav.css'
import NewTweetOverlay from './NewTweetOverlay'

class Nav extends Component {
    constructor(props) {
        super(props);
        this.toggleNewTweet.bind(this);
    }

    toggleNewTweet() {
        this.tweetOverlay.toggleShow();
    }
    
    render(){
        const { user } = this.props;
        return (
            [<nav key="nav-0" className="navbar fixed-top">
                <div className="container">
                    <Link to="/">Home</Link>
                    <div className="my-2">
                        <img alt={user.handle} className="rounded-circle" src={`/images/${user.handle}.jpg`}/>
                        <button className="tweet-button" onClick={() => this.toggleNewTweet()}>Tweet</button>
                    </div>
                </div>
            </nav>,
            <NewTweetOverlay key="nav1" onRef={ref => (this.tweetOverlay = ref)} loggedInUserId={user.id} />]
        )
    }
}

Nav.propTypes = {
    user: PropTypes.object
}

export default Nav;
