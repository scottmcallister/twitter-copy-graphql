import React, { Component } from 'react'
import { newTweet } from '../graphql/mutations'
import { graphql } from 'react-apollo';
import './styles/NewTweetOverlay.css'

class NewTweetOverlay extends Component {
    constructor(props) {
        super(props);
        this.state = {
            text: '',
            show: false,
            error: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.toggleShow = this.toggleShow.bind(this);
        this.setWrapperRef = this.setWrapperRef.bind(this);           
        this.handleClickOutside = this.handleClickOutside.bind(this);
    }

    componentDidMount() {
        this.props.onRef(this);
        document.addEventListener('mousedown', this.handleClickOutside);
    }

    componentWillUnmount() {
        this.props.onRef(undefined);
        document.removeEventListener('mousedown', this.handleClickOutside);
    }

    handleChange(event) {
        this.setState({ text: event.target.value })
    }

    handleSubmit(event) {
        event.preventDefault();
        const { loggedInUserId } = this.props;
        const { text } = this.state;
        this.props.mutate({
            variables: { 
                text,
                authorId: loggedInUserId
            }
        })
        .then(({ data }) => {
            this.setState({ error: '', text: '' });
            this.toggleShow();
        }).catch((error) => {
            this.setState({ error: 'Problem sending tweet' });
        });;
    }

    toggleShow() {
        const { show } = this.state;
        this.setState({ show: !show });
    }

    setWrapperRef(node) {
        this.backdrop = node;
    }

    handleClickOutside(event) {
        if (this.backdrop && this.backdrop === event.target) {
            this.toggleShow();
        }
    }

    render() {
        const { show, error } = this.state;
        return show ?
            (<div className="overlay-backdrop" ref={this.setWrapperRef}>
                <div className="tweet-modal card">
                    <h4 className="card-header tweet-modal-header text-center">Compose new Tweet</h4>
                    <div className="card-block tweet-modal-content">
                        { error.length > 0 && (<span className="error">{ error }</span>) }
                        <form id="tweet-modal-form" onSubmit={this.handleSubmit}>
                            <div className="col-10 offset-1">
                                <textarea name="text" form="tweet-modal-form" onChange={this.handleChange} rows={3} cols={60}
                                    placeholder="What's happening?" className="form-control tweet-input" required></textarea>
                            </div>
                            <div className="col-1 offset-9">
                                <input className="tweet-button pull-right" type="submit" value="Tweet" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>) : null;
    }
}

export default graphql(newTweet)(NewTweetOverlay);