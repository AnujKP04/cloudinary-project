Upload Images & Videos to Cloudinary • Store URLs in Database • Supports Large Files • Clean Architecture

<p align="center"> <img src="https://img.shields.io/badge/Java-17-blue?logo=java" /> <img src="https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=springboot" /> <img src="https://img.shields.io/badge/Cloudinary-Enabled-blue?logo=cloudinary" /> <img src="https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven" /> <img src="https://img.shields.io/badge/Status-Active-success" /> </p>
📝 Overview

This project is a Spring Boot REST API that enables uploading images and videos to Cloudinary, automatically organizing them in folders and storing the secure URL in a database.

✨ Core Features
📁 Media Upload Support

Upload Images → stored in /images folder
Upload Videos → stored in /videos folder

🔧 Configuration (application.properties)
cloudinary.cloud_name=your_cloud_name
cloudinary.api_key=your_api_key
cloudinary.api_secret=your_api_secret

# Upload size limits
spring.servlet.multipart.max-file-size=100MB
spring.servlet.multipart.max-request-size=100MB


