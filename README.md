## 📌 Fixing 415 Unsupported Media Type (Multipart + JSON DTO)

When sending a file and JSON together in a `multipart/form-data` request,  
Spring Boot will throw:

415 Unsupported Media Type

yaml
Copy code

This happens because Postman does **not** send the JSON with the correct `Content-Type`.

---

### ✅ Correct Postman Setup

#### 1️⃣ Go to **Body → form-data**

#### 2️⃣ Add fields:

| Key     | Type | Value Example |
|---------|------|----------------|
| file    | File | Redmi.jpg |
| product | Text | {"productName":"Redmi","category":"Mobile","price":45000} |

---

### ✅ 3️⃣ Enable Content-Type Column

In Postman:

Three dots (⋮) → Show Columns → enable "Content-Type"

yaml
Copy code

---

### ✅ 4️⃣ Set Content-Type for JSON Row

For the `product` field, set:

application/json

yaml
Copy code

---

### ✔ Final Postman Table Should Look Like

| Key     | Type | Value | Content-Type |
|---------|------|--------|--------------|
| file    | File | Redmi.jpg | Auto |
| product | Text | {"productName":"Redmi","category":"Mobile","price":45000} | application/json |

---

### 🎉 Result

Spring Boot correctly maps:

- `file` → `MultipartFile`  
- `product` → `ProductDto`  

And the **415 error is resolved**.

Image for Reference 
<img width="1320" height="542" alt="image" src="https://github.com/user-attachments/assets/f5940159-e752-405b-a9d7-dd4bd7b91f5b" />
