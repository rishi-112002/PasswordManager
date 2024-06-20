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
![WhatsApp Image 2024-06-20 at 11 00 00](https://github.com/rishi-112002/PasswordManager/assets/141514994/2ab30b71-1a82-4501-bc7f-16f7c7a8583d)
![WhatsApp Image 2024-06-20 at 11 00 00 (1)](https://github.com/rishi-112002/PasswordManager/assets/141514994/2855c332-33ee-4cc3-9581-30953ad69154)
![WhatsApp Image 2024-06-20 at 11 00 00 (3)](https://github.com/rishi-112002/PasswordManager/assets/141514994/9911ca01-d8f2-434a-9ce0-24d145d20268)
![WhatsApp Image 2024-06-20 at 11 11 15](https://github.com/rishi-112002/PasswordManager/assets/141514994/bba9a925-88ca-49d2-bebd-7da86c03ac2e)
![WhatsApp Image 2024-06-20 at 11 11 15 (1)](https://github.com/rishi-112002/PasswordManager/assets/141514994/ed2d1745-16ad-499a-b090-652d611c9bb7)


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
