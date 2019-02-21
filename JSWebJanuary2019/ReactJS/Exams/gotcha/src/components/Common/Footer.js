import React from 'react'
import { Layout } from 'antd'
const { Footer } = Layout

export default class FooterClass extends React.Component{
    render() {
        return(
            <Footer className='ant-layout-footer' style={{textAlign: 'center'}}>
                Nino Bonev ©2019 Created using React
            </Footer>
        )
    }
}