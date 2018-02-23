import React, { Component } from 'react'
import { graphql, compose } from 'react-apollo';
import gql from 'graphql-tag';
import TweetList from '../components/TweetList';
import Nav from '../components/Nav';
import ProfileCard from '../components/ProfileCard';

const ListOfTweets = gql`
    query {
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
`;
const getLoggedInUser = gql`
    query {
        loggedInUser @client {
            name
            handle
        }
    }
`;

class Home extends Component {
    render() {
        const { data, loggedInUser } = this.props;
        const tweets = data.loading ? [] : data.allTweets;
        console.log(this.props);
        return (<div>
            <Nav user={loggedInUser} />
            <div className="container">
                { data.loading ? 'Loading...' : 
                    <div className="row">
                        <ProfileCard user={loggedInUser} /><TweetList tweets={tweets} />
                    </div>
                }
            </div>
        </div>)
    }
}
export default compose(
    graphql(getLoggedInUser, {
        props: ({ data: { loggedInUser, loading } }) => ({
            loggedInUser,
            loading
        })
    }),
    graphql(ListOfTweets)
)(Home);
