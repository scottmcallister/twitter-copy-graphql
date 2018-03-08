import gql from 'graphql-tag';

export const newTweet = gql`
    mutation newTweet($authorId: ID!, $text: String) {
        newTweet(authorId: $authorId, text: $text) {
            timestamp
        }
    }
`;