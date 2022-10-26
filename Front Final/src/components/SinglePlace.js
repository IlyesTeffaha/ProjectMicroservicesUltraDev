import axios from 'axios'
import React, { useContext, useEffect, useState } from 'react'
import { Link, useHistory, useParams } from 'react-router-dom'
import '../pages/css/SinglePlace.css'
import {Button, Container, Row} from 'react-bootstrap'
import Parser from 'html-react-parser';

import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css'; 
import EditorToolbar, { modules, formats } from "./editortoolbar";
import Tippy from '@tippyjs/react';
import 'tippy.js/dist/tippy.css';
import { AuthContext } from '../ContextApi/AuthContext'
import { Routes } from '../routes'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faWarehouse,faHandshake,faPlace,faMapMarked ,faMailBulk} from '@fortawesome/free-solid-svg-icons'




function SinglePlace() {
    // const [placedata,setPlacedata]= useState([]);
    const [post,setPost]= useState([]);

    const [updateMode, setUpdateMode] = useState(false);


    let {id} = useParams()
    
    useEffect(()=>{
        axios.get(`http://localhost:8086/place/getplace/${id}`,{headers:{accessToken:localStorage.getItem("accessToken")},
    }).then((response)=>{
        setPost(response.data)
            console.log(response.data)
            setDescription(response.data.description)
            setDesc(response.data.description);
            setTitle(response.data.placeTitle)
        })
    },[id]);
  
      const handleChange=(value)=>{
        setDesc(value);
      }
      const handleUpdate = async () => {
        try {
          await axios.put(`http://localhost:8086/place/update-Place/${id}`, {
            // name:data.name,
            placeTitle:title,
            description:desc,
          
          
          });
          setUpdateMode(false)
        } catch (err) {}
      };
 
    const [desc, setDesc] = useState("");
    // function getAge(dateString) 
    // {
    //     var today = new Date();
    //     var birthDate = new Date(dateString);
    //     var age = today.getFullYear() - birthDate.getFullYear();
    //     var m = today.getMonth() - birthDate.getMonth();
    //     if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) 
    //     {
    //         age--;
    //     }
    //     return age;
    // }
    const [description,setDescription]=useState("")
    const [title, setTitle] = useState("");
  const {authState}=useContext(AuthContext);
  const history=useHistory()

  
  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8086/place/delete/${id}`, {
        // data: { name: data.name },
      });
      console.log("deleted")
   history.push(Routes.PlacesList.path)
      
    } catch (err) {console.log(err)}
  };

  console.log(title+"iluyess")
    
      return (
//         <div>
//              {/* {placedata.map((value, key) => {
//           return (
//            <div key={key}>
//      */}
//     <Container>
    
    
//     <section className ="section about-section gray-bg" id="about">
//                 <div className ="container">
//                     <div className ="row align-items-center flex-row-reverse">
//                         <div className ="col-lg-6">
//                             <div className ="about-text go-to">
//                                 <h3 className ="dark-color">{placedata.title}</h3>
//                                 {/* <h6 className ="theme-color lead">A Lead UX &amp; UI designer based in Canada</h6>
//                                 <p>I <mark>design and develop</mark> services for customers of all sizes, specializing in creating stylish, modern websites, web services and online stores. My passion is to design digital place experiences through the bold interface and meaningful interactions.</p> */}
//                                 <div className ="row about-list">
//                                     <div className ="col-md-6">
//                                     <div className ="media">
//                                             <label>Place title</label>
//                                             <p>{placedata.title}</p>
//                                         </div>
//                                         <div className ="media">
//                                             <label>Creation Date</label>
//                                             <p>{new Date(placedata.creationtime).toDateString()}</p>
//                                         </div>
                                    
                        

//                                    <br/>

//                                         {/* <div className ="media">
//                                             <label>Address</label>
//                                             <p>{placedata.address}</p>
//                                         </div> */}
//                                     </div>
//                                     <div className ="col-md-6">
//                                         {/* <div className ="media">
//                                             <label>E-mail</label>
//                                             <p>{placedata.email}</p>
//                                         </div>
//                                         <div className ="media">
//                                             <label>Phone</label>
//                                             <p>{placedata.PhoneNumber}</p>
//                                         </div>
//                                         <div className ="media">
//                                             <label>Current Status</label>
//                                             <p>{placedata.currentstatus}</p>
//                                         </div> */}
                                      
//                                     </div>
//                                 </div>
//                             </div>
//                         </div>
//                         <Row>
//                         <div >
//                                             <label>BLOGPOST CONTENT</label>
//                                             <p>{Parser(description)}</p>
//                                         </div>
//                         </Row>
//                         <br/>
//                         <br/>
//                         <br/>

//                         <div className ="col-lg-6">
//                             <div className ="about-avatar">
//                                 <img src={placedata.image} title="" alt=""/>
//                             </div>
//                         </div>
//                     </div>
//                     {/* <div className ="counter">
//                         <div className ="row">
//                             <div className ="col-6 col-lg-3">
//                                 <div className ="count-data text-center">
//                                     <h6 className ="count h2" data-to="500" data-speed="500">500</h6>
//                                     <p className ="m-0px font-w-600">Happy Clients</p>
//                                 </div>
//                             </div>
//                             <div className ="col-6 col-lg-3">
//                                 <div className ="count-data text-center">
//                                     <h6 className ="count h2" data-to="150" data-speed="150">150</h6>
//                                     <p className ="m-0px font-w-600">Project Completed</p>
//                                 </div>
//                             </div>
//                             <div className ="col-6 col-lg-3">
//                                 <div className ="count-data text-center">
//                                     <h6 className ="count h2" data-to="850" data-speed="850">850</h6>
//                                     <p className ="m-0px font-w-600">Photo Capture</p>
//                                 </div>
//                             </div>
//                             <div className ="col-6 col-lg-3">
//                                 <div className ="count-data text-center">
//                                     <h6 className ="count h2" data-to="190" data-speed="190">190</h6>
//                                     <p className ="m-0px font-w-600">Telephonic Talk</p>
//                                 </div>
//                             </div>
//                         </div>
//                     </div> */}
//                 </div>
//             </section>
    
        
//             </Container>
    
// {/*     
//            </div>
//            )
        
//         })}
//      */}
    
    
        
//         </div>

<div className="singlePost">
      <div className="singlePostWrapper">
        {post.image && (
          <img src={post.image} alt="" className="singlePostImg" />
        )}
        {updateMode ? (
          <input
            type="text"
            value={title}
            className="singlePostTitleInput"
            autoFocus
            onChange={(e) => setTitle(e.target.value)}
          />
        ) : (
          <h1 className="singlePostTitle">
            {true&& (
              <div className="iconsb">
           
          <h1>{post.PlaceTitle}</h1>
              

<Tippy content="Update post ?" >
    <Button className="deleteicon"
                 
                 onClick={() => setUpdateMode(true)}>Update</Button></Tippy>

<Tippy content="Delete post ?" ><Button className="deleteicon"
                 
                 onClick={handleDelete}>Delete</Button></Tippy>
                
                
                
              </div>
            )}
          </h1>
        )}
        <div className="singlePostInfo">
          <span className="singlePostAuthor">
         
              <font className="linkc"> {post.availability}</font>
             
      
          </span>
         
          
          <span className="singlePostDate">
            
     
          </span>
        </div>

        
        {updateMode ? (
          <div className="tools">
          <EditorToolbar />
          <ReactQuill
            className="singlePostDescInput"
            type="text"
            value={desc}
            modules={modules}
            formats={formats}
            onChange={handleChange}
          /></div>
        ) : (
          <p className="singlePostDesc">{Parser(desc)}</p>
        )}


        {updateMode && (
         
           <Button size="medium" variant="success" style={{width:"250px"}}   onClick={handleUpdate}>
           Confirm Update
         </Button>
        )}
      </div>

{/* 
<motion.div >
<CardContent>
<div className="mb-24">
                <Typography className="font-semibold mb-4 text-15">Gender</Typography>
                <Typography>{data.gender}</Typography>
                
              </div>
              <div className="mb-24">
                <Typography className="font-semibold mb-4 text-15">Birthday</Typography>
                <Typography>{data.birthday}</Typography>
              </div>
</CardContent>
</motion.div> */}


    </div>
      )
}

export default SinglePlace