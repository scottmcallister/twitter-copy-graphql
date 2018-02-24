import React from 'react'
import { Link } from 'react-router-dom'
import PropTypes from 'prop-types'
import './styles/TweetList.css'

const TweetList = props => {
    const listOfTweets = props.tweets.map(tweet => (
        <div className="row tweet" key={tweet.id}>
            <div className="col-2">
                <img alt={tweet.author.handle} className="rounded-circle" style={{ width: 50, height: 50 }} src={`/images/${tweet.author.handle}.jpg`} />
            </div>
            <div className="col-10 text-left">
                <Link to={`/user/${tweet.author.id}`}><span className="font-weight-bold">{tweet.author.name} </span></Link>
                <span className="handle">@{tweet.author.handle}</span>
            </div>
            <div className="col-10 offset-2 text-left">
                <p>{tweet.text}</p>
            </div>
        </div>
    ));
    return (<div className="tweet-list">{listOfTweets}</div>);
}

TweetList.propTypes = {
    tweets: PropTypes.array
}

export default TweetList;