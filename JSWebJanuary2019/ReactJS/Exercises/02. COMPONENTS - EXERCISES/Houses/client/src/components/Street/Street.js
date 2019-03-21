import React from 'react'
import './Street.css'

export default class Street extends React.Component{
    render() {
        return (
            <div className="Street" onMouseEnter={() => this.props.streetHoverEvent(this.props.id)}>
                <p className="street-info"> {this.props.location} </p>
            </div>
        )
    }
}