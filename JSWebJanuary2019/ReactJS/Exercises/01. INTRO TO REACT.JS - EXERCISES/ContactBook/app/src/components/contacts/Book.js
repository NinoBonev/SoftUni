import React from 'react'
import Details from './Details'
import Content from './Content'

export default class Book extends React.Component{
    constructor(props){
        super(props)

        this.state = {
            id: '0'
        }

        this.setId = this.setId.bind(this)
    }

    setId(newId) {
        this.setState({
            id: newId
        })
    }
    render() {
        return (
            <div id="book">
                <Content setId = {this.setId.bind(this)} />
                <Details id={this.state.id}/>
            </div>
        )
    }
}