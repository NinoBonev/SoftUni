import React from 'react'
import {Carousel, Button} from 'antd'
import '../custom.css'

export default class CarouselClass extends React.Component {
    render() {
        const settings = {
            dots: true,
            infinite: true,
            speed: 1500,
            pauseOnHover: false,
            autoplaySpeed: 5000,
            slidesToShow: 1,
            autoplay: true,
            slidesToScroll: 1,
        };
        return (

            <Carousel {...settings}>
                <div className='one'>
                    <div>
                        Something
                    </div>
                </div>
                <div className='two'>
                    <p>
                        Any Text
                    </p>
                </div>
                <div className='three'>
                    <div>
                        Other text
                    </div>
                </div>
            </Carousel>

        )
    }
}