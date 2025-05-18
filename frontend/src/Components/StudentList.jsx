import React from 'react'
import  { useEffect, useState } from 'react';
import axios from 'axios';
function StudentList() {
    const [students, setStudents] = useState([])

 // load  fetch on this http when the component loads
    useEffect(() => {
        axios.get('http://localhost:3001/getAllStudents')
            .then(response => setStudents(response.data))
            .catch(error => console.error('Error fetching students:', error));
    }, []);
  return (
      <div className="container mt-4">
          <h2>VIT Semester Results</h2>
          <table className="table table-striped">
              <thead>
                  <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Roll Number</th>
                      <th>Final Result</th>
                  </tr>
              </thead>
              <tbody>
                  {students.length > 0 ? (
                      students.map(student => (
                          <tr key={student.id}>
                              <td>{student.id}</td>
                              <td>{student.name}</td>
                              <td>{student.rollNumber}</td>
                              <td>{student.result ? student.result.toFixed(2) : 'Not Calculated'}</td>
                          </tr>
                      ))
                  ) : (
                      <tr>
                          <td colSpan="4">No students found</td>
                      </tr>
                  )}
              </tbody>
          </table>
      </div>
  )
}

export default StudentList