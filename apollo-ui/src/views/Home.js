import React, { Component } from 'react'
import { graphql } from 'react-apollo';
import gql from 'graphql-tag';
import TweetList from '../components/TweetList';
import Nav from '../components/Nav';
import ProfileCard from '../components/ProfileCard';

const ListOfTweets = gql`
    query ListOfTweets {
        allTweets {
            id
            text
            author {
                name
                handle
                id
            }
        }
    }
`
const loggedIn = true;
const user = {
    name: 'Donald J. Trump',
    handle: 'realDonaldTrump'
}

class Home extends Component {
    render() {
        const { data } = this.props;
        const tweets = data.loading ? [] : data.allTweets;
        return (<div>
            <Nav loggedIn={loggedIn} user={user} />
            <div className="container">
                { data.loading ? 'Loading...' : 
                    <div className="row">
                        <ProfileCard user={user} /><TweetList tweets={tweets} />
                    </div>
                }
            </div>
        </div>)
    }
}
export default graphql(ListOfTweets)(Home);
