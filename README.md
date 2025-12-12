# 🌤️ Spring Boot + Cloudinary Media Upload API

A simple Spring Boot API to upload **Images** and **Videos** to Cloudinary and store file URLs in the database.

---

## ✨ Features

- 📸 Upload Images → stored in **/images** folder  
- 🎥 Upload Videos → stored in **/videos** folder  
- 📁 Store URLs in database  
- 🧾 Add product with image  
- 🧪 Easy API testing with Postman  

---

## ⚙️ Configuration (`application.properties`)

cloudinary.cloud_name=your_cloud_name
cloudinary.api_key=your_api_key
cloudinary.api_secret=your_api_secret

spring.servlet.multipart.max-file-size=500MB
spring.servlet.multipart.max-request-size=500MB

yaml
Copy code

---

## 📸 Image Upload Code

```java
Map upload = cloudinary.uploader().upload(
        file.getBytes(),
        ObjectUtils.asMap("folder", "images")
);
String imageUrl = upload.get("secure_url").toString();
🎥 Video Upload (Large File Support)
java
Copy code
Map upload = cloudinary.uploader().uploadLarge(
        file.getBytes(),
        ObjectUtils.asMap(
            "resource_type", "video",
            "folder", "videos",
            "chunk_size", 6000000
        )
);
String videoUrl = upload.get("secure_url").toString();
📡 API Endpoints
➕ Add Product (Image + JSON)
POST /product
Content-Type: multipart/form-data

Key	Type	Example
file	File	image.jpg
product	Text	{"productName":"Phone","category":"Mobile","price":45000}

🎥 Upload Video
POST /uploadVideo

Key	Type
file	Video (.mp4)

▶️ Run Project
arduino
Copy code
mvn spring-boot:run
👨‍💻 Author
Anuj Kumar Prajapati
Java | Spring Boot | Cloud | Backend Developer

yaml
Copy code

---

# 🎉 WHAT CHANGED?

### ✔ Clean heading spacing  
### ✔ Proper line breaks  
### ✔ Code blocks fixed  
### ✔ Emoji spacing corrected  
### ✔ No clutter  
### ✔ Perfect GitHub rendering  
### ✔ Easy to read and understand  

---

# 🔥 If you want, I can also generate:

✅ Attractive README with banners  
✅ README with screenshots  
✅ README with collapsible sections  
✅ README with API documentation tables  
✅ README with badges  

Just tell me!











