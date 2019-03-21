import React from 'react'
import Data from './contacts'

export default class Content extends React.Component {
    render() {
        return (
            <div id="list">
                <h1>Contacts</h1>
                <div>
                    {Data.map(c => <div key={Data.indexOf(c) + 1}
                                        className="contact"
                                        data-id={Data.indexOf(c)}
                                        onClick={() => this.props.setId(Data.indexOf(c))}>
                        <span className="avatar small">☻</span>
                        <span className="title">{c.firstName} {c.lastName}</span>
                    </div>)}
                </div>
            </div>

        )
    }
}