# Little Lemon Food Ordering App

This project is the final capstone for the **Meta Android Developer Professional Certificate**. The app provides a food ordering interface for the **Little Lemon** restaurant, allowing users to browse the restaurant's menu, place orders, and manage their profiles.

## Preview

![Demonstration](https://user-images.githubusercontent.com/93353925/227747468-3e923704-873f-4a06-8bbb-8fad77580034.gif)

## Features

- **Onboarding Screen**: Users are prompted to enter personal details for registration.
- **Stack Navigation**: Allows users to move between screens using the back button.
- **Home Screen**: Displays a header, hero section with restaurant information, category-based menu breakdown, and a detailed list of food items.
- **Profile Screen**: Displays and allows editing of the user’s details, with changes retained across sessions.
- **Persistent User Data**: The profile data and menu items are fetched from a remote server and saved locally.
- **Filter Menu Items**: Users can search for and filter items based on different categories like Starters, Mains, Desserts, and Drinks.

## Wireframe

The app's Home screen is based on the following wireframe:

<img width="500" alt="Wireframe" src="https://user-images.githubusercontent.com/93353925/227747759-133a6613-06cb-4797-95f1-37a668c8be67.png">

## Screens Overview

### Onboarding Screen
The onboarding flow is presented the first time the app is launched. Users are required to input their **First Name**, **Last Name**, and **Email Address**. The screen contains:
- Three **TextFields** for user input.
- A **Register Button** that navigates the user to the Home screen upon submission.

### Home Screen
After registration, users are redirected to the Home screen. The screen is structured into the following sections:
- **Hero Section**: Displays the restaurant name, location, and a short description. Includes a **Search Bar** to filter menu items.
- **Menu Breakdown**: Includes category buttons for **Starters**, **Mains**, **Desserts**, and **Drinks**.
- **Food Menu List**: Displays dishes with a title, description, image, and price, all fetched from a remote server.

### Profile Screen
Users can view and edit their profile details on this screen. It includes:
- Three **TextFields** showing user information.
- Labels explaining each field.
- A **Logout Button** that signs the user out of the app.

## Functionality Breakdown

1. **Onboarding Flow**:
   - New users are prompted to provide personal details (first name, last name, email).
   - A **Register Button** submits the data and navigates the user to the Home screen.
   
2. **Home Screen**:
   - Contains restaurant details in the hero section.
   - A **Search Bar** filters the menu items dynamically.
   - Menu items are displayed in a scrollable list, divided by category buttons.
   
3. **Profile Screen**:
   - Displays editable user data.
   - Includes a **Logout Button** to sign out of the app.

## Project Details

This project showcases fundamental Android app development skills, including:
- **Jetpack Compose**: Used for building the UI components.
- **Remote Data Fetching**: Menu items are fetched from a remote server and stored locally for offline use.
- **Navigation**: Implemented using a stack-based navigation flow to move between screens.
