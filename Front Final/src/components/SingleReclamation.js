import axios from 'axios'
import React, { useContext, useEffect, useState } from 'react'
import { Link, useHistory, useParams } from 'react-router-dom'
import '../pages/css/SingleReclamation.css'
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
import { faWarehouse,faHandshake,faReclamation,faMapMarked ,faMailBulk} from '@fortawesome/free-solid-svg-icons'




function SingleReclamation() {
    // const [reclamationdata,setReclamationdata]= useState([]);
    const [post,setPost]= useState([]);

    const [updateMode, setUpdateMode] = useState(false);
    const [sendmail, setSendmail] = useState(false);



    let {id} = useParams()
    
    useEffect(()=>{
        axios.get(`http://localhost:8087/reclamation/getReclamById/${id}`,{headers:{accessToken:localStorage.getItem("accessToken")},
    }).then((response)=>{
        setPost(response.data)
            console.log(response.data)
            setDescription(response.data.description)
            setDesc(response.data.description);
            setTitle(response.data.reclamationName)
        })
    },[id]);
  
      const handleChange=(value)=>{
        setDesc(value);
      }

      const [descmail,setDescmail]=useState("")
      const handleChangemail=(value)=>{
        setDescmail(value);
      }
      const handleUpdate = async () => {
        try {
          await axios.put(`http://localhost:8087/reclamation/updateReclamation/${id}`, {
            // name:data.name,
            reclamationName:title,
            description:desc,
            inspected:post.inspected,
            creationtime:post.creationtime
          
          
          });
          setUpdateMode(false)
        } catch (err) {}
      };
      console.log(post.email)

      const handleMail = async () => {
        try {
          await axios.post(`http://localhost:8087/email/sendMail`, {
            // name:data.name,
            msgBody:descmail,
            recipient:post.email,
            subject:post.reclamationName
          
          
          });
        console.log("mail sent")
          setSendmail(false)
        } catch (err) {}
        console.log("mail sent")

      };
 
    const [desc, setDesc] = useState("");

    const [description,setDescription]=useState("")
    const [title, setTitle] = useState("");
  const {authState}=useContext(AuthContext);
  const history=useHistory()
console.log(descmail)
  
  const handleDelete = async () => {
    try {
      await axios.delete(`http://localhost:8087/reclamation/delete/${id}`, {
        // data: { name: data.name },
      });
      console.log("deleted")
   history.push(Routes.ReclamationsList.path)
      
    } catch (err) {console.log(err)}
  };

  console.log(title+"iluyess")
    
      return (


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
           
          <h1>{post.reclamationName}</h1>
              

<Tippy content="Update post ?" >
    <Button className="deleteicon"
                 
                 onClick={() => setUpdateMode(true)}>Update</Button></Tippy>

<Tippy content="Delete post ?" ><Button className="deleteicon"
                 
                 onClick={handleDelete}>Delete</Button></Tippy>
                
                <Tippy content="Send Mail ?" ><Button className="deleteicon"
                 
                 onClick={() => setSendmail(true)}>Send Mail</Button></Tippy>
                
                
              </div>
            )}
          </h1>
        )}
        <div className="singlePostInfo">
          <span className="singlePostAuthor">
         
              <font className="linkc"> {post.email}</font>
             
      
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
          />
          
          
          </div>
        ) : (
          <p className="singlePostDesc">{Parser(desc)}</p>
          
        )}
 {sendmail ? (
          <div className="tools">
          <EditorToolbar />
          <ReactQuill
            className="singlePostDescInput"
            type="text"
          
            modules={modules}
            formats={formats}
            onChange={handleChangemail}
          />
          
          
          </div>
        ) : (
          <p className="singlePostDesc"></p>
          
        )}

        {updateMode && (
         
           <Button size="medium" variant="success" style={{width:"250px"}}   onClick={handleUpdate}>
           Confirm Update
         </Button>
        )}
          {sendmail && (
         
         <Button size="medium" variant="success" style={{width:"250px"}}   onClick={handleMail}>
         Confirm Mail
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

export default SingleReclamation