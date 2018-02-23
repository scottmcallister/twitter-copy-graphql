import React from 'react'
import { withRouter } from 'react-router-dom';
import { graphql, compose } from 'react-apollo';
import { UserProfile, getLoggedInUser } from '../graphql/queries';
import './styles/Profile.css'
import Nav from '../components/Nav';

class Profile extends React.Component {
    render() {
        const { data, loggedInUser } = this.props;
        const profile = data.loading ? [] : data.user;
        return (
            <div>
                <Nav user={loggedInUser} />
                <div>
                    { data.loading ? 'Loading...' :
                        ([
                            <div className="backdrop">
                                <div className="container">
                                    <img alt={profile.handle} className="rounded-circle" style={{ width: 200, height: 200 }} src={`/images/${profile.handle}.jpg`} />
                                </div>
                            </div>,
                            <nav className="navbar">
                                <div className="container">
                                    <div className="col-lg-3 col-md-4 col-sm-5">

                                    </div>
                                    <ul className="nav col-lg-9 col-md-8 col-sm-7 col-4 offset-8 offset-sm-0 float-right float-sm-left float-md-left float-lg-left">
                                        <li className="nav-item">
                                            <a className="nav-link">Tweets</a>
                                        </li>
                                        <li className="nav-item">
                                            <a className="nav-link">Following</a>
                                        </li>
                                        <li className="nav-item">
                                            <a className="nav-link">Followers</a>
                                        </li>
                                    </ul>
                                </div>
                            </nav>,
                            <div className="container">
                                <div className="col-lg-3 text-left" style={{ paddingTop: 40 }}>
                                    <h3>{profile.name}</h3>
                                    <span style={{color: '#aaa'}}>@{profile.handle}</span>
                                    <p>{profile.bio}</p>
                                    <a href={`http://${profile.website}`} target="_blank">{profile.website}</a>
                                </div>
                            </div>
                        ])
                    }
                </div>
            </div>
        )
    }
}

export default compose(
    withRouter,
    graphql(UserProfile, {
        options: (ownProps) => ({ 
            variables: { 
                userId: ownProps.match.params.userId
            }
        })
    }),
    graphql(getLoggedInUser, {
        props: ({ data: { loggedInUser, loading } }) => ({
            loggedInUser,
            loading
        })
    }),
)(Profile);
