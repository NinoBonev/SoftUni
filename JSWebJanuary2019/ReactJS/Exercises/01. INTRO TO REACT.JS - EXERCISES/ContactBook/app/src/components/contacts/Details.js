import React from 'react'
import Data from './contacts'

export default class Details extends React.Component{

    render () {
        const id = this.props.id

        return (
            <div id="details">
                <h1>Details</h1>
                <div className="content">
                    <div className="info">
                        <div className="col">
                            <span className="avatar">☻</span>
                        </div>
                        <div className="col">
                            <span className="name">{Data[id].firstName}</span>
                            <span className="name">{Data[id].lastName}</span>
                        </div>
                    </div>
                    <div className="info">
                        <span className="info-line">☎ {Data[id].phone}</span>
                        <span className="info-line">✉ {Data[id].email}</span>
                    </div>
                </div>
            </div>
        )
    }
}