import React from 'react'
import { withRouter } from 'react-router-dom';
import { graphql } from 'react-apollo';
import gql from 'graphql-tag';

const UserProfile = gql`
    query UserProfile($userId: ID!) {
        user(id: $userId) {
            name
            handle
            bio
            website
            location
        }
    }
`;

const DummyUserProfile = gql`
    query UserProfile {
        user(id: 1) {
            name
            handle
            bio
            website
            location
        }
    }
`;

class Profile extends React.Component {

    render() {
        const { data } = this.props;
        const profile = data.loading ? [] : data.user;
        return (
            <div>
                <h1>Profile</h1>
                { data.loading ? 'Loading...' :
                    ([<div>
                        <img alt={profile.handle} className="rounded-circle" style={{ width: 100, height: 100 }} src={`/images/${profile.handle}.jpg`} />
                    </div>,
                    <h3>{profile.name}</h3>,
                    <span style={{color: '#aaa'}}>@{profile.handle}</span>,
                    <p>{profile.bio}</p>,
                    <a href={`http://${profile.website}`} target="_blank">{profile.website}</a>
                ])
                }
            </div>
        )
    }
}

export default graphql(UserProfile, {
    options: (ownProps) => ({ 
        variables: { 
            userId: ownProps.match.params.userId
        }
    })
})(withRouter(Profile));
