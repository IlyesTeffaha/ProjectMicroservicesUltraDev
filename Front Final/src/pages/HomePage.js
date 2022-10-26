import React, { useState, useEffect, useContext } from 'react';
import { Route, Switch, Redirect } from "react-router-dom";
import { Routes } from "../routes";
// pages
import Presentation from "./Presentation";

import Upgrade from "./Upgrade";
import DashboardOverview from "./dashboard/DashboardOverview";
import Transactions from "./UserList";
import Settings from "./Settings";
import BootstrapTables from "./tables/BootstrapTables";
import Signin from "./examples/Signin";
import Signup from "./examples/Signup";
import ForgotPassword from "./examples/ForgotPassword";
import ResetPassword from "./examples/ResetPassword";
import Lock from "./examples/Lock";
import NotFoundPage from "./examples/NotFound";
import ServerError from "./examples/ServerError";

// documentation pages
import DocsOverview from "./documentation/DocsOverview";
import DocsDownload from "./documentation/DocsDownload";
import DocsQuickStart from "./documentation/DocsQuickStart";
import DocsLicense from "./documentation/DocsLicense";
import DocsFolderStructure from "./documentation/DocsFolderStructure";
import DocsBuild from "./documentation/DocsBuild";
import DocsChangelog from "./documentation/DocsChangelog";

// components
import Sidebar from "../components/Sidebar";
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";
import Preloader from "../components/Preloader";

import Accordion from "./components/Accordion";
import Alerts from "./components/Alerts";
import Badges from "./components/Badges";
import Breadcrumbs from "./components/Breadcrumbs";
import Buttons from "./components/Buttons";
import Forms from "./components/Forms";
import Modals from "./components/Modals";
import Navs from "./components/Navs";
import Navbars from "./components/Navbars";
import Pagination from "./components/Pagination";
import Popovers from "./components/Popovers";
import Progress from "./components/Progress";
import Tables from "./components/Tables";
import Tabs from "./components/Tabs";
import Tooltips from "./components/Tooltips";
import Toasts from "./components/Toasts";
import axios from "axios"
import { AuthContext } from '../ContextApi/AuthContext';
import test from './examples/test';
import SingleUserProfile from './SingleUserProfile';
import MultiStepForm from './components/MultiStepForm';
import AccountConfirmed from '../components/AccountConfirmed';
import BlogsList from '../components/BlogsList';
import { AddBlogs } from '../components/AddBlogs';
import { QuizBuilder } from './QuizBuilder';
import { PersonalityTest } from './PersonalityTest';
import { SingleQuestion } from './SingleQuestion';
import PersonalityTestUi from './PersonalityTestUi';
import { AddHotel } from '../components/AddHotel';
import HotelList from '../components/HotelList';
import { AddSejour } from '../components/AddSejour';
import { AddPlaces } from '../components/AddPlaces';
import SejourList from '../components/SejourList';
import PlacesList from '../components/PlacesList';
import SingleBlog from '../components/SingleBlog';
import ReclamationList from '../components/ReclamationList';
import { AddReclamations } from '../components/AddReclamation';
import SingleHotel from '../components/SingleHotel';
import SingleSejour from '../components/SingleSejour';
import SinglePlace from '../components/SinglePlace';
import SingleReclamation from '../components/SingleReclamation';





const RouteWithLoader = ({ component: Component, ...rest }) => {
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    const timer = setTimeout(() => setLoaded(true), 1000);
    return () => clearTimeout(timer);
  }, []);

   

  return (


    <Route {...rest} render={props => ( <> <Preloader show={loaded ? false : true} /> <Component {...props} /> </> ) } />
   
  );
};

const RouteWithSidebar = ({ component: Component, ...rest }) => {
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    const timer = setTimeout(() => setLoaded(true), 1000);
    return () => clearTimeout(timer);
  }, []);

  const localStorageIsSettingsVisible = () => {
    return localStorage.getItem('settingsVisible') === 'false' ? false : true
  }

  const [showSettings, setShowSettings] = useState(localStorageIsSettingsVisible);

  const toggleSettings = () => {
    setShowSettings(!showSettings);
    localStorage.setItem('settingsVisible', !showSettings);
  }

 
const{authState,setAuthState}=useContext(AuthContext)
  
    


  return (
  <AuthContext.Provider value={{authState,setAuthState}}>

    <Route {...rest} render={props => (
      <>
        <Preloader show={loaded ? false : true} />
        <Sidebar />

        <main className="content">
          <Navbar props={authState.id} />
          <Component {...props} />
          <Footer toggleSettings={toggleSettings} showSettings={showSettings} />
        </main>
      </>
    )}
    />
 </AuthContext.Provider>
  );
};





 export default()=> {
  
const [authState,setAuthState]=useState({
  username:"",
  email:"",
  status:false,
  role:"",
  id:0,
  birthday:"",
  gender:"",
  address:"",
  PostalCode:0,
  PhoneNumber:0,
  occupation:"",
  scorebac:null,
  section:"",
  image:"test",
  blogimage:"blog",
  hotelimage:"hotel",
  sejourimage:"sejour",
  restaurantimage:"restaurant",
  reclamationimage:"reclamation"
 

  
});

const [globalstate,setGlobalstate]=useState({
  blogimage:"blog"
})

// //prevent login and registration from apearing again once page is refreshed because they dissapeared the first time when we pressed logind and the authstate changed to true but since it's set to false by default any rerendering of the app returns it to false and hence login and register appear again also validating the authanticity of the token


useEffect(() => {
axios
  .get("http://localhost:3001/auth/validate", {
    headers: {
      accessToken: localStorage.getItem("accessToken"),
    },
  })
  .then((response) => {
    if (response.data.error) {
      // keep the old fields of the object the same and only change the authState using this deconstractor
      setAuthState({...authState,status:false});
    } else {
      // we already got this response data through the auth/validate function
      setAuthState({
        username:response.data.username,
        status:true,
        role:response.data.role,
        email:response.data.email,
        id:response.data.id,
        birthday:response.data.birthday,
        PostalCode:response.data.PostalCode,
        address:response.data.address,
        PhoneNumber:response.data.PhoneNumber,
        gender:response.data.gender,
        occupation:response.data.occupation,
        blogimage:authState.blogimage,
        hotelimage:authState.hotelimage,
        image:response.data.image,
        sejourimage:authState.sejourimage,
        restaurantimage:authState.restaurantimage,
        reclamationimage:authState.reclamationimage

        
       

       
      });
    }
  });
   // eslint-disable-next-line
}, []);



// function ProtectedRoutes ({children,...rest}){
//   return(
//     <Route {...rest} render={()=>{
//       return authState.status ===true 
//       ? children
//       : <Redirect to="/examples/sign-in"/>
//     }} />
//   )
// }


const ProtectedRoute = ({ auth, component: Component, ...rest }) => {
  return (
    <Route
      {...rest}
      render={(props) => {
        if (auth) return <Component {...props} />;
        if (!auth)
          return (
            <Redirect to="/examples/sign-in" />
          );
      }}
    />
  );
};




  return(
  <AuthContext.Provider value={{authState,setAuthState}} >

  <Switch>
  <RouteWithSidebar exact path={Routes.SingleUserProfile.path}  component={SingleUserProfile}/>
    {/* <ProtectedRoute path="/test" component={test} auth={ authState.status}/> */}
    <ProtectedRoute path={Routes.ForgotPassword.path} component={ForgotPassword} auth={ authState.status}/>
    <ProtectedRoute path={Routes.Badges.path} component={Badges} auth={ authState.status}/>


  <RouteWithSidebar exact path={Routes.BlogsList.path}  component={BlogsList}/>
  <RouteWithSidebar exact path={Routes.AddBlogs.path}  component={AddBlogs}/>
  <RouteWithSidebar exact path={Routes.SingleBlog.path}  component={SingleBlog}/>  

  <RouteWithSidebar exact path={Routes.AddHotel.path}  component={AddHotel}/>
  <RouteWithSidebar exact path={Routes.HotelList.path}  component={HotelList}/>
  <RouteWithSidebar exact path={Routes.SingleHotel.path}  component={SingleHotel}/>  


  <RouteWithSidebar exact path={Routes.AddPlaces.path}  component={AddPlaces}/>
  <RouteWithSidebar exact path={Routes.PlacesList.path}  component={PlacesList}/>
  <RouteWithSidebar exact path={Routes.SinglePlace.path}  component={SinglePlace}/>  

  <RouteWithSidebar exact path={Routes.AddSejour.path}  component={AddSejour}/>
  <RouteWithSidebar exact path={Routes.SejourList.path}  component={SejourList}/>
  <RouteWithSidebar exact path={Routes.SingleSejour.path}  component={SingleSejour}/> 

    
  <RouteWithSidebar exact path={Routes.AddReclamation.path}  component={AddReclamations}/>
  <RouteWithSidebar exact path={Routes.ReclamationsList.path}  component={ReclamationList}/>
  <RouteWithSidebar exact path={Routes.SingleReclamation.path}  component={SingleReclamation}/> 





  <RouteWithSidebar exact path={Routes.QuizBuilder.path}  component={QuizBuilder}/>
  <RouteWithSidebar exact path={Routes.PersonalityTest.path} component={PersonalityTest} />
  <RouteWithSidebar exact path={Routes.SingleQuestion.path} component={SingleQuestion} />
  

  <RouteWithLoader exact path={Routes.MultiStepForm.path} component={MultiStepForm} />

    <RouteWithLoader exact path={Routes.PersonalityTestUi.path} component={PersonalityTestUi} />
    <Route exact path={Routes.AccountConfirmed.path} component={AccountConfirmed} />

    {/* <Route exact component={test} path="/test"></Route> */}
    
    <RouteWithLoader exact path={Routes.Presentation.path} component={Presentation} />
    <RouteWithLoader exact path={Routes.Signin.path} component={Signin} />
    <RouteWithLoader exact path={Routes.Signup.path} component={Signup} />
    <RouteWithLoader exact path={Routes.ForgotPassword.path} component={ForgotPassword} />
    <RouteWithLoader exact path={Routes.ResetPassword.path} component={ResetPassword} />
    <RouteWithLoader exact path={Routes.Lock.path} component={Lock} />
    <RouteWithLoader exact path={Routes.NotFound.path} component={NotFoundPage} />
    <RouteWithLoader exact path={Routes.ServerError.path} component={ServerError} />

    {/* pages */}
    {/* <ProtectedRoutes> */}
    <RouteWithSidebar exact path={Routes.DashboardOverview.path} component={DashboardOverview} />
    {/* </ProtectedRoutes> */}
    <RouteWithSidebar exact path={Routes.Upgrade.path} component={Upgrade} />
    <RouteWithSidebar exact path={Routes.Transactions.path} component={Transactions} />
    <RouteWithSidebar exact path={Routes.Settings.path} component={Settings} />
    <RouteWithSidebar exact path={Routes.BootstrapTables.path} component={BootstrapTables} />

    {/* components */}
    <RouteWithSidebar exact path={Routes.Accordions.path} component={Accordion} />
    <RouteWithSidebar exact path={Routes.Alerts.path} component={Alerts} />
    <RouteWithSidebar exact path={Routes.Badges.path} component={Badges} />
    <RouteWithSidebar exact path={Routes.Breadcrumbs.path} component={Breadcrumbs} />
    <RouteWithSidebar exact path={Routes.Buttons.path} component={Buttons} />
    <RouteWithSidebar exact path={Routes.Forms.path} component={Forms} />
    <RouteWithSidebar exact path={Routes.Modals.path} component={Modals} />
    <RouteWithSidebar exact path={Routes.Navs.path} component={Navs} />
    <RouteWithSidebar exact path={Routes.Navbars.path} component={Navbars} />
    <RouteWithSidebar exact path={Routes.Pagination.path} component={Pagination} />
    <RouteWithSidebar exact path={Routes.Popovers.path} component={Popovers} />
    <RouteWithSidebar exact path={Routes.Progress.path} component={Progress} />
    <RouteWithSidebar exact path={Routes.Tables.path} component={Tables} />
    <RouteWithSidebar exact path={Routes.Tabs.path} component={Tabs} />
    <RouteWithSidebar exact path={Routes.Tooltips.path} component={Tooltips} />
    <RouteWithSidebar exact path={Routes.Toasts.path} component={Toasts} />

    {/* documentation */}
    <RouteWithSidebar exact path={Routes.DocsOverview.path} component={DocsOverview} />
    <RouteWithSidebar exact path={Routes.DocsDownload.path} component={DocsDownload} />
    <RouteWithSidebar exact path={Routes.DocsQuickStart.path} component={DocsQuickStart} />
    <RouteWithSidebar exact path={Routes.DocsLicense.path} component={DocsLicense} />
    <RouteWithSidebar exact path={Routes.DocsFolderStructure.path} component={DocsFolderStructure} />
    <RouteWithSidebar exact path={Routes.DocsBuild.path} component={DocsBuild} />
    <RouteWithSidebar exact path={Routes.DocsChangelog.path} component={DocsChangelog} />

    <Redirect to={Routes.NotFound.path} />
  </Switch>
  </AuthContext.Provider>
  )


  }