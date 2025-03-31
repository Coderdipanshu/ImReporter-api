📢 ImReporter - Crime Reporting API
🚔 ImReporter is a Spring Boot-powered REST API for crime reporting, allowing users to upload, retrieve, and manage crime-related data with images.



📌 Features
✔ Upload crime reports with images 🖼️
✔ Retrieve crime details based on state, district, type, and date 🔍
✔ Automatic cleanup of records after 10 days ⏳
✔ Base64 Image Encoding for smooth frontend integration 🔄
✔ CORS Support for cross-origin access 🌍

🚀 Technologies Used
Spring Boot (Java) - Backend API

Spring Data JPA - Database management

MySQL  - Relational database

Hibernate - ORM for database operations

JavaScript (Fetch API) - Frontend integration

Railway.app - API Deployment




The URI of the hit api is- https://imreporter-api-production.up.railway.app

📂 API Endpoints
🔹 API  Endpoint
➤ Upload a crime report
    POST Mapping (/api/crimes/upload)

➤ Get  a crime report
   With State- Get Mapping (/api/crimes/state/{state_name})

➤ Get  a crime report
   With State and district - Get Mapping (/api/crimes/state/{state_name}/district/{district_name})


➤ Get  a crime report
   With State , district and crime type  - Get Mapping (/api/crimes/state/{state_name}/district/{district_name}/{crimeType_name})

➤ Get  a crime report
   With State , district , crime type  and category  - Get Mapping (/api/crimes/state/{state_name}/district/{district_name}/{crimeType_name}/{category_name})

➤ Get  a crime report
   With State , district , crime type  and category  - Get Mapping (/api/crimes/state/{state_name}/district/{district_name}/{crimeType_name}/{category_name})

➤ Get  a crime report
   With State , district , crime type , category and date  - Get Mapping (/api/crimes/state/{state_name}/district/{district_name}/{crimeType_name}/{category}/{date})
   
   
   
