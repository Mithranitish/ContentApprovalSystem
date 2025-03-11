# YouTube Content Approval System

## Problem Statement

Managing a YouTube channel with multiple contributors requires a structured approval process to ensure content quality and compliance. However, the owner frequently travels and often experiences unstable internet connectivity, making real-time approvals challenging. Manually handling video submissions, approvals, and metadata updates is time-consuming and prone to errors.

This platform automates the workflow between editors and the owner, ensuring secure collaboration, reducing manual intervention, and maintaining control over content publishing—even in low-connectivity environments.
## 📌 Project Overview
The **YouTube Content Approval System** streamlines collaboration between **YouTube content owners** and **editors** by automating the process of video approvals and uploads. This system allows:
- **Owners** to upload unedited videos.
- **Editors** to download, edit, and upload the videos for review.
- **Owners** to approve/reject videos with comments.
- **Approved videos** to be uploaded to YouTube automatically.

## 🚀 Features
### Owner Functionalities
✅ Upload raw video to **Google Cloud Storage**.
✅ Review & approve/reject edited videos.
✅ Provide comments on rejected videos.
✅ Automatic upload of approved videos to YouTube.

### Editor Functionalities
✅ Download raw videos from Google Cloud Storage.
✅ Upload edited versions for owner review.
✅ View status (Pending, Approved, Rejected).

### Security & Authentication
✅ **Spring Security & JWT** for authentication.
✅ **Google Cloud IAM** for secure storage access.
✅ **YouTube OAuth 2.0** for video publishing.

---

## 🛠️ Tech Stack
- **Frontend**: React.js
- **Backend**: Spring Boot (REST API)
- **Database**: PostgreSQL
- **Cloud Storage**: Google Cloud Storage (GCS)
- **YouTube API**: YouTube Data API v3 (for automatic uploads)

---

## 📂 Folder Structure
```
📂 youtube-approval-system
 ┣ 📂 frontend (React.js)
 ┃ ┣ 📜 src/ (Login, Dashboards, Components)
 ┃ ┣ 📜 package.json (Dependencies)
 ┣ 📂 backend (Spring Boot)
 ┃ ┣ 📂 src/main/java/com/example/youtubeapproval
 ┃ ┣ 📜 application.properties
 ┃ ┣ 📜 pom.xml (Maven dependencies)
 ┣ 📜 README.md (Project Documentation)
```

---

## 💾 Installation & Setup
### Prerequisites
- Node.js & npm (for frontend)
- Java 17+ & Maven (for backend)
- PostgreSQL Database
- Google Cloud & YouTube API Keys

### 🔹 Backend Setup (Spring Boot)
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/youtube-approval-system.git
   ```
2. Navigate to the backend folder:
   ```sh
   cd youtube-approval-system/backend
   ```
3. Configure **application.properties** with database & cloud credentials.
4. Build and run the Spring Boot application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

### 🔹 Frontend Setup (React.js)
1. Navigate to the frontend folder:
   ```sh
   cd youtube-approval-system/frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the React development server:
   ```sh
   npm start
   ```

---

## 📡 API Endpoints
### **Owner APIs**
| Method | Endpoint | Description |
|--------|----------------|----------------|
| POST | `/api/videos/upload-unedited` | Upload raw video |
| GET | `/api/videos/download/{videoId}` | Get raw video URL |
| POST | `/api/videos/approve/{videoId}` | Approve & upload to YouTube |
| POST | `/api/videos/reject/{videoId}` | Reject with comments |

### **Editor APIs**
| Method | Endpoint | Description |
|--------|-----------------|----------------|
| POST | `/api/videos/upload-edited/{videoId}` | Upload edited video |
| GET | `/api/videos/status/{videoId}` | View approval status |

---

## ✅ Future Enhancements
🚀 Multi-user support (Multiple editors per owner).  
🚀 AI-powered automated video enhancement suggestions.  
🚀 Email notifications for approvals/rejections.  
🚀 Mobile app integration for on-the-go access.  

---

 

