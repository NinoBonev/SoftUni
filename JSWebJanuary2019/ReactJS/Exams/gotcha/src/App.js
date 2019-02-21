import React, {Component} from 'react';
import {Layout, Menu, Icon, Carousel} from 'antd';
import SiderClass from './components/Common/Sider';
import HeaderClass from './components/Common/Header'
import FooterClass from './components/Common/Footer'
import {Switch, Route} from 'react-router-dom'
import HomePage from "./components/Home/HomePage";
import RegisterPage from './components/Auth/RegisterPage'
import 'antd/dist/antd.css'

class App extends Component {
    constructor(props) {
        super(props)

        this.state = {
            collapsed: true,
        }

        this.toggleCollapsed = this.toggleCollapsed.bind(this)

    }

    toggleCollapsed = () => {
        this.setState(prevState => ({
            collapsed: !prevState.collapsed,
        }));
    }

    render() {
        return (
            <Layout>
                <HeaderClass toggleCollapsed={this.toggleCollapsed}
                             collapsed={this.state.collapsed}>
                </HeaderClass>
                <Layout>
                    <SiderClass
                        toggleCollapsed={this.toggleCollapsed}
                        collapsed={this.state.collapsed}/>
                    <Layout>
                        <Switch>
                            <Route exact path='/' component={HomePage}/>
                            <Route path='/register' component={RegisterPage}/>
                        </Switch>
                    </Layout>
                </Layout>
                <Layout>
                    <FooterClass/>
                </Layout>
            </Layout>
        );
    }
}

export default App;
