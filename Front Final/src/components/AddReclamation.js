
import React, { useContext, useEffect, useState } from "react";
import moment from "moment-timezone";
import Datetime from "react-datetime";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCalendarAlt } from '@fortawesome/free-solid-svg-icons';
import { Col, Row, Card, Form, Button, InputGroup } from '@themesberg/react-bootstrap';
import { AuthContext } from "../ContextApi/AuthContext";
import axios from 'axios'
import AccordionComponent from "./AccordionComponent";
import {  Country, State, City  } from "country-state-city";
import { Alert } from '@themesberg/react-bootstrap';
import data from '../data/universities-data.json'
import '../pages/css/Tags.scss'
import { Routes } from "../routes";
import { useHistory } from "react-router-dom";
import { faAngleDown, faAngleUp, faChartArea, faChartBar, faChartLine, faFlagUsa, faFolderOpen, faGlobeEurope, faPaperclip, faUserPlus } from '@fortawesome/free-solid-svg-icons';
import { ProfileCardWidget,ChoosePhotoWidgetreclamation } from "../components/Widgets";
import 'react-quill/dist/quill.snow.css'; 
import 'react-quill/dist/quill.bubble.css'; 
import EditorToolbar, { modules, formats } from "./editortoolbar";
import ReactQuill from 'react-quill';

export const AddReclamations = () => {

  const [desc, setDesc] = useState("");
  const handleChange=(value)=>{
    setDesc(value);
  }
  const [title, setTitle] = useState("");
  const [faculty, setFaculty] = useState("");

  const [category, setCategory] = useState("");

  const [tags, setTags] = useState("");



  const [section, setSection] = useState("");
  const [description, setDescription] = useState("");
  const [scorebac, setScorebac] = useState("");

  const [state,setState]=useState(State.getStatesOfCountry("TN"));
const [cities,setCities]=useState([]);
const [chosencity, setChosencity] = useState("");

const [chosenstate,setChosenstate]=useState("");


const [cats, setCats] = useState([]);



  const {authState}=useContext(AuthContext);
  // console.log(state[4])
  // console.log(City.getCitiesOfState("TN","11"))

  // console.log(authState.id)

  // setId(authState.id);

  // const updateuser=()=>{
  // const data={email:email,username:username,birthday:birthday,address:address,PostalCode:PostalCode,PhoneNumber:PhoneNumber,gender:gender,occupation:occupation}; 

  //   axios.put(`http://localhost:3001/auth/update/${authState.id}`,data).then((response)=>{
  //     if(response.data.error){ console.log("error")} 
  //     else{

  //   )};
  const [reclamationdata,setReclamationdata]= useState([]);
 
console.log(authState)
const id=authState.id;
const[categorie,setCategorie]=useState("")

    
   ///the get cities method require the second parameter to be a string anf for that i transormed the idn[1] value that i sent via even.target into the chosen state then seperated the string using $ sign , this transformation is necessarry because in the first render idn returns undefined which makes the tostring function return a unescapable error we are doing this because we faced a problem when getting the cities by state in real time 
  // console.log(chosenstate)

    const idn=chosenstate.split("$")
    const nn=idn[1]+"";
    const bn=nn.toString();
  

    useEffect(()=>{

      setCities(City.getCitiesOfState("TN",bn))
  },[idn[1]]);



    const [errorexist,setErrorexist]=useState(false);
    const [errmsg,setErrmsg]=useState("");
    const[chosenfaculty,setChosenfaculty]=useState("")
    



 

let history = useHistory()
const [image,setImage]=useState();



const config = {
  headers: {
    AccessControlAllowOrigin:"http://localhost:3000"
  }}
const addReclamation=()=>{
  const data={reclamationName:title,description:desc,email:authState.email,image:authState.reclamationimage};

  // const data={}


console.log(data)


  axios.post("http://localhost:8087/reclamation/addReclamation",data,config).then((response)=>{
//     if(response.data.message){
//       setErrorexist(true)

//       setErrmsg(response.data.message)
 setTimeout(() => { history.push(Routes.ReclamationsList.path)}, 1000);

//   } 
 console.log(response)
    
  }
   
  )
};
console.log(image+"ilyessss")



  return (


         

    <Card border="light"  className="bg-white shadow-sm mb-4">
      <Card.Body>
        <h5 className="mb-4">General information</h5>
        <Form>
          <Row>
            <Col md={6} className="mb-3">
              <Form.Group id="firstName" >
              <Form.Label>Title</Form.Label>
                <InputGroup  onChange={(e)=>{setTitle(e.target.value)}}>
                
                <Form.Control placeholder="Enter Title" required type="text" />
                </InputGroup>
              </Form.Group>
            </Col>
            <Col md={6} className="mb-3">
              {/* <Form.Group id="gender">
                <Form.Label>Description</Form.Label>
                <InputGroup  onChange={(e)=>{setDescription(e.target.value)}}>
                <Form.Control  required type="text"   />
                </InputGroup>
              </Form.Group> */}


            </Col>
            
          <ChoosePhotoWidgetreclamation  title="Select a photo"/>
      
          </Row>
        
       
    
          <Row>
            {/* <Col sm={4} className="mb-3">
              <Form.Group id="city">
                <Form.Label>City</Form.Label>
                <Form.Control required type="text" placeholder="City" />
              </Form.Group>
            </Col> */}
            {/* <Col sm={4} className="mb-3">
              <Form.Group className="mb-2">
                <Form.Label>Select state</Form.Label>
                <Form.Select onChange={(e)=>setChosenstate(e.target.value)}>
                {state.map((items , index)=>{
                  return(
  <option value={items.name+"$"+items.isoCode} key={index}>{items.name} </option>
                  )
})}
                </Form.Select>


                
              </Form.Group>
            </Col>
            <Col sm={4}>
              <Form.Group id="zip" >
              
                 <Form.Label>Select City</Form.Label>
                <Form.Select onChange={(e)=>setChosencity(e.target.value)}>
                {cities.map((items , index)=>{
                  return(
  <option value={items.name} key={index}>{items.name} </option>
                  )
})}
                </Form.Select>
              </Form.Group>
            </Col>
          */}
          <div className="writeFormGroup ">
        <div className="row tools"><EditorToolbar /></div>
        <div className=""><ReactQuill
          id="myfield" name="myfield"
            placeholder="Tell your story..."
            type="text"
            className="writeInput writeText"
            value={desc}
            modules={modules}
            formats={formats}
            onChange={handleChange}
          /></div>
        
          
        </div>
           
          </Row>
          <Row>
          {/* <div className="mx-3 my-5">
            <label className="mb-3">Choose tags</label>
			<TagsInput selectedTags={selectedTags}  tags={[...chosentags]}   />
		</div> */}
          </Row>
      
          <div className="mt-3 mb-3">
            <Button variant="primary" onClick={addReclamation}>Add Reclamation </Button>
          </div>
          {errorexist?(
                        <>
                                            <Alert variant="success"   >
    {errmsg}
  </Alert>
                        </>
                      ):(
                        <>
                        </>
                      )}
         
        </Form>
      
      </Card.Body>
 
      
      <Form.Group id="address" >
                <Form.Label>{scorebac}</Form.Label>
                
                
              </Form.Group>
      


         

      
    </Card>

   
  );
// })}

// </div>)

};
