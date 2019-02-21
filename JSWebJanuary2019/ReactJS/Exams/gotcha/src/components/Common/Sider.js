import React from 'react'
import {Menu, Icon, Button, Layout} from 'antd';
import {Link} from 'react-router-dom'

const { SubMenu } = Menu;
const { Sider } = Layout

class SiderClass extends React.Component {
    render() {
        return (
            <Sider
                theme='dark'
                className='ant-layout-sider'
                breakpoint="lg"
                collapsedWidth="90"
                collapsed={this.props.collapsed}>
                <Button type="primary" onClick={() => this.props.toggleCollapsed()} style={{marginBottom: 16, textAlign: 'left'}}>
                    <Icon type={this.props.collapsed ? 'menu-unfold' : 'menu-fold'}/>
                </Button>
                <Menu
                    defaultSelectedKeys={['1']}
                    mode="inline"
                    theme="dark"
                >
                    <Menu.Item key="1">
                        <Link style={{color: 'white'}} to='/'><span><Icon type="home"/><span>Home</span></span></Link>
                    </Menu.Item>
                    <SubMenu key="sub1" title={<span><Icon type="read"/><span>About</span></span>}>
                        <Menu.Item key="2">Info</Menu.Item>
                        <Menu.Item key="3">Rules</Menu.Item>
                    </SubMenu>
                    <SubMenu key="sub2" title={<span><Icon type="mail"/><span>Events</span></span>}>
                        <Menu.Item key="4">Active</Menu.Item>
                        <Menu.Item key="5">Archive</Menu.Item>
                    </SubMenu>
                    <SubMenu key="sub3" title={<span><Icon type="play-circle" /><span>Get Involved</span></span>}>
                        <Menu.Item key="6"><Link to='/register'>Register</Link></Menu.Item>
                        <Menu.Item key="7">Log In</Menu.Item>
                    </SubMenu>
                </Menu>
            </Sider>
        );
    }
}

export default SiderClass