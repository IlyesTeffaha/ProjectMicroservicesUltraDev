import React, { useEffect, useState } from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCheck, faCog, faHome, faSearch } from '@fortawesome/free-solid-svg-icons';
import { Col, Row, Form, Button, ButtonGroup, Breadcrumb, InputGroup, Dropdown } from '@themesberg/react-bootstrap';

//////////////////////////////////////////////////////////////////////////////
import '../pages/css/BlogsList.css'
import { faAngleDown, faAngleUp, faArrowDown, faArrowUp, faEdit, faEllipsisH, faExternalLinkAlt, faEye, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import {  Nav, Card, Image, Table, ProgressBar, Pagination } from '@themesberg/react-bootstrap';
import { Link, NavLink, useHistory } from 'react-router-dom';

import { Routes } from "../routes";
import { pageVisits, pageTraffic, pageRanking } from "../data/tables";
import transactions from "../data/transactions";
import commands from "../data/commands";
import axios from "axios";
import Parser from 'html-react-parser';


// import { TransactionsTable } from "../components/Tables";

export default () => {
  //

  const [blogslist,setBlogsList] = useState([]);


  useEffect(()=>{
    let iscanceled =false;

    const getblogs=async()=>{
      axios.get("http://localhost:8090/blog/getblogs").then((response)=>{
      if(!iscanceled){
        setBlogsList(response.data);
        
      }
      console.log(response.data)
      })

      return()=>{
        iscanceled=true;
      };
    };
    // await timeout(1000);
    getblogs();
  },[]);




  
  
   return (
    <>
      <div className="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center py-4">
        <div className="d-block mb-4 mb-md-0">
          <Breadcrumb className="d-none d-md-inline-block" listProps={{ className: "breadcrumb-dark breadcrumb-transparent" }}>
            <Breadcrumb.Item><FontAwesomeIcon icon={faHome} /></Breadcrumb.Item>
            <Breadcrumb.Item>Sidebar Menu</Breadcrumb.Item>
            <Breadcrumb.Item active>Blogs list</Breadcrumb.Item>
          </Breadcrumb>
          <h4>Blogs list</h4>
          {/* <p className="mb-0">Your web analytics dashboard template.</p> */}
        </div>
        <div className="btn-toolbar mb-2 mb-md-0">
          <ButtonGroup>
         
            <Button as={NavLink} to={Routes.AddBlogs.path} variant="outline-primary" size="lg">Add Blog Post</Button>
          </ButtonGroup>
        </div>
      </div>

      <div className="table-settings mb-4">
        <Row className="justify-content-between align-items-center">
          <Col xs={8} md={6} lg={3} xl={4}>
            <InputGroup>
              <InputGroup.Text>
                <FontAwesomeIcon icon={faSearch} />
              </InputGroup.Text>
              <Form.Control type="text" placeholder="Search" />
            </InputGroup>
          </Col>
          <Col xs={4} md={2} xl={1} className="ps-md-0 text-end">
            <Dropdown as={ButtonGroup}>
              <Dropdown.Toggle split as={Button} variant="link" className="text-dark m-0 p-0">
                <span className="icon icon-sm icon-gray">
                  <FontAwesomeIcon icon={faCog} />
                </span>
              </Dropdown.Toggle>
              <Dropdown.Menu className="dropdown-menu-xs dropdown-menu-right">
                <Dropdown.Item className="fw-bold text-dark">Show</Dropdown.Item>
                <Dropdown.Item className="d-flex fw-bold">
                  10 <span className="icon icon-small ms-auto"><FontAwesomeIcon icon={faCheck} /></span>
                </Dropdown.Item>
                <Dropdown.Item className="fw-bold">20</Dropdown.Item>
                <Dropdown.Item className="fw-bold">30</Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>
          </Col>
        </Row>
      </div>
 
      <TransactionsTable/>
    </>
  );
  
};
// export const TransactionsTable = () => {
//   const totalTransactions = transactions.length;
//   const [blogslist,setBlogsList] = useState([]);


//   useEffect(()=>{
//     let iscanceled =false;

//     const getblogs=async()=>{
//       axios.get("http://localhost:8090/blog/getblogs").then((response)=>{
//       if(!iscanceled){
//         setBlogsList(response.data);
//         console.log("hi")
        
//       }
      
//       })

//       return()=>{
//         iscanceled=true;
//       };
//     };
//     // await timeout(1000);
//     getblogs();
//   },[]);
// console.log(blogslist)

//   return (


//  <div className="posts"> 
//    {blogslist.map((value, key) => {
//   return(
//   <div className="post">
//       {value.image && <img className="postImg" src={value.image} alt="" />}
//       <div className="postInfo">
  
//         <Link to={`/post/`} className="link">
//           <span className="postTitle">{value.title}</span>
//         </Link>
//         <hr />
//         <span className="postDate">
//           {new Date(value.creationtime).toDateString()}
//         </span>
//       </div>
//       <p className="postDesc">{Parser(value.description)}</p>

//     </div>
//     )
//  })}
    
//  </div>
//   );
// };
export const TransactionsTable = () => {
  const totalTransactions = transactions.length;
  const [hotellist,setHotelList] = useState([]);


  useEffect(()=>{
    let iscanceled =false;

    const gethotel=async()=>{
      axios.get("http://localhost:8090/blog/getblogs").then((response)=>{
      if(!iscanceled){
        setHotelList(response.data);
        console.log(response.data)
        
      }
      
      })

      return()=>{
        iscanceled=true;
      };
    };
    // await timeout(1000);
    gethotel();
  },[]);
console.log(hotellist)
function redirect(){
  history.push(Routes.SingleBlog.path)
}

// const [availability,useAvailability]=useState(false);
let history=useHistory();
  return (
  
 <div className="posts"> 
   {hotellist.map((value, key) => {
  return(
  <div className="post">
    
    <NavLink to={`/single-blog/${value.idPost}`}>
      <img className="postImg" src={value.image} alt="" />
      </NavLink>
      
      <div className="postInfo">
  
        <Link as={Link} to={`/single-blog/${value.idPost}`} className="link">
          <span className="postTitle">{value.title}</span>
        </Link>
        
        <hr />
     
        
               <span className="postDate">
           {new Date(value.creationtime).toDateString()}
        </span>
      </div>
      <p className="postDesc">{Parser(value.description)}</p>
    </div>
    )
 })}
    
 </div>
  );
};
