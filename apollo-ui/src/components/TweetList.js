import React from 'react'
import PropTypes from 'prop-types'
import './styles/TweetList.css'
const TweetList = props => {
    const listOfTweets = props.tweets.map(tweet => (
        <div className="row">
                <div className="col-2">
                    <img className="rounded-circle" style={{ width: 50, height: 50 }} src={`/images/${tweet.author.handle}.jpg`} />
                </div>
                <div className="col-10 text-left">
                    <span className="font-weight-bold">{tweet.author.name} </span>
                    <span className="handle">@{tweet.author.handle}</span>
                </div>
                <div className="col-10 offset-2 text-left">
                    <p>{tweet.text}</p>
                </div>
            
        </div>
    ));
    return (<div className="col-8">{listOfTweets}</div>);
}
TweetList.propTypes = {
    tweets: PropTypes.array
}
export default TweetList;