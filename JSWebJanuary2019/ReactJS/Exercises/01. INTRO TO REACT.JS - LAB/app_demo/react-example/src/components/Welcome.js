import React from 'react'

class Welcome extends React.Component {
    render () {
        return <div>
            <h1>Me: {this.props.name1}</h1>
            <h2>Her: {this.props.name2}</h2>
        </div>
    }
}

export default Welcome