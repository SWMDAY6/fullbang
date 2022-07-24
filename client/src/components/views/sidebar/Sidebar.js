import React from 'react';
import logo_icon from '../../../assets/logo_kor.png';
import { AppProvider, useGlobalContext } from '../../../context';

const Sidebar = () => {
  const { switchSearchDetail, switchMapDetail, switchMyPageDetail, openModal } =
    useGlobalContext();

  return (
    <aside className="sidebar show-sidebar">
      <div className="sidebar-header">
        <img src={logo_icon} />
      </div>
      {/* 사이드바 메뉴 목록 */}
      <ul className="links">
        <li>
          <a onClick={switchSearchDetail}>검색</a>
        </li>
        <li>
          <a onClick={switchMapDetail}>지도</a>
        </li>
        <li>
          <a onClick={openModal}>분석</a>
        </li>
        <li>
          <a onClick={switchMyPageDetail}>마이페이지</a>
        </li>
        <li>
          <a onClick={openModal}>도움말</a>
        </li>
      </ul>
    </aside>
  );
};

export default Sidebar;
