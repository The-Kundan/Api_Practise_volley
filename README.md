# 📱 Volley Library Demo  

This project demonstrates how to use the **Volley Library** in Android for making network requests and parsing JSON data.  
It includes three different examples:  

1. **Fetching student details** from a JSON server (Mockaroo API).  
2. **Fetching images** using Pixabay API.  
3. **Fetching movies list** from a JSON server (Mockaroo API) with detailed view on selection.  

---

## 🚀 Features  

### 1️⃣ Fetching Student Data (Mockaroo API)  
- Retrieves student details from a JSON server.  
- Sample Data:  
  ```json
  [
    {
      "id": 101,
      "name": "John Doe",
      "course": "Computer Science",
      "age": 22
    },
    {
      "id": 102,
      "name": "Emma Watson",
      "course": "Electronics",
      "age": 21
    }
  ]
  ```  
- Displays student **ID, Name, Course, and Age** in a RecyclerView.  

---

### 2️⃣ Fetching Images (Pixabay API)  
- Uses [Pixabay API](https://pixabay.com/api/?key=51859612-ff1979d1c2687e240c24326e6&q=nature&image_type=photo&pretty=true).  
- Fetches and displays:  
  - 📸 Image preview  
  - 🖼️ Collections of images  
  - ❤️ Likes  
  - 💬 Comments  
  - ⬇️ Downloads  
- All images are shown in a grid layout using RecyclerView.  

Example JSON Response:  
```json
{
  "hits": [
    {
      "id": 195893,
      "pageURL": "https://pixabay.com/en/blossom-bloom-flower-195893/",
      "previewURL": "https://cdn.pixabay.com/photo/2013/07/21/13/00/rose-165819_150.jpg",
      "likes": 120,
      "comments": 15,
      "downloads": 3400
    }
  ]
}
```

---

### 3️⃣ Fetching Movies List (Mockaroo API)  
- Fetches a list of movies with:  
  - 🎬 Movie Name  
  - 🖼️ Poster Image  
  - 📖 Description  
  - ⭐ Rating  
- Movies are displayed in a RecyclerView.  
- On clicking a movie → Opens a new screen with **full movie details**.  

Sample Data:  
```json
[
  {
    "name": "Inception",
    "pic": "https://example.com/inception.jpg",
    "description": "A mind-bending thriller about dream invasion.",
    "rating": 8.8
  },
  {
    "name": "Interstellar",
    "pic": "https://example.com/interstellar.jpg",
    "description": "A journey beyond the stars to save humanity.",
    "rating": 9.0
  }
]
```

---

## 🛠️ Tech Stack  
- **Language:** Java  
- **Networking:** Volley Library  
- **UI:** RecyclerView, CardView, Glide (for image loading)  

---

## 📸 Screenshots  

<p align="center">
  <img src="https://github.com/The-Kundan/Api_Practise_volley/blob/master/Data.jpg" alt="Student Data" width="200"/>
  <img src="https://github.com/The-Kundan/Api_Practise_volley/blob/master/Image1.jpg" alt="Image1" width="200"/>
  <img src="https://github.com/The-Kundan/Api_Practise_volley/blob/master/Image2.jpg" alt="Image2" width="200"/>
  <img src="https://github.com/The-Kundan/Api_Practise_volley/blob/master/MovieList.jpg" alt="Movie List" width="200"/>
  <img src="https://github.com/The-Kundan/Api_Practise_volley/blob/master/MovieDetails.jpg" alt="Movie Details" width="200"/>
</p>


## ▶️ How to Run  
1. Clone the repository.  
2. Add your own **Pixabay API key** in the request URL.  
3. Update the **Mockaroo API endpoint** with your custom schema for Student & Movies data.  
4. Run the app on an emulator or Android device.  

---

✨ This project helps in learning how to:  
- Make GET requests using Volley.  
- Parse JSON arrays and objects.  
- Display data using RecyclerView.  
- Load images efficiently with Glide.  
