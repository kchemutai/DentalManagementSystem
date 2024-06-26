Advantis Dental Surgeries, LLC (ADS) is a company that is in the business of managing a
growing network of dental surgeries which are located across cities in the South West region.
You have been hired by the company, as a Lead Software Engineer and tasked to lead
the effort in designing and developing a web-based software solution (i.e. a website) that the
company will be using to manage their business.
The system will be used by an Office Manager to register Dentists who apply to join their
network of dental surgeries. Each Dentist is given a unique ID number and their First Name,
Last Name, Contact Phone Number, Email, and Specialization are recorded into the system.
The Office Manager also uses the system to enroll new Patients who require dental services,
including the Patient’s First Name, Last Name, Contact Phone Number, Email, Mailing Address
and Date of Birth. A Patient can call in to request an appointment to see a dentist. A Patient
can also request an appointment by submitting an online form on the ADS website. Upon
receiving a request for an appointment, the Office Manager can then book the appointment
and the system will send a confirmation email notifying the Patient and the appointment gets
recorded accordingly.
Dentists should be able to sign in to the system and view a listing of all their Appointments,
including details of the Patients they have been scheduled to see. Each appointment is
normally made for a specific date and time and the dentist is expected to see/treat the
patient at one of ADS’s surgery locations. The system should provide information about each
Surgery, including its name, location address, and telephone number. Patients should be able
to sign in to the system and view their appointments, including the information of the dentist
they have been booked to see. Patients should also be able to request to cancel or change
their appointments.
A dentist cannot be given more than 5 appointments in any given week. The system should
prevent a Patient from requesting a new appointment if they have an outstanding, unpaid
bill for dental service they have received.



Requirements Analysis


- Office Manager registers new dentists.
- Office Manager enrolls new patients.
- Office Manager books appointments for patients.
- Office Manager sends confirmation emails for booked appointments.
- Office Manager prevents appointment requests for patients with outstanding unpaid bills.
- Dentist signs in to view their appointment schedule.
- Dentist accesses details of scheduled patients.
- Dentist manages a maximum of 5 appointments per week.
- Patient registers and signs in to the system.
- Patient views their appointments.
- Patient requests, cancels, or changes appointments.
- Patient submits online forms to request appointments.



ER Diagram

![img.png](img.png)



Refined Class Diagram
![classDiagram.png](screenshots%2FclassDiagram.png)




Architecture
![ApplicationArchitecture.png](screenshots/ApplicationArchitecture.png)