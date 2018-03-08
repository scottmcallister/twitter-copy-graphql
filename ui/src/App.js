import React, { Component } from 'react';
import './App.css';
import Home from './views/Home';
import Profile from './views/Profile';
import NotFound from './views/NotFound';
import {
  BrowserRouter,
  Switch,
  Route
} from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <div className="App">
        <BrowserRouter>
          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/user/:userId" component={Profile} />
            <Route path="*" exact component={NotFound} />
          </Switch>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;
