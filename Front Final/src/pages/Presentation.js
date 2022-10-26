import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBook, faExternalLinkAlt, faTimesCircle, faCheckCircle, faCalendarAlt, faCodeBranch, faShoppingCart, faFolder, faMapMarkedAlt, faPager, faFileCode, faDownload,faSignInAlt } from "@fortawesome/free-solid-svg-icons";
import { faBootstrap, faGithub, faJs, faReact, faSass } from "@fortawesome/free-brands-svg-icons";
import { Col, Row, Card, Image, Button, Container, ListGroup, Tooltip, OverlayTrigger, Form, Navbar, Nav, Badge } from '@themesberg/react-bootstrap';
import { Link } from 'react-router-dom';
import { HashLink } from 'react-router-hash-link';
import Code from "../components/CodeEditor";
import GitHubButton from 'react-github-btn';
import "./css/Presentation.css"
import { Routes } from "../routes";
import ThemesbergLogoIcon from "../assets/img/themesberg.svg";
import ThemesbergLogo from "../assets/img/themesberg-logo.svg";
import MockupPresentation from "../assets/img/mockup-presentation.png";
import ReactHero from "../assets/img/technologies/react-hero-logo.svg";
import MapboxImg from "../assets/img/mockup-map-presentation.png";
import CalendarImg from "../assets/img/mockup-calendar-presentation.png";
import ReactMockupImg from "../assets/img/react-mockup.png";
import BS5IllustrationsImg from "../assets/img/illustrations/bs5-illustrations.svg";
import BS5Logo from "../assets/img/technologies/bootstrap-5-logo.svg";
import ReactLogo from "../assets/img/technologies/react-logo.svg";
import logo from "../media/logo.png"
import backimage from "../media/landingpageimage.png"
import pages from "../data/pages";
import features from "../data/features";
import ScrollTotop from "../components-travel/ScrollToTop";
import Navbars from "../components-travel/Navbar";
import Services from "../components-travel/Services";
import Destinations from "../components-travel/Destinations";
import Offer from "../components-travel/Offer";
import Tours from "../components-travel/Tours";
import Testimonials from "../components-travel/Testimonial";
import DownloadApp from "../components-travel/DownloadApp";
import Home from "../components-travel/Home";

export default () => {
  const PagePreview = (props) => {
    const { name, image, link } = props;

    return (
      <Col xs={6} className="mb-5">
        <Card.Link as={Link} to="/" className="page-preview page-preview-lg scale-up-hover-2">
          <Image src={image} className="shadow-lg rounded scale" alt="Dashboard page preview" />

              
          <div className="text-center show-on-hover">
            <h6 className="m-0 text-center text-white">
              {name} <FontAwesomeIcon icon={faExternalLinkAlt} className="ms-2" />
            </h6>
          </div>
        </Card.Link>
      </Col>
    );
  };

  const Feature = (props) => {
    const { title, description, icon } = props;

    return (
      <Col xs={12} sm={6} lg={3}>
        <Card className="bg-white shadow-soft text-primary rounded mb-4">
          <div className="px-3 px-lg-4 py-5 text-center">
            <span className="icon icon-lg mb-4">
              <FontAwesomeIcon icon={icon} />
            </span>
            <h5 className="fw-bold text-primary">{title}</h5>
            <p>{description}</p>
          </div>
        </Card>
      </Col>
    );
  };

  const FolderItem = (props) => {
    const { name, icon, tooltip, iconColor } = props;
    const color = iconColor ? `text-${iconColor}` : "";

    return (
      <OverlayTrigger
        trigger={['hover', 'focus']}
        placement="left"
        overlay={<Tooltip>{tooltip}</Tooltip>}
      >
        <li data-toggle="tooltip" data-placement="left" title="Main folder that you will be working with">
          <FontAwesomeIcon icon={icon ? icon : faFolder} className={`${color} me-2`} /> {name}
        </li>
      </OverlayTrigger>
    );
  };
  console.log("presentation")

  return (
    <>
    <div className="fullwidth">
      {/* <Navbar className="colornav navbar-transparent sticky-top">
        <Container className="position-relative justify-content-between px-3"> */}
          {/* <Navbar.Brand as={HashLink} to="/" className="me-lg-3 d-flex align-items-center">
            <Image src={logo} />
            <span className="ms-2 brand-text d-none d-md-inline">UNI</span>
          </Navbar.Brand> */}

          {/* <div className="d-flex align-items-center"> */}
            {/* <Navbar.Collapse id="navbar-default-primary">
              <Nav className="navbar-nav-hover align-items-lg-center">
                <Nav.Link as={HashLink} to="#features">Features</Nav.Link>
                <Nav.Link as={HashLink} to="#pages">Pages</Nav.Link>
                <Nav.Link as={HashLink} to="#folder" className="d-sm-none d-xl-inline">Folder Structure</Nav.Link>
                <Nav.Link as={HashLink} to="#getting-started">Getting Started</Nav.Link>
                <Nav.Link as={HashLink} to="#download">Upgrade to Pro</Nav.Link>
              </Nav>
            </Navbar.Collapse> */}
            {/* <Button as={HashLink} to={Routes.Signin.path} variant="secondary" className="ls-3 loginbton"><FontAwesomeIcon icon={faSignInAlt} className="me-1" /> Login</Button>
          </div>
        </Container>
      </Navbar> */}

       
        <div   >
        {/* <img src={backimage} alt="" />
        
            <div xs={12} className=" textonimg">
              <div className="react-big-icon d-none d-lg-block"><span className="fab fa-react"></span></div>
              <h1 className="fw-bolder text-secondary">UNI</h1>
              <p className=" textcol mb-5 h5">Welcome to UNI</p>
              <div className="d-flex align-items-center justify-content-center">
                <Button variant="secondary" size="lg" as={Link} to={Routes.Signup.path} className="text-dark ">
                  Sign Up <FontAwesomeIcon icon={faExternalLinkAlt} className="d-none d-sm-inline ms-1" />
                </Button>
              
              </div>
       
            </div> */}
            <ScrollTotop />
      <Navbars />
      <Home />
      <Services />
      <Destinations />
      <Offer />
      <Tours />
      <Testimonials />
      <DownloadApp />
      
         
        </div>
      
    
     
      </div>
    </>
  );
};
