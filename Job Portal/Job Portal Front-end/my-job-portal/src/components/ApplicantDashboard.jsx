import { useEffect, useState } from "react";
import Navbar from "./NavBar";
import axios from "axios";


const ApplicantDashboard = () => {

    const [jobs, setJobs] = useState([]); // state to hold the list of jobs

    // fetch jobs when the component loads
    useEffect(() => {
        getAllJobs();
    }, []);

    // function to call the API
    const getAllJobs = async () => {
        try {
            const response = await axios.get("http://localhost:8081/api/jobs/all")
            setJobs(response.data) // save the jobs in state
        }
        catch (error) {
            console.log("Error fetching jobs:", error);
        }
    }

    const apply = async (jobId) => {
        try {
            const response = await axios.post("http://localhost:8081/api/applications/apply/" + jobId, 
                {},{
                    headers: {
                        "Authorization": "Bearer " + localStorage.getItem("token")
                    }
                }
            )
            alert("Application Success!!!")
        }
        catch (error) {
            console.log(error)
        }
    }
    return (
        <>
            {/** Navbar with welcome <username> and logout button */}
            <Navbar />
            <h1>Applicant Dashboard</h1>
            <div className="container">
                <div className="row">
                    {
                        jobs.map((job, index) => (
                            <div className="col-sm-4" key={index}>
                                <div className="card mb-4">
                                    <div className="card-body">
                                        <h4>Title: {job.title}</h4>
                                        <p>Details: {job.description}</p>
                                        <p>Company: {job.company}</p>
                                        <p>Posted Date: {job.postedDate}</p>
                                        <div>
                                            <button className="btn btn-primary"
                                                onClick={() => apply(job.id)}>Apply</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))
                    }
                </div>

            </div>
        </>
    )
}

export default ApplicantDashboard;