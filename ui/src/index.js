import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './index.css';

import { ApolloClient } from 'apollo-client';
import { ApolloProvider } from 'react-apollo';
import { InMemoryCache } from 'apollo-cache-inmemory';
import { withClientState } from 'apollo-link-state';
import { HttpLink } from 'apollo-link-http'
import { ApolloLink } from 'apollo-link';

const cache = new InMemoryCache();
const httpLink = new HttpLink({
    uri: 'http://127.0.0.1:8080/graphql'
});

const defaultState = {
    loggedInUser: {
        __typename: 'User',
        id: 1,
        name: "Donald J. Trump",
        handle: "realDonaldTrump"
    }
};

const stateLink = withClientState({
    cache,
    defaults: defaultState
});

const link = ApolloLink.from([stateLink, httpLink]);

const client = new ApolloClient({ 
    link: link,
    cache
});

ReactDOM.render(
    <ApolloProvider client={client}>
        <App />
    </ApolloProvider>, 
    document.getElementById('root'));
registerServiceWorker();
