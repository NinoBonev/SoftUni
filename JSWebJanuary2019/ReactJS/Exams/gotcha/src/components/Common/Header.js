import React from 'react'
import {Menu, Icon, Button, Layout} from 'antd';

const { Header } = Layout;

export default class HeaderClass extends React.Component{
    render() {
        return(
            <Header className='ant-layout-header' style={{textAlign: 'center', color: 'white', minHeight: 20}}>
                Some Randomn Text
            </Header>
        )
    }
}