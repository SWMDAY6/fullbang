import React, { useState } from "react";
import {
  bubjungdong_sido,
  bubjungdong_sigungu,
  bubjungdong_dong,
} from "./bubjungdong";

const SearchComponent = () => {
  const [sido, setSido] = useState();
  const [sigungu, setSigungu] = useState();
  const [dong, setDong] = useState();

  const handleSido = (e) => {
    setSido(e.target.value);
  };
  const handleSigungu = (e) => {
    setSigungu(e.target.value);
  };
  return (
    <div className="SearchComponent">
      <select id="sido" onChange={handleSido}>
        <option value="">선택</option>
        {bubjungdong_sido.map((data, idx) => {
          return <option value={data.sido}>{data.codeNM}</option>;
        })}
      </select>
      <select id="sigugun" onChange={handleSigungu}>
        <option value="">선택</option>
        {bubjungdong_sigungu.map((data, idx) => {
          if (data.sido == sido)
            return <option value={data.sigungu}>{data.codeNM}</option>;
        })}
      </select>
      <select id="dong">
        <option value="">선택</option>
        {bubjungdong_dong.map((data, idx) => {
          if (data.sido == sido && data.sigungu == sigungu)
            return <option value={data.dong}>{data.codeNM}</option>;
        })}
      </select>
    </div>
  );
};

export default SearchComponent;
