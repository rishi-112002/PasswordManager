#Password Manager App
Welcome to the Password Manager App! This app allows users to securely manage their passwords for different accounts. It uses Room for local data storage
to ensure all your sensitive information is safely stored on your device.

Features
Add Passwords: Users can add passwords for different accounts. All input fields (Account Name, Username, Password) must be filled out for the password to be successfully added.
View Passwords: Users can view a list of all saved passwords. Passwords are displayed in a masked format (e.g., *******), with an option to reveal them.
Update Passwords: Users can update existing password entries.
Delete Passwords: Users can delete password entries they no longer need.
Password Strength Meter: Provides a visual indicator of password strength to help users create strong passwords.
Technologies Used
Kotlin: The primary programming language used.
Jetpack Compose: For building the UI in a modern and declarative way.
Room: For local data storage, ensuring that user passwords are securely stored on the device.
Getting Started
Prerequisites
Android Studio installed on your development machine.
Basic knowledge of Kotlin and Jetpack Compose.
Installation
Clone the repository:
sh
Copy code
git clone https://github.com/yourusername/password-manager-app.git
Open the project in Android Studio.
Build and run the app on an emulator or a physical device.
Usage

ScreenShot :
![WhatsApp Image 2024-06-20 at 11 00 00](https://github.com/rishi-112002/PasswordManager/assets/141514994/dc74c93d-6059-4bdb-90e5-c086f7ccf586)
![WhatsApp Image 2024-06-20 at 11 00 00 (1)](https://github.com/rishi-112002/PasswordManager/assets/141514994/8e30509e-e87c-4b67-aa56-9bee9b3f338f)
![WhatsApp Image 2024-06-20 at 11 00 00 (2)](https://github.com/rishi-112002/PasswordManager/assets/141514994/4784222f-795a-4efe-be42-9c272943a057)
![WhatsApp Image 2024-06-20 at 11 00 00 (3)](https://github.com/rishi-112002/PasswordManager/assets/141514994/dbb9af5e-bebe-44a9-9d62-f29d2b7945e9)

Adding a Password:

Tap the "Add" button (a floating action button at the bottom right).
Fill out the Account Name, Username, and Password fields.
Tap "Add New Account" to save the password.
Viewing Passwords:

The home screen displays a list of all saved passwords.
Tap on any password entry to view more details or to update/delete it.
Updating a Password:

Tap on a password entry from the list.
Update the Account Name, Username, or Password fields.
Tap "Update" to save the changes.
Deleting a Password:

Tap on a password entry from the list.
Tap the "Delete" button to remove the password from the database.

Contributing
Contributions are welcome! Please fork this repository and submit a pull request for any feature additions, bug fixes, or improvements.
