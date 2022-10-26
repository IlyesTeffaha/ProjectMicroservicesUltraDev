import React, { useEffect, useState } from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCheck, faCog, faHome, faSearch } from '@fortawesome/free-solid-svg-icons';
import { Col, Row, Form, Button, ButtonGroup, Breadcrumb, InputGroup, Dropdown } from '@themesberg/react-bootstrap';
import Parser from 'html-react-parser';

//////////////////////////////////////////////////////////////////////////////
import '../pages/css/PlacesList.css'
import { faAngleDown, faAngleUp, faArrowDown, faArrowUp, faEdit, faEllipsisH, faExternalLinkAlt, faEye, faTrashAlt } from '@fortawesome/free-solid-svg-icons';
import {  Nav, Card, Image, Table, ProgressBar, Pagination } from '@themesberg/react-bootstrap';
import { Link, NavLink } from 'react-router-dom';

import { Routes } from "../routes";
import { pageVisits, pageTraffic, pageRanking } from "../data/tables";
import transactions from "../data/transactions";
import commands from "../data/commands";
import axios from "axios";

// import { TransactionsTable } from "../components/Tables";

export default () => {
  //

  const [placesslist,setPlacessList] = useState([]);


  useEffect(()=>{
    let iscanceled =false;

    const getplacess=async()=>{
      axios.get("http://localhost:8086/place/getplaces").then((response)=>{
      if(!iscanceled){
        setPlacessList(response.data);
        
      }
      console.log(response.data)
      })

      return()=>{
        iscanceled=true;
      };
    };
    // await timeout(1000);
    getplacess();
  },[]);



  
  
   return (
    <>
      <div className="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center py-4">
        <div className="d-block mb-4 mb-md-0">
          <Breadcrumb className="d-none d-md-inline-block" listProps={{ className: "breadcrumb-dark breadcrumb-transparent" }}>
            <Breadcrumb.Item><FontAwesomeIcon icon={faHome} /></Breadcrumb.Item>
            <Breadcrumb.Item>Sidebar Menu</Breadcrumb.Item>
            <Breadcrumb.Item active>Placess list</Breadcrumb.Item>
          </Breadcrumb>
          <h4>Placess list</h4>
          {/* <p className="mb-0">Your web analytics dashboard template.</p> */}
        </div>
        <div className="btn-toolbar mb-2 mb-md-0">
          <ButtonGroup>
         
            <Button as={NavLink} to={Routes.AddPlaces.path} variant="outline-primary" size="lg">Add a Place</Button>
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
export const TransactionsTable = () => {
  const totalTransactions = transactions.length;
  const [placeslist,setPlacesList] = useState([]);


  useEffect(()=>{
    let iscanceled =false;

    const getplacess=async()=>{
      axios.get("http://localhost:8086/place/getplaces").then((response)=>{
      if(!iscanceled){
        setPlacesList(response.data);
        console.log("hi")
        
      }
      
      })

      return()=>{
        iscanceled=true;
      };
    };
    // await timeout(1000);
    getplacess();
  },[]);

  return (
  
 <div className="posts"> 
   {placeslist.map((value, key) => {
  return(
  <div className="post">
      <NavLink to={`/single-place/${value.idPlace}`}>
      <img className="postImg" src={value.image} alt="" />
      </NavLink>
      <div className="postInfo">
  
        <Link to={`/single-place/${value.idPlace}`} className="link">
          <span className="postTitle">{value.placeTitle}</span>
        </Link>
        <hr />
        <span>
      {value.country}

        </span>
        <span className="postDate">
      <br/>
          
            {value.state},
          {value.type}
        </span>
      </div>
      <p className="postDesc">{Parser(value.description)}</p>
    </div>
    )
 })}
    
 </div>
  );
};
