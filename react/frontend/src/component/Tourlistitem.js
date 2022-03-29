import React ,{useState, useEffect} from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import './css/bootstrap.min.css';
import './css/style.css';
import axios from "axios";

function Tourlistitem(props) {
    // 현재 페이지 출력 관광지 리스트 
    const [tourList, setTourList] = useState([{id:'' ,img:'', tour:'', sub_title:''}, {id:'' ,img:'', tour:'', sub_title:''}, {id:'' ,img:'', tour:'', sub_title:''}, {id:'' ,img:'', tour:'', sub_title:''}, {id:'' ,img:'', tour:'', sub_title:''}])

    const reqUrl = '/tour/searchByCertainColumn'

    const getListItem = async () => {
        await axios
            .get(reqUrl, {
                params: {
                    search: decodeURI(window.location.search.split('=')[1])
                }
            })
            .then((res) => setTourList(res.data));  
    }

   // 처음 렌더링시 한번 실행되는 함수
    useEffect(() => {
        getListItem();
    }, [])

    const tourlistRender = () => {
        const result = [];
        console.log(tourList)
        for (let i = 0; i < tourList.length; i++) {
            result.push(
                // 출력 관광지 리스트의 관광지 명을 값으로 상세페이지에 보냄
                <div class="list-item p-4 mb-4"  onClick={(e) => window.location.href = "/jeju/TouristAttractionInfo?tourSpot=" + tourList[i].id}>
                    <div class="row g-4">
                        <div class="col-md-4 d-flex align-items-start">
                            <img class="img-list" src={tourList[i].img} />
                        </div>
                        <div class="col-md-8">
                            <h3 class="text-left" typeof='text' id='test' >{tourList[i].tour}</h3>
                            <p class="list-p">{tourList[i].sub_title}</p>
                        </div>
                    </div>
                </div>
            );}
        return result;
    };


    return (
        <div class="col-lg-6">
            <h1 class="text-center mb-5 wow fadeInUp" data-wow-delay="0.1s">관광지 리스트</h1>
            <div class="tab-class wow fadeInUp" data-wow-delay="0.3s">
                <div class="tab-content">
                    <div id="tab-1" class="tab-pane fade show p-0 active">
                        {tourlistRender()}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Tourlistitem;