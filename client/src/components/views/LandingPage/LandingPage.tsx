import React, { useState } from 'react';
import HeaderComponent from '../HeaderComponent/HeaderComponent';
import SearchComponent from '../SearchComponent/SearchComponent';
import Sidebar from '../sidebar/Sidebar';
import SidebarMapDetail from '../sidebar/SidebarMapDetail';
import SidebarMyPageDetail from '../sidebar/SidebarMyPageDetail';
import SidebarSearchDetail from '../sidebar/SidebarSearchDetail';
import Map from './Sections/Map';
import './LandingPage.css';

export interface propsType {
  searchKeyword: string;
}

const LandingPage = (): JSX.Element => {
  // 입력 폼 변화 감지하여 입력 값 관리
  const [Value, setValue] = useState('');
  // 제출한 검색어 관리
  const [Keyword, setKeyword] = useState('');

  // 입력 폼 변화 감지하여 입력 값을 state에 담아주는 함수
  // const keywordChange = (e: {
  //     preventDefault: () => void;
  //     target: { value: string };
  // }) => {
  //     e.preventDefault();
  //     setValue(e.target.value);
  // };

  // 제출한 검색어 state에 담아주는 함수
  // const submitKeyword = (e: { preventDefault: () => void }) => {
  //     e.preventDefault();
  //     setKeyword(Value);
  // };

  // 검색어를 입력하지 않고 검색 버튼을 눌렀을 경우
  // const valueChecker = () => {
  //     if (Value === '') {
  //         alert('검색어를 입력해주세요.');
  //     }
  // };

  return (
    <>
      <HeaderComponent />
      <SearchComponent />
      {/* <Sidebar /> */}
      {/* <SidebarMapDetail />
            <SidebarMyPageDetail />
            <SidebarSearchDetail /> */}
      <div className="landing-page">
        <div className="landing-page__inner">
          <Map searchKeyword={Keyword} />
        </div>
      </div>
    </>
  );
};

export default LandingPage;
