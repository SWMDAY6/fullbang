import {AppProvider, useGlobalContext} from "../../../context";
import styled from "styled-components";
import './Sidebar.css'
import yanolja from '../../../assets/logo_yanolja.png'
import yeogiattae from '../../../assets/logo_yeogiattae.png'

const Sidebar = () => {
    // const { switchSearchDetail, switchMapDetail, switchMyPageDetail, openModal } =
    //   useGlobalContext();

    return (<aside className="sidebar show-sidebar">
        <input
            type="textbox"
            id="searchTextbox"
            placeholder="업체명을 입력해주세요."
        />
        <AccommodationWrap>
            {AccomodationList.map((data) => {
                return <AccommodationBox>
                    <img className="accomodationImg" src={data.img_src}/>

                    <div className="accomodationName">{data.name}</div>

                    <br/>
                    <div className="accomodationStar">{data.stars}</div>

                    <br/>
                    <div className="yanoljaPrice">
                        <img src={yanolja}/>
                        <div>
                        {data.yanolja.toString()
                        .replace(/\B(?=(\d{3})+(?!\d))/g, ",")}원
                        </div>
                    </div>
                    <br/>
                    <div className="yeogiattaePrice">
                        <img src={yeogiattae}/>
                        {data.yeogiattae.toString()
                        .replace(/\B(?=(\d{3})+(?!\d))/g, ",")}원
                    </div>
                </AccommodationBox>;
            })}
        </AccommodationWrap>
    </aside>);
};

const AccommodationWrap = styled.div`
  height: calc(100% - 74px);
  margin-top: 26px;
  text-align: center;
  overflow: auto;
`;

const AccommodationBox = styled.div`
  border: 1px solid #d0d0d0;
  height: 163px;
  width: 349px;
  margin-top: 9px;
  margin-left: 10px;
`;

export default Sidebar;

const AccomodationList = [
    {name: "페어필드 바이 메리어트 강남", yanolja: 108356, yeogiattae: 118750, stars: 9.3, img_src: "https://image.goodchoice.kr/resize_490x348/adimg_new/1/298386/16ff63278a75e0866797808ea2ff7094.jpg"},
    {name: "페어필드 바이 메리어트 강남", yanolja: 108356, yeogiattae: 118750, stars: 9.3, img_src: "https://image.goodchoice.kr/resize_490x348/adimg_new/1/298386/16ff63278a75e0866797808ea2ff7094.jpg"},
    {name: "페어필드 바이 메리어트 강남", yanolja: 108356, yeogiattae: 118750, stars: 9.3, img_src: "https://image.goodchoice.kr/resize_490x348/adimg_new/1/298386/16ff63278a75e0866797808ea2ff7094.jpg"},
    {name: "페어필드 바이 메리어트 강남", yanolja: 108356, yeogiattae: 1131238750, stars: 9.3, img_src: "https://image.goodchoice.kr/resize_490x348/adimg_new/1/298386/16ff63278a75e0866797808ea2ff7094.jpg"},
    {name: "페어필드 바이 메리어트 강남", yanolja: 108356, yeogiattae: 118750, stars: 9.3, img_src: "https://image.goodchoice.kr/resize_490x348/adimg_new/1/298386/16ff63278a75e0866797808ea2ff7094.jpg"},
];
