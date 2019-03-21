import React from 'react'
import Header from './Header'
import Footer from './Footer'
import Book from '../contacts/Book'

export default class Container extends React.Component{
    render () {
        return (
            <div className="container">
                <Header />
                <Book />
                <Footer />
            </div>
        )
    }
}