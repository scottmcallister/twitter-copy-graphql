import React, { Component } from 'react'
import { graphql } from 'react-apollo';
import gql from 'graphql-tag';
import TweetList from '../components/TweetList';

const ListOfTweets = gql`
    query ListOfTweets {
        allTweets {
            text
            author {
                handle
            }
        }
    }
`
class Home extends Component {
    render() {
        const { data } = this.props;
        const tweets = data.loading ? [] : data.allTweets;
        return (<div>
            <h1>Home</h1>
            { data.loading ? 'Loading...' : <TweetList tweets={tweets} /> }
        </div>)
    }
}
export default graphql(ListOfTweets)(Home);
