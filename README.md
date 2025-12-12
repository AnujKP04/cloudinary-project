Upload Images & Videos to Cloudinary • Store URLs in Database • Supports Large Files • Clean Architecture

<p align="center"> <img src="https://img.shields.io/badge/Java-17-blue?logo=java" /> <img src="https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=springboot" /> <img src="https://img.shields.io/badge/Cloudinary-Enabled-blue?logo=cloudinary" /> <img src="https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven" /> <img src="https://img.shields.io/badge/Status-Active-success" /> </p>
📝 Overview

This project is a Spring Boot REST API that enables uploading images and videos to Cloudinary, automatically organizing them in folders and storing the secure URL in a database.

It also supports large video uploads (chunk upload), making it suitable for e-commerce apps, media platforms, or any backend requiring safe media storage.

✨ Core Features
📁 Media Upload Support

Upload Images → stored in /images folder

Upload Videos → stored in /videos folder

Built-in support for large files (chunk upload for >100MB)

📦 Product Management

Add product with image

Store uploaded file URL in database

Retrieve list of all products

⚙️ Clean Architecture

DTO → Controller → Service → Repository

Environment-safe configuration (no API keys pushed to GitHub)

🧱 Project Structure
project-name/
│
├── src/
│   ├── main/
│   │   ├── java/com/cloud/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── entity/
│   │   │   └── dto/
│   │   └── resources/
│   │        ├── application.properties
│   │        └── static/
│   └── test/
│
├── pom.xml
├── mvnw / mvnw.cmd
└── README.md

🔧 Configuration (application.properties)
cloudinary.cloud_name=your_cloud_name
cloudinary.api_key=your_api_key
cloudinary.api_secret=your_api_secret

# Upload size limits
spring.servlet.multipart.max-file-size=500MB
spring.servlet.multipart.max-request-size=500MB


⚠️ Never commit real Cloudinary credentials — use .gitignore.

🚀 API Endpoints
📌 1. Upload Product (Image + JSON)

POST /product
Content-Type: multipart/form-data

🧩 Form-data fields:
Key	Type	Description
file	File	Product image
product	Text	One-line JSON
📝 Sample JSON:
{"productName":"OnePlus","category":"Mobile","price":45000}

🎥 2. Upload Video

POST /uploadVideo
Content-Type: multipart/form-data

Key	Type
file	Video (.mp4, .mov, etc.)
💻 Upload Logic (Code Samples)
🖼️ Image Upload (Auto folder creation)
Map upload = cloudinary.uploader().upload(
        file.getBytes(),
        ObjectUtils.asMap("folder", "images")
);

String imageUrl = upload.get("secure_url").toString();

🎬 Video Upload (Chunk Upload for Large Files)
Map upload = cloudinary.uploader().uploadLarge(
        file.getBytes(),
        ObjectUtils.asMap(
            "resource_type", "video",
            "folder", "videos",
            "chunk_size", 6000000  // 6MB chunks
        )
);

String videoUrl = upload.get("secure_url").toString();

🧪 Testing with Postman

Open Postman

Go to Body → form-data

Add fields:

file → File → select media

product → Text → JSON

Send request

You get:** secure URL** from Cloudinary

Product is saved in DB ✔

🗄️ Product Entity Example
private String productName;
private String category;
private double price;
private String imgUrl;
private String videoUrl;

🏗️ Build & Run
▶️ Run the project
mvn spring-boot:run

📦 Create a JAR
mvn clean package

📸 Screenshots (Optional)

Add your screenshots here for a more attractive README:

/screenshots/
    ├── postman-upload.png
    ├── cloudinary-folder.png
    └── api-response.png

👨‍💻 Author

Anuj Kumar Prajapati
Java | Spring Boot | Cloud | Microservices | Backend Development

📌 GitHub: [Your GitHub Profile]
📌 LinkedIn: [Your LinkedIn] (optional)

📜 License

This project is open-source and free for learning and personal use.
