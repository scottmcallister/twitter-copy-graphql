import React from 'react'
import PropTypes from 'prop-types'
import './styles/ProfileCard.css'

const ProfileCard = props => {
    const { user } = props;
    return (
        <div className="profile-card col-lg-4">
            <div className="blue-bg">
                <img className="rounded-circle" src={`/images/${user.handle}.jpg`}/>
            </div>
            <div className="info-container">
                <div className="info">
                    <div>
                        <span className="name">{user.name}</span>
                    </div>
                    <div>
                        <span className="handle">@{user.handle}</span>
                    </div>
                </div>
            </div>
        </div>
    )
}

ProfileCard.propTypes = {
    user: PropTypes.object
}

export default ProfileCard;