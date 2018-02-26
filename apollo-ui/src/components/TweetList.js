import React from 'react'
import { Link } from 'react-router-dom'
import PropTypes from 'prop-types'
import './styles/TweetList.css'

const monthNames = [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ];

const getTime = timestamp => {
    const date = new Date(timestamp);
    const currentDate = new Date();
    const microsecondsDiff = Math.abs(currentDate.getTime() - timestamp);
    console.log(microsecondsDiff);
    const hoursDiff = Math.floor(microsecondsDiff/(1000 * 60 * 60));
    if (hoursDiff < 24) {
        return `${hoursDiff} h`;
    } else {
        const sameYear = date.getFullYear() == currentDate.getFullYear();
        const month = monthNames[date.getMonth()];
        return ` ${month} ${date.getDate()} ${sameYear ? '' : date.getFullYear()}`;
    }
}

const TweetList = props => {
    const listOfTweets = props.tweets.map(tweet => (
        <div className="row tweet" key={tweet.id}>
            <div className="col-2">
                <img alt={tweet.author.handle} className="rounded-circle" style={{ width: 50, height: 50 }} src={`/images/${tweet.author.handle}.jpg`} />
            </div>
            <div className="col-10 text-left">
                <Link to={`/user/${tweet.author.id}`}><span className="font-weight-bold">{tweet.author.name} </span></Link>
                <span className="handle">@{tweet.author.handle}</span>
                <span className="handle">{getTime(tweet.timestamp)}</span>
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