import gql from 'graphql-tag';

export const UserProfile = gql`
    query UserProfile($userId: ID!) {
        user(id: $userId) {
            name
            handle
            bio
            website
            location
        }
        tweetsByAuthor(authorId: $userId) {
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
export const ListOfTweets = gql`
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
export const getLoggedInUser = gql`
    query {
        loggedInUser @client {
            name
            handle
        }
    }
`;