# Compose Stability Examples

Dive into the world of Jetpack Compose with the Compose Stability Examples project, which showcases best practices and common pitfalls related to stability and recomposition. This project and its insights were inspired by the blog article [The Do’s and Don’ts of Jetpack Compose](https://blog.savvas.cloud/2023/09/07/the-dos-and-donts-of-jetpack-compose/). Special thanks to the author for providing practical examples and best practices.

## ⭐️Features
### Main Screen 
- **Slider Interaction:** A responsive slider that dynamically updates UI components, showcasing how to handle recomposition efficiently.
  
- **LazyVerticalGrid:** Learn how recompositions are triggered by different state changes.

- **Dialog with Image:** Click on any example to view a dialog with an associated image, demonstrating code of particular example.🖼️

### Visual Feedback
- **Recompose Highlighter:** Highlights areas of the screen that recompose, helping developers visualize the impact of their code.

### Stability Examples
- **Stable Examples:** Properly implemented composables using immutable data structures or stable objects, ensuring optimal recomposition behavior.
  
  **Key Point:** If a class is marked as **stable**, it uses **structural equality** (`.equals()`) to detect changes, ensuring precise and efficient recomposition.

- **Unstable Examples:** Common issues in Compose, such as passing mutable or frequently changing data, leading to excessive recompositions.
  
  **Key Point:** If a class is **unstable**, it uses **referential equality** (`===`), which may result in unnecessary recompositions when data is updated but not replaced.

## ⚙️Technologies
### 📱App:
- **Jetpack Compose:** A modern toolkit for building native Android UIs with declarative components. 🎨

- **Persistent Data Structures:** Leveraging immutable collections to enhance stability and prevent unnecessary recompositions.

## 🎯 Goals
- Show how parameters in composables impact recomposition and performance.
- Highlight the difference between stable and unstable parameters in composables and their effect on recomposition.
- Provide insights on handling state, immutability, and stability annotations to optimize UI rendering.

## Installation
1. Clone the repository:
```bash
git clone https://github.com/AdamDawi/ComposeStabilityExamples
```
2. Open the project in Android Studio.
3. Be sure the versions in gradle are same as on github

## Here are some overview pictures:
![11](https://github.com/user-attachments/assets/2fa751c7-001b-4863-93ae-ab0ccf6b0d4b)
![22](https://github.com/user-attachments/assets/ab1875ff-f105-449a-a7a9-51900aaa7673)
![33](https://github.com/user-attachments/assets/4ccfde9c-6980-4e9a-9349-4963df9955dc)
![44](https://github.com/user-attachments/assets/ba29a0a6-0566-4a8d-bd03-3ca8c5c54b7d)

## Requirements
Minimum version: Android 7 (API level 24) or later📱

Target version: Android 14 (API level 34) or later📱

## Author
Adam Dawidziuk🧑‍💻
