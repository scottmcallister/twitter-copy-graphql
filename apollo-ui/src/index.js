import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './index.css';

import ApolloClient from 'apollo-boost';
import { ApolloProvider } from 'react-apollo';

// Pass your GraphQL endpoint to uri
const client = new ApolloClient({ uri: 'http://localhost:8080/graphql' });

ReactDOM.render(
    <ApolloProvider client={client}>
        <App />
    </ApolloProvider>, 
    document.getElementById('root'));
registerServiceWorker();
