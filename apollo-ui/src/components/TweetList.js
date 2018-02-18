import React from 'react'
import PropTypes from 'prop-types'
const TweetList = props => {
    const listOfTweets = props.tweets.map(tweet => (
        <div className="tweet">
            <h3>@{tweet.author.handle}</h3>
            <p>{tweet.text}</p>
        </div>
    ));
    return (<div className="tweetList">{listOfTweets}</div>);
}
TweetList.propTypes = {
    tweets: PropTypes.array
}
export default TweetList;