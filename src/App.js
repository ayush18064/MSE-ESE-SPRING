import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import axios from "axios"
import React, { useEffect, useState } from 'react'

function App() {
  const [result, setResult] = useState([])
  useEffect(() => {
    const fetchResult = async () => {
      try {

        const response = await axios.get("/getAllStudents");
        console.log(response.data);
        setResult(response.data)
      } catch (error) {
        console.log(error);

      }


    }
    fetchResult()
  }, [])

  return (
    <>
      <div className="container mt-4">
        <h3>Result</h3>
        {
          result.length > 0 ?
            (
              <table className="table">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>PRN</th>
                    <th>Result</th>
                  </tr>
                </thead>
                <tbody>
                  {result.map((student) => (
                    <tr key={student.id}>
                      <td>{student.id}</td>
                      <td>{student.name}</td>
                      <td>{student.prn}</td>
                      <td>{student.result.toFixed(2)}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            ) :
            <p>No data</p>
        }
      </div>
    </>
  );
}

export default App;
